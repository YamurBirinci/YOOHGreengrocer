import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import domain.users;

public class customer_homepage implements Initializable {

    @FXML
    private Button fruits_button;

    @FXML
    private Button vegetables_button;

    @FXML
    private Label customer_username;

    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        users loggedInUser = loggedIn.getInstance().getLoggedInUser();

        if (loggedInUser != null) {
            customer_username.setText("Dear, " + loggedInUser.getUsername());
        } else {
            customer_username.setText("Dear Guest");
        }
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/customer.fxml"));
        Parent root = loader.load();
        customer controller = loader.getController();
        controller.to_vegetables(event);

        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.show();
    }

    private void changeScreenToFruits(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/customer.fxml"));
        Parent root = loader.load();
        customer controller = loader.getController();
        controller.to_fruits(event);

        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.show();
    }
}