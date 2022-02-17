
-- Referential integrity Constraint: It means wen a table reference another table, u can not perform delete on the table

-- turn the foreign key off

set foreign_key_checks=0;

truncate table product;
truncate table item;
truncate table cart;
truncate table cart_item_list;
truncate table app_user;


insert into product(id, name, price, quantity)

values(12, 'car', 50000, 2),
(13, 'bar', 55000, 5),
(14, 'television', 6000, 1),
(15, 'gigner', 899, 8);


insert into item(id, product_id, quantity_added_cart)
values(102, 14, 2),
       (122, 15, 3),
       (133, 12, 1);

insert into cart(id)
values(345),
       (346),
       (347),
       (348);

insert into app_user(id, first_name, last_name, email, my_cart_id)
values(5005, 'caleb', 'kola', 'kola@gmail.com', 345),
      (5006, 'jeremiah', 'ola', 'ola@gmail.com', 346),
      (5007, 'bintu', 'shola', 'shola@gmail.com', 347),
      (5008, 'mike', 'yola', 'yola@gmail.com', 348);



insert into cart_item_list(cart_id, item_list_id)
values(345, 102),
       (345, 122),
       (345, 133);




set foreign_key_checks=1;




