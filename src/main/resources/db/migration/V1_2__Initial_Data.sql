INSERT INTO book (active, created_date, updated_date, description, title) VALUES
    (true, now(), now(), 'Livre 1 - Desc', 'Livre 1'),
    (true, now(), now(),'Livre 2 - Desc', 'Livre 2'),
    (true, now(), now(), 'Livre 3 - Desc', 'Livre 3'),
    (true, now(), now(), 'Livre 4 - Desc', 'Livre 4'),
    (true, now(), now(), 'Livre 5 - Desc', 'Livre 5'),
    (true, now(), now(), 'Livre 6 - Desc', 'Livre 6'),
    (true, now(), now(), 'Livre 7 - Desc', 'Livre 7'),
    (true, now(), now(), 'Livre 8 - Desc', 'Livre 8'),
    (true, now(), now(), 'Livre 9 - Desc', 'Livre 9'),
    (true, now(), now(), 'Livre 10 - Desc', 'Livre 10');

INSERT INTO customer(active, created_date, updated_date, birth_date, firstname, lastname) VALUES
    (true, now(), now(), now(), 'Flavian', 'Ovyn'),
    (true, now(), now(), now(), 'Alexandre', 'Kimtarsis'),
    (true, now(), now(), now(), 'Mélanie', 'Geert'),
    (true, now(), now(), now(), 'Jérome', 'Vanoproek'),
    (true, now(), now(), now(), 'Caroline', 'Herssens'),
    (true, now(), now(), now(), 'Michaël', 'Person'),
    (true, now(), now(), now(), 'Thierry', 'Morre'),
    (true, now(), now(), now(), 'Aurélien', 'Strimelle'),
    (true, now(), now(), now(), 'Julien', 'Coppin'),
    (true, now(), now(), now(), 'Gregory', 'Ceulers');

INSERT INTO author(active, created_date, updated_date, name, pseudo) VALUES
    (true, now(), now(), 'Tolkien', null);

INSERT INTO write(prc, book_id, author_id) VALUES
    (100, 1,1),
    (100, 2,1),
    (100, 3,1),
    (100, 4,1);
