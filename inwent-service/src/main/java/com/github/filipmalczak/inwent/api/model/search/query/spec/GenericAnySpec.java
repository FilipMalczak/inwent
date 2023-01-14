package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm;

import java.util.List;

import static com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm.canonical;

public interface GenericAnySpec {

    record AnyContentSpec(
        List<ContentSpec> any
    ) implements ContentSpec<AnyContentSpec> {
        @Override
        public AnyContentSpec toCanonicalForm() {
            return new AnyContentSpec(canonical(any));
        }
    }

    record AnyNameSpec(
        List<NameSpec> any
    ) implements NameSpec<AnyNameSpec> {
        @Override
        public AnyNameSpec toCanonicalForm() {
            return new AnyNameSpec(canonical(any));
        }
    }

    record AnyPathSpec(
        List<PathSpec> any
    ) implements PathSpec<AnyPathSpec> {
        @Override
        public AnyPathSpec toCanonicalForm() {
            return new AnyPathSpec(canonical(any));
        }
    }

    record AnyNamespaceSpec(
        List<NamespaceSpec> any
    ) implements NamespaceSpec<AnyNamespaceSpec> {
        @Override
        public AnyNamespaceSpec toCanonicalForm() {
            return new AnyNamespaceSpec(canonical(any));
        }
    }

    record AnyParentSpec(
        List<ParentSpec> any
    ) implements ParentSpec<AnyParentSpec> {
        @Override
        public AnyParentSpec toCanonicalForm() {
            return new AnyParentSpec(canonical(any));
        }
    }

    record AnyTagSpec(
        List<TagSpec> any
    ) implements TagSpec<AnyTagSpec> {
        @Override
        public AnyTagSpec toCanonicalForm() {
            return new AnyTagSpec(canonical(any));
        }
    }

    record AnyOriginSpec(
        List<OriginSpec> any
    ) implements OriginSpec<AnyOriginSpec> {
        @Override
        public AnyOriginSpec toCanonicalForm() {
            return new AnyOriginSpec(canonical(any));
        }
    }
}
