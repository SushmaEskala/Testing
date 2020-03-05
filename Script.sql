drop table if exists user;

#DDL

create database PMS;

use PMS;

create table user (id bigint(20) primary key auto_increment,first_name varchar(45),last_name varchar(45),password varchar(45),email varchar(45),mobile_number varchar(45),gender varchar(45),date_of_birth date,address_id bigint(20),role_id bigint(20),foreign key (address_id) references address(id),foreign key (role_id) references role(id));

#DML

insert into user (first_name,last_name,password,email,mobile_number,gender,date_of_birth) values ('ram','kuruva','ram@123','ram@gmail.com',9632587410,'Male','21/07/1996');