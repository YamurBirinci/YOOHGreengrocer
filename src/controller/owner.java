package controller;

import javafx.beans.Observable;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class owner {

    //combo boxlarda yer alacak seçenekleri tanımlıyorum
    ObservableList<String> carrierStatList = FXCollections.observableArrayList("Full time", "Half time");

    ObservableList<String> prodStatList = FXCollections.observableArrayList("Full price", "Discount price");

    ObservableList<String> prodTypeList = FXCollections.observableArrayList("Fruits", "Vegetables");

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
    private TableColumn<?, ?> prodManagTabDateCol;

    @FXML
    private TableColumn<?, ?> prodManagTabIDcol;

    @FXML
    private TableColumn<?, ?> prodManagTabNameCol;

    @FXML
    private TableColumn<?, ?> prodManagTabPriceCol;

    @FXML
    private TableColumn<?, ?> prodManagTabStatCol;

    @FXML
    private TableColumn<?, ?> prodManagTabStockCol;

    @FXML
    private TableColumn<?, ?> prodManagTabTypeCol;

    @FXML
    private TableView<?> prodManagementTable;

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
    private void initialize()
    {
        //combo box'larda yer alan seçenekleri burada atıyorum
        chooseCarrierStat.setItems(carrierStatList);
    
        chooseProdStat.setItems(prodStatList);
    
        chooseProdType.setItems(prodTypeList);
    }


    @FXML
    void to_prod_management(ActionEvent event) {
        productManagementPage.setVisible(true);
        carrierManagementPage.setVisible(false);
        inventoryPage.setVisible(false);
        statisticsPage.setVisible(false);
//connect to sql database and display

        //which button had been pressed
        prodAddBtn.setOnAction(e -> addPRod());
        prodDltBtn.setOnAction(e -> deleteProd());
        prodClrBtn.setOnAction(e -> clearEnteredProd());
        prodUpdtBtn.setOnAction(e -> updateProd());
    }

    @FXML
    void to_carrier_management(ActionEvent event) {
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(true);
        inventoryPage.setVisible(false);
        statisticsPage.setVisible(false);

        //which button had been pressed
        carrierAddBtn.setOnAction(e -> addCarrier());
        carrierDltBtn.setOnAction(e -> deleteCarrier());
        carrierClrBtn.setOnAction(e -> clearEnteredCarrier());
        carrierUpdtBtn.setOnAction(e -> updateCarrier());
    }

    @FXML
    void to_inventory_page(ActionEvent event) {
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(false);
        inventoryPage.setVisible(true);
        statisticsPage.setVisible(false);
        //connect with sql and display the product table

    }

        @FXML
    void to_statistics_page(ActionEvent event) {
        productManagementPage.setVisible(false);
        carrierManagementPage.setVisible(false);
        inventoryPage.setVisible(false);
        statisticsPage.setVisible(true);
        //sql statistics table
    }


    void addPRod() {
        
        // JavaFX te owner'ın info girdiği textler
        String prodID = prodIDInput.getText();
        String prodName = prodNameInput.getText();
        String prodPrice = prodPriceInput.getText();
        String prodStock = prodStockInput.getText();
        String prodType = chooseProdType.getSelectionModel().getSelectedItem().toString();
        String prodStat = chooseProdStat.getSelectionModel().getSelectedItem().toString();

        //bu alınan string isimlerini sql'e ekleme


        //ÖNEMLİ!! -> sonra bütün string değerlerini tekrar boşa eşitleme
        prodID = "";
        prodName = "";
        prodPrice = "";
        prodStock = "";
    }

    void updateProd(){

        // JavaFX te owner'ın info girdiği textler
        String prodID = prodIDInput.getText();
        String prodName = prodNameInput.getText();
        String prodPrice = prodPriceInput.getText();
        String prodStock = prodStockInput.getText();
        String prodType = chooseProdType.getSelectionModel().getSelectedItem().toString();
        String prodStat = chooseProdStat.getSelectionModel().getSelectedItem().toString();

        //bu alınan infoları check etme eğer aynı değilse, product bilgilerini güncelleme

        //ÖNEMLİ!! -> sonra bütün string değerlerini tekrar boşa eşitleme
        prodID = "";
        prodName = "";
        prodPrice = "";
        prodStock = "";
    }

    void deleteProd(){

        // JavaFX te owner'ın info girdiği textler
        String prodID = prodIDInput.getText();
        String prodName = prodNameInput.getText();
        String prodPrice = prodPriceInput.getText();
        String prodStock = prodStockInput.getText();
        String prodType = chooseProdType.getSelectionModel().getSelectedItem().toString();
        String prodStat = chooseProdStat.getSelectionModel().getSelectedItem().toString();

        //bu alınan infoları sql database den silme, tablo güncellenicek

        //ÖNEMLİ!! -> sonra bütün string değerlerini tekrar boşa eşitleme
        prodID = "";
        prodName = "";
        prodPrice = "";
        prodStock = "";

        

    }

    void clearEnteredProd(){

        //JavaFX te owner'ın info girdiği textleri temizle
        prodIDInput.clear();
        prodNameInput.clear();
        prodPriceInput.clear();
        prodStockInput.clear();
        
    }

    void addCarrier()
    {
        String carrierID = carrierIDInput.getText();
        String carrierName = carrierNameInput.getText();
        String carrierStartDate = carrierStartDateInput.getText();
        String carrierTotCarries = carrierTotCarriesInput.getText();
        String carrierStat = chooseCarrierStat.getSelectionModel().getSelectedItem().toString();

        //ÖNEMLİ!! -> sonra bütün string değerlerini tekrar boşa eşitleme
        carrierID = "";
        carrierName = "";
        carrierStartDate = "";
        carrierTotCarries = "";
    }

    void deleteCarrier()
    {
        String carrierID = carrierIDInput.getText();
        String carrierName = carrierNameInput.getText();
        String carrierStartDate = carrierStartDateInput.getText();
        String carrierTotCarries = carrierTotCarriesInput.getText();
        String carrierStat = chooseCarrierStat.getSelectionModel().getSelectedItem().toString();

        //ÖNEMLİ!! -> sonra bütün string değerlerini tekrar boşa eşitleme
        carrierID = "";
        carrierName = "";
        carrierStartDate = "";
        carrierTotCarries = "";
    }

    void clearEnteredCarrier()
    {
        
        carrierIDInput.clear();
        carrierNameInput.clear();
        carrierStartDateInput.clear();
        carrierTotCarriesInput.clear();
    }

    void updateCarrier()
    {
        String carrierID = carrierIDInput.getText();
        String carrierName = carrierNameInput.getText();
        String carrierStartDate = carrierStartDateInput.getText();
        String carrierTotCarries = carrierTotCarriesInput.getText();
        String carrierStat = chooseCarrierStat.getSelectionModel().getSelectedItem().toString();

        //ÖNEMLİ!! -> sonra bütün string değerlerini tekrar boşa eşitleme
        carrierID = "";
        carrierName = "";
        carrierStartDate = "";
        carrierTotCarries = "";   
    }

}


   
