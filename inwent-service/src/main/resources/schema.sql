CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS content(
    uri VARCHAR(255) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS location(
    id SERIAL PRIMARY KEY,
    url VARCHAR(255) NOT NULL UNIQUE,
    type VARCHAR(255) NOT NULL,
    content_id VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS origin(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid() ,
    origin_name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS namespace(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    namespace_path VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS tag(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid() ,
    namespace_id UUID,
    tag_name VARCHAR(255) NOT NULL,
    parent_id UUID,
    FOREIGN KEY (parent_id) REFERENCES tag(id),
    FOREIGN KEY (namespace_id) REFERENCES namespace(id)
);

--todo indexes!
--todo constraint on tag.parent_id so that parent.namespace_id==this.namespace_id
--todo constraint on tag.tag_name - unique in scope of namespace