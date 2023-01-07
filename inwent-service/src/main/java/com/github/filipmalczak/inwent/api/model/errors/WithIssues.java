package com.github.filipmalczak.inwent.api.model.errors;

import java.util.List;

public record WithIssues<T> (
    T data,
    List<Issue> issues
){
}
