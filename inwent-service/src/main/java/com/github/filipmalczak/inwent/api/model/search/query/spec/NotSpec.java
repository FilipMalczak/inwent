package com.github.filipmalczak.inwent.api.model.search.query.spec;

import com.github.filipmalczak.inwent.api.model.search.query.meta.ConstraintContext;

public interface NotSpec extends ScopeSpec {
    @ConstraintContext
    record NotContentSpec(
        ContentSpec not
    ) implements ContentSpec<NotSpec.NotContentSpec>, NotSpec {
        @Override
        public NotSpec.NotContentSpec toCanonicalForm() {
            return new NotSpec.NotContentSpec((ContentSpec) not.toCanonicalForm());
        }
    }

    @ConstraintContext
    record NotNameSpec(
        NameSpec not
    ) implements NameSpec<NotSpec.NotNameSpec>, NotSpec {
        @Override
        public NotSpec.NotNameSpec toCanonicalForm() {
            return new NotSpec.NotNameSpec((NameSpec) not.toCanonicalForm());
        }
    }

    @ConstraintContext
    record NotPathSpec(
        PathSpec not
    ) implements PathSpec<NotSpec.NotPathSpec>, NotSpec {
        @Override
        public NotSpec.NotPathSpec toCanonicalForm() {
            return new NotSpec.NotPathSpec((PathSpec) not.toCanonicalForm());
        }
    }

    @ConstraintContext
    record NotNamespaceSpec(
        NamespaceSpec not
    ) implements NamespaceSpec<NotSpec.NotNamespaceSpec>, NotSpec {
        @Override
        public NotSpec.NotNamespaceSpec toCanonicalForm() {
            return new NotSpec.NotNamespaceSpec((NamespaceSpec) not.toCanonicalForm());
        }
    }

    @ConstraintContext
    record NotParentSpec(
        ParentSpec not
    ) implements ParentSpec<NotSpec.NotParentSpec>, NotSpec {
        @Override
        public NotSpec.NotParentSpec toCanonicalForm() {
            return new NotSpec.NotParentSpec((ParentSpec) not.toCanonicalForm());
        }
    }

    @ConstraintContext
    record NotTagSpec(
        TagSpec not
    ) implements TagSpec<NotSpec.NotTagSpec>, NotSpec {
        @Override
        public NotSpec.NotTagSpec toCanonicalForm() {
            return new NotSpec.NotTagSpec((TagSpec) not.toCanonicalForm());
        }
    }

    @ConstraintContext
    record NotOriginSpec(
        OriginSpec not
    ) implements OriginSpec<NotSpec.NotOriginSpec>, NotSpec {
        @Override
        public NotSpec.NotOriginSpec toCanonicalForm() {
            return new NotSpec.NotOriginSpec((OriginSpec) not.toCanonicalForm());
        }
    }
}
