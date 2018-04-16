--
-- PostgreSQL Database
-- Initial SQL Script
--

CREATE TABLE endusers (
    id bigserial not null primary key,
    username text not null,
    password text not null,
    first_name text not null,
    last_name text not null,
    e_mail text not null
);
