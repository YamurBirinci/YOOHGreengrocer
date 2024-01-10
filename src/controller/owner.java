package controller;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.EventHandler;
import data.orderData;
import data.productData;
import domain.order;
import domain.products;
import domain.users;
import javafx.scene.control.cell.PropertyValueFactory;


import java.util.ArrayList;
import java.util.Arrays;


public class owner {

    ObservableList<String> statusList = FXCollections.observableArrayList("All", "Order Received", "Order Has Been Prepared", "Delivered to cargo", "Order Was delivered");
        

    @FXML
    private Button carrierAddBtn;

    @FXML
    private Button carrierClrBtn;

    @FXML
    private Button carrierDltBtn;

    @FXML
    private TextField carrierIDInput;

    @FXML
    private TableView<?> carrierManagTab;

    @FXML
    private TableColumn<?, ?> carrierManagTabDateCol;

    @FXML
    private TableColumn<?, ?> carrierManagTabIDcol;

    @FXML
    private TableColumn<?, ?> carrierManagTabNameCol;

    @FXML
    private TableColumn<?, ?> carrierManagTabStatCol;

    @FXML
    private TableColumn<?, ?> carrierManagTabTotCarryCol;

    @FXML
    private ComboBox<String> choose_status_combobox;

    @FXML
    private TableView<order> order_table;

    @FXML
    private TableColumn<?, ?> orderID_column;

    @FXML
    private TableColumn<?, ?> kg_column;

    @FXML
    private TableColumn<?, ?> customerID_column;

    @FXML
    private TableColumn<?, ?> status_column;

    @FXML
    private TableColumn<?, ?> time_column;

    @FXML
    private TableColumn<?, ?> product_column;

    @FXML
    private TableColumn<?, ?> price_column;

    @FXML
    private Button carrierManagementButton;

    @FXML
    private AnchorPane carrierManagementPage;

    @FXML
    private TextField carrierNameInput;

    @FXML
    private TextField carrierStartDateInput;

    @FXML
    private TextField carrierTotCarriesInput;

    @FXML
    private Button carrierUpdtBtn;

    @FXML
    private ComboBox<String> chooseCarrierStat;

    @FXML
    private ComboBox<String> chooseProdStat;

    @FXML
    private ComboBox<String> chooseProdType;

    @FXML
    private AreaChart<Integer, Integer> customProdChartStat;

    @FXML
    private AnchorPane graphSection;

    @FXML
    private TableView<?> incentoryTable;

    @FXML
    private Button inventoryButton;

    @FXML
    private AnchorPane inventoryPage;

    @FXML
    private TableColumn<?, ?> invntryTabDateCol;

    @FXML
    private TableColumn<?, ?> invntryTabIDcol;

    @FXML
    private TableColumn<?, ?> invntryTabNameCol;

    @FXML
    private TableColumn<?, ?> invntryTabPriceCol;

    @FXML
    private TableColumn<?, ?> invntryTabStatCol;

    @FXML
    private TableColumn<?, ?> invntryTabStockCol;

    @FXML
    private TableColumn<?, ?> invntryTabTypeCol;

    @FXML
    private Button logOutButton;

    @FXML
    private Label numOfCustomerStat;

    @FXML
    private Label owner_username;

    @FXML
    private Button prodAddBtn;

    @FXML
    private Button prodClrBtn;

    @FXML
    private Button prodDltBtn;

    @FXML
    private TextField prodIDInput;

    @FXML
    private ImageView prodImgView;

    @FXML
    private Button prodImpotBtn;

    @FXML
    private AnchorPane prodManagTab;

    @FXML
    private TableColumn<products, Integer> prodManagTabIDcol;

    @FXML
    private TableColumn<products, String> prodManagTabNameCol;

    @FXML
    private TableColumn<products, Double> prodManagTabPriceCol;

    @FXML
    private TableColumn<products, Double> prodManagTabStockCol;


    @FXML
    private TableView<products> prodManagementTable;

    @FXML
    private TextField prodNameInput;

    @FXML
    private TextField prodPriceInput;

    @FXML
    private TextField prodStockInput;

    @FXML
    private Button prodUpdtBtn;

    @FXML
    private Button productManagementButton;

    @FXML
    private AnchorPane productManagementPage;

    @FXML
    private Button search_button;

    @FXML
    private AnchorPane statInfoSection;

