package com.github.fmd.backend.api.domain;

import com.github.fmd.backend.api.model.domain.hit.HitsBatchRequest;
import com.github.fmd.backend.api.model.domain.hit.HitsBatchResponse;
import com.github.fmd.backend.api.model.errors.WithIssues;
import com.github.fmd.backend.api.model.search.query.HitQuery;
import com.github.fmd.backend.api.model.search.results.HitSearchResults;
import com.github.fmd.backend.api.security.Stability;
import com.github.fmd.backend.api.security.annotations.AccessToken;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Tag(name = "Hit management", description = Stability.EVOLVING)
@AccessToken
@RequestMapping("/api/v${api.version}")
public interface HitAPI {

    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200")
    })
    @PostMapping("/hit")
    Flux<WithIssues<HitsBatchResponse>> makeHits(@RequestBody Flux<HitsBatchRequest> requests);


    @Operation(responses = {
        @ApiResponse(description = "OK", responseCode = "200")
    })
    @PostMapping("/hit/query")
    Flux<HitSearchResults> queryHits(@RequestBody Mono<HitQuery> query);
}
