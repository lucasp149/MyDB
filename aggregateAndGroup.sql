use mydb;

/*1 How many times the product number 1 has been ordered */
select COUNT(order_products.id)
from order_products
where order_products.products_id = 1;

/*2 How many times the product number 1 or 2 has been ordered  with product id*/
select COUNT(order_products.id), order_products.products_id
from order_products
group by order_products.products_id;

/*3 Sum the ammount of order number 1 */
select sum(p.price*quantity)
from products p
inner join order_products on order_products.products_id = p.id
inner join orders on orders.id = 1;

/*4 Average price of all products */
select avg(p.price)
from products p;

/*5 Show the minimun price */
select min(p.price)
from products p;

/*6 Show the maximun price */
select max(p.price)
from products p;

/*7 Show zones related cities sum */
select zone_id, count(cities.zone_id) as number_of_instances
from cities
group by zone_id;

/*1 Show products price only when its bigger than 120, ordered by price */
select count(products.id), price
from products
group by price
having price > 120;


/*2 Show cities that has been addressed one time */
select count(cities.id), cities.name
from cities
inner join addresses on cities.id = addresses.city_id
group by cities.name
having count(cities.id) = 1;

/*3 Show products that has been selled on more than one order */
select count(p.id), p.name
from order_products op
inner join products p on p.id = op.products_id
group by p.id
having count(p.id) > 1;

/*4 Show categories that have been used more than one time on products */
select count(p.id), c.name,  p.category_id
from products p
left join categories c on c.id = p.category_id
group by p.category_id
having count(p.id) > 1
order by p.category_id;

/*5 Show clients that have at least one order an that contains an "a" on their First Name */
select count(c.id), c.first_name
from clients c
inner join orders o on o.client_id = c.id
group by c.first_name
having c.first_name LIKE "%a%";

/*6 Show passports numbers that contains the number 7 or 6 */
select count(p.id), p.number
from passports p
group by p.number
having p.number LIKE "%7%" or p.number LIKE "%6%";

/*7 Show passports numbers that contains the number 7 or 6 only if their has been used */
select count(p.id), p.number
from passports p
inner join clients c on c.passport_id = p.id
group by p.number
having p.number LIKE "%7%" or p.number LIKE "%6%";

select * from products;