    @FXML
    private Button statisticsButton;

    @FXML
    private AnchorPane statisticsPage;

    @FXML
    private Label totalIncomeStat;

    @FXML
    private BarChart<?, ?> yearlyIncomeChartStat;

    @FXML
    private AnchorPane updatePrice_panel;

    @FXML
    private AnchorPane delete_panel;

    @FXML
    private AnchorPane update_stock_panel;

    @FXML
    private AnchorPane order_panel;

    @FXML
    private Button updateStock_panel_button;

    @FXML
    private Button updatePrice_panel_button;

    @FXML
    private Button delete_panel_button;

    @FXML
    private Button decrease_button;

    @FXML
    private Button add_button;

    users loggedInUser = loggedIn.getInstance().getLoggedInUser();

    @FXML
    void to_delete_panel(ActionEvent event) {
        updatePrice_panel.setVisible(false);
        delete_panel.setVisible(true);
        update_stock_panel.setVisible(false);

    }

    @FXML
    void to_updateStock_panel(ActionEvent event) {
        updatePrice_panel.setVisible(false);
        delete_panel.setVisible(false);
        update_stock_panel.setVisible(true);
    }

    @FXML
    void to_updatePrice_panel(ActionEvent event) {
        updatePrice_panel.setVisible(true);
        delete_panel.setVisible(false);
        update_stock_panel.setVisible(false);
    }

    @FXML
    void to_orderManagement(ActionEvent event) {
        order_panel.setVisible(true);
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(false);
        inventoryPage.setVisible(false);
        statisticsPage.setVisible(false);

        choose_status_combobox.setItems(statusList);
    }


    @FXML
    private void initialize()
    {   
        if (loggedInUser != null) {
            owner_username.setText("Dear, " + loggedInUser.getUsername());
        }else {
            owner_username.setText("Dear Guest");
        }
        
    }


    @FXML
    void to_prod_management(ActionEvent event) {
        productManagementPage.setVisible(true);
        carrierManagementPage.setVisible(false);
        inventoryPage.setVisible(false);
        statisticsPage.setVisible(false);
        order_panel.setVisible(false);

        List<products> productList = productData.getAllProducts();

        prodManagTabIDcol.setCellValueFactory(new PropertyValueFactory<>("p_id"));
        prodManagTabNameCol.setCellValueFactory(new PropertyValueFactory<>("p_name"));
        prodManagTabStockCol.setCellValueFactory(new PropertyValueFactory<>("p_stock"));
        prodManagTabPriceCol.setCellValueFactory(new PropertyValueFactory<>("p_price"));


        prodManagementTable.getItems().addAll(productList);

        

    }

    @FXML
    void to_carrier_management(ActionEvent event) {
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(true);
        inventoryPage.setVisible(false);
        statisticsPage.setVisible(false);
        order_panel.setVisible(false);


    }

    @FXML
    void to_inventory_page(ActionEvent event) {
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(false);
        inventoryPage.setVisible(true);
        statisticsPage.setVisible(false);
        order_panel.setVisible(false);
        //connect with sql and display the product table

    }

        @FXML
    void to_statistics_page(ActionEvent event) {
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(false);
        inventoryPage.setVisible(false);
        statisticsPage.setVisible(true);
        order_panel.setVisible(false);
        //sql statistics table
    }

    @FXML
    void to_dec_quantity(ActionEvent event) {

    }

    @FXML
    void to_add_quantity(ActionEvent event) {
        

    }

    @FXML
    void to_selected_status_table(ActionEvent event) {
        if("All".equals(choose_status_combobox.getValue())){

            List<order> allorderList = orderData.getAllCustomerOrders();
            

            orderID_column.setCellValueFactory(new PropertyValueFactory<>("orderID"));
            customerID_column.setCellValueFactory(new PropertyValueFactory<>("order_customer_id"));
            time_column.setCellValueFactory(new PropertyValueFactory<>("time"));
            product_column.setCellValueFactory(new PropertyValueFactory<>("order_p_name"));
            price_column.setCellValueFactory(new PropertyValueFactory<>("order_p_price"));
            kg_column.setCellValueFactory(new PropertyValueFactory<>("order_p_kg"));
            status_column.setCellValueFactory(new PropertyValueFactory<>("order_status"));

            order_table.getItems().addAll(allorderList);
            System.out.println("List size: " + allorderList.size());
        }
    }


   
}


   
