use mydb;


/* Super Join */

select 
o.date, 
pay.type as payment,
prod.name as product, prod.price as price, op.quantity as quantity, cat.name as category,
s.name as Store, 
a.street_name as Store_street, a.number as Store_number,
city.name as city,
z.name as zone,
c.first_name as client_first_name, c.last_name as client_last_name, 
p.number as client_passport,
dep.name as deposit
from
clients c
inner join passports p on c.passport_id = p.id
inner join orders o on o.client_id = c.id
inner join order_products op on op.orders_id = o.id
inner join products prod on prod.id = op.products_id
inner join categories cat on cat.id = prod.category_id
inner join payments pay on pay.id =  o.payment_id
inner join deposits dep on dep.id = prod.deposit_id
inner join stores s on s.id = o.store_id
inner join addresses a on a.id = s.address_id
inner join cities city on city.id = a.city_id
inner join zones z on z.id = city.zone_id;

/* Left, Right, Outer Joins */
/* Show all clients but only with client id */
select *
from clients c
left join orders o on c.id = o.client_id;

/* Show all orders but only clients that had made orders */
select *
from orders o 
left join clients c on c.id = o.client_id;

/* Show all addresses even is there are not related to a city */
select *
from addresses a
left join cities c on c.id = a.city_id;

/* Show all cities even when has no address related */
select *
from addresses a
right join cities c on c.id = a.city_id;

/* Show zone name from zones related with cities related with addresses */
select zones.name
from zones
inner join cities c on zones.id = c.zone_id
right join addresses a on a.city_id = c.id;




