create table author
(
    id           bigint generated by default as identity
        primary key,
    active       boolean      not null,
    created_date date,
    updated_date date,
    name         varchar(255) not null,
    pseudo       varchar(255)
);

alter table author
    owner to postgres;

create table book
(
    id           bigint generated by default as identity
        primary key,
    active       boolean      not null,
    created_date date,
    updated_date date,
    description  varchar(255) not null,
    title        varchar(255) not null
);

alter table book
    owner to postgres;

create table book_authors
(
    book_id    bigint not null
        constraint fks4xm7q8i3uxvaiswj1c35nnxw
            references book,
    authors_id bigint not null
        constraint fk551i3sllw1wj7ex6nir16blsm
            references author,
    primary key (book_id, authors_id)
);

alter table book_authors
    owner to postgres;

create table customer
(
    id           bigint generated by default as identity
        primary key,
    active       boolean      not null,
    created_date date,
    updated_date date,
    birth_date   date         not null,
    firstname    varchar(255) not null,
    lastname     varchar(255) not null
);

alter table customer
    owner to postgres;

create table borrow
(
    id           bigint generated by default as identity
        primary key,
    active       boolean not null,
    created_date date,
    updated_date date,
    back_date    date,
    customer_id  bigint  not null
        constraint fkphxmq2f253m8rov3dgiub0oq4
            references customer
);

alter table borrow
    owner to postgres;

create table borrow_books
(
    borrow_id bigint not null
        constraint fk1kynvahukv7dmxfbvrs1no6hc
            references borrow,
    books_id  bigint not null
        constraint fkcsst8lggfpu8klvlpqm4pcjds
            references book,
    primary key (borrow_id, books_id)
);

alter table borrow_books
    owner to postgres;

create table write
(
    prc       integer not null,
    book_id   bigint  not null
        constraint fk6gr1xpi5ooni6strs1uqwkkc1
            references book,
    author_id bigint  not null
        constraint fk33nkoxs6oom4na85vkc7k7a
            references author,
    primary key (author_id, book_id)
);

alter table write
    owner to postgres;

