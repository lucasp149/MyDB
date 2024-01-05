use mydb;

/* CLIENT */

/* Zones creation */
insert into zones(name) values ("East"),("West"),("North"),("South");
select * from zones;

/* City creation */
insert into cities(name, zone_id) values ("Big City",2),("Green City",3),("Smoke City",1),("Sports City",3),("Old City",4);
select * from cities;

/* Address creation */
insert into addresses(street_name, number, city_id) values ("Quiet Street", 2525,2),
("Shopping Street", 102 ,5),  
("Running Street", 200 ,4), 
("Running Street", 320 ,4);
select * from addresses;

/* Passport creation */
insert into passports(number) values ("628A4"),("6288P"),("A1412"),("OP987"),("P1515"),("O7870");
select * from passports; 

/*Client creation */
insert into clients(first_name, last_name, address_id, passport_id) values
("Sam", "Forest", 1, 1),
("Lewis", "Ham", 4, 2),
("Bill", "Jungle", 4, 3);
select * from clients;

/* PRODUCTS */

/* Category creation */
insert into categories (name) values
("Shoes"),
("Tools"),
("Health Care"),
("Clothes"),
("Cleaning Supplies");
select * from categories;

/* Deposit creation*/
insert into deposits(name, address_id) values
("Main deposit", 2),
("Small deposit", 2),
("Backstore deposit", 2);
select * from deposits;

/* Product creation */
insert into products(name, description,price,deposit_id, category_id) values 
("Running shoes", "Super-Soft Cushioning provides a soft, luxurious feeling underfoot",120.5,1,1),
("Walking shoes", "Only-Soft Cushioning provides a soft feeling to walk",50,1,1);
insert into products(name, description,price,deposit_id, category_id) values
("Medicine box", "A medicine box cointaning many supplies", 340, 1,3),
("Summer Shirt", "In blue, green and white", 60, 1,3),
("Summer pants", "Only blue and white", 85, 2,3);
select * from categories;

/* SELLING */

/* Store creation */
insert into stores(name, address_id) values
("Main Store", 2),
("Secondary Store",1);
select * from stores; 

/* Payment creation */
insert into payments(type) values
("Cash"), 
("Credit Card"),
("Check");
select * from payments;

/* Order creation */
insert into orders(date, payment_id,client_id,store_id) values
("2023-12-18",1,1,1),
("2023-12-18",1,5,1);
insert into orders(date, payment_id,client_id,store_id) values
("2023-12-16",2,5,1);
select * from products;

/* Add products to order */
insert into order_products(orders_id, products_id, quantity) values
(4,4,1),
(5,2,2);
insert into order_products(orders_id, products_id, quantity) values
(6,8,2);
select * from order_products;
