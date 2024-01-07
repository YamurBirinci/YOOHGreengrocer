import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.io.IOException;

public class login {

    public login() {
    }

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group09";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "MySQL61.";

    @FXML
    private Button login_button;
    @FXML
    private Button choose_signup;
    @FXML
    private Label warning;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
    }

    @FXML
    private void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }

    @FXML
    private void choseSignUp(ActionEvent event) throws IOException {
        changeScreenToSignUp(event);
    }

    private void changeScreenToSignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/signup.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.getIcons().add(new Image("img/yooh_logo.png"));
        newStage.show();
    }


    private void checkLogin() throws IOException {
        try (Connection connection = getConnection()) {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                warning.setText("Please enter your data.");
            } else {
                String query = "SELECT * FROM user_info WHERE username = ? AND BINARY user_password = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, username.getText());
                    preparedStatement.setString(2, password.getText());

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        warning.setText("Login successful");
                        // app.changeScene("afterLogin.fxml");

                    } else {
                        warning.setText("Wrong username or password!");

                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); // Hata durumunda hatayı yazdır
        }
        
    }
}