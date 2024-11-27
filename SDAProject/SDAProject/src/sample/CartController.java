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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CartController implements Initializable {
    FoodWorld f=new FoodWorld();
    @FXML
    private Button Add_Cart_Button;
    @FXML
    private ListView<String>  List_item_Id;
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
        String Price=String.valueOf(FoodWorld.foodlist.get(FoodListController.index2).getPrice());
        List_item_Id.getItems().add(0, "Item ID");
        List_item_name.getItems().add(0,"Item Name");
        List_item_price.getItems().add(0,"Price");
        List_item_Id.getItems().addAll(FoodWorld.foodlist.get(FoodListController.index2).getId());
        List_item_name.getItems().addAll(FoodWorld.foodlist.get(FoodListController.index2).getName());
        List_item_price.getItems().addAll(Price);
    }


    @FXML
    public void AddCart(ActionEvent event) throws Exception
    {
        String price=String.valueOf(FoodWorld.foodlist.get(FoodListController.index2).getPrice());
        CartList obj=new CartList(FoodWorld.foodlist.get(FoodListController.index2).getId(),FoodWorld.foodlist.get(FoodListController.index2).getName(),price,FoodWorld.restaurantlist.get(Rest_List_Controller.Cus_select_Rest_index).getid(),CustomerLoginController.C_user);
        f.AddCart(obj);
    }
    @FXML
    public void AddMore(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("../Resources/Restaurant_List.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void BACK(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("../Resources/Food_List.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Done(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
