package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;
import com.github.filipmalczak.inwent.api.model.search.query.meta.SyntaxSugar;

@SyntaxSugar
public record NamespaceLiteral(
    String namespace
) implements NamespaceSpec<NamespacePredicate>, Literal<NamespacePredicate> {
    @Override
    public NamespacePredicate toCanonicalForm() {
        return new NamespacePredicate(new PathPredicate(new StringValueLiteral(namespace)));
    }
}
