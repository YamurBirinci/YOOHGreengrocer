package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.order;
public class orderData {
    private static orderData instance;

    private orderData(){

    }
    public static synchronized orderData getInstance() {
        if (instance == null) {
            instance = new orderData();
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

    public static boolean orderSave(int customer_id) {
        boolean save = false;

        try (Connection connection = getConnection()) {
			String insertQuery = "INSERT INTO order_info (order_customer_id, order_p_name, order_p_price, order_p_kg, order_p_image, order_status, time) SELECT customer_id, p_name, SUM(p_price) AS total_price, SUM(p_kg) AS total_kg, p_image, 'Order Received' AS order_status, NOW() AS time FROM group09.cart_info WHERE customer_id = ? GROUP BY customer_id, p_name, p_image HAVING total_price > 0;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, customer_id);


                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

    public static List<order> getMyOrders(int order_customer_id) {
        List<order> myOrder = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT order_customer_id, time, order_status, SUM(order_p_price) AS total_price FROM order_info WHERE order_customer_id = ? GROUP BY order_customer_id, time, order_status ORDER BY time DESC;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, order_customer_id);
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        order orderItem = new order();
                        orderItem.setOrder_customer_id(resultSet.getInt("order_customer_id"));
                        orderItem.setOrder_p_price(resultSet.getDouble("total_price"));
                        orderItem.setOrder_status(resultSet.getString("order_status"));
                        orderItem.setTime(resultSet.getTimestamp("time"));

                        myOrder.add(orderItem);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return myOrder;
    }


    public static List<order> getAllCustomerOrders() {
        List<order> allOrders = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT order_customer_id, CONCAT(order_customer_id, '_', time) AS orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = 'Order Received' ORDER BY time DESC;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        order order = new order();
                        order.setOrder_customer_id(resultSet.getInt("order_customer_id"));
                        order.setOrderID(resultSet.getString("orderID"));
                        order.setOrder_status(resultSet.getString("order_status"));
                        order.setTime(resultSet.getTimestamp("time"));
                        order.setOrder_p_name(resultSet.getString("order_p_name"));
                        order.setOrder_p_kg(resultSet.getDouble("order_p_kg"));
                        order.setOrder_p_price(resultSet.getDouble("order_p_price"));

                        allOrders.add(order);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return allOrders;
    }


    public static List<order> getOrdersByStatus(String order_status) {
        List<order> allOrders = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT order_customer_id, CONCAT(order_customer_id, '_', time) AS orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = ? ORDER BY time DESC;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, order_status);
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        order order = new order();
                        order.setOrder_customer_id(resultSet.getInt("order_customer_id"));
                        order.setOrder_p_price(resultSet.getDouble("orderID"));
                        order.setOrder_status(resultSet.getString("order_status"));
                        order.setTime(resultSet.getTimestamp("time"));
                        order.setOrder_p_name(resultSet.getString("order_p_name"));
                        order.setOrder_p_kg(resultSet.getDouble("order_p_kg"));

                        allOrders.add(order);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return allOrders;
    }
    
}
