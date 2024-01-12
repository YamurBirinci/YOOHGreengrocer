package controller;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.customer_cart;
import domain.order;
import domain.products;
import domain.users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import data.userData;
import data.customer_cartData;
import data.orderData;
import data.productData;

public class customer implements Initializable{

    @FXML
    private HBox Fruits;

    @FXML
    private HBox MyOrders;

    @FXML
    private HBox MyProfile;

    @FXML
    private HBox Vegetables;

    @FXML
    private TextArea address;

    @FXML
    private Button button_cart;

    @FXML
    private Button button_fruits;

    @FXML
    private Button button_profile;

    @FXML
    private Button button_vegetables;

    @FXML
    private PasswordField current_password;

    @FXML
    private Label customer_username;

    @FXML
    private VBox fruitsAndVeg;

    @FXML
    private PasswordField password1;

    @FXML
    private PasswordField password2;

    @FXML
    private AnchorPane products_panel;

    @FXML
    private AnchorPane profil_panel;

    @FXML
    private TextField search;

    @FXML
    private Button search_button;

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

    @FXML
    private AnchorPane myOrder_panel;

    @FXML
    private VBox allMyOrders;

    @FXML
    private Button logout_button;

    @FXML
    private Button my_order_button;

    users loggedIn = users.loggedIN;



    public List<customer_cart> getMyCart() {
        return customer_cartData.myCart(loggedIn.getUser_id());
    }

    

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (loggedIn != null) {
            customer_username.setText("Dear, " + loggedIn.getUsername());
        } else {
            customer_username.setText("Dear Guest");
        }
    }

    @FXML
    void to_myOrder(ActionEvent event) {
        profil_panel.setVisible(false);
        products_panel.setVisible(false);
        myOrder_panel.setVisible(true);

        MyOrders.setStyle("-fx-background-color: #C4CBC0;");
        Fruits.setStyle("-fx-background-color: #F1F1F1;");
        Vegetables.setStyle("-fx-background-color: #F1F1F1;");
        MyProfile.setStyle("-fx-background-color: #F1F1F1;");

        allMyOrders.getChildren().clear();

        try{
            List<order> myOrder = orderData.getMyOrders(loggedIn.getUser_id());
            for (int i = 0; i < myOrder.size(); i++) {

                HBox hbox = new HBox();
                hbox.setAlignment(Pos.CENTER);

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/order_card.fxml"));
                VBox card_box = loader.load();
                order_card cartItem = loader.getController();
                cartItem.setData(myOrder.get(i));
                hbox.getChildren().add(card_box);

                allMyOrders.getChildren().add(hbox);
                allMyOrders.setSpacing(20);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    @FXML
    void to_cart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/customer_cart.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.show();
    }

    @FXML
    void to_fruits(ActionEvent event) {
        profil_panel.setVisible(false);
        myOrder_panel.setVisible(false);
        products_panel.setVisible(true);
        fruitsAndVeg.getChildren().clear();

        Fruits.setStyle("-fx-background-color: #C4CBC0;");
        Vegetables.setStyle("-fx-background-color: #F1F1F1;");
        MyProfile.setStyle("-fx-background-color: #F1F1F1;");


        try{
            List<products> allFruits = productData.getAllFruits();
            for (int i = 0; i < allFruits.size(); i += 3) {

                HBox hbox = new HBox();
                hbox.setAlignment(Pos.CENTER); 
                hbox.setSpacing(35);

                for (int j = 0; j < 3 && i + j < allFruits.size(); j++) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/product_card.fxml"));
                    VBox card_box = loader.load();
                    product_card product_card = loader.getController();
                    product_card.setData(allFruits.get(i + j));
                    hbox.getChildren().add(card_box);
                }

                fruitsAndVeg.getChildren().add(hbox);
                fruitsAndVeg.setSpacing(35);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    @FXML
    void to_profile(ActionEvent event) {
        profil_panel.setVisible(true);
        myOrder_panel.setVisible(false);
        products_panel.setVisible(false);
        MyProfile.setStyle("-fx-background-color: #C4CBC0;");
        Vegetables.setStyle("-fx-background-color: #F1F1F1;");
        Fruits.setStyle("-fx-background-color: #F1F1F1;");


        user_name.setText(loggedIn.getUser_name());
        user_surname.setText(loggedIn.getUser_surname());
        user_username.setText(loggedIn.getUsername());
        user_phone.setText(loggedIn.getUser_phone());
        address.setText(loggedIn.getUser_address());
    }

    @FXML
    void to_search(ActionEvent event) {
        myOrder_panel.setVisible(false);
        profil_panel.setVisible(false);
        fruitsAndVeg.getChildren().clear();
        products_panel.setVisible(true);

        try{
            List<products> searchResult = productData.searchProduct(search.getText());
            for (int i = 0; i < searchResult.size(); i += 3) {
                HBox hbox = new HBox();
                hbox.setAlignment(Pos.CENTER); 
                hbox.setSpacing(35);

                for (int j = 0; j < 3 && i + j < searchResult.size(); j++) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/product_card.fxml"));
                    VBox card_box = loader.load();
                    product_card product_card = loader.getController();
                    product_card.setData(searchResult.get(i + j));
                    hbox.getChildren().add(card_box);
                }

                fruitsAndVeg.getChildren().add(hbox);
                fruitsAndVeg.setSpacing(35);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void to_vegetables(ActionEvent event) {
        profil_panel.setVisible(false);
        products_panel.setVisible(true);
        myOrder_panel.setVisible(false);
        fruitsAndVeg.getChildren().clear();
        
        Vegetables.setStyle("-fx-background-color: #C4CBC0;");
        Fruits.setStyle("-fx-background-color: #F1F1F1;");
        MyProfile.setStyle("-fx-background-color: #F1F1F1;");

        try{
            List<products> allVegetables = productData.getAllVegetables();
            for (int i = 0; i < allVegetables.size(); i += 3) {

                HBox hbox = new HBox();
                hbox.setAlignment(Pos.CENTER); 
                hbox.setSpacing(35);

                for (int j = 0; j < 3 && i + j < allVegetables.size(); j++) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/product_card.fxml"));
                    VBox card_box = loader.load();
                    product_card product_card = loader.getController();
                    product_card.setData(allVegetables.get(i + j));
                    hbox.getChildren().add(card_box);
                }

                fruitsAndVeg.getChildren().add(hbox);
                fruitsAndVeg.setSpacing(35);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void to_logout(ActionEvent event) throws IOException {
        loggedIn = null;
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
                loggedIn = userData.getThisUser(userID);
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
        else if(!customer.isStrongPassword(password1.getText())){
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

    boolean checkPhone(String Phone) {
        if(Phone.length() != 10){
            return false;
        }

        if(Phone.charAt(0) != '5'){
            return false;
        }
        return true;
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
    

    

}
