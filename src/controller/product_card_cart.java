package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.products;

public class productData {

    private static productData instance;

    private productData() {
    }

    public static synchronized productData getInstance() {
        if (instance == null) {
            instance = new productData();
        }
        return instance;
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group09";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "MySQL61.";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
    }

    public static List<products> getAllProducts() {
        List<products> allProduct = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "select * from group09.product_info order by p_name;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        products product = new products();
                        product.setp_id(resultSet.getInt("p_id"));
                        product.setp_name(resultSet.getString("p_name"));
                        product.setp_price(resultSet.getDouble("p_price"));
                        product.setp_stock(resultSet.getInt("p_stock"));
    
                        allProduct.add(product);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return allProduct;
    }


    public static List<products> getAllFruits() {
        List<products> fruitsList = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "select * from product_info where p_type = 'fruit' and p_stock > 0 order by p_name;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        products fruit = new products();
                        fruit.setp_id(resultSet.getInt("p_id"));
                        fruit.setp_name(resultSet.getString("p_name"));
                        fruit.setp_price(resultSet.getDouble("p_price"));
                        fruit.setp_stock(resultSet.getInt("p_stock"));
                        fruit.setp_kg(resultSet.getDouble("p_kg"));
                        fruit.setp_image(resultSet.getString("p_image"));
    
                        fruitsList.add(fruit);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return fruitsList;
    }


    public static List<products> getAllVegetables() {
        List<products> vegetableList = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "select * from product_info where p_type = 'vegetable' and p_stock > 0 order by p_name;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        products vegetable = new products();
                        vegetable.setp_id(resultSet.getInt("p_id"));
                        vegetable.setp_name(resultSet.getString("p_name"));
                        vegetable.setp_price(resultSet.getDouble("p_price"));
                        vegetable.setp_stock(resultSet.getInt("p_stock"));
                        vegetable.setp_kg(resultSet.getDouble("p_kg"));
                        vegetable.setp_image(resultSet.getString("p_image"));
    
                        vegetableList.add(vegetable);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return vegetableList;
    }

    public static products getThisProduct(String product_name) {
       
        products product = new products();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "select * from product_info where p_name = ?"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, product_name);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        product.setp_id(resultSet.getInt("p_id"));
                        product.setp_name(resultSet.getString("p_name"));
                        product.setp_price(resultSet.getDouble("p_price"));
                        product.setp_stock(resultSet.getDouble("p_stock"));
                        product.setp_kg(resultSet.getDouble("p_kg"));
                        product.setp_image(resultSet.getString("p_image"));
                        }

                    }
                }
            }
         
        
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return product;
    }
        

    public static List<products> searchProduct(String key) {
        List<products> searchResult = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT * FROM product_info WHERE p_name LIKE ? and p_stock > 0 order by p_name;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, "%" + key + "%");
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        products searchProduct = new products();
                        searchProduct.setp_id(resultSet.getInt("p_id"));
                        searchProduct.setp_name(resultSet.getString("p_name"));
                        searchProduct.setp_price(resultSet.getDouble("p_price"));
                        searchProduct.setp_stock(resultSet.getInt("p_stock"));
                        searchProduct.setp_kg(resultSet.getDouble("p_kg"));
                        searchProduct.setp_image(resultSet.getString("p_image"));
    
                        searchResult.add(searchProduct);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return searchResult;
    }


    
}

