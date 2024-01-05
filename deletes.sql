use mydb;

/* Delete City */
delete from cities where id = 3;
select * from cities;

/* Delete Address */
SET FOREIGN_KEY_CHECKS=0; -- to disable them
delete from addresses  where id = 3;
SET FOREIGN_KEY_CHECKS=1; -- to re-enable them
select * from addresses;

/* Delete Passport */
delete from passports where id = 5;
select * from passports;

/* Delete client */ 
delete from clients where id = 2;
select * from clients;

/* Delete categories */
delete from categories where id = 4;
delete from categories where id = 5;
select * from categories;

/* Delete deposits */
delete from deposits where id = 3;
select * from deposits;

/* Delete product */
delete from products where id = 3;
select * from products;

/* Delete Stores */
delete from stores where id = 2;
select * from stores;

/* Delete product from order */
delete from order_products where id = 2;
select * from order_products;

/* Reinsert product to order */
insert into order_products (orders_id, products_id, quantity) values
(1,2,1);