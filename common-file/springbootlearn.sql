drop database if exists springbootlearn ;
create database springbootlearn;
use springbootlearn;

drop table if exists department;
create table department (
    id int auto_increment primary key,
    departmentName varchar(20)
) default charset utf8 ;

drop table if exists employee;
create table employee (
    id int auto_increment primary key,
    lastName varchar(50),
    email varchar(50),
    gender varchar(20),
    dId varchar(50)
) default charset utf8 ;

insert into employee values
(1,'张三','zhangsan@lx.com',1,2),
(3,'赵六','zhaoliu@lx.com',1,1),
(4,'张三','zhangsan@lx.com',1,1),
(5,'张三','zhangsan@lx.com',1,1),
(6,'张三','zhangsan@lx.com',1,1),
(7,'张三','zhangsan@lx.com',1,1);

insert into department(departmentName) values ('开发部');
insert into department(departmentName) values ('运维部');
insert into department(departmentName) values ('测试部');
insert into department(departmentName) values ('财务部');
insert into department(departmentName) values ('销售部');
