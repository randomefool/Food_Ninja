package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerfunctionController {
    FoodWorld f=new FoodWorld();
    private Stage stage;
    private Scene scene;
    private Parent root;
    static int viewFood=0;
    static int cart=0;
    static int ride=0;

    @FXML // Back Button
    public void loginas (ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/customerlogin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Logout(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/loginas.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ViewFoodDetails(ActionEvent event) throws Exception{
        viewFood++;
        cart=0;
        //FoodWorld.restaurantlist.add(f.r);
        root = FXMLLoader.load(getClass().getResource("../Resources/Restaurant_List.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void AddToCart(ActionEvent event) throws Exception{
        viewFood++;
        cart++;
        root = FXMLLoader.load(getClass().getResource("../Resources/Restaurant_List.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Place(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/ItemList.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void remove(ActionEvent event) throws Exception{
        RestaurantfunctionController.res_order=0;
        ride=0;
        RiderfunctionController.pick=0;
        root = FXMLLoader.load(getClass().getResource("../Resources/OrdersList.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Deliver(ActionEvent event) throws Exception{
        ride++;
        root = FXMLLoader.load(getClass().getResource("../Resources/RiderList.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
