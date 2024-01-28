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

    private static final String JDBC_URL = "jdbc:mysql://localhost: "MYLOCALHOST"  /group09";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = ""MYPASSWORD"";

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
                        fruit.setP_threshold(resultSet.getDouble("p_threshold"));
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
                        vegetable.setP_threshold(resultSet.getDouble("p_threshold"));
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
                        product.setP_threshold(resultSet.getDouble("p_threshold"));
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

    public static products getThisProduct(int p_id) {
       
        products product = new products();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "select * from product_info where p_id = ?"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, p_id);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        product.setp_id(resultSet.getInt("p_id"));
                        product.setp_name(resultSet.getString("p_name"));
                        product.setp_price(resultSet.getDouble("p_price"));
                        product.setp_stock(resultSet.getDouble("p_stock"));
                        product.setP_threshold(resultSet.getDouble("p_threshold"));
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
                        searchProduct.setP_threshold(resultSet.getDouble("p_threshold"));
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

    public static boolean addStock(int p_id, double p_stock) {
        boolean save = false;
        try (Connection connection = getConnection()) {
			String insertQuery = "UPDATE product_info SET p_stock = p_stock + ? WHERE p_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setDouble(1, p_stock);
                preparedStatement.setInt(2, p_id);
                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

    public static boolean decreaseStock(int p_id, double p_stock) {
        boolean save = false;
        try (Connection connection = getConnection()) {
			String insertQuery = "UPDATE product_info SET p_stock = p_stock - ? WHERE p_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setDouble(1, p_stock);
                preparedStatement.setInt(2, p_id);
                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}


    public static boolean updatePrice(int p_id, double p_price) {
        boolean save = false;
        try (Connection connection = getConnection()) {
			String insertQuery = "UPDATE product_info SET p_price = ? WHERE p_id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setDouble(1, p_price);
                preparedStatement.setInt(2, p_id);
                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

    public static boolean insertProduct(String p_name, String p_type, double p_price, double p_stock, double p_kg, String p_image, double p_threshold) {
        boolean save = false;
        try (Connection connection = getConnection()) {
			String insertQuery = "INSERT INTO group09.product_info (p_name, p_type, p_price, p_stock, p_kg, p_image, p_threshold) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, p_name);
                preparedStatement.setString(2, p_type);
                preparedStatement.setDouble(3, p_price);
                preparedStatement.setDouble(4, p_stock);
                preparedStatement.setDouble(5, p_kg);
                preparedStatement.setString(6, p_image);
                preparedStatement.setDouble(7, p_threshold);

                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

    
}

