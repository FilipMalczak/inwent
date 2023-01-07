package com.github.fmd.backend.api.model.search.query.spec;

public interface NotSpec {

    record NotContentSpec(
        ContentSpec not
    ) implements ContentSpec {
    }

    record NotNameSpec(
        NameSpec not
    ) implements NameSpec {
    }

    record NotPathSpec(
        PathSpec not
    ) implements PathSpec {
    }

    record NotNamespaceSpec(
        NamespaceSpec not
    ) implements NamespaceSpec {
    }

    record NotParentSpec(
        ParentSpec not
    ) implements ParentSpec {
    }

    record NotTagSpec(
        TagSpec not
    ) implements TagSpec {
    }

    record NotOriginSpec(
        OriginSpec not
    ) implements OriginSpec {
    }
}
