package controller;
import data.userData;
import domain.users;
import domain.order;
import data.orderData;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

import java.net.URL;
import java.security.Timestamp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private TableView<order> carrierOrderTable;

    @FXML
    private TableView<order> carrierActiveOrderTable;

    @FXML
    private TableView<order> carrierDeliveredOrderTable;

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
    private TableColumn<order, String> active_customer_name;

    @FXML
    private TableColumn<order, String> delivered_order_id;

    @FXML
    private TableColumn<order, String> delivered_address;

    @FXML
    private TableColumn<order, String> delivered_date;

    @FXML
    private TableColumn<order, Integer> delivered_customer_id;

    @FXML
    private TableColumn<order, String> myOrders_delivery_address;

    @FXML
    private TableColumn<order, String> active_delivery_address;

    @FXML
    private TableColumn<order, String> active_order_delivery_time;

    @FXML
    private TableColumn<order, Integer> myOrders_order_customer_id;

    @FXML
    private TableColumn<order, String> myOrders_order_id_col;

    @FXML
    private TableColumn<order, String> active_order_id_col;

    @FXML
    private TableColumn<order, String> avtive_order_customer_id;

    @FXML
    private TableColumn<order, String> myOrders_delivery_time;

    @FXML
    private TableColumn<order, Timestamp> delivered_completed;

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
    private Button delivered_button;

    @FXML
    private Button accept_button;

    @FXML
    private TextField user_name;

    @FXML
    private TextField user_phone;

    @FXML
    private TextField user_surname;

    @FXML
    private TextField user_username;

    @FXML
    private TextField accept_OrderID_text;

    @FXML
    private Label warning1;

    @FXML
    private Label warning2;

    users loggedIn = users.loggedIN;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (loggedIn != null) {
            customer_username.setText("Dear, " + loggedIn.getUsername());
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
        int userID = loggedIn.getUser_id();
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
        else if(!password1.getText().equals(loggedIn.getUser_password())){
            warning2.setText("   Your password is not correct!");
        }  
        else if(!isStrongPassword(password1.getText())){
            warning2.setText("           Enter strong password.");
        }
        else{
            int userID = loggedIn.getUser_id();
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

    @FXML
    void to_orders(ActionEvent event) throws IOException {
        
        my_profile_page.setVisible(false);
        my_orders_page.setVisible(true);
        active_orders_page.setVisible(false);
        delivered_orders_page.setVisible(false);

        ObservableList<order> allMyOrders = FXCollections.observableArrayList(orderData.getCarrierCurrentOrders(loggedIn.getUser_id()));

        myOrders_order_id_col.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        myOrders_order_customer_id.setCellValueFactory(new PropertyValueFactory<>("order_customer_id"));
        myOrders_delivery_address.setCellValueFactory(new PropertyValueFactory<>("c_address"));
        myOrders_delivery_time.setCellValueFactory(new PropertyValueFactory<>("deliveryTime"));

        carrierOrderTable.getItems().clear();
        carrierOrderTable.getItems().addAll(allMyOrders);
    }

    @FXML
    void to_accept_order(ActionEvent event) {
        try {
            String checkStatus = orderData.getOrderStatusByID(accept_OrderID_text.getText());
            if(!("Order Has Been Prepared".equals(checkStatus))){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid ID");
                alert.setHeaderText(null);
                alert.setContentText("You can only change orders whose order status is \"Order Has Been Prepared\"!");
                alert.showAndWait();
            }
            orderData.changeOrderStatus(accept_OrderID_text.getText(), "Received by Carrier");
            orderData.acceptedOrderbyCarrier(accept_OrderID_text.getText(), loggedIn.getUser_id());
            activeOrderTable();

        } 
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("You entered the invalid input value!");
            alert.showAndWait();
        }
    }

    @FXML
    void to_active_orders_page(ActionEvent event) throws IOException{
        
        my_profile_page.setVisible(false);
        my_orders_page.setVisible(false);
        active_orders_page.setVisible(true);
        delivered_orders_page.setVisible(false);

        activeOrderTable();

    }

    void activeOrderTable(){
        ObservableList<order> allWaitingOrders = FXCollections.observableArrayList(orderData.getOrdersByStatus("Order Has Been Prepared"));
    
        active_order_id_col.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        avtive_order_customer_id.setCellValueFactory(new PropertyValueFactory<>("order_customer_id"));
        active_delivery_address.setCellValueFactory(new PropertyValueFactory<>("c_address"));
        active_order_delivery_time.setCellValueFactory(new PropertyValueFactory<>("deliveryTime"));

        carrierActiveOrderTable.getItems().clear();
        carrierActiveOrderTable.getItems().addAll(allWaitingOrders);
    }
    
    @FXML 
    void to_delivered_orders_page(ActionEvent event) throws IOException{

        my_profile_page.setVisible(false);
        my_orders_page.setVisible(false);
        active_orders_page.setVisible(false);
        delivered_orders_page.setVisible(true);
        deliveryTable();

    }

    void deliveryTable(){
        ObservableList<order> allDeliveredOrders = FXCollections.observableArrayList(orderData.getCarrierOrders(loggedIn.getUser_id()));
        
        delivered_order_id.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        delivered_customer_id.setCellValueFactory(new PropertyValueFactory<>("order_customer_id"));
        delivered_address.setCellValueFactory(new PropertyValueFactory<>("c_address"));
        delivered_date.setCellValueFactory(new PropertyValueFactory<>("deliveryTime"));
        delivered_completed.setCellValueFactory(new PropertyValueFactory<>("completedDelivery"));

        carrierDeliveredOrderTable.getItems().clear();
        carrierDeliveredOrderTable.getItems().addAll(allDeliveredOrders);
    }


    @FXML
    void to_deliveredToCustomer(ActionEvent event) {
        ObservableList<order> allMyOrders = FXCollections.observableArrayList(orderData.getCarrierCurrentOrders(loggedIn.getUser_id()));
    
        try {
            if (!allMyOrders.isEmpty()) {
                order firstOrder = allMyOrders.get(0);
                orderData.completedTime(firstOrder.getOrderID());
            }
            orderData.changeOrderStatus(myOrderInputID.getText(), "Order Was Delivered");
            deliveryTable();
        } 
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("You entered the invalid input value!");
            alert.showAndWait();
        }
    }


    public void displayOrders(List<order> orders) 
    {
        orders = orderData.getAllCustomerOrders();
        StringBuilder sb = new StringBuilder();

        TextArea textArea = new TextArea(); 
        textArea.setText(sb.toString());
    }


        @FXML
    void to_logout(ActionEvent event) throws IOException {
        loggedIn = null;
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