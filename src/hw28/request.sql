create table sales(
                      id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                      product VARCHAR(256) NOT NULL,
                      price DOUBLE,
                      quantity INT
);
insert into sales(product, price, quantity) values ('Laptop', 1000.0, 5),
                                                   ('Phone', 700.0, 3),
                                                   ('Tablet', 500.0, 2),
                                                   ('Printer', 300.0, 4);
select * from sales
         limit 2;
select sum(price * quantity) as total_value
from sales;
select product,
       sum(quantity) as quantity,
       sum(price) as price
from sales
group by product;
