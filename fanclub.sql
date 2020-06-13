create database if not exists fanclub;

use fanclub;

drop table if exists members;

create table members (
		id int(10) not null auto_increment,
		first_name varchar(25) not null,
		last_name varchar(25) not null,
		email_address varchar(50) not null,
		favorite_album varchar(50) not null,
		primary key(id)
);