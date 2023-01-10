package com.github.filipmalczak.inwent.impl.tag;

import com.github.filipmalczak.inwent.api.domain.NamespaceAPI;
import com.github.filipmalczak.inwent.api.model.domain.tag.NamespaceDescriptor;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import com.github.filipmalczak.inwent.impl.common.Issues;
import com.github.filipmalczak.inwent.impl.common.Values;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NamespaceController implements NamespaceAPI {
    @Autowired
    NamespaceRepository namespaceRepository;

    @Autowired
    NamespaceConverter namespaceConverter;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TagConverter tagConverter;

    @Autowired
    Values values;

    @Autowired
    Issues issues;

    //todo validate that path/name are correct, canonicalize

    @Override
    public Mono<ResponseEntity<NamespaceDescriptor>> makeNamespace(String hostname, String path) {
        return namespaceRepository
            .findByPath(path)
            .map(x -> Pair.of(true, x))
            .switchIfEmpty(
                namespaceRepository
                    .save(new NamespaceData(null, path))
                    .map(x -> Pair.of(false, x))
            )
            .flatMap(pair ->
                namespaceConverter
                    .convert(pair.getSecond())
                    .map(desc ->
                        Pair.of(pair.getFirst(), desc)
                    )
            )
            .map(pair ->
                pair.getFirst() ?
                    ResponseEntity.ok(pair.getSecond()) :
                    ResponseEntity.created(
                        values.uri(
                            values.endpoint(
                                hostname,
                                "/namespace/"+path
                            )
                        )
                    )
                        .body(pair.getSecond())
            );
    }

    @Override
    public Mono<NamespaceDescriptor> getNamespace(String idOrPath) {
        return namespace(idOrPath)
            .flatMap(namespaceConverter::convert)
            .switchIfEmpty(issues.missingNamespace(idOrPath));
    }

    private Mono<NamespaceData> namespace(String idOrPath){
        Mono<NamespaceData> startingStream;
        try {
            var id = UUID.fromString(idOrPath);
            startingStream = namespaceRepository.findById(id);
        } catch (IllegalArgumentException e){
            startingStream = Mono.empty();
        }

        return startingStream
            .switchIfEmpty(
                namespaceRepository.findByPath(idOrPath)
            );
    }

    @Override
    public Mono<ResponseEntity<TagDescriptor>> makeTagByName(String hostname, String idOrPath, String tagName) {
        return namespace(idOrPath)
            .switchIfEmpty(issues.missingNamespace(idOrPath))
            .flatMap( nmsp ->
                tagRepository.findByNamespaceIdAndName(nmsp.id(), tagName)
                    .map(x -> Pair.of(true, x))
                    .switchIfEmpty(
                        tagRepository
                            .save(
                                new TagData(null, nmsp.id(), tagName, null)
                            )
                            .map(x -> Pair.of(false, x))
                    )
            )
            .flatMap(pair ->
                tagConverter
                    .convert(
                        pair.getSecond()
                    )
                    .map(x ->
                        Pair.of(pair.getFirst(), x)
                    )
            )
            .map(pair ->
                pair.getFirst() ?
                    ResponseEntity.ok(pair.getSecond()) :
                    ResponseEntity.created(
                            values.uri(
                                values.endpoint(
                                    hostname,
                                    "/tag/"+pair.getSecond().id().toString()
                                )
                            )
                        )
                        .body(pair.getSecond())
            );
    }

    @Override
    public Flux<TagDescriptor> getTagsByNamespace(String idOrPath) {
        return null;
    }

    @Override
    public Mono<TagDescriptor> getTagByName(String idOrPath, String tagName) {
        return null;
    }
}
