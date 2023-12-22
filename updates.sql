use mydb;

/* Update City name */
update cities set name = "New City" where id = 2;
select * from cities where id = 2;

/* Update Address name and number */
update addresses set street_name = "Shopping Street II", number = 120
where id = 2;
select * from addresses;

/* Update passport number */
update passports set number = "628A5"  where id = 1;
select * from passports where id = 1;

/* Update category */
update categories set name = "Home Tools" where id = 2;
select * from categories;

/* Deposit address update */
update deposits set address_id = 3 where id = 2;
select * from deposits;

/* Product price and description update */
update products set price = 130, description = "Just walking shoes. Cute, confortable and cheap." where id = 2;
update products set description = "Just walking shoes. Cute, confortable and cheap." where id = 2;
select * from products where id = 2;

/* Payment update */
update payments set type = "Credit or Debit card" where id = 2;
select * from payments where id = 2;

/* Order date correction */
update orders set date = "2023-12-19" where id = 1;
select * from orders where id = 1;

/* Update product quantity at order */
update order_products set quantity = 3 where id = 1;
select * from order_products where id = 1;
