import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import domain.products;
import domain.users;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import domain.users;
import data.userData;
import domain.products;
import data.productData;

public class customerdeneme {

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

        try{
            List<products> allFruits = productData.getAllFruits();
            for (int i = 0; i < allFruits.size(); i += 3) {

                HBox hbox = new HBox();
                hbox.setAlignment(Pos.CENTER); 
                hbox.setSpacing(35);

                for (int j = 0; j < 3 && i + j < allFruits.size(); j++) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("fxml/product_card.fxml"));
                    VBox card_box = loader.load();
                    product_card product_card = loader.getController();
                    product_card.setData(allFruits.get(i + j));
                    hbox.getChildren().add(card_box);
                }

                fruitsAndVeg.getChildren().add(hbox);
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
    }

    @FXML
    void to_search(ActionEvent event) {

    }

    @FXML
    void to_vegetables(ActionEvent event) {
        cart_panel.setVisible(false);
        profil_panel.setVisible(false);
        products_panel.setVisible(true);
        fruitsAndVeg.getChildren().clear();

        try{
            List<products> allVegetables = productData.getAllVegetables();
            for (int i = 0; i < allVegetables.size(); i += 3) {

                HBox hbox = new HBox();
                hbox.setAlignment(Pos.CENTER); 
                hbox.setSpacing(35);

                for (int j = 0; j < 3 && i + j < allVegetables.size(); j++) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("fxml/product_card.fxml"));
                    VBox card_box = loader.load();
                    product_card product_card = loader.getController();
                    product_card.setData(allVegetables.get(i + j));
                    hbox.getChildren().add(card_box);
                }

                fruitsAndVeg.getChildren().add(hbox);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}