package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm;
import com.github.filipmalczak.inwent.api.model.search.query.meta.Selector;

import java.util.List;

import static com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm.canonical;

public interface GenericAllSelector<T> {

    record AllContentSelector(
        List<ContentSelector> all
    ) implements ContentSelector<AllContentSelector> {
        @Override
        public AllContentSelector toCanonicalForm() {
            return new AllContentSelector(canonical(all));
        }
    }



    record AllNameSelector(
        List<NameSelector> all
    ) implements NameSelector<AllNameSelector> {
        @Override
        public AllNameSelector toCanonicalForm() {
            return new AllNameSelector(canonical(all));
        }
    }

    record AllPathSelector(
        List<PathSelector> all
    ) implements PathSelector<AllPathSelector> {
        @Override
        public AllPathSelector toCanonicalForm() {
            return new AllPathSelector(canonical(all));
        }
    }

    record AllNamespaceSelector(
        List<NamespaceSelector> all
    ) implements NamespaceSelector<AllNamespaceSelector> {
        @Override
        public AllNamespaceSelector toCanonicalForm() {
            return new AllNamespaceSelector(canonical(all));
        }
    }

    record AllParentSelector(
        List<ParentSelector> all
    ) implements ParentSelector<AllParentSelector> {
        @Override
        public AllParentSelector toCanonicalForm() {
            return new AllParentSelector(canonical(all));
        }
    }

    record AllTagSelector(
        List<TagSelector> all
    ) implements TagSelector<AllTagSelector> {
        @Override
        public AllTagSelector toCanonicalForm() {
            return new AllTagSelector(canonical(all));
        }
    }

    record AllOriginSelector(
        List<OriginSelector> all
    ) implements OriginSelector<AllOriginSelector> {
        @Override
        public AllOriginSelector toCanonicalForm() {
            return new AllOriginSelector(canonical(all));
        }
    }
}
