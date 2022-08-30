create database JNWEBML101_SMS;
use JNWEBML101_SMS;

create table Users(
user_id int auto_increment primary key,
first_name varchar(50),
last_name  varchar(50),
email varchar(50),
user_name  varchar(100),
pass_word varchar(50)
);

create table Users_Roles(
user_role_id int auto_increment primary key,
authority varchar(45),
user_id int ,
foreign key(user_id) references Users(user_id)
);

