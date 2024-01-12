package controller;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import domain.customer_cart;

import domain.users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import data.customer_cartData;
import data.orderData;

public class customer_shoppingcart implements Initializable {

    @FXML
    private AnchorPane after_cart_panel;

    @FXML
    private Label cargo_total;

    @FXML
    private Label date;
    
    @FXML
    private AnchorPane cart_product;

    @FXML
    private Label customer_username;

    @FXML
    private ComboBox<String> delivery;

    @FXML
    private Label kdv;

    @FXML
    private VBox product_panel;

    @FXML
    private AnchorPane cart_panel;

    @FXML
    private Label product_total;

    @FXML
    private Label total;

    @FXML
    private Button order_button;

    @FXML
    private Button return_button;

    @FXML
    private Button ok_button;

    @FXML
    private AnchorPane warning;

    @FXML
    private Button ok_button2;

    @FXML
    private Button ok_button3;

    @FXML
    private AnchorPane warning2;

    @FXML
    private AnchorPane warning3;

    
    users loggedInUser = loggedIn.getInstance().getLoggedInUser();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateDeliveryTimes();
        after_cart_panel.setVisible(false);
        cart_panel.setVisible(true);

        if (loggedInUser != null) {
            customer_username.setText("Dear, " + loggedInUser.getUsername());
        } else {
            customer_username.setText("Dear Guest");
        }
        
        getProduct();
        orderSummery();
        
    }

    @FXML
    void to_hp_afterOrder(ActionEvent event) throws IOException {
        after_cart_panel.setVisible(true);
        cart_panel.setVisible(false);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/customer_homepage.fxml"));
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
    void close_warning(ActionEvent event) {
        warning.setVisible(false);   
    }

    @FXML
    void close_warning2(ActionEvent event) {
        warning2.setVisible(false);   
    }

    @FXML
    void close_warning3(ActionEvent event) {
        warning3.setVisible(false);   
    }


    

    @FXML
    void to_order(ActionEvent event) {
        String selectedValue = delivery.getValue();
        if (selectedValue == null) {
            warning.setVisible(true);
        }
        else if (customer_cartData.getTotalPrice(loggedInUser.getUser_id()) == 0){
            warning2.setVisible(true);
        }
        else if(loggedInUser.getUser_phone() == null || loggedInUser.getUser_address() == null){
            warning3.setVisible(true);
        }
        else{
            cargo_total.setText("29.99₺");
            orderData.orderSave(loggedInUser.getUser_id());
            orderData.setOrderID();
            orderData.decreaseStocksAfterOrder(customer_cartData.myCart(loggedInUser.getUser_id()));
            customer_cartData.cleanCart(loggedInUser.getUser_id());
            after_cart_panel.setVisible(true);
            cart_panel.setVisible(false);
        
            date.setText(selectedValue);
        }
                
    }


    public void getProduct(){
        product_panel.getChildren().clear();
        users loggedInUser = loggedIn.getInstance().getLoggedInUser();

        try{
            List<customer_cart> myCart = customer_cartData.myCart(loggedInUser.getUser_id());
            for (int i = 0; i < myCart.size(); i++) {

                HBox hbox = new HBox();
                hbox.setAlignment(Pos.CENTER);

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/product_card_cart.fxml"));
                VBox card_box = loader.load();
                product_card_cart product_card = loader.getController();
                product_card.setData(myCart.get(i));
                hbox.getChildren().add(card_box);

                product_panel.getChildren().add(hbox);
                product_panel.setSpacing(20);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    private void updateDeliveryTimes() {

        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();
        LocalDate tomorrow = today.plusDays(1);
        LocalDate dayAfterTomorrow = today.plusDays(2);
        LocalDate threeDaysLater = today.plusDays(3);

        delivery.getItems().clear();
        

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        if (now.getHour() < 12) {
            delivery.getItems().addAll(
                "12:00-15:00 " + today.format(formatter),
                "15:00-18:00 " + today.format(formatter),
                "09:00-12:00 " + tomorrow.format(formatter),
                "12:00-15:00 " + tomorrow.format(formatter),
                "15:00-18:00 " + tomorrow.format(formatter),
                "09:00-12:00 " + dayAfterTomorrow.format(formatter)
            );
        } else if (now.getHour() < 15) {
            delivery.getItems().addAll(
                "15:00-18:00 " + today.format(formatter),
                "09:00-12:00 " + tomorrow.format(formatter),
                "12:00-15:00 " + tomorrow.format(formatter),
                "15:00-18:00 " + tomorrow.format(formatter),
                "09:00-12:00 " + dayAfterTomorrow.format(formatter),
                "12:00-15:00 " + dayAfterTomorrow.format(formatter)
            );
        
        } else if (now.getHour() < 18) {
            delivery.getItems().addAll(
                "09:00-12:00 " + tomorrow.format(formatter),
                "12:00-15:00 " + tomorrow.format(formatter),
                "15:00-18:00 " + tomorrow.format(formatter),
                "09:00-12:00 " + dayAfterTomorrow.format(formatter),
                "12:00-15:00 " + dayAfterTomorrow.format(formatter),
                "15:00-18:00 " + dayAfterTomorrow.format(formatter)
            );
        } else if (now.getHour() > 18) {
            delivery.getItems().addAll(
                "12:00-15:00 " + tomorrow.format(formatter),
                "15:00-18:00 " + tomorrow.format(formatter),
                "09:00-12:00 " + dayAfterTomorrow.format(formatter),
                "12:00-15:00 " + dayAfterTomorrow.format(formatter),
                "15:00-18:00 " + dayAfterTomorrow.format(formatter),
                "9:00-12:00 " + threeDaysLater.format(formatter)
            );
        } 
        
        
    }

    @FXML
    void selected_delivery(ActionEvent event) {
        
        
    }

    @FXML
    void to_homepage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/customer_homepage.fxml"));
        Parent root = loader.load();

        Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        currentStage.close();

        Stage newStage = new Stage();
        newStage.setResizable(false);
        newStage.setScene(new Scene(root, 960, 540));
        newStage.setTitle("Group9");
        newStage.show();
    }

    public void orderSummery() {
        double pt = customer_cartData.getTotalPrice(loggedInUser.getUser_id());
        product_total.setText(String.format("%.2f", pt));
        double product_kdv = pt* 0.01;
        kdv.setText(String.format("%.2f", product_kdv));
        double cargo = 29.99;
        cargo_total.setText("29.99₺");

        double order_total;
        order_total = pt + product_kdv + cargo;

        total.setText(String.format("%.2f", order_total));
    }
    
}
