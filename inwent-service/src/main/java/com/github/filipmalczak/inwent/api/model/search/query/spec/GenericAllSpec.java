package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm;

import java.util.List;

import static com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm.canonical;

public interface GenericAllSpec {

    record AllContentSpec(
        List<ContentSpec> all
    ) implements ContentSpec<AllContentSpec> {
        @Override
        public AllContentSpec toCanonicalForm() {
            return new AllContentSpec(canonical(all));
        }
    }

    record AllNameSpec(
        List<NameSpec> all
    ) implements NameSpec<AllNameSpec> {
        @Override
        public AllNameSpec toCanonicalForm() {
            return new AllNameSpec(canonical(all));
        }
    }

    record AllPathSpec(
        List<PathSpec> all
    ) implements PathSpec<AllPathSpec> {
        @Override
        public AllPathSpec toCanonicalForm() {
            return new AllPathSpec(canonical(all));
        }
    }

    record AllNamespaceSpec(
        List<NamespaceSpec> all
    ) implements NamespaceSpec<AllNamespaceSpec> {
        @Override
        public AllNamespaceSpec toCanonicalForm() {
            return new AllNamespaceSpec(canonical(all));
        }
    }

    record AllParentSpec(
        List<ParentSpec> all
    ) implements ParentSpec<AllParentSpec> {
        @Override
        public AllParentSpec toCanonicalForm() {
            return new AllParentSpec(canonical(all));
        }
    }

    record AllTagSpec(
        List<TagSpec> all
    ) implements TagSpec<AllTagSpec> {
        @Override
        public AllTagSpec toCanonicalForm() {
            return new AllTagSpec(canonical(all));
        }
    }

    record AllOriginSpec(
        List<OriginSpec> all
    ) implements OriginSpec<AllOriginSpec> {
        @Override
        public AllOriginSpec toCanonicalForm() {
            return new AllOriginSpec(canonical(all));
        }
    }
}
