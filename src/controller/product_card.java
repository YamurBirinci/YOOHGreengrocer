package controller;
import data.customer_cartData;
import domain.products;
import domain.users;
import data.productData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;

public class product_card {

    @FXML
    private VBox card;

    @FXML
    private ImageView product_image;

    @FXML
    private Label product_kg;

    @FXML
    private Label product_name;

    @FXML
    private Label product_price;

    @FXML
    private Button addToCart;

    @FXML
    private TextField amount;

    @FXML
    void toCart(ActionEvent event) {
        String name = product_name.getText();
        products product = productData.getThisProduct(name);

        try {
            double enteredAmount = Double.parseDouble(amount.getText());
            if (enteredAmount % 0.25 != 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter a number divisible by 0.25.");
                alert.showAndWait();
                amount.clear();
            }
            else if(!(product.getp_stock() >= enteredAmount)){
                String warning = "Due to stocks, you can buy a maximum of " + String.valueOf(product.getp_stock())+ "kg of products.";
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText(warning);
                alert.showAndWait();
                amount.clear();
            }
            else{
                users loggedInUser = loggedIn.getInstance().getLoggedInUser();
                double price = Double.valueOf(product_price.getText());
                double kg = Double.valueOf(product_kg.getText());

                int user_id = loggedInUser.getUser_id();
            

                customer_cartData.addToCart(user_id, name, (enteredAmount*price)/kg, enteredAmount, product.getp_image());
            }
            
        }catch(NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter numbers only.");
            alert.showAndWait();
            amount.clear();
        }
    
    }

    public void setData(products product){
        String imagePath = product.getp_image();
        if (imagePath != null) {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            product_image.setImage(image);
        }
        String changePrice;
        if((product.getP_threshold() >= product.getP_stock())){
            changePrice = String.format("%.2f", product.getp_price()*2);
        }else{
            changePrice = String.format("%.2f", product.getp_price());
        }
        product_name.setText(product.getp_name());
        product_price.setText(String.valueOf(changePrice));
        product_kg.setText(String.valueOf(product.getp_kg()));
        addToCart.setId(String.valueOf(product.getp_id()));
    }
}
