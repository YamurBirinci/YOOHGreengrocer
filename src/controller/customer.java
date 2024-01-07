package controller;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import domain.products;
import domain.users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import data.userData;
import data.productData;

public class customer implements Initializable{

    @FXML
    private HBox Fruits;

    @FXML
    private HBox MyOrders;

    @FXML
    private Button update1_button;

    @FXML
    private Button update2_button;

    @FXML
    private HBox MyProfile;

    @FXML
    private HBox Vegetables;

    @FXML
    private Button button_cart;

    @FXML
    private Button button_fruits;

    @FXML
    private Button button_profile;

    @FXML
    private Button button_vegetables;

    @FXML
    private VBox product_panel;

    @FXML
    private AnchorPane products_panel;

    @FXML
    private AnchorPane cart_panel;

    @FXML
    private AnchorPane cart_product;

    @FXML
    private VBox fruitsAndVeg;

    @FXML
    private AnchorPane profil_panel;

    @FXML
    private TextField search;

    @FXML
    private Button search_button;

    @FXML
    private TextField user_name;

    @FXML
    private TextField user_phone;

    @FXML
    private TextField user_surname;

    @FXML
    private TextField user_username;

    @FXML
    private Label customer_username;

    @FXML
    private Label warning1;

    @FXML
    private Label warning2;

    @FXML
    private TextArea address;

    @FXML
    private TextField password1;

    @FXML
    private TextField password2;

    @FXML
    private TextField current_password;

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
    void to_cart(ActionEvent event) {
        cart_panel.setVisible(true);
        profil_panel.setVisible(false);
        products_panel.setVisible(false);
    }

    @FXML
    void to_fruits(ActionEvent event) {
        cart_panel.setVisible(false);
        profil_panel.setVisible(false);
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
        cart_panel.setVisible(false);
        profil_panel.setVisible(true);
        products_panel.setVisible(false);
        MyProfile.setStyle("-fx-background-color: #C4CBC0;");
        Vegetables.setStyle("-fx-background-color: #F1F1F1;");
        Fruits.setStyle("-fx-background-color: #F1F1F1;");


        users loggedInUser = loggedIn.getInstance().getLoggedInUser();
        user_name.setText(loggedInUser.getUser_name());
        user_surname.setText(loggedInUser.getUser_surname());
        user_username.setText(loggedInUser.getUsername());
        user_phone.setText(loggedInUser.getUser_phone());
        address.setText(loggedInUser.getUser_address());
    }

    @FXML
    void to_search(ActionEvent event) {
        cart_panel.setVisible(false);
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
        cart_panel.setVisible(false);
        profil_panel.setVisible(false);
        products_panel.setVisible(true);
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
        else if(!customer.isStrongPassword(password1.getText())){
            warning2.setText("           Enter strong password.");
        }
        else{
            users loggedInUser = loggedIn.getInstance().getLoggedInUser();
            int userID = loggedInUser.getUser_id();
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
        if (password.length() < 6) {
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
    
        // Noktalama işareti kontrolü
        if (!containsSpecialCharacter(password)) {
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
    
    private static boolean containsSpecialCharacter(String password) {
        return password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");
    }

}