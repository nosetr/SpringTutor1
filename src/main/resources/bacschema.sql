CREATE TABLE if NOT EXISTS photos (
    id bigint IDENTITY PRIMARY KEY,
    file_name VARCHAR(255),
    content_type VARCHAR(255),
    data binary
);
