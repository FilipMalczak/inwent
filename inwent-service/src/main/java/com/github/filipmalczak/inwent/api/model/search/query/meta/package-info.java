/**
 * This package holds the marker(ish) types used to keep the DSL consistently-structures.
 *
 * Generally, when querying for X (e.g. Hit), you send a XQuery.
 * A query consists of rendering details and search criteria.
 *
 * The criteria are built out of YSpecs of things Y relating to X (e.g. X=Hit, Y=Tag/Origin/Content).
 *
 * YSpec is either a YLiteral (<code>{"tag": "name"}</code>) or a YPredicate (<code>{"tag": { ... }}</code>).
 * YPredicate has form <code>{"Y": YSelector}</code>.
 *
 * For example, given <code>{"tag": {"name": {"regex" "..."}}}</code>, the whole thing is a TagPredicate (so, a TagSpec),
 * the object with "name" key is a TagSelector, but also a NameSpec (NamePredicate, to be precise). The "regex" object
 * is a RegexLiteral, which is also a NameSelector.
 *
 * Additionally, some things has syntactic sugar. For example, <code>{"tag": {"name": {"value" "X"}}}</code>
 * (a tag predicate) can be written as <code>{"tag": "X"}</code> which is a TagLiteral. The former is called a "canonical form".
 * <code>HasCanonicalForm<X></code> is a type that stands for something represented by X, for example
 * <code>TagLiteral implements HasCanonicalForm<TagPredicate></TagPredicate></code>.
 */
package com.github.filipmalczak.inwent.api.model.search.query.meta;