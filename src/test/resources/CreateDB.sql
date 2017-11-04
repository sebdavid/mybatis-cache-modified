drop table person if exists;

create table person(
	id integer,
	first_name varchar(20),
	last_name varchar(20)
);

insert into person(id, first_name, last_name) values (1, 'Jane', 'Doe'); 
insert into person(id, first_name, last_name) values (2, 'John', 'Smith'); 
