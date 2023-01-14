package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;

public interface GenericNotSelector<T> {
    record NotContentSelector(
        ContentSelector not
    ) implements ContentSelector<NotContentSelector> {
        @Override
        public NotContentSelector toCanonicalForm() {
            return new NotContentSelector((ContentSelector) not.toCanonicalForm());
        }
    }

    record NotNameSelector(
        NameSelector not
    ) implements NameSelector<NotNameSelector> {
        @Override
        public NotNameSelector toCanonicalForm() {
            return new NotNameSelector((NameSelector) not.toCanonicalForm());
        }
    }

    record NotPathSelector(
        PathSelector not
    ) implements PathSelector<NotPathSelector> {
        @Override
        public NotPathSelector toCanonicalForm() {
            return new NotPathSelector((PathSelector) not.toCanonicalForm());
        }
    }

    record NotNamespaceSelector(
        NamespaceSelector not
    ) implements NamespaceSelector<NotNamespaceSelector> {
        @Override
        public NotNamespaceSelector toCanonicalForm() {
            return new NotNamespaceSelector((NamespaceSelector) not.toCanonicalForm());
        }
    }

    record NotParentSelector(
        ParentSelector not
    ) implements ParentSelector<NotParentSelector> {
        @Override
        public NotParentSelector toCanonicalForm() {
            return new NotParentSelector((ParentSelector) not.toCanonicalForm());
        }
    }

    record NotTagSelector(
        TagSelector not
    ) implements TagSelector<NotTagSelector> {
        @Override
        public NotTagSelector toCanonicalForm() {
            return new NotTagSelector((TagSelector) not.toCanonicalForm());
        }
    }

    record NotOriginSelector(
        OriginSelector not
    ) implements OriginSelector<NotOriginSelector> {
        @Override
        public NotOriginSelector toCanonicalForm() {
            return new NotOriginSelector((OriginSelector) not.toCanonicalForm());
        }
    }
}
