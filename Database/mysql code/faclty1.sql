/*use  factlty1;
create table dpet_cost(
cost int not null ,
dpet_name varchar(30) primary key not null,
dr varchar(40) not null
 )*/
/*CREATE TABLE student_dept (
    dpet VARCHAR(30) NOT NULL,
    FOREIGN KEY (dpet)
        REFERENCES dpet_cost (dpet_name),
    id INT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    age INT NOT NULL,dpet_costdpet_cost,
    per INT NOT NULL
)*/


/*
alter table student_dept 
rename to `student_dept`
*/

/*describe student_dept*/

/*alter table  dpet_cost 
add constraint   primary key(dpet_name)
*/
/*describe dpet_cost*/
/*
insert into student_dept values('cs',1,'abdo',20,100);
insert into student_dept values('cs',2,'Ali',29,90);
insert into student_dept values('cs',3,'mhmed',22,89);
insert into student_dept values('it',4,'mhmed',22,70);
insert into student_dept values('is',5,'seed',11,60);
*/
/*select * from  dpet_cost order by  cost  desc ;*/
/*select sum(cost)  from  dpet_cost  ;*/
/*
select sum(cost),dr,dpet_name  from  dpet_cost  
group by dr,dpet_name;
*/
/*select * from dpet_cost join student_dept
on dpet =dpet_name*/


/*select * from dpet_cost join student_dept
on dpet =dpet_name order by cost desc;*/


