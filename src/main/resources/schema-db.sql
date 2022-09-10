create table if not exists users (
    id NUMERIC PRIMARY KEY,
    name TEXT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);