package com.github.filipmalczak.inwent.api.model.search.query.spec;

public interface GenericNotSpec {
    record NotContentSpec(
        ContentSpec not
    ) implements ContentSpec<GenericNotSpec.NotContentSpec> {
        @Override
        public GenericNotSpec.NotContentSpec toCanonicalForm() {
            return new GenericNotSpec.NotContentSpec((ContentSpec) not.toCanonicalForm());
        }
    }

    record NotNameSpec(
        NameSpec not
    ) implements NameSpec<GenericNotSpec.NotNameSpec> {
        @Override
        public GenericNotSpec.NotNameSpec toCanonicalForm() {
            return new GenericNotSpec.NotNameSpec((NameSpec) not.toCanonicalForm());
        }
    }

    record NotPathSpec(
        PathSpec not
    ) implements PathSpec<GenericNotSpec.NotPathSpec> {
        @Override
        public GenericNotSpec.NotPathSpec toCanonicalForm() {
            return new GenericNotSpec.NotPathSpec((PathSpec) not.toCanonicalForm());
        }
    }

    record NotNamespaceSpec(
        NamespaceSpec not
    ) implements NamespaceSpec<GenericNotSpec.NotNamespaceSpec> {
        @Override
        public GenericNotSpec.NotNamespaceSpec toCanonicalForm() {
            return new GenericNotSpec.NotNamespaceSpec((NamespaceSpec) not.toCanonicalForm());
        }
    }

    record NotParentSpec(
        ParentSpec not
    ) implements ParentSpec<GenericNotSpec.NotParentSpec> {
        @Override
        public GenericNotSpec.NotParentSpec toCanonicalForm() {
            return new GenericNotSpec.NotParentSpec((ParentSpec) not.toCanonicalForm());
        }
    }

    record NotTagSpec(
        TagSpec not
    ) implements TagSpec<GenericNotSpec.NotTagSpec> {
        @Override
        public GenericNotSpec.NotTagSpec toCanonicalForm() {
            return new GenericNotSpec.NotTagSpec((TagSpec) not.toCanonicalForm());
        }
    }

    record NotOriginSpec(
        OriginSpec not
    ) implements OriginSpec<GenericNotSpec.NotOriginSpec> {
        @Override
        public GenericNotSpec.NotOriginSpec toCanonicalForm() {
            return new GenericNotSpec.NotOriginSpec((OriginSpec) not.toCanonicalForm());
        }
    }
}
