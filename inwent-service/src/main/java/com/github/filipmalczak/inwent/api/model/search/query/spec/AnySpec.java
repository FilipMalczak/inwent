package com.github.filipmalczak.inwent.api.model.search.query.spec;

import java.util.List;

public interface AnySpec {

    record AnyContentSpec(
        List<ContentSpec> any
    ) implements ContentSpec {
    }

    record AnyNameSpec(
        List<NameSpec> any
    ) implements NameSpec {
    }

    record AnyPathSpec(
        List<PathSpec> any
    ) implements PathSpec {
    }

    record AnyNamespaceSpec(
        List<NamespaceSpec> any
    ) implements NamespaceSpec {
    }

    record AnyParentSpec(
        List<ParentSpec> any
    ) implements ParentSpec {
    }

    record AnyTagSpec(
        List<TagSpec> any
    ) implements TagSpec {
    }

    record AnyOriginSpec(
        List<OriginSpec> any
    ) implements OriginSpec {
    }
}
