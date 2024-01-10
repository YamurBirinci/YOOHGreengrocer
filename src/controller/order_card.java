package controller;

import domain.order;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class order_card {

    @FXML
    private Label date;

    @FXML
    private Label order_status;

    @FXML
    private Label price;

    public void setData(order orderItem){
        date.setText(String.valueOf(orderItem.getTime()));
        order_status.setText(String.valueOf(orderItem.getOrder_status()));
        price.setText(String.valueOf(orderItem.getOrder_p_price()));
    }

}
