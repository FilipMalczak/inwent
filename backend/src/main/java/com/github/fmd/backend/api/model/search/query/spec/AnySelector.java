package com.github.fmd.backend.api.model.search.query.spec;

import java.util.List;

public interface AnySelector {
    record AnyContentSelector(
        List<ContentSelector> any
    ) implements ContentSelector {
    }

    record AnyNameSelector(
        List<NameSelector> any
    ) implements NameSelector {
    }

    record AnyPathSelector(
        List<PathSelector> any
    ) implements PathSelector {
    }

    record AnyNamespaceSelector(
        List<NamespaceSelector> any
    ) implements NamespaceSelector {
    }

    record AnyParentSelector(
        List<ParentSelector> any
    ) implements ParentSelector {
    }

    record AnyTagSelector(
        List<TagSelector> any
    ) implements TagSelector {
    }

    record AnyOriginSelector(
        List<OriginSelector> any
    ) implements OriginSelector {
    }


}
