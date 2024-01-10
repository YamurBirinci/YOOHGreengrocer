package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import domain.customer_cart;



public class customer_cartData {


    private customer_cartData() {
    }

    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group09";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "MySQL61.";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
    }

    public static boolean addToCart(int customer_id, String p_name, double p_price, double p_kg, String p_image) {
        boolean save = false;
        try {
            
            try (Connection connection = getConnection()) {
                String insertQuery = "INSERT INTO group09.cart_info (customer_id, p_name, p_price, p_kg, p_image) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                    preparedStatement.setInt(1, customer_id);
                    preparedStatement.setString(2, p_name);
                    preparedStatement.setDouble(3, p_price);
                    preparedStatement.setDouble(4, p_kg);
                    preparedStatement.setString(5, p_image);

                    preparedStatement.executeUpdate();
                    save = true;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return save;
    }

    public static double getTotalPrice(int customer_id) {
        double total = 0;
        try (Connection connection = getConnection()) {
            String selectQuery = "SELECT customer_id, SUM(p_price) AS total_price FROM group09.cart_info WHERE customer_id = ? GROUP BY customer_id HAVING total_price > 0;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setInt(1, customer_id);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        total = resultSet.getDouble("total_price");
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    
        return total;
    }

    public static customer_cart getThisProductFromCart(int customer_id, String product_name) {
       
        customer_cart cartItem = new customer_cart();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT customer_id, p_name, SUM(p_price) AS total_price, SUM(p_kg) AS total_kg, p_image FROM group09.cart_info WHERE customer_id = 1 and p_name = ? GROUP BY customer_id, p_name, p_image HAVING total_price > 0  order by p_name;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, customer_id);
                    preparedStatement.setString(1, product_name);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        cartItem.setUser_id(resultSet.getInt("customer_id"));
                        cartItem.setProduct_name(resultSet.getString("p_name"));
                        cartItem.setPrice(resultSet.getDouble("total_price"));
                        cartItem.setQuantity(resultSet.getDouble("total_kg"));
                        cartItem.setP_image(resultSet.getString("p_image"));
                        }

                    }
                }
            }
         
        
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return cartItem;
    }

    public static List<customer_cart> myCart( int customer_id) {
        List<customer_cart> myCart = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT customer_id, p_name, SUM(p_price) AS total_price, SUM(p_kg) AS total_kg, p_image FROM group09.cart_info WHERE customer_id = ? GROUP BY customer_id, p_name, p_image HAVING total_price > 0 order by p_name;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, customer_id);
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        customer_cart cart = new customer_cart();
                        cart.setUser_id(resultSet.getInt("customer_id"));
                        cart.setProduct_name(resultSet.getString("p_name"));
                        cart.setPrice(resultSet.getDouble("total_price"));
                        cart.setQuantity(resultSet.getDouble("total_kg"));
                        cart.setP_image(resultSet.getString("p_image"));
    
                        myCart.add(cart);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return myCart;
    }

    public static boolean updateAmount(int customer_id, String p_name, double p_price, double p_kg, String p_image) {
        boolean save1 = false;
        boolean save2 = false;
    
        try {
            try (Connection connection = getConnection()) {
                String query = "DELETE FROM group09.cart_info WHERE customer_id = ? AND p_name = ?;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, customer_id);
                    preparedStatement.setString(2, p_name);
                    
                    preparedStatement.executeUpdate();
    
                    save1 = true;
                }
            }
            try (Connection connection = getConnection()) {
                String query = "INSERT INTO group09.cart_info (customer_id, p_name, p_price, p_kg, p_image) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, customer_id);
                    preparedStatement.setString(2, p_name);
                    preparedStatement.setDouble(3, p_price);
                    preparedStatement.setDouble(4, p_kg);
                    preparedStatement.setString(5, p_image);
                    
                    preparedStatement.executeUpdate();
    
                    save2 = true;
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return save1 && save2;
    }

    public static boolean deleteProduct(int customer_id, String p_name) {
        boolean save1 = false;
    
        try {
            try (Connection connection = getConnection()) {
                String query = "DELETE FROM group09.cart_info WHERE customer_id = ? AND p_name = ?;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, customer_id);
                    preparedStatement.setString(2, p_name);
                    
                    preparedStatement.executeUpdate();
    
                    save1 = true;
                }
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return save1;
    }

    public static boolean cleanCart (int customer_id) {
        boolean save1 = false;
    
        try {
            try (Connection connection = getConnection()) {
                String query = "DELETE FROM group09.cart_info WHERE customer_id = ?;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, customer_id);
                    
                    preparedStatement.executeUpdate();
    
                    save1 = true;
                }
            }
            
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return save1;
    }

    

}
