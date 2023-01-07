package com.github.filipmalczak.inwent.api.model.search.query.spec;

import java.util.List;

public interface AllSelectors {

    record AllContentSelector(
        List<ContentSelector> all
    ) implements ContentSelector {
    }

    record AllNameSelector(
        List<NameSelector> all
    ) implements NameSelector {
    }

    record AllPathSelector(
        List<PathSelector> all
    ) implements PathSelector {
    }

    record AllNamespaceSelector(
        List<NamespaceSelector> all
    ) implements NamespaceSelector {
    }

    record AllParentSelector(
        List<ParentSelector> all
    ) implements ParentSelector {
    }

    record AllTagSelector(
        List<TagSelector> all
    ) implements TagSelector {
    }

    record AllOriginSelector(
        List<OriginSelector> all
    ) implements OriginSelector {
    }
}
