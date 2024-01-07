import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import domain.users;
import data.userData;


public class login_page {

    
    public login_page() {
    }

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

    @FXML
    private void userLogin(ActionEvent event) throws IOException {
        checkLogin(event);
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
        newStage.show();
    }


    private void checkLogin(ActionEvent event) throws IOException {
        if (username.getText().isEmpty() || password.getText().isEmpty()) {
            warning.setText("Please enter your data.");
        } else {
            String userName = username.getText();
            String userPassword = password.getText();
            users loggedInUser = userData.userAuthenticate(userName, userPassword);
            loggedIn.getInstance().setLoggedInUser(loggedInUser);

            if (loggedInUser != null) {
                String role = loggedInUser.getUser_role();
                if("customer".equals(role)){

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/customer_homepage.fxml"));
                    Parent root = loader.load();

                    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
                    currentStage.close();

                    Stage newStage = new Stage();
                    newStage.setResizable(false);
                    newStage.setScene(new Scene(root, 960, 540));
                    newStage.setTitle("Group9");
                    newStage.show();
                }
            }
            else {
                warning.setText("Wrong username or password!");

            }
        }
    }
         
        
}
