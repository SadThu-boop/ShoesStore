/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  phucl
 * Created: Oct 28, 2023
 */

use master
go

create database WebApplication1
go
use WebApplication1
go


create table [User](
	id int identity,
	email varchar(50),
	username varchar(50) unique not null,
	[password] varchar(36) not null,
	avatar varchar(50),
	role_id int,
	primary key(id)
)
create table Category(
	cate_id int identity primary key,
	cate_name nvarchar(255) not null,
)

create table Product(
	id int identity primary key,
	[name] nvarchar(255) not null,
	price float ,
	cate_id int references Category(cate_id) not null,
	des varchar(2000),
	image varchar(50),
)


create table Cart(
	id varchar(50) primary key,
	u_id int references [User](id) not null ,
	buyDate date
)
create table CartItem(
	id varchar(50) primary key,
	quantity int,
	unitPrice float,
	pro_id int references Product(id) not null,
	cat_id varchar(50) references Cart(id) not null
)

