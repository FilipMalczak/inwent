package com.github.filipmalczak.inwent.impl.tag;

import com.github.filipmalczak.inwent.api.domain.TagTreeAPI;
import com.github.filipmalczak.inwent.api.model.domain.tag.TagDescriptor;
import com.github.filipmalczak.inwent.impl.common.Issues;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static reactor.core.publisher.Mono.just;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TagTreeController implements TagTreeAPI {
    @Autowired
    TagRepository repository;

    @Autowired
    TagConverter converter;

    @Autowired
    Issues issues;

    private Mono<Void> bindParentInternal(UUID childId, UUID parentId, boolean failOnBound){
        var result = repository
            .findById(childId)
            .switchIfEmpty(issues.missingTag(childId))
            .flatMap(child ->
                repository
                    .findById(parentId)
                    .flatMap(parent ->
                        parent.namespaceId().equals(child.namespaceId()) ?
                            just(child) :
                            issues.badRequest()
                    )
            );
        if (failOnBound) {
            result = result.flatMap(child ->
                child.parentId() != null ?
                    issues.parentAlreadyBound(childId) :
                    just(child)
            );
        }
            return result.map(child ->
                child.withParentId(parentId)
            )
            .flatMap(repository::save)
            .then();
    }

    @Override
    public Mono<Void> bindParent(UUID childId, UUID parentId) {
        return bindParentInternal(childId, parentId, true);
    }

    @Override
    public Mono<Void> bindOrRebindParent(UUID childId, UUID parentId) {
        return bindParentInternal(childId, parentId, false);
    }

    @Override
    public Mono<Void> unbindParent(UUID childId) {
        return repository
            .findById(childId)
            .switchIfEmpty(issues.missingTag(childId))
            .flatMap(child ->
                child.parentId() != null ?
                    just(child) :
                    issues.badRequest()
            )
            .map(child ->
                child.withParentId(null)
            )
            .flatMap(repository::save)
            .then();
    }

    @Override
    public Flux<UUID> getTagChildren(UUID parentId) {
        return repository.findAllIdsByParentId(parentId);
    }

    @Override
    public Flux<TagDescriptor> getTagChildrenDescriptions(UUID parentId) {
        return repository.findAllByParentId(parentId).flatMap(converter::convert);
    }
}
