package controller;
import domain.products;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    void toCart(ActionEvent event) {
        
    }

    public void setData(products fruit){
        String imagePath = fruit.getp_image();
        if (imagePath != null) {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            product_image.setImage(image);
        }
        product_name.setText(fruit.getp_name());
        product_price.setText(String.valueOf(fruit.getp_price()));
        product_kg.setText(String.valueOf(fruit.getp_kg()));
        addToCart.setId(String.valueOf(fruit.getp_id()));
    }
}
