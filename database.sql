CREATE DATABASE IF NOT EXISTS group09;

use group09;
CREATE TABLE IF NOT EXISTS user_info (
    user_id int auto_increment primary key,
    user_name varchar(40) not null,
    user_surname varchar(40) not null,
    username varchar(40) not null unique, 
    user_password varchar(40) not null, 
    user_role varchar(10) not null, 
    user_address varchar(200),
    user_phone varchar(10)
);

use group09;
CREATE TABLE IF NOT EXISTS product_info (
    p_id int auto_increment primary key,
    p_name varchar(40) not null unique,
    p_type varchar(20) not null,
    p_price double not null,
    p_stock double not null, 
    p_kg double not null, 
    p_image varchar(50) not null
);


use group09;
CREATE TABLE IF NOT EXISTS cart_info (
    c_id int auto_increment primary key,
    customer_id int not null,
    p_name varchar(50) not null,
    p_price double not null,
    p_kg double not null,
    p_image varchar(50) not null
);



use group09;
CREATE TABLE IF NOT EXISTS order_info (
	orderID int,
    order_customer_id int not null,
    order_p_name varchar(50) not null,
    order_p_price double not null,
    order_p_kg double not null,
    order_p_image varchar(50) not null,
    order_status varchar(50) not null,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO order_info (order_customer_id, order_p_name, order_p_price, order_p_kg, order_p_image, order_status, time) SELECT customer_id, p_name, p_price, p_kg, p_image, 'Sipariş alındı', NOW() FROM cart_info WHERE customer_id = 1;

select * from group09.order_info;
delete from order_info;


Insert cart_info (customer_id, p_name, p_price, p_kg, p_image)
values ("1", "Banana", "24.99", "0.5", "/img/banana.png");

Insert cart_info (customer_id, p_name, p_price, p_kg, p_image)
values ("1", "Banana", "24.99", "0.5", "/img/banana.png");

use group09;
INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Banana", "fruit", "24.99", "5", "0.5", "/img/banana.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Red Apple", "fruit", "9.99", "20.25", "2.25", "/img/red_apple.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Avacado", "fruit", "119.99", "12", "1", "/img/avacado.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Green Apple", "fruit", "24.99", "7.5", "0.5", "/img/green_apple.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Kiwi", "fruit", "39.99", "9.5", "0.5", "/img/kiwi.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Mandarin", "fruit", "33.99", "15", "1", "/img/mandarin.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Orange", "fruit", "54.99", "16", "2", "/img/orange.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Pineapple", "fruit", "69.99", "14", "1.5", "/img/pineapple.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Pomegranate", "fruit", "44.99", "24", "1", "/img/pomegranate.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Red Ripe Pear", "fruit", "62.99", "5", "1", "/img/red_ripe_pears.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Sour Orange", "fruit", "44.99", "9", "2", "/img/sour_orange.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Strawberry", "fruit", "83.99", "9", "0.5", "/img/strawberry.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Broccoli", "vegetable", "39.99", "9", "0.5", "/img/broccoli.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Capia Pepper", "vegetable", "37.99", "15", "0.5", "/img/capia_pepper.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Carrot", "vegetable", "20.99", "18", "0.5", "/img/carrot.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Cauliflower", "vegetable", "49.99", "9", "1.5", "/img/cauliflower.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Cucumber", "vegetable", "25.5", "15", "0.5", "/img/cucumber.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Eggplant", "vegetable", "56.99", "11", "1.5", "/img/eggplant.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Garlic", "vegetable", "34.99", "11", "0.25", "/img/garlic.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Grape Tomatoes", "vegetable", "57.99", "13", "1", "/img/grape_tomatoes.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Green Pepper", "vegetable", "32.99", "4", "0.5", "/img/green_pepper.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Lemon", "vegetable", "24.99", "17", "1", "/img/lemon.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Mushroom", "vegetable", "28.99", "3", "0.25", "/img/mushroom.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Onion", "vegetable", "37.99", "34", "2", "/img/onion.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Potatoes", "vegetable", "52.99", "22", "2", "/img/potatoes.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Cocktail Tomato", "vegetable", "44.99", "11", "0.25", "/img/cocktail_tomato.png");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image)
VALUES("Courgette", "vegetable", "54.99", "15", "1", "/img/courgette.png");

INSERT INTO user_info (username, user_name, user_surname, user_password, user_role, user_address, user_phone)
VALUES("Yamur61", "Yağmur Fatma", "Birinci", "Khas61.37", "customer", "Beylerbeyi mahallesi, Üsküdar", "5389855850");

INSERT INTO user_info (username, user_name, user_surname, user_password, user_role, user_address, user_phone)
VALUES("OykuSucu", "Öykü", "Sucuoğlu", "Kedimvar123.", "owner", "", "");

-- select * from group09.user_info
-- select * from group09.product_info
-- select * from group09.cart_info
-- select * from group09.order_info

drop table order_info;


SELECT orderID, order_customer_id, time, order_p_name, order_p_price, order_p_kg, order_status
FROM order_info
WHERE order_customer_id = 1 AND order_status = 'Order Received'
ORDER BY time DESC;

    
    
SELECT customer_id, p_name, SUM(p_price) AS total_price, SUM(p_kg) AS total_kg, p_image FROM group09.cart_info WHERE customer_id = 1 GROUP BY customer_id, p_name, p_image HAVING total_price > 0;
SELECT customer_id, p_name, p_price, p_kg, p_image FROM group09.cart_info WHERE customer_id = 1;


SELECT customer_id, p_name, SUM(p_price) AS total_price, SUM(p_kg) AS total_kg, p_image FROM group09.cart_info WHERE customer_id = 1 and p_name = 'Banana' GROUP BY customer_id, p_name, p_image HAVING total_price > 0  order by p_name;

SELECT customer_id, SUM(p_price) AS total_price FROM group09.cart_info WHERE customer_id = 1 GROUP BY customer_id  HAVING total_price > 0 ;


DELETE FROM group09.order_info;

SELECT * FROM order_info WHERE order_customer_id = 1 ;
SELECT order_customer_id, time, order_status, SUM(order_p_price) AS total_price FROM order_info WHERE order_customer_id = 1 GROUP BY order_customer_id, time, order_status ORDER BY time DESC;
SELECT order_customer_id, MAX(time) AS max_time, order_status, SUM(order_p_price) AS total_price FROM order_info WHERE order_customer_id = 1  GROUP BY order_customer_id, order_status ORDER BY max_time DESC;

SELECT order_customer_id, CONCAT(order_customer_id, '_', time) AS orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = 'Order Received' ORDER BY time DESC;

select * from product_info where p_type = 'fruit' and p_stock > 0 order by p_name;
select * from group09.product_info order by p_name;

select * from product_info order by p_name;