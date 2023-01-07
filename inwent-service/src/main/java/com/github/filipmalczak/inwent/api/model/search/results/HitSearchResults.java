package com.github.filipmalczak.inwent.api.model.search.results;

import java.util.List;

public record HitSearchResults(
    List<HitResult> hits
) {
}
