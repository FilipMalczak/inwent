package com.github.filipmalczak.inwent.api.model.search.query.spec;

public interface NotSelector {
    record NotContentSelector(
        ContentSelector not
    ) implements ContentSelector {
    }

    record NotNameSelector(
        NameSelector not
    ) implements NameSelector {
    }

    record NotPathSelector(
        PathSelector not
    ) implements PathSelector {
    }

    record NotNamespaceSelector(
        NamespaceSelector not
    ) implements NamespaceSelector {
    }

    record NotParentSelector(
        ParentSelector not
    ) implements ParentSelector {
    }

    record NotTagSelector(
        TagSelector not
    ) implements TagSelector {
    }

    record NotOriginSelector(
        OriginSelector not
    ) implements OriginSelector {
    }
}
