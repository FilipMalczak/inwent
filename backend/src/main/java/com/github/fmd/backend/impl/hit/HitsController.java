package com.github.fmd.backend.impl.hit;

import com.github.fmd.backend.api.domain.HitAPI;
import com.github.fmd.backend.api.model.domain.hit.HitsBatchRequest;
import com.github.fmd.backend.api.model.domain.hit.HitsBatchResponse;
import com.github.fmd.backend.api.model.errors.WithIssues;
import com.github.fmd.backend.api.model.search.query.HitQuery;
import com.github.fmd.backend.api.model.search.results.HitSearchResults;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.util.Arrays.asList;

@RestController
public class HitsController implements HitAPI {


    @Override
    public Flux<WithIssues<HitsBatchResponse>> makeHits(@RequestBody Flux<HitsBatchRequest> requests){
        return requests.map(r -> new WithIssues<>(new HitsBatchResponse(r.originId(), asList(), asList()), asList()));
    }

    @Override
    public Flux<HitSearchResults> queryHits(Mono<HitQuery> query) {
        return null;
    }
}
