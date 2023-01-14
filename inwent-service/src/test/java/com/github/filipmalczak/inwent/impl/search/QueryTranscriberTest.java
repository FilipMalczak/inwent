package com.github.filipmalczak.inwent.impl.search;

import com.github.filipmalczak.inwent.api.model.search.query.HitQuery;
import com.github.filipmalczak.inwent.api.model.search.query.spec.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        var expectation = "SELECT * FROM hit h JOIN tag t0 ON h.tag_id = t0.id WHERE (t0.tag_name = \"howdy\");";
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
        var expectation = "SELECT * FROM hit h JOIN tag t0 ON h.tag_id = t0.id WHERE (t0.tag_name ~ \"ma.*ma\");";
        assertEquals(expectation, t.getSql());
    }

    @Test
    void nullRenderWhereTagNamespaceLiteral(){
        var t = new QueryTranscriber(
            new HitQuery(
                null,
                asList(
                    new TagPredicate(
                        new NamespaceLiteral(
                            "foo.bar"
                        )
                    )
                )
            )
        );
        var expectation = "SELECT * FROM hit h JOIN tag t0 ON h.tag_id = t0.id JOIN namespace n0 ON t0.namespace_id = n0.id WHERE (n0.namespace_path = \"foo.bar\");";
        assertEquals(expectation, t.getSql());
    }

    @Test
    void nullRenderWhereAllTagNameNamespaceRgx(){
        var t = new QueryTranscriber(
            new HitQuery(
                null,
                asList(
                    new AllSpec.AllTagSpec(asList(
                        new TagPredicate(
                            new NamePredicate(
                                new RegexLiteral(
                                    "ma.*ma"
                                )
                            )
                        ),
                        new TagPredicate(
                            new NamespacePredicate(
                                new PathPredicate(
                                    new RegexLiteral(
                                        "da.*da"
                                    )
                                )
                            )
                        )
                    ))
                )
            )
        );
        var expectation = "SELECT * FROM hit h JOIN tag t0 ON h.tag_id = t0.id JOIN namespace n0 ON t0.namespace_id = n0.id WHERE ((n0.namespace_path ~ \"da.*da\") AND (t0.tag_name ~ \"ma.*ma\"));";
        assertEquals(expectation, t.getSql());
    }

    @Test
    void nullRenderWhereTagAnyName2Rgx(){
        var t = new QueryTranscriber(
            new HitQuery(
                null,
                asList(
                    new TagPredicate(
                        new AnySpec.AnyNameSpec(asList(
                            new NamePredicate(
                                new RegexLiteral(
                                    "ma.*ma"
                                )
                            ),
                            new NamePredicate(
                                new RegexLiteral(
                                    "da.*da"
                                )
                            )
                        ))
                    )
                )
            )
        );
        var expectation = "SELECT * FROM hit h JOIN tag t0 ON h.tag_id = t0.id WHERE ((t0.tag_name ~ \"da.*da\") OR (t0.tag_name ~ \"ma.*ma\"));";
        assertEquals(expectation, t.getSql());
    }
}