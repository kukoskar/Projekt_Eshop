select * from product;

update product set price = 333 where id = 1;

SELECT cast(isForSale as signed) FROM product;

insert into product
(partNumber, name, description, isForSale, price)
values
('160', 'Oranges', 'Red oranges', 1, '45');

insert into product
(partNumber, name, description, isForSale, price)
values
('180', 'Grep', 'Pink and juicy', 0, '66');

update product set name = 'Melon' where partNumber = "150";

update product set isForSale = '0' where partNumber = "43";

update product set price = '99' where partNumber = "100";

delete from product where id = 32;

delete from product where isForSale = false;

update product set description = 'Exotic citrus' where name = "Pomelo";

ALTER TABLE product MODIFY COLUMN isForSale int;


