import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import domain.products;

public class customer_fruits implements Initializable{
    @FXML
    private VBox fruits_panel;

    private List<products> getAllFruits;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/group09";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "MySQL61.";

    private static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
    }

    @Override

    public void initialize(URL location, ResourceBundle resources){

        getAllFruits = new ArrayList<>(getAllFruits());
        try{
            for (int i = 0; i < getAllFruits.size(); i += 3) {

                HBox hbox = new HBox();
                hbox.setAlignment(Pos.CENTER); 
                hbox.setSpacing(35);

                for (int j = 0; j < 3 && i + j < getAllFruits.size(); j++) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("fxml/product_card.fxml"));
                    VBox card_box = loader.load();
                    product_card product_card = loader.getController();
                    product_card.setData(getAllFruits.get(i + j));
                    hbox.getChildren().add(card_box);
                }

                fruits_panel.getChildren().add(hbox);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        

    }

    public static List<products> getAllFruits() {
        List<products> fruitsList = new ArrayList<>();
    
        try {
            try (Connection connection = getConnection()) {
                String query = "select * from product_info where p_type = 'fruit' and p_stock > 0 order by p_name;"; 
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    ResultSet resultSet = preparedStatement.executeQuery();
    
                    while (resultSet.next()) {
                        products fruit = new products();
                        fruit.setp_id(resultSet.getInt("p_id"));
                        fruit.setp_name(resultSet.getString("p_name"));
                        fruit.setp_price(resultSet.getDouble("p_price"));
                        fruit.setp_stock(resultSet.getInt("p_stock"));
                        fruit.setp_kg(resultSet.getDouble("p_kg"));
                        fruit.setp_image(resultSet.getString("p_image"));
    
                        fruitsList.add(fruit);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace(); 
        }
    
        return fruitsList;
    }
}