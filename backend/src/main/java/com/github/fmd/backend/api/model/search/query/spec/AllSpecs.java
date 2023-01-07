package com.github.fmd.backend.api.model.search.query.spec;

import java.util.List;

public interface AllSpecs {

    record AllContentSpec(
        List<ContentSpec> all
    ) implements ContentSpec {
    }

    record AllNameSpec(
        List<NameSpec> all
    ) implements NameSpec {
    }

    record AllPathSpec(
        List<PathSpec> all
    ) implements PathSpec {
    }

    record AllNamespaceSpec(
        List<NamespaceSpec> all
    ) implements NamespaceSpec {
    }

    record AllParentSpec(
        List<ParentSpec> all
    ) implements ParentSpec {
    }

    record AllTagSpec(
        List<TagSpec> all
    ) implements TagSpec {
    }

    record AllOriginSpec(
        List<OriginSpec> all
    ) implements OriginSpec {
    }
}
