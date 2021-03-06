DROP TABLE user IF EXISTS;

create table user (
    id bigint generated by default as identity,
    create_date timestamp,
    modified_date timestamp,
    email varchar(255) not null,
    name varchar(255) not null,
    picture varchar(255),
    primary key (id)
);