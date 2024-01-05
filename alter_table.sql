use mydb;

/* Add new column */
alter table payments add
status boolean;
select * from payments;

/* Rename column name */
alter table payments rename
column status to is_online;
select * from payments;

/* Change data type */
alter table payments modify column
is_online varchar(1);
select * from payments;

/* Delete column */
alter table payments drop column
is_online;
select * from payments;