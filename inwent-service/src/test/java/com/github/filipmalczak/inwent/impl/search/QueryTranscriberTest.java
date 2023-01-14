package com.github.filipmalczak.inwent.impl.search;

import com.github.filipmalczak.inwent.api.model.search.query.HitQuery;
import com.github.filipmalczak.inwent.api.model.search.query.spec.NamePredicate;
import com.github.filipmalczak.inwent.api.model.search.query.spec.RegexLiteral;
import com.github.filipmalczak.inwent.api.model.search.query.spec.TagLiteral;
import com.github.filipmalczak.inwent.api.model.search.query.spec.TagPredicate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class QueryTranscriberTest {
    @Test
    void nullRenderWhereTagLiteral(){
        var t = new QueryTranscriber(
            new HitQuery(
                null,
                asList(
                    new TagLiteral("howdy")
                )
            )
        );
        var expectation = "SELECT * FROM hit h JOIN tag t0 ON h.tag_id = t0.id WHERE (t0.tag_name = howdy);";
        assertEquals(expectation, t.getSql());
    }

    @Test
    void nullRenderWhereTagNameRegex(){
        var t = new QueryTranscriber(
            new HitQuery(
                null,
                asList(
                    new TagPredicate(
                        new NamePredicate(
                            new RegexLiteral(
                                "ma.*ma"
                            )
                        )
                    )
                )
            )
        );
        var expectation = "SELECT * FROM hit h JOIN tag t0 ON h.tag_id = t0.id WHERE (t0.tag_name LIKE ma.*ma);";
        assertEquals(expectation, t.getSql());
    }
}