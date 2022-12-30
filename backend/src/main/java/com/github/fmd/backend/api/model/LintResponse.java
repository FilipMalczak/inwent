package com.github.fmd.backend.api.model;

public record LintResponse(
    String subject,
    LintSubjectType subjectType,
    boolean isCanonical,
    boolean isAllowed,
    String canonicalVersion
) {
}
