package controller;

import java.io.File;
import java.io.IOException;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import data.orderData;
import data.productData;
import data.userData;
import domain.order;
import domain.products;
import domain.users;
import javafx.scene.control.cell.PropertyValueFactory;



public class owner {


    @FXML
    private Button carrierAddBtn;

    @FXML
    private Button carrierClrBtn;

    @FXML
    private Button carrierDltBtn;

    @FXML
    private TextField carrierIDInput;

    @FXML
    private TableView<users> carrierManagTab;

    @FXML
    private TableColumn<users, String> carrierManagTabSurnameCol;

    @FXML
    private TableColumn<users, Integer> carrierManagTabIDcol;

    @FXML
    private TableColumn<users, String> carrierManagTabNameCol;

    @FXML
    private TableColumn<users, String> carrierManagTabUsernameCol;

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
    private TextField carrierSurnameInput;

    @FXML
    private TextField carrierUsernameInput;

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
    private TextField prodPriceInput1;

    @FXML
    private TextField prodStockInput;

    @FXML
    private TextField orderID_text;

    @FXML
    private Button prodUpdtBtn;

    @FXML
    private Button orderID_button;

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
    private AnchorPane update_stock_panel;

    @FXML
    private AnchorPane order_panel;

    @FXML
    private AnchorPane add_product_panel;

    @FXML
    private Button updateStock_panel_button;

    @FXML
    private Button updatePrice_panel_button;

    @FXML
    private Button decrease_button;

    @FXML
    private Button add_button;

    @FXML
    private AnchorPane warning2;

    @FXML
    private Button ok_button2;

    @FXML
    private TextField name_add_product;

    @FXML
    private TextField stock_add_product;

    @FXML
    private TextField price_add_product;

    @FXML
    private TextField threshold_add_product;

    @FXML
    private TextField kg_add_product;

    @FXML
    private Button AddProductButton;

    @FXML
    private Button import_button;

    @FXML
    private Button addProduct_panel_button;
    

    @FXML
    private ImageView new_product_image;

    @FXML
    private AnchorPane owner_page;

    private String path;

    @FXML
    private ComboBox<String> type_add_product;

    
    ObservableList<String> statusList = FXCollections.observableArrayList("Order Received", "Order Has Been Prepared", "Received by Carrier", "Order Was Delivered");
    ObservableList<String> productType = FXCollections.observableArrayList("fruit", "vegetable");



    users loggedIn = users.loggedIN;

    @FXML
    void to_addProduct_panel(ActionEvent event) {
        updatePrice_panel.setVisible(false);
        update_stock_panel.setVisible(false);
        add_product_panel.setVisible(true);
    } 

    @FXML
    void to_updateStock_panel(ActionEvent event) {
        updatePrice_panel.setVisible(false);
        update_stock_panel.setVisible(true);
        add_product_panel.setVisible(false);
    }

    @FXML
    void to_updatePrice_panel(ActionEvent event) {
        updatePrice_panel.setVisible(true);
        update_stock_panel.setVisible(false);
        add_product_panel.setVisible(false);
    }

    @FXML
    void to_orderManagement(ActionEvent event) {
        order_panel.setVisible(true);
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(false);

        choose_status_combobox.setItems(statusList);
    }


    @FXML
    private void initialize()
    {   
        if (loggedIn != null) {
            owner_username.setText("Dear, " + loggedIn.getUsername());
        }else {
            owner_username.setText("Dear Guest");
        }

        type_add_product.setItems(productType);
        
    }

    @FXML
    void to_prod_management(ActionEvent event) {
        productManagementPage.setVisible(true);
        carrierManagementPage.setVisible(false);
        order_panel.setVisible(false);

        getProductTable();
    }

    void getProductTable(){
        ObservableList<products> productList = FXCollections.observableArrayList(productData.getAllProducts());

        prodManagTabIDcol.setCellValueFactory(new PropertyValueFactory<>("p_id"));
        prodManagTabNameCol.setCellValueFactory(new PropertyValueFactory<>("p_name"));
        prodManagTabStockCol.setCellValueFactory(new PropertyValueFactory<>("p_stock"));
        prodManagTabPriceCol.setCellValueFactory(new PropertyValueFactory<>("p_price"));

        prodManagementTable.setItems(productList);
    }

