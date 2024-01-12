package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.users;

public class userData {

    private static userData instance;

    private userData() {
    }

    public static synchronized userData getInstance() {
        if (instance == null) {
            instance = new userData();
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

    public static users userAuthenticate(String username, String user_password) {
		users loggedInUser = null;
        try (Connection connection = getConnection()) {
			String query = "SELECT * FROM group09.user_info WHERE username = ? AND BINARY user_password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, user_password);

			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
                loggedInUser = new users();
				loggedInUser.setUser_id(set.getInt("user_id"));
                loggedInUser.setUser_name(set.getString("user_name"));
                loggedInUser.setUser_surname(set.getString("user_surname"));
				loggedInUser.setUsername(set.getString("username"));
				loggedInUser.setUser_password(set.getString("user_password"));
				loggedInUser.setUser_role(set.getString("user_role"));
				loggedInUser.setUser_phone(set.getString("user_phone"));
                loggedInUser.setUser_address(set.getString("user_address"));
			}
            

		} catch (Exception e) {
			e.printStackTrace();
		}

		return loggedInUser;
	}


    public static users getThisUser(int user_id) {
        users customer = null;
        try (Connection connection = getConnection()) {
			String query = "SELECT * FROM group09.user_info WHERE user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, user_id);

			ResultSet set = preparedStatement.executeQuery();
			while (set.next()) {
                customer = new users();
				customer.setUser_id(set.getInt("user_id"));
                customer.setUser_name(set.getString("user_name"));
                customer.setUser_surname(set.getString("user_surname"));
				customer.setUsername(set.getString("username"));
				customer.setUser_phone(set.getString("user_phone"));
                customer.setUser_address(set.getString("user_address"));
			}
            

		} catch (Exception e) {
			e.printStackTrace();
		}

		return customer;
	}


    public static boolean userSave(String user_name, String user_surname, String username, String user_password, String user_role) {
        boolean save = false;
        try (Connection connection = getConnection()) {
			String insertQuery = "INSERT INTO group09.user_info (user_name, user_surname, username, user_password, user_role) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, user_name);
                preparedStatement.setString(2, user_surname);
                preparedStatement.setString(3, username);
                preparedStatement.setString(4, user_password);
                preparedStatement.setString(5, user_role);

                preparedStatement.executeUpdate();
                save = true;
            }
		} 
        catch (Exception e) {
			e.printStackTrace();
		}

		return save;
	}



    public static boolean updateInfoById(int id, String user_name, String user_surname, String username, String phonenumber, String user_address) {
        boolean update = false;
    
        try (Connection connection = getConnection()) {
            String query = "update group09.user_info SET user_name = ?, user_surname = ?, username = ?, user_phone = ?, user_address = ? WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user_name);
            preparedStatement.setString(2, user_surname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, phonenumber);
            preparedStatement.setString(5, user_address);
            preparedStatement.setInt(6, id);
    
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                update = true;
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return update;
    }

    public static boolean updatePasswordById(int id, String newPassword) {
        boolean update = false;
    
        try (Connection connection = getConnection()) {
            String query = "update group09.user_info SET user_password = ? WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, id);
    
            int rowCount = preparedStatement.executeUpdate();
            if (rowCount > 0) {
                update = true;
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return update;
    }


    public static List<users> getAllCarriers() {
        List<users> carriers = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "select user_id, user_name, user_surname, username from group09.user_info where user_role = \"carrier\";"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        users carrier = new users();
                        carrier.setUser_id(resultSet.getInt("user_id"));
                        carrier.setUser_name(resultSet.getString("user_name"));
                        carrier.setUser_surname(resultSet.getString("user_surname"));
                        carrier.setUsername(resultSet.getString("username"));

                        carriers.add(carrier);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return carriers;
    }


}
