
create table if not exists customer (
	customer_id int auto_increment primary key,
    first_name varchar(20) not null,
    last_name varchar(30) not null,
    e_mail varchar(50),
    phone varchar(12),
    created_at timestamp default current_timestamp
);

create table if not exists author (
	author_id int auto_increment primary key,
    first_name varchar(20) not null,
    last_name varchar(30) not null
);

create table if not exists book (
	isbn varchar(13) primary key,
    title varchar(50) not null,
    publication_date date not null,
    format varchar(9),
    price decimal(5, 2)
);

insert into customer(first_name, last_name, e_mail, phone) values 
	('John', 'Smith', 'john.smith@verizon.net', '553-340-1230');
insert into customer(first_name, last_name, e_mail, phone) values 
	('Mary', 'Johnson', 'mary.johnson@', '555-123-4567');
insert into customer(first_name, last_name, e_mail, phone) values 
	('Bob', 'Collins', 'bob.collins@', '555-012-3456');
insert into customer(first_name, last_name, e_mail, phone) values 
	('Rebecca', 'Mayer', 'rebecca.mayer@gmail.com', '555-205-8212');
insert into customer(first_name, last_name, e_mail, phone) values 
	('Anthony', 'Clark', 'antony.clark@gmail.com', '555-256-1901');
insert into customer(first_name, last_name, e_mail, phone) values 
	('Judy', 'Sousa', 'judy.sousa@verizon.net', '555-751-1207');
insert into customer(first_name, last_name, e_mail, phone) values 
	('Christopher', 'Patriquin', 'patriquinc@yahoo.com', '555-316-1803');
insert into customer(first_name, last_name, e_mail, phone) values 
	('Deborah', 'Smith', 'debsmith@comcast.net', '555-256-3421');
insert into customer(first_name, last_name, e_mail, phone) values 
	('Jennifer', 'McGinn', 'jmcginn@comcast.net', '555-250-0918');

insert into book(isbn, title, publication_date, format, price) values 
	('142311339X', 'The Lost Hero (Heroes of Olympus, Book 1)', str_to_date('12, 10, 2010', '%d, %m, %Y'), 'Hardcover', 10.95);
insert into book(isbn, title, publication_date, format, price) values 
	('0689852223', 'The House of the Scorpion', str_to_date('1, 1, 2002', '%d, %m, %Y'), 'Hardcover', 16.95);
insert into book(isbn, title, publication_date, format, price) values 
	('0525423656', 'Crossed (Matched Trilogy, Book 2)', str_to_date('1, 11, 2011', '%d, %m, %Y'), 'Hardcover', 12.95);
insert into book(isbn, title, publication_date, format, price) values 
	('1423153627', 'The Kane Chronicles Survival Guide', str_to_date('1, 3, 2012', '%d, %m, %Y'), 'Hardcover', 13.95);
insert into book(isbn, title, publication_date, format, price) values 
	('0439371112', 'Howliday Inn', str_to_date('1, 11, 2001', '%d, %m, %Y'), 'Paperback', 14.95);
insert into book(isbn, title, publication_date, format, price) values 
	('0439861306', 'The Lightning Thief', str_to_date('12, 3, 2006', '%d, %m, %Y'), 'Paperback', 11.95);
insert into book(isbn, title, publication_date, format, price) values 
	('031673737X', 'How to Train Your Dragon', str_to_date('1, 2, 2010', '%d, %m, %Y'), 'Hardcover', null);
insert into book(isbn, title, publication_date, format, price) values 
	('0545078059', 'The White Giraffe', str_to_date('1, 5, 2008', '%d, %m, %Y'), 'Paperback', 6.95);
insert into book(isbn, title, publication_date, format, price) values 
	('0803733428', 'The Last Leopard', str_to_date('5, 3, 2009', '%d, %m, %Y'), 'Hardcover', null);
insert into book(isbn, title, publication_date, format, price) values 
	('9780545236', 'Freaky Monday', str_to_date('15, 1, 2010', '%d, %m, %Y'), 'Paperback', 12.95);

insert into author(first_name, last_name) values ('Rick', 'Riordan');
insert into author(first_name, last_name) values ('Nancy', 'Farmer');
insert into author(first_name, last_name) values ('Ally', 'Condie');
insert into author(first_name, last_name) values ('Cressida', 'Cowell');
insert into author(first_name, last_name) values ('Lauren', 'St. John');
insert into author(first_name, last_name) values ('Eoin', 'Colfer');
insert into author(first_name, last_name) values ('Esther', 'Freisner');
insert into author(first_name, last_name) values ('Chris', 'D\'lacey');
insert into author(first_name, last_name) values ('Mary', 'Rodgers');
insert into author(first_name, last_name) values ('Heather', 'Hatch');

drop function if exists hello_sda_function;

create function hello_sda_function(name varchar(20))
returns varchar(40)
deterministic
return concat('Hello from SDA, ', name, '!');

