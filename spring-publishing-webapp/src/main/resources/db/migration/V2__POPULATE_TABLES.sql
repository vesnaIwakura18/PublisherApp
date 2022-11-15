INSERT INTO author (first_name, last_name)
values ('Test1', 'Test1');
INSERT INTO author (first_name, last_name)
values ('Test2', 'Test2');
INSERT INTO author (first_name, last_name)
values ('Test3', 'Test3');
INSERT INTO author (first_name, last_name)
values ('Test4', 'Test4');
INSERT INTO author (first_name, last_name)
values ('Test5', 'Test5');

INSERT INTO book (title, issue_year, amount, author_id)
VALUES ('Test1', 2000, 50, 1);
INSERT INTO book (title, issue_year, amount, author_id)
VALUES ('Test2', 2000, 50, 2);
INSERT INTO book (title, issue_year, amount, author_id)
VALUES ('Test3', 2000, 50, 3);
INSERT INTO book (title, issue_year, amount, author_id)
VALUES ('Test4', 2000, 50, 4);
INSERT INTO book (title, issue_year, amount, author_id)
VALUES ('Test5', 2000, 50, 5);

insert into client (amount, name)
values (20, 'Test1');
insert into client (amount, name)
values (20, 'Test2');
insert into client (amount, name)
values (20, 'Test3');

insert into publisher (first_name, last_name)
VALUES ('Test1', 'Test1');
insert into publisher (first_name, last_name)
VALUES ('Test2', 'Test2');
insert into publisher (first_name, last_name)
VALUES ('Test3', 'Test3');

insert into book_client (amount, book_id, client_id)
VALUES (12, 1, 2);
insert into book_client (amount, book_id, client_id)
VALUES (12, 2, 1);
insert into book_client (amount, book_id, client_id)
VALUES (12, 3, 5);