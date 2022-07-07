INSERT INTO author(id, created_date, is_active, updated_date) VALUES (1, now(), true, now());
INSERT INTO book(id, created_date, is_active, updated_date, description, title) VALUES (1, now(), true, now(), 'BLOP', 'BLOP');

INSERT INTO book_authors(book_id, authors_id) VALUES (1,1);
