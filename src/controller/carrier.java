package controller;
import data.userData;
import domain.users;
import domain.order;
import data.orderData;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;


import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class carrier {

    @FXML
    private HBox MyOrders;

    @FXML
    private HBox MyOrders1;

    @FXML
    private HBox MyOrders11;

    @FXML
    private HBox MyProfile;

    @FXML
    private AnchorPane active_orders_page;

    @FXML
    private TextArea address;

    @FXML
    private Button button_logout;

    @FXML
    private Button button_orders;

    @FXML
    private Button button_orders1;

    @FXML
    private Button button_orders11;

    @FXML
    private Button button_profile;

    @FXML
    private TableView<?> carrierOrderTable;

    @FXML
    private TableView<?> carrierOrderTable1;

    @FXML
    private TableView<?> carrierOrderTable11;

    @FXML
    private VBox carrierorders;

    @FXML
    private PasswordField current_password;

    @FXML
    private Label customer_username;

    @FXML
    private AnchorPane delivered_orders_page;

    @FXML
    private ComboBox<?> myOrderChangeOrderStat;

    @FXML
    private TextField myOrderInputID;

    @FXML
    private TextField myOrderInputID1;

    @FXML
    private TableColumn<?, ?> myOrders_customer_name;

    @FXML
    private TableColumn<?, ?> myOrders_customer_name1;

    @FXML
    private TableColumn<?, ?> myOrders_customer_name11;

    @FXML
    private TableColumn<?, ?> myOrders_delivery_address;

    @FXML
    private TableColumn<?, ?> myOrders_delivery_address1;

    @FXML
    private TableColumn<?, ?> myOrders_delivery_address11;

    @FXML
    private TableColumn<?, ?> myOrders_order_customer_id;

    @FXML
    private TableColumn<?, ?> myOrders_order_customer_id1;

    @FXML
    private TableColumn<?, ?> myOrders_order_customer_id11;

    @FXML
    private TableColumn<?, ?> myOrders_order_id_col;

    @FXML
    private TableColumn<?, ?> myOrders_order_id_col1;

    @FXML
    private TableColumn<?, ?> myOrders_order_id_col11;

    @FXML
    private TableColumn<?, ?> myOrders_order_total_kg;

    @FXML
    private TableColumn<?, ?> myOrders_order_total_kg1;

    @FXML
    private TableColumn<?, ?> myOrders_order_total_kg11;

    @FXML
    private AnchorPane my_orders_page;

    @FXML
    private AnchorPane my_profile_page;

    @FXML
    private PasswordField password1;

    @FXML
    private PasswordField password2;

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
    private Label warning2;


    users loggedInCarrier = loggedIn.getInstance().getLoggedInUser();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {


        if (loggedInCarrier != null) {
            customer_username.setText("Dear, " + loggedInCarrier.getUsername());
        } else {
            customer_username.setText("Dear Guest");
        }

    }

    

    @FXML
    void to_my_profile_page(ActionEvent event) throws IOException {
        my_profile_page.setVisible(true);
        my_orders_page.setVisible(false);
        active_orders_page.setVisible(false);
        delivered_orders_page.setVisible(false);
    }



    @FXML
    void update_info(ActionEvent event) {
        users loggedInUser = loggedIn.getInstance().getLoggedInUser();
        int userID = loggedInUser.getUser_id();
        String name = user_name.getText();
        String surname = user_surname.getText();
        String username = user_username.getText();
        String phone = user_phone.getText();
        String user_address = address.getText();

        if(phone != null && !checkPhone(phone)){
            warning1.setText("                  Invalid phone number.");   
        }
        else if(user_address != null && !checkAddress(user_address)){
            warning1.setText("Address must be between 25-200 characters.");
        }
        else{
            boolean update = userData.updateInfoById(userID, name, surname, username, phone, user_address);
            if (update == true){
                warning1.setText("              Updated successfully.");
            }
            else{
                warning1.setText("           Username already exists.");
            }
        }
    }

    @FXML
    void update_password(ActionEvent event) {
        if (current_password.getText().isEmpty() || password1.getText().isEmpty() || password2.getText().isEmpty()) {
            warning2.setText("         Please enter your data.");
        } 
        else if(!password1.getText().equals(password2.getText())) {
            warning2.setText("    Please check your passwords!");
        } 
        else if(!password1.getText().equals(loggedInCarrier.getUser_password())){
            warning2.setText("   Your password is not correct!");
        }  
        else if(!customer.isStrongPassword(password1.getText())){
            warning2.setText("           Enter strong password.");
        }
        else{
            users loggedInCarrier = loggedIn.getInstance().getLoggedInUser();
            int userID = loggedInCarrier.getUser_id();
            if(userData.updatePasswordById(userID, password1.getText())) {
                warning2.setText("       Successfully updated.");
            }
            else {
                warning2.setText("       Something went wrong!");
            }
        }
    }


    boolean checkAddress(String Adress) {
        if(Adress.length() > 200){
            return false;
        }
        if(Adress.length() < 25){
            return false;
        }

        return true;
    }

    boolean checkPhone(String Phone) {
        if(Phone.length() != 10){
            return false;
        }

        if(Phone.charAt(0) != '5'){
            return false;
        }
        return true;
    }

    private static boolean isStrongPassword(String password) {
        if (password.length() < 4) {
            return false;
        }

        if (password.length() > 20) {
            return false;
        }
    
        // Büyük harf kontrolü
        if (!containsUppercase(password)) {
            return false;
        }
    
        // Küçük harf kontrolü
        if (!containsLowercase(password)) {
            return false;
        }
    
        // Sayı kontrolü
        if (!containsDigit(password)) {
            return false;
        }
    
        // Tüm kriterlere uyuyorsa true döndür
        return true;
    }
    
    private static boolean containsUppercase(String password) {
        return !password.equals(password.toLowerCase());
    }
    
    private static boolean containsLowercase(String password) {
        return !password.equals(password.toUpperCase());
    }
    
    private static boolean containsDigit(String password) {
        return password.matches(".*\\d.*");
    }

    
    public static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }
//------------------------------------MY PROFILE KISMININ KODU YUKARISI-------------------------------------------------------


    // to my orders page my orders sayfasından sipariş durumunu değştirme
    @FXML
    void to_orders(ActionEvent event) throws IOException {
        
        my_profile_page.setVisible(false);
        my_orders_page.setVisible(true);
        active_orders_page.setVisible(false);
        delivered_orders_page.setVisible(false);


    }

    @FXML
    void to_active_orders_page(ActionEvent event) throws IOException{
        
        my_profile_page.setVisible(false);
        my_orders_page.setVisible(false);
        active_orders_page.setVisible(true);
        delivered_orders_page.setVisible(false);

        }
    
    @FXML 
    void to_delivered_orders_page(ActionEvent event) throws IOException{

        my_profile_page.setVisible(false);
        my_orders_page.setVisible(false);
        active_orders_page.setVisible(false);
        delivered_orders_page.setVisible(true);
    }

    //aktif sipariş sayfasından ID girerek sipariş kabul etme
   @FXML
    void to_accept(ActionEvent event) {


        

    }


    // Sipariş bilgilerinin olduğun achorpane'lerde yer alaan tablolar (order_status'e göre)
    public void displayOrders(List<order> orders) 
    {
        orders = orderData.getAllCustomerOrders();
        StringBuilder sb = new StringBuilder();

        TextArea textArea = new TextArea(); // Declare and initialize the textArea variable
        textArea.setText(sb.toString());
    }


        @FXML
    void to_logout(ActionEvent event) throws IOException {
        loggedInCarrier = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/user_login.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.show();
    }
}


