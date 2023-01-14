package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.ConstraintContext;
import com.github.filipmalczak.inwent.impl.search.sql.Scope;

import java.util.List;

import static com.github.filipmalczak.inwent.api.model.search.query.meta.HasCanonicalForm.canonical;

public interface AllSpec extends ScopeSpec {
    @ConstraintContext
    record AllContentSpec(
        List<ContentSpec> all
    ) implements ContentSpec<AllContentSpec>, AllSpec {
        @Override
        public AllContentSpec toCanonicalForm() {
            return new AllContentSpec(canonical(all));
        }
    }

    @ConstraintContext
    record AllNameSpec(
        List<NameSpec> all
    ) implements NameSpec<AllNameSpec>, AllSpec {
        @Override
        public AllNameSpec toCanonicalForm() {
            return new AllNameSpec(canonical(all));
        }
    }

    @ConstraintContext
    record AllPathSpec(
        List<PathSpec> all
    ) implements PathSpec<AllPathSpec>, AllSpec {
        @Override
        public AllPathSpec toCanonicalForm() {
            return new AllPathSpec(canonical(all));
        }
    }

    @ConstraintContext
    record AllNamespaceSpec(
        List<NamespaceSpec> all
    ) implements NamespaceSpec<AllNamespaceSpec>, AllSpec {
        @Override
        public AllNamespaceSpec toCanonicalForm() {
            return new AllNamespaceSpec(canonical(all));
        }
    }

    @ConstraintContext
    record AllParentSpec(
        List<ParentSpec> all
    ) implements ParentSpec<AllParentSpec>, AllSpec {
        @Override
        public AllParentSpec toCanonicalForm() {
            return new AllParentSpec(canonical(all));
        }
    }

    @ConstraintContext
    record AllTagSpec(
        List<TagSpec> all
    ) implements TagSpec<AllTagSpec>, AllSpec {
        @Override
        public AllTagSpec toCanonicalForm() {
            return new AllTagSpec(canonical(all));
        }
    }

    @ConstraintContext
    record AllOriginSpec(
        List<OriginSpec> all
    ) implements OriginSpec<AllOriginSpec>, AllSpec {
        @Override
        public AllOriginSpec toCanonicalForm() {
            return new AllOriginSpec(canonical(all));
        }
    }
}
