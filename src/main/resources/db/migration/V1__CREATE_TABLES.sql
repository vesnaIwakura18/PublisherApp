create table author
(
    id         int primary key generated by default as identity,
    first_name varchar(30) not null,
    last_name  varchar(30) not null
);

create table book
(
    id             int primary key generated by default as identity,
    author_id      int          references author (id) on delete set null,
    title          varchar(100) not null,
    isbn           varchar,
    issue_datetime timestamp    not null,
    amount         int          not null
);

create table book_scan
(
    book_id           int primary key references book (id),
    scanned_date_time timestamp
);

create table publisher
(
    id         int primary key generated by default as identity,
    first_name varchar(30) not null,
    last_name  varchar(30) not null
);

create table client
(
    id     int primary key generated by default as identity,
    amount int         not null,
    name   varchar(30) not null
);

create table book_client
(
    amount    int not null,
    book_id   int not null references book (id),
    client_id int not null references client (id)
);