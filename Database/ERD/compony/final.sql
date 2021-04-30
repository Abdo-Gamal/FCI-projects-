 /*
create database company;
use company;
 
create table department(
 
dname varchar(20) not null,
dnumber int(4) ,
mgr_ssn int(14)  ,
mgr_start_data  datetime,
primary key (dnumber)
 );
 
 create table employee(
fname varchar(10) ,
lname varchar(10) ,
ssn int(14),
bdata  datetime,
sex varchar(7),
salary float(7,2),
 
dno int(4)  not null,
 primary key (ssn),
 
  foreign key(dno)
 references department(dnumber)
 
);
 
alter table department add
foreign key  (mgr_ssn)
references employee(ssn);
 
 
 
create table project(
pname varchar(20) not null,
pnumber  int (3),
location varchar(20),
 
  primary key (pnumber)
 
);
 
create table works_on(
ess int(14),
pno int(3),
hours int(2)  default 8,
 primary key (ess,pno),
 
 foreign key (ess)
references employee(ssn),
 
 foreign key  (pno)
references project(pnumber)
 
);
alter table employee 
add column city char(20) not null ;
 
 
alter table employee 
add  check( salary >=3000 and salary<=10000);
 
describe employee;
 
 
describe department ;
insert into department (dnumber,dname) value(1,'sales');
insert into department (dnumber,dname) value(2,'sales2');
insert into department (dnumber,dname) value(3,'sales3');
insert into department (dnumber,dname) value(4,'sales4');
alter table employee 
add  check( salary >=3000.00 and salary<=10000.00);
 
 insert into employee (ssn,dno,fname,lname,salary,city) value(6,2,'abdo','gamal', 3000,'assuit');

  update department
 set mgr_ssn=6
 where dnumber =2;
 
 update department
 set mgr_ssn=1
 where dnumber =2;
 
ALTER TABLE department
MODIFY COLUMN mgr_ssn  int(14) UNIQUE ;

update department // must not work
 set mgr_ssn=33
 where dnumber =3;

select lname ,fname ,ssn from employee;
select ssn ,  lname ||' '||fname from employee

select dname  ,fname ,salary  from employee as emp ,department as dpet
where  dnumber =dno


select pname ,fname  from employee  ,project  ,works_on
where ssn=ess  and pnumber =dno

select dname ,max(salary)  from employee  ,department
where dnumber =dno
group by dname;


 insert into works_on (ess,pno,hours) value(1,2,3);

select fname ,sum(hours)  from employee  ,works_on
where ssn=ess
group by fname;

select fname ,sum(hours)  from employee  ,works_on
where ssn=ess
group by fname
having sum(hours)>10
*/ 








