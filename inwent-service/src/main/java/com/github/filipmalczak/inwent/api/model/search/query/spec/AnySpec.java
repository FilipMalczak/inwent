package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.ConstraintContext;

import java.util.List;

import static com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm.canonical;

public interface AnySpec extends ScopeSpec {
    @ConstraintContext
    record AnyContentSpec(
        List<ContentSpec> any
    ) implements ContentSpec<AnyContentSpec>, AnySpec {
        @Override
        public AnyContentSpec toCanonicalForm() {
            return new AnyContentSpec(canonical(any));
        }
    }

    @ConstraintContext
    record AnyNameSpec(
        List<NameSpec> any
    ) implements NameSpec<AnyNameSpec>, AnySpec {
        @Override
        public AnyNameSpec toCanonicalForm() {
            return new AnyNameSpec(canonical(any));
        }
    }

    @ConstraintContext
    record AnyPathSpec(
        List<PathSpec> any
    ) implements PathSpec<AnyPathSpec>, AnySpec {
        @Override
        public AnyPathSpec toCanonicalForm() {
            return new AnyPathSpec(canonical(any));
        }
    }

    @ConstraintContext
    record AnyNamespaceSpec(
        List<NamespaceSpec> any
    ) implements NamespaceSpec<AnyNamespaceSpec>, AnySpec {
        @Override
        public AnyNamespaceSpec toCanonicalForm() {
            return new AnyNamespaceSpec(canonical(any));
        }
    }

    @ConstraintContext
    record AnyParentSpec(
        List<ParentSpec> any
    ) implements ParentSpec<AnyParentSpec>, AnySpec {
        @Override
        public AnyParentSpec toCanonicalForm() {
            return new AnyParentSpec(canonical(any));
        }
    }

    @ConstraintContext
    record AnyTagSpec(
        List<TagSpec> any
    ) implements TagSpec<AnyTagSpec>, AnySpec {
        @Override
        public AnyTagSpec toCanonicalForm() {
            return new AnyTagSpec(canonical(any));
        }
    }

    @ConstraintContext
    record AnyOriginSpec(
        List<OriginSpec> any
    ) implements OriginSpec<AnyOriginSpec>, AnySpec {
        @Override
        public AnyOriginSpec toCanonicalForm() {
            return new AnyOriginSpec(canonical(any));
        }
    }
}
