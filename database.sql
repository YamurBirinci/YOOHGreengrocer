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
    p_image varchar(50) not null,
    p_threshold double
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
	orderID varchar(50),
    order_customer_id int not null,
    order_p_name varchar(50) not null,
    order_p_price double not null,
    order_p_kg double not null,
    order_p_image varchar(50) not null,
    order_status varchar(50) not null,
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

UPDATE order_info SET orderID = CONCAT(order_customer_id, SUBSTRING(time FROM 1 FOR 4), SUBSTRING(time FROM 6 FOR 2), SUBSTRING(time FROM 9 FOR 2), SUBSTRING(time FROM 12 FOR 2), SUBSTRING(time FROM 15 FOR 2), SUBSTRING(time FROM 18 FOR 2)
);

SELECT order_customer_id, orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = 'Order Received' ORDER BY time DESC;







INSERT INTO order_info (order_customer_id, order_p_name, order_p_price, order_p_kg, order_p_image, order_status, time) SELECT customer_id, p_name, p_price, p_kg, p_image, 'Sipariş alındı', NOW() FROM cart_info WHERE customer_id = 1;

select * from group09.order_info;
delete from order_info;

drop table product_info;

SELECT order_customer_id, orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = 'Order Received' ORDER BY time DESC;

SELECT order_status from group09.order_info  where orderID= "120240112012524" limit 1;

use group09;
INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Banana", "fruit", "24.99", "15", "0.5", "/img/banana.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Red Apple", "fruit", "9.99", "20.25", "2.25", "/img/red_apple.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Avacado", "fruit", "119.99", "12", "1", "/img/avacado.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Green Apple", "fruit", "24.99", "7.5", "0.5", "/img/green_apple.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Kiwi", "fruit", "39.99", "9.5", "0.5", "/img/kiwi.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Mandarin", "fruit", "33.99", "15", "1", "/img/mandarin.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Orange", "fruit", "54.99", "16", "2", "/img/orange.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Pineapple", "fruit", "69.99", "14", "1.5", "/img/pineapple.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Pomegranate", "fruit", "44.99", "24", "1", "/img/pomegranate.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Red Ripe Pear", "fruit", "62.99", "5", "1", "/img/red_ripe_pears.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Sour Orange", "fruit", "44.99", "9", "2", "/img/sour_orange.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Strawberry", "fruit", "83.99", "9", "0.5", "/img/strawberry.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Broccoli", "vegetable", "39.99", "9", "0.5", "/img/broccoli.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Capia Pepper", "vegetable", "37.99", "15", "0.5", "/img/capia_pepper.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Carrot", "vegetable", "20.99", "18", "0.5", "/img/carrot.png", "2.25");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Cauliflower", "vegetable", "49.99", "9", "1.5", "/img/cauliflower.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Cucumber", "vegetable", "25.5", "15", "0.5", "/img/cucumber.png", "5.25");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Eggplant", "vegetable", "56.99", "11", "1.5", "/img/eggplant.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Garlic", "vegetable", "34.99", "11", "0.25", "/img/garlic.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Grape Tomatoes", "vegetable", "57.99", "13", "1", "/img/grape_tomatoes.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Green Pepper", "vegetable", "32.99", "4", "0.5", "/img/green_pepper.png", "2");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Lemon", "vegetable", "24.99", "17", "1", "/img/lemon.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Mushroom", "vegetable", "28.99", "3", "0.25", "/img/mushroom.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Onion", "vegetable", "37.99", "34", "2", "/img/onion.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Potatoes", "vegetable", "52.99", "22", "2", "/img/potatoes.png", "2");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Cocktail Tomato", "vegetable", "44.99", "11", "0.25", "/img/cocktail_tomato.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Courgette", "vegetable", "54.99", "15", "1", "/img/courgette.png", "2");

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

select * from order_info;

SELECT order_customer_id, CONCAT(order_customer_id, '_', REGEXP_REPLACE(time, '[^0-9]', '')) AS orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = 'Order Received' ORDER BY time DESC;


UPDATE product_info SET p_stock = p_stock + 1 WHERE p_id = 2;

UPDATE group09.product_info SET p_stock = 10 WHERE p_id = 1;
SELECT order_customer_id, CONCAT(order_customer_id, REPLACE(time, '[^0-9]', '')) AS orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = 'Order Received' ORDER BY time DESC;

UPDATE group09.order_info SET order_status = 'Order Has Been Prepared' WHERE CONCAT(order_customer_id, '_', time) = '3_2024-01-10 20:34:20';

SELECT order_customer_id, time, order_status, SUM(order_p_price) AS total_price FROM order_info WHERE order_customer_id = 1 GROUP BY order_customer_id, time, order_status ORDER BY time DESC;



INSERT INTO order_info (order_customer_id, order_p_name, order_p_price, order_p_kg, order_p_image, order_status, time) SELECT customer_id, p_name, SUM(p_price) AS total_price, SUM(p_kg) AS total_kg, p_image, 'Order Received' AS order_status, NOW() AS time FROM group09.cart_info WHERE customer_id = 1 GROUP BY customer_id, p_name, p_image HAVING total_price > 0;


SELECT order_customer_id, CONCAT(order_customer_id, CONCAT(SUBSTRING(time FROM 1 FOR 4), SUBSTRING(time FROM 6 FOR 2), SUBSTRING(time FROM 9 FOR 2), SUBSTRING(time FROM 12 FOR 2), SUBSTRING(time FROM 15 FOR 2), SUBSTRING(time FROM 18 FOR 2))) AS orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = 'Order Received' ORDER BY time DESC;
