package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Literal;
import com.github.filipmalczak.inwent.api.model.search.query.meta.SyntaxSugar;

@SyntaxSugar
public record TagLiteral(
    String tag
) implements TagSpec<TagPredicate>, Literal<TagPredicate> {
    @Override
    public TagPredicate toCanonicalForm() {
        return new TagPredicate(new NamePredicate(new StringValueLiteral(tag)));
    }
}
