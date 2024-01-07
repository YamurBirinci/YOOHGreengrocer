import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import domain.users;
import data.userData;
import javafx.fxml.Initializable;

import java.io.IOException ;

public class customer_hp implements Initializable{
    @FXML
    private Button fruits_button;

    @FXML
    private Button vegetables_button;

    @FXML
    private Label customer_username;

    private users loggedInUser;

    public void setUser(users loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    private String getData() {
        if (loggedInUser != null) {
            return loggedInUser.getUsername();
        } else {
            return "Guest";
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        customer_username.setText("Dear, " + getData());
    }
    

    @FXML
    void to_fruits(ActionEvent event) throws IOException {
        changeScreenToFruits(event);
    }

    @FXML
    void to_vegetables(ActionEvent event) throws IOException {
        changeScreenToVegetables(event);
    }
    


    private void changeScreenToVegetables(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/customer_vegetables.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.show();
    }

    private void changeScreenToFruits(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/customer_fruits.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.show();
    }
}
