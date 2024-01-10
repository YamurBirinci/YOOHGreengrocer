package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class carrier {

    @FXML
    private HBox MyOrders;

    @FXML
    private HBox MyProfile;

    @FXML
    private TextArea address;

    @FXML
    private Button button_accept;

    @FXML
    private Button button_orders;

    @FXML
    private Button button_profile;

    @FXML
    private Button button_reject;

    @FXML
    private VBox carrierorders;

    @FXML
    private PasswordField current_password;

    @FXML
    private Label customer_username;

    @FXML
    private AnchorPane myprofilepanel;

    @FXML
    private PasswordField password1;

    @FXML
    private PasswordField password2;

    @FXML
    private AnchorPane profil_panel;

    @FXML
    private Button update1_button;

    @FXML
    private Button update2_button;

    @FXML
    private TextField user_name;

    @FXML
    private TextField user_phone;

    @FXML
    private TextField user_surname;

    @FXML
    private TextField user_username;

    @FXML
    private Label warning1;

    @FXML
    private Label warning111;

    @FXML
    private Label warning2;

    @FXML
    void to_accept(ActionEvent event) {
        // ownerdan gelen sepeti accept tıkladığında selected kısmına yollayacak(en üstteki siparişi)
        if(sepet boş değilse){
            selectedordersa ekle
        }

    }

    @FXML
    void to_orders(ActionEvent event) throws IOException{
        myprofilepanel.setVisible(true);
        profil_panel.setVisible(false);
    }

    @FXML
    void to_profile(ActionEvent event) {
        myprofilepanel.setVisible(false);
        profil_panel.setVisible(true);
    }

    @FXML
    void to_reject(ActionEvent event) {
        // ownerdan gelen sepeti rejecte tıkladığında silecek(en üstteki siparişi)
        if (sepet boş değilse){
            sepeti sil
        }
    }

    @FXML
    void update_info(ActionEvent event) {

    }

    @FXML
    void update_password(ActionEvent event) {

    }

    @FXML
    private TextArea available_orders;

    @FXML
    private TextArea selected_orders;

    @FXML
    private TextArea completed_orders;
}