    void getCarrierTable(){
        ObservableList<users> carrierList = FXCollections.observableArrayList(userData.getAllCarriers());

        carrierManagTabIDcol.setCellValueFactory(new PropertyValueFactory<>("user_id"));
        carrierManagTabNameCol.setCellValueFactory(new PropertyValueFactory<>("user_name"));
        carrierManagTabSurnameCol.setCellValueFactory(new PropertyValueFactory<>("user_surname"));
        carrierManagTabUsernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));

        carrierManagTab.setItems(carrierList);
    }


    @FXML
    void to_carrier_management(ActionEvent event) {
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(true);
        order_panel.setVisible(false);
        getCarrierTable();
    }


    @FXML
    void to_dec_quantity(ActionEvent event) {
        try {
            double pStock = Double.parseDouble(prodStockInput.getText());
            int pID = Integer.parseInt(prodIDInput.getText());
            products product = productData.getThisProduct(pID);

            if(product.getp_stock() < pStock){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("You entered too high an amount!");
                alert.showAndWait();
            }
            else if(!productData.decreaseStock(Integer.parseInt(prodIDInput.getText()), Double.parseDouble(prodStockInput.getText()))){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter the correct ID!");
                alert.showAndWait();
            }
            else{
                warning2.setVisible(true);
            } 
            getProductTable();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("You entered the invalid input value!");
            alert.showAndWait();
        }
    }

    @FXML
    void to_add_quantity(ActionEvent event) {
        try {
            double pStock = Double.parseDouble(prodStockInput.getText());
            int pID = Integer.parseInt(prodIDInput.getText());
            products product = productData.getThisProduct(pID);

            if(product.getp_stock() < pStock){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("You entered too high an amount!");
                alert.showAndWait();
            }
            else if(!productData.addStock(Integer.parseInt(prodIDInput.getText()), Double.parseDouble(prodStockInput.getText()))){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter the correct ID!");
                alert.showAndWait();
            }
            else{
                warning2.setVisible(true);
            } 
            getProductTable();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("You entered the invalid input value!");
            alert.showAndWait();
        }
    }

    @FXML
    void to_selected_status_table(ActionEvent event) {
        
        allOrderTableByStatus();
        
    }


    void allOrderTableByStatus(){
        String status = choose_status_combobox.getValue();
        ObservableList<order> orderListByStatus = FXCollections.observableArrayList(orderData.getOrdersByStatus(status));

            orderID_column.setCellValueFactory(new PropertyValueFactory<>("orderID"));
            customerID_column.setCellValueFactory(new PropertyValueFactory<>("order_customer_id"));
            time_column.setCellValueFactory(new PropertyValueFactory<>("time"));
            product_column.setCellValueFactory(new PropertyValueFactory<>("order_p_name"));
            price_column.setCellValueFactory(new PropertyValueFactory<>("order_p_price"));
            kg_column.setCellValueFactory(new PropertyValueFactory<>("order_p_kg"));
            status_column.setCellValueFactory(new PropertyValueFactory<>("order_status"));

            order_table.getItems().clear();
            order_table.getItems().addAll(orderListByStatus);
    }

    @FXML
    void close_warning2(ActionEvent event) { 
        warning2.setVisible(false);
    }   

    @FXML
    void to_updatePrice(ActionEvent event) {
        try {
            double pPrice = Double.parseDouble(prodPriceInput1.getText());
            int pID = Integer.parseInt(prodIDInput.getText());

            if(prodPriceInput1.getText().contains("-")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter the valid price!");
                alert.showAndWait();
            }
            if(!productData.updatePrice(pID, pPrice)){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter the correct ID!");
                alert.showAndWait();
            }
            else{
                warning2.setVisible(true);
            } 
            getProductTable();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("You entered the invalid input value!");
            alert.showAndWait();
        }
    }

    @FXML
    void to_changeOrderStatus(ActionEvent event) {
        orderID_text.getText();
        try {
            String checkStatus = orderData.getOrderStatusByID(orderID_text.getText());
            if(!("Order Received".equals(checkStatus))){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid ID");
                alert.setHeaderText(null);
                alert.setContentText("You can only change orders whose order status is \"Order Received\"!");
                alert.showAndWait();
            }
            orderData.changeOrderStatus(orderID_text.getText(), "Order Has Been Prepared");
            allOrderTableByStatus();

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
    void  to_addProduct(ActionEvent event) {
        try{
            if(name_add_product.getText().isEmpty() || kg_add_product.getText().isEmpty()|| stock_add_product.getText().isEmpty()||price_add_product.getText().isEmpty()||threshold_add_product.getText().isEmpty()||type_add_product.getSelectionModel().getSelectedItem() == null || path == null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Missing Input");
                alert.setHeaderText(null);
                alert.setContentText("Please enter data!");
                alert.showAndWait();
            }

            String productName = String.valueOf(name_add_product.getText());
            double productStock = Double.valueOf(stock_add_product.getText());
            double productPrice = Double.valueOf(price_add_product.getText());
            double productThreshold = Double.valueOf(threshold_add_product.getText());
            double productKg = Double.valueOf(kg_add_product.getText());
            String productType = type_add_product.getValue();

            int index = path.indexOf("img");
            String newPath = "/" + "img" + "/" + path.substring(index+4);  

            
            productData.insertProduct(productName, productType, productPrice, productStock, productKg, newPath, productThreshold);
            getProductTable();

        }catch (NumberFormatException e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter valid values.");
            alert.showAndWait();
        }
        
    }

    @FXML
    public void import_image(ActionEvent event){
        FileChooser openFile = new FileChooser();
        openFile.getExtensionFilters().add(new ExtensionFilter("Open Image File", "*png", "*jpg"));

        File file = openFile.showOpenDialog(owner_page.getScene().getWindow());
        if(file != null){
            path = file.getAbsolutePath();
            Image image = new Image(file.toURI().toString(),116, 111, false, true);
            new_product_image.setImage(image);
        }
        
    }

    @FXML
    public void to_addCarrier(ActionEvent event){
        if(!userData.userSave(carrierNameInput.getText(), carrierSurnameInput.getText(), carrierUsernameInput.getText(), carrierUsernameInput.getText(), "carrier")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Username already exist.");
            alert.showAndWait();
        }
        else{
            getCarrierTable();
        }
        
    }

    void getOrderTable(){
        
        ObservableList<products> productList = FXCollections.observableArrayList(productData.getAllProducts());

        prodManagTabIDcol.setCellValueFactory(new PropertyValueFactory<>("p_id"));
        prodManagTabNameCol.setCellValueFactory(new PropertyValueFactory<>("p_name"));
        prodManagTabStockCol.setCellValueFactory(new PropertyValueFactory<>("p_stock"));
        prodManagTabPriceCol.setCellValueFactory(new PropertyValueFactory<>("p_price"));

        prodManagementTable.setItems(productList);
    }

    @FXML
    public void to_logout(ActionEvent event) throws IOException{
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


    

}


   
