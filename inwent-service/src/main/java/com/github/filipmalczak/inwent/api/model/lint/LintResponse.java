package com.github.filipmalczak.inwent.api.model.lint;

public record LintResponse(
    String subject,
    LintSubjectType subjectType,
    boolean isCanonical,
    boolean isAllowed,
    String canonicalVersion
) {
}
