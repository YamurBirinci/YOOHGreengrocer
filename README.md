
## Steps to run the project

This project was run using visual studio code, so these steps apply to vs code.


#### 1. Adding MySQL Connector:
*MySQL-connector.jar* file has been added to Java Projects' Referenced Libraries.

#### 2. Adding JavaFX Libraries:
All *javafx.jar* files have been added to Java Projects' Referenced Libraries.

#### 3. Adding Configuration in VS Code:
Configuration was added by pressing 'Add Configuration...' from the Run section of VsCode.

#### 4. Adding VM Arguments to the Configuration File:
Under the 'ProjectName' line in the configuration file,

    "vmArgs": "--module-path \"C:/PathOfFiles/javafx-sdk-21.0.1/lib\" --add-modules javafx.controls,javafx.fxml"

added. 'PathOfFiles' should be changed to the location of the jar file.

#### 5. Changing MySQL localhost number and password:
MySQL localhost and password information for each file in the data folder has changed to our own.

    private static final String JDBC_URL = "jdbc:mysql://localhost:yourNumber/group09";
    private static final String MYSQL_USERNAME = "yourUsername";
    private static final String MYSQL_PASSWORD = "yourPassword.";



_____________


## Project

#### Customer Interface

![1](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/530c9bbb-ef02-482a-9c7c-15f55ab69b58)


When the program is first run, it loads the login screen. The user can log in here or click on the sign up button to load the registration screen.

___

![2](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/8a6f8156-fc19-488f-849b-9ac5d1aff586)


The user can register as a customer by entering his/her information. When registering, the customer must type a strong password and re-enter the password to confirm it. After the registration is successfully confirmed, the customer can log in by returning to the log in page.

___

![3](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/14efb8a2-b4b8-49d7-84d0-1f84d62fd3b6)


After successful login, the homepage page is loaded. Here the user decides whether he/she wants to buy fruits or vegetables. Accordingly, the page is loaded according to the option clicked.

___

![4](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/ca57d564-31ec-4c21-b559-fb326fabcb55)


Customer can access the products from this page. Additionally, they can find the product they want more quickly with the Search button. They can add the products to the cart, but if the amount of product in stock falls below 5kg, they will see the product price double. On the other hand, apart from examining the product, they can view their orders, change their information or log out.

___

![5](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/8bb5491a-5c49-4a45-884c-2568fb2f609b)

Customer can update the product quantity or remove the product from the cart. To place an order, he/she must select a delivery date from the top right and enter an address and phone number in the MyProfile section.

____

#### Owner Interface

![6](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/5c562112-988c-494a-a29f-2bd33b20c676)

Owner logs in from the same log in page. He/she can view the stock and product quantities of all products. In addition, can add new products, update the stock quantity, and update the product price.

___

![7](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/25aac43e-919e-488c-b2a6-0d901aee3c62)

The owner adds carriers to the system and can view them.

___

![8](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/78af611b-7a5c-43b3-a4d6-e42bb1d1a026)

When a customer places an order, the owner displays the specified order. When he/she packages the order, enters the order number and changes the order status to 'Prepared'. This way the order can be viewed by carriers.

____

#### Carrier Interface

![9](https://github.com/YamurBirinci/YOOHGreengrocer/assets/99952328/103d514d-aa21-46c9-ad64-d6b94da35d02)

Carrier may update its own profile information. In addition, carrier can view all active orders. When a carrier selects and accepts one or more orders among all active orders, those orders appear in the carrier's own 'My Orders' table. If the order is delivered, he/she marks the order as delivered in the My Orders table.


________


*As a result, the project runs smoothly. However, instead of writing order numbers, the code could have been edited and improved using a more efficient and effective way. In addition, data information pages such as statistics could be added to the carrier and owner interfaces.*



