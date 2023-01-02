package com.github.fmd.backend.api.model.search.results;

import java.util.List;

public record HitSearchResults(
    List<HitResult> hits
) {
}
