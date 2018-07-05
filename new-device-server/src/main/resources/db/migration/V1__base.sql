--
-- PostgreSQL Database
-- Initial SQL Script
--

CREATE TABLE devices (
    id bigserial not null primary key,
    dev_eui text not null,
    used_id text not null,
    description text not null,
    location text not null
);
