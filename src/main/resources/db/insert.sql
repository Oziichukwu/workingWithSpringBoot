
-- Referential integrity Constrsint: It means wen a table reference another table, u can not perform delete on the table

-- turn the foreign key off
set foreign_key_checks=0;

truncate table product;

insert into product(id, name, price, quantity)

values(12, 'car', 50000, 2),
(13, 'bar', 55000, 5),
(14, 'television', 6000, 1),
(15, 'gigner', 899, 8);

set foreign_key_checks=1;




