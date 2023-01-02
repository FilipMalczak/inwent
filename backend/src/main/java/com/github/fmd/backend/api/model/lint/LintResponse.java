package com.github.fmd.backend.api.model.lint;

public record LintResponse(
    String subject,
    LintSubjectType subjectType,
    boolean isCanonical,
    boolean isAllowed,
    String canonicalVersion
) {
}
