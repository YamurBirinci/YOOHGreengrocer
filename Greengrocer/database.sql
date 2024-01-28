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
    order_carrierID int,
    deliveryTime varchar(100) not null,
    c_address varchar(200),
    time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completedDelivery TIMESTAMP
);

use group09;
INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Banana", "fruit", "24.99", "15", "1", "/img/banana.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Red Apple", "fruit", "9.99", "20.25", "1", "/img/red_apple.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Avacado", "fruit", "119.99", "12", "1", "/img/avacado.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Green Apple", "fruit", "24.99", "7.5", "1", "/img/green_apple.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Kiwi", "fruit", "39.99", "9.5", "1", "/img/kiwi.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Mandarin", "fruit", "33.99", "15", "1", "/img/mandarin.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Orange", "fruit", "54.99", "16", "1", "/img/orange.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Pineapple", "fruit", "69.99", "14", "1", "/img/pineapple.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Pomegranate", "fruit", "44.99", "24", "1", "/img/pomegranate.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Red Ripe Pear", "fruit", "62.99", "5", "1", "/img/red_ripe_pears.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Sour Orange", "fruit", "44.99", "9", "1", "/img/sour_orange.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Strawberry", "fruit", "83.99", "9", "1", "/img/strawberry.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Broccoli", "vegetable", "39.99", "9", "1", "/img/broccoli.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Capia Pepper", "vegetable", "37.99", "15", "1", "/img/capia_pepper.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Carrot", "vegetable", "20.99", "18", "1", "/img/carrot.png", "2.25");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Cauliflower", "vegetable", "49.99", "9", "1", "/img/cauliflower.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Cucumber", "vegetable", "25.5", "15", "1", "/img/cucumber.png", "5.25");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Eggplant", "vegetable", "56.99", "11", "1", "/img/eggplant.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Garlic", "vegetable", "34.99", "11", "1", "/img/garlic.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Grape Tomatoes", "vegetable", "57.99", "13", "1", "/img/grape_tomatoes.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Green Pepper", "vegetable", "32.99", "4", "1", "/img/green_pepper.png", "2");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Lemon", "vegetable", "24.99", "17", "1", "/img/lemon.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Mushroom", "vegetable", "28.99", "3", "1", "/img/mushroom.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Onion", "vegetable", "37.99", "34", "1", "/img/onion.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Potatoes", "vegetable", "52.99", "22", "1", "/img/potatoes.png", "2");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Cocktail Tomato", "vegetable", "44.99", "1", "0.25", "/img/cocktail_tomato.png", "5");

INSERT INTO product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold)
VALUES("Courgette", "vegetable", "54.99", "15", "1", "/img/courgette.png", "2");

INSERT INTO user_info (username, user_name, user_surname, user_password, user_role, user_address, user_phone)
VALUES("Owner", "Owner", "Owner", "Owner", "owner", "", "");