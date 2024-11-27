package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class OrdersListController implements Initializable {

    @FXML
    private ListView<String> List_item_Id;
    @FXML
    private ListView<String> List_item_name;
    @FXML
    private ListView<String> List_item_price;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    String Selectedorder;

    @FXML
    public void back(ActionEvent event) throws Exception {
        if(RestaurantfunctionController.res_order==0 && RiderfunctionController.pick==0) {
            root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(RiderfunctionController.pick>0)
        {
            root = FXMLLoader.load(getClass().getResource("../Resources/RiderFunction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else if(RestaurantfunctionController.res_order>0)
        {
            root = FXMLLoader.load(getClass().getResource("../Resources/restaurantfunction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List_item_Id.getItems().add(0, "Item ID");
        List_item_name.getItems().add(0, "Item Name");
        List_item_price.getItems().add(0, "Price");
        if (RestaurantfunctionController.res_order == 0 && CustomerfunctionController.ride==0) {
            for (int i = 0; i < FoodWorld.orderlist.size(); i++) {
                boolean valid = CustomerLoginController.C_user.equals(FoodWorld.orderlist.get(i).getCus_username());
                if (valid == true) {
                    List_item_Id.getItems().addAll(FoodWorld.orderlist.get(i).getItem_id());
                    List_item_name.getItems().addAll(FoodWorld.orderlist.get(i).getItem_name());
                    List_item_price.getItems().addAll(FoodWorld.orderlist.get(i).getItem_price());
                }
            }
            List_item_name.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                    Selectedorder = List_item_name.getSelectionModel().getSelectedItem();
                    for (int i = 0; i < FoodWorld.orderlist.size(); i++) {
                        if (Selectedorder.equals(FoodWorld.orderlist.get(i).getItem_name())) {
                            FoodWorld.orderlist.remove(i);
                        }
                    }

                }
            });
        }
        else if(RestaurantfunctionController.res_order>0)
        {
            for (int i = 0; i < FoodWorld.orderlist.size(); i++) {
                boolean valid = RestaurantLoginController.res_id.equals(FoodWorld.orderlist.get(i).getRes_id());
                if (valid == true) {
                    List_item_Id.getItems().addAll(FoodWorld.orderlist.get(i).getItem_id());
                    List_item_name.getItems().addAll(FoodWorld.orderlist.get(i).getItem_name());
                    List_item_price.getItems().addAll(FoodWorld.orderlist.get(i).getItem_price());
                }
            }
        }
        else if(RiderfunctionController.pick>0)
        {
            for (int i = 0; i < FoodWorld.orderlist.size(); i++) {
                boolean valid = RiderLoginController.rider_id.equals(FoodWorld.orderlist.get(i).getRid_id());
              //  System.out.println("valid: "+valid+" "+FoodWorld.orderlist.get(i).getRid_id()+" "+RiderLoginController.rider_id);
                if (valid == true) {
                    List_item_Id.getItems().addAll(FoodWorld.orderlist.get(i).getItem_id());
                    List_item_name.getItems().addAll(FoodWorld.orderlist.get(i).getItem_name());
                    List_item_price.getItems().addAll(FoodWorld.orderlist.get(i).getItem_price());
                    break;
                }
            }
        }
    }


    @FXML
    public void initialize()
    {
        List_item_name.setOnMouseClicked(event ->{
            try {
                if(RestaurantfunctionController.res_order==0 && RiderfunctionController.pick==0) {
                    root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else if(RiderfunctionController.pick>0)
                {
                    root = FXMLLoader.load(getClass().getResource("../Resources/RiderFunction.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
            }
            catch (Exception e)
            {
                e.getStackTrace();
            }
        });
    }
}


