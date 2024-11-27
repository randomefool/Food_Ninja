package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemListController implements Initializable {
    FoodWorld f=new FoodWorld();
    @FXML
    private Button Add_Cart_Button;
    @FXML
    private ListView<String> List_item_Id;
    @FXML
    private ListView<String>   List_item_name;
    @FXML
    private ListView<String>    List_item_price;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Double Price=0.0;
        List_item_Id.getItems().add(0, "Item ID");
        List_item_name.getItems().add(0,"Item Name");
        List_item_price.getItems().add(0,"Price");
        for(int i=0;i<FoodWorld.cartlist.size();i++) {
            List_item_Id.getItems().addAll(FoodWorld.cartlist.get(i).getItem_id());
            List_item_name.getItems().addAll(FoodWorld.cartlist.get(i).getItem_name());
            List_item_price.getItems().addAll(FoodWorld.cartlist.get(i).getItem_price());
            Price+=Double.parseDouble(FoodWorld.cartlist.get(i).getItem_price());
        }
        String Total=String.valueOf(Price);
        List_item_price.getItems().addAll("Total : "+Total);
    }

    @FXML
    public void back(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Proceed(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("../Resources/Payment.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
