create table author (id int8 generated by default as identity, active boolean not null, created_date date, updated_date date, name varchar(255) not null, pseudo varchar(255), primary key (id));
create table book (id int8 generated by default as identity, active boolean not null, created_date date, updated_date date, description varchar(255) not null, title varchar(255) not null, primary key (id));
create table book_authors (book_id int8 not null, authors_id int8 not null, primary key (book_id, authors_id));
create table borrow (id int8 generated by default as identity, active boolean not null, created_date date, updated_date date, back_date date, customer_id int8 not null, primary key (id));
create table borrow_books (borrow_id int8 not null, books_id int8 not null, primary key (borrow_id, books_id));
create table customer (id int8 generated by default as identity, active boolean not null, created_date date, updated_date date, birth_date date not null, firstname varchar(255) not null, lastname varchar(255) not null, primary key (id));
create table write (prc int4 not null, book_id int8 not null, author_id int8 not null, primary key (author_id, book_id));
alter table if exists book_authors add constraint FK551i3sllw1wj7ex6nir16blsm foreign key (authors_id) references author;
alter table if exists book_authors add constraint FKs4xm7q8i3uxvaiswj1c35nnxw foreign key (book_id) references book;
alter table if exists borrow add constraint FKphxmq2f253m8rov3dgiub0oq4 foreign key (customer_id) references customer;
alter table if exists borrow_books add constraint FKcsst8lggfpu8klvlpqm4pcjds foreign key (books_id) references book;
alter table if exists borrow_books add constraint FK1kynvahukv7dmxfbvrs1no6hc foreign key (borrow_id) references borrow;
alter table if exists write add constraint FK33nkoxs6oom4na85vkc7k7a foreign key (author_id) references author;
alter table if exists write add constraint FK6gr1xpi5ooni6strs1uqwkkc1 foreign key (book_id) references book;