package controller;


import java.util.ResourceBundle;
import data.productData;
import data.customer_cartData;
import domain.users;
import domain.products;
import domain.customer_cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class product_card_cart implements Initializable  {

    @FXML
    private Button delete_button;

     @FXML
    private TextField p_amount;

    @FXML
    private Button product_amount_submit;

    @FXML
    private ImageView product_image;

    @FXML
    private Label product_name;

    @FXML
    private Label product_price;

    
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // FXML dosyası yüklendiğinde yapılacak işlemleri burada gerçekleştirin.
    }

    @FXML
    void to_delete(ActionEvent event) throws IOException {
        users loggedInUser = loggedIn.getInstance().getLoggedInUser();
        customer_cartData.deleteProduct(loggedInUser.getUser_id(), product_name.getText());
        product_price.setText("0");
        p_amount.setText("0");

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
    void to_submit(ActionEvent event) throws IOException {   
        users loggedInUser = loggedIn.getInstance().getLoggedInUser();
        customer_cart this_product = customer_cartData.getThisProductFromCart(loggedInUser.getUser_id(), product_name.getText());
        products product = productData.getThisProduct(product_name.getText());
        try {
            double newKg = Double.parseDouble(p_amount.getText());
            if (newKg % 0.25 != 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a number divisible by 0.25.");
                alert.showAndWait();
                p_amount.clear();
            }else if (product.getp_stock() < newKg){
                String warning = "Due to stocks, you can buy a maximum of " + String.valueOf(product.getp_stock())+ "kg of products.";
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText(warning);
                alert.showAndWait();
                p_amount.clear();
            }
            else{
                double current_product_price = Double.parseDouble(product_price.getText()); 
                double current_product_kg = this_product.getQuantity();

                double sNewPrice =(current_product_price * newKg) / current_product_kg;

                customer_cartData.updateAmount(loggedInUser.getUser_id(), product_name.getText(), sNewPrice, newKg, this_product.getP_image());
        
                String changePrice = String.format("%.2f", sNewPrice);
                product_price.setText(changePrice);

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

        }catch(NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter numbers only.");
            alert.showAndWait();
            p_amount.clear();
        }
    }

    void setData(customer_cart cart_item){
        String imagePath = cart_item.getP_image();
        if (imagePath != null) {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            product_image.setImage(image);
        }
        String changePrice = String.format("%.2f", cart_item.getPrice());
        product_name.setText(cart_item.getProduct_name());
        product_price.setText(String.valueOf(changePrice));
        p_amount.setText(String.valueOf(cart_item.getQuantity()));
    }

}
