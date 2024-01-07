package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.customer_cart;
import domain.products;

public class customer_cartData {

    private static productData instance;

    private customer_cartData() {
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group09";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "MySQL61.";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
    }


    public static synchronized productData getInstance() {
        if (instance == null) {
            instance = new customer_cartData();
        }
        return instance;
    }

    public static boolean addToCartList(String user_name, String user_surname, String username, String user_password) {
        boolean save = false;
        try (Connection connection = getConnection()) {
			String insertQuery = "INSERT INTO user_info (user_name, user_surname, username, user_password, user_role) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, user_name);
                preparedStatement.setString(2, user_surname);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, user_password);
                preparedStatement.setString(5, "customer");

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