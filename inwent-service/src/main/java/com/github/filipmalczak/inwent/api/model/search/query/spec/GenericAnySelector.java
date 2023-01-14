package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm;
import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;

import java.util.List;

import static com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm.canonical;

public interface GenericAnySelector {
    record AnyContentSelector(
        List<ContentSelector> any
    ) implements ContentSelector<AnyContentSelector> {
        @Override
        public AnyContentSelector toCanonicalForm() {
            return new AnyContentSelector(canonical(any));
        }
    }

    record AnyNameSelector(
        List<NameSelector> any
    ) implements NameSelector<AnyNameSelector> {
        @Override
        public AnyNameSelector toCanonicalForm() {
            return new AnyNameSelector(canonical(any));
        }
    }

    record AnyPathSelector(
        List<PathSelector> any
    ) implements PathSelector<AnyPathSelector> {
        @Override
        public AnyPathSelector toCanonicalForm() {
            return new AnyPathSelector(canonical(any));
        }
    }

    record AnyNamespaceSelector(
        List<NamespaceSelector> any
    ) implements NamespaceSelector<AnyNamespaceSelector> {
        @Override
        public AnyNamespaceSelector toCanonicalForm() {
            return new AnyNamespaceSelector(canonical(any));
        }
    }

    record AnyParentSelector(
        List<ParentSelector> any
    ) implements ParentSelector<AnyParentSelector> {
        @Override
        public AnyParentSelector toCanonicalForm() {
            return new AnyParentSelector(canonical(any));
        }
    }

    record AnyTagSelector(
        List<TagSelector> any
    ) implements TagSelector<AnyTagSelector> {
        @Override
        public AnyTagSelector toCanonicalForm() {
            return new AnyTagSelector(canonical(any));
        }
    }

    record AnyOriginSelector(
        List<OriginSelector> any
    ) implements OriginSelector<AnyOriginSelector> {
        @Override
        public AnyOriginSelector toCanonicalForm() {
            return new AnyOriginSelector(canonical(any));
        }
    }


}
