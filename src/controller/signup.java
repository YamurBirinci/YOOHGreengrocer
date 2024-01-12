package controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import data.userData;
import domain.users;

public class signup {

    public signup() {
    }

    @FXML
    private Button sign_button;
    @FXML
    private Button choose_login;
    @FXML
    private Label warning;
    @FXML
    private TextField create_username;
    @FXML
    private PasswordField create_password;
    @FXML
    private PasswordField create_password2;
    @FXML
    private TextField create_surname;
    @FXML
    private TextField create_name;


    @FXML
    private void userSignup(ActionEvent event) throws IOException {
        checkSignup();
    }

    @FXML
    private void choseLogin(ActionEvent event) throws IOException {
        changeScreenToLogin(event);
    }

    private void changeScreenToLogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user_login.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.show();
    } 


    private void checkSignup() throws IOException {

        if (create_surname.getText().isEmpty() || create_name.getText().isEmpty() || create_username.getText().isEmpty() || create_password2.getText().isEmpty() || create_password.getText().isEmpty()) {
            warning.setText("      Please enter your data.");
        } 
        else if(!create_password2.getText().equals(create_password.getText())) {
            warning.setText("Please check your passwords!");
        } 
            
        else if(!isStrongPassword(create_password.getText())){
            warning.setText("      Enter strong password.");
        }
        else {
            String name = create_name.getText();
            String surname = create_surname.getText();
            String username = create_username.getText();
            String password = create_password.getText();
                
            if (userData.userSave(name, surname, username, password, "customer")) {
                users loggedIn = new users(name, surname, username, password);
                users.setloggedIN(loggedIn);
                warning.setText("  You signed up! Log in now.");
            }
            else {
                warning.setText(" Your username already exist!");
            }

                
        }
    }

    private static boolean isStrongPassword(String password) {
        if (password.length() < 4) {
            return false;
        }

        if (password.length() > 20) {
            return false;
        }
    
        if (!uppercase(password)) {
            return false;
        }
    
        if (!lowercase(password)) {
            return false;
        }
    
        if (!digit(password)) {
            return false;
        }
    
        return true;
    }
    
    private static boolean uppercase(String password) {
        return !password.equals(password.toLowerCase());
    }
    
    private static boolean lowercase(String password) {
        return !password.equals(password.toUpperCase());
    }
    
    private static boolean digit(String password) {
        return password.matches(".*\\d.*");
    }
}