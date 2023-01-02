package com.github.fmd.backend.api.model.errors;

import java.util.List;

public record WithIssues<T> (
    T data,
    List<Issue> issues
){
}
