package data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.customer_cart;
import domain.order;
public class orderData {
   

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group09";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "MySQL61.";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
    }

    public static boolean orderSave(int customer_id, String deliveryTime, String c_address) {
        boolean save = false;

        try (Connection connection = getConnection()) {
			String insertQuery = "INSERT INTO order_info (order_customer_id, order_p_name, order_p_price, order_p_kg, order_p_image, order_status, time, deliveryTime, c_address) SELECT customer_id, p_name, SUM(p_price) AS total_price, SUM(p_kg) AS total_kg, p_image, 'Order Received' AS order_status, NOW() AS time, ? AS deliveryTime, ? as c_address FROM group09.cart_info WHERE customer_id = ? GROUP BY customer_id, p_name, p_image HAVING total_price > 0";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, deliveryTime);
                preparedStatement.setString(2, c_address);
                preparedStatement.setInt(3, customer_id);

                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

    public static boolean changeOrderStatus(String orderID, String status) {
        boolean save = false;

        try (Connection connection = getConnection()) {
			String insertQuery = "UPDATE group09.order_info SET order_status = ? WHERE orderID = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, status);
                preparedStatement.setString(2, orderID);


                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

    

    public static boolean acceptedOrderbyCarrier(String orderID, int order_carrierID) {
        boolean save = false;

        try (Connection connection = getConnection()) {
			String insertQuery = "UPDATE group09.order_info SET order_carrierID = ? WHERE orderID = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, order_carrierID);
                preparedStatement.setString(2, orderID);


                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

    public static boolean decreaseStocksAfterOrder(List<customer_cart> myorder) {
        boolean save = false;

        try (Connection connection = getConnection()) {
			String insertQuery = "UPDATE product_info SET p_stock = p_stock - ? WHERE p_name = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                for (customer_cart product : myorder) {
                    preparedStatement.setDouble(1, product.getQuantity());
                    preparedStatement.setString(2, product.getProduct_name());
                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}


    public static boolean setOrderID() {
        boolean save = false;

        try (Connection connection = getConnection()) {
			String insertQuery = "UPDATE order_info SET orderID = CONCAT(order_customer_id, SUBSTRING(time FROM 1 FOR 4), SUBSTRING(time FROM 6 FOR 2), SUBSTRING(time FROM 9 FOR 2), SUBSTRING(time FROM 12 FOR 2), SUBSTRING(time FROM 15 FOR 2), SUBSTRING(time FROM 18 FOR 2))";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    save = true;
                }

            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}

    public static boolean completedTime(String orderID) {
        boolean save = false;

        try (Connection connection = getConnection()) {
			String insertQuery = "UPDATE group09.order_info SET completedDelivery = CURRENT_TIMESTAMP WHERE orderID = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, orderID);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    save = true;
                }

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


    public static List<order> getCarrierOrders(int order_carrierID) {
        List<order> carrierOrders = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT * from group09.order_info where order_carrierID = ? and order_status = \"Order Was Delivered\""; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, order_carrierID);
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        order orderItem = new order();
                        orderItem.setOrderID(resultSet.getString("orderID"));
                        orderItem.setOrder_customer_id(resultSet.getInt("order_customer_id"));
                        orderItem.setC_address(resultSet.getString("c_address"));
                        orderItem.setDeliveryTime(resultSet.getString("deliveryTime"));
                        orderItem.setCompletedDelivery(resultSet.getTimestamp("completedDelivery"));

                        carrierOrders.add(orderItem);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return carrierOrders;
    }

    public static List<order> getCarrierCurrentOrders(int order_carrierID) {
        List<order> carrierOrders = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT * from group09.order_info where order_carrierID = ? and completedDelivery is null"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, order_carrierID);
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        order orderItem = new order();
                        orderItem.setOrderID(resultSet.getString("orderID"));
                        orderItem.setOrder_customer_id(resultSet.getInt("order_customer_id"));
                        orderItem.setC_address(resultSet.getString("c_address"));
                        orderItem.setDeliveryTime(resultSet.getString("deliveryTime"));

                        carrierOrders.add(orderItem);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return carrierOrders;
    }


    public static List<order> getDeliveredOrders(int order_carrierID) {
        List<order> carrierOrders = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT * from group09.order_info where order_carrierID = ? and order_status = \"Order Was Delivered\""; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, order_carrierID);
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        order orderItem = new order();
                        orderItem.setOrderID(resultSet.getString("orderID"));
                        orderItem.setOrder_customer_id(resultSet.getInt("order_customer_id"));
                        orderItem.setC_address(resultSet.getString("c_address"));
                        orderItem.setDeliveryTime(resultSet.getString("deliveryTime"));

                        carrierOrders.add(orderItem);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return carrierOrders;
    }


    public static List<order> getAllCustomerOrders() {
        List<order> allOrders = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT order_customer_id, orderID, time, order_p_name, order_p_price, order_p_kg, order_status FROM order_info WHERE order_status = 'Order Received' ORDER BY time DESC;"; 
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
                String query = "SELECT order_customer_id, orderID, time, order_p_name, order_p_price, order_p_kg, order_status, deliveryTime, c_address, completedDelivery FROM order_info WHERE order_status = ? ORDER BY time DESC;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, order_status);
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        order order = new order();
                        order.setOrder_customer_id(resultSet.getInt("order_customer_id"));
                        order.setOrderID(resultSet.getString("orderID"));
                        order.setOrder_p_price(resultSet.getDouble("order_p_price"));
                        order.setOrder_status(resultSet.getString("order_status"));
                        order.setTime(resultSet.getTimestamp("time"));
                        order.setCompletedDelivery(resultSet.getTimestamp("completedDelivery"));
                        order.setOrder_p_name(resultSet.getString("order_p_name"));
                        order.setOrder_p_kg(resultSet.getDouble("order_p_kg"));
                        order.setDeliveryTime(resultSet.getString("deliveryTime"));
                        order.setC_address(resultSet.getString("c_address"));

                        allOrders.add(order);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return allOrders;
    }

    

    public static String getOrderStatusByID(String orderID) {
        String order_state = "";
    
        try {
            try (Connection connection = getConnection()) {
                String query = "SELECT order_status from group09.order_info  where orderID= ? limit 1;";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, orderID);
    
                    try (ResultSet resultSet = preparedStatement.executeQuery()) {
                        if (resultSet.next()) {
                            order_state = resultSet.getString("order_status");
                        }
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return order_state;
    }
    


}