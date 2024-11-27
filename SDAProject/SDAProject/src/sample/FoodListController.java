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

public class FoodListController implements Initializable {
    FoodWorld fw = new FoodWorld();
    @FXML
    private ListView<String> myListView;
    @FXML
    private ListView<String> List_food_Id;
    @FXML
    private ListView<String> List_Food_des;
    @FXML
    private ListView<String> List_food_price;

    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    String currentfood;
    static int index;
    static int index2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().add(0, "Food Name");
        List_food_Id.getItems().add(0, "Food ID");
        List_Food_des.getItems().add(0, "Food Description");
        List_food_price.getItems().add(0, "Food Price");
        if (CustomerfunctionController.viewFood == 0) {
            for (int i = 0; i < FoodWorld.foodlist.size(); i++) {
                if (FoodWorld.foodlist.get(i).getRes_f_name().equals(RestaurantLoginController.res_name)) {
                    String price = String.valueOf(FoodWorld.foodlist.get(i).getPrice());
                    myListView.getItems().addAll(FoodWorld.foodlist.get(i).getName());
                    List_food_Id.getItems().addAll(FoodWorld.foodlist.get(i).getId());
                    List_Food_des.getItems().addAll(FoodWorld.foodlist.get(i).getDescription());
                    List_food_price.getItems().addAll(price);
                }
            }
        } else {
            for (int i = 0; i < FoodWorld.foodlist.size(); i++) {
                if (FoodWorld.foodlist.get(i).getRes_f_name().equals(FoodWorld.restaurantlist.get(Rest_List_Controller.Cus_select_Rest_index).getName())) {
                    String price = String.valueOf(FoodWorld.foodlist.get(i).getPrice());
                    myListView.getItems().addAll(FoodWorld.foodlist.get(i).getName());
                    List_food_Id.getItems().addAll(FoodWorld.foodlist.get(i).getId());
                    List_Food_des.getItems().addAll(FoodWorld.foodlist.get(i).getDescription());
                    List_food_price.getItems().addAll(price);
                }
            }
        }

        if (CustomerfunctionController.viewFood == 0) {
            myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                    currentfood = myListView.getSelectionModel().getSelectedItem();
                    if (RestaurantfunctionController.update > RestaurantfunctionController.remove) {
                        for (int i = 0; i < FoodWorld.foodlist.size(); i++) {
                            if (currentfood.equals(FoodWorld.foodlist.get(i).getName())) {
                                index = i;
                            }
                        }
                    } else {
                        for (int i = 0; i < FoodWorld.foodlist.size(); i++) {
                            if (currentfood.equals(FoodWorld.foodlist.get(i).getName())) {
                                FoodWorld.foodlist.remove(i);
                            }
                        }
                    }
                }
            });
        }
        if (CustomerfunctionController.cart > 0) {
            myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


                public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                    currentfood = myListView.getSelectionModel().getSelectedItem();
                    System.out.println("Current food: "+currentfood);

                    for (int i = 0; i < FoodWorld.foodlist.size(); i++) {
                        if (currentfood.equals(FoodWorld.foodlist.get(i).getName())) {
                            index2=i;
                        }
                    }
                }
            });
        }
    }

    @FXML
    public void BACK(ActionEvent event) throws Exception{
        if(CustomerfunctionController.viewFood==0) {
            root = FXMLLoader.load(getClass().getResource("../Resources/restaurantfunction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            root = FXMLLoader.load(getClass().getResource("../Resources/MenuList.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    public void initialize()
    {

        myListView.setOnMouseClicked(event ->{
            try {
                if(CustomerfunctionController.viewFood==0) {
                    if (RestaurantfunctionController.update > RestaurantfunctionController.remove) {
                        root = FXMLLoader.load(getClass().getResource("../Resources/UpdateFoodDetails.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } else {
                        root = FXMLLoader.load(getClass().getResource("../Resources/Restaurantfunction.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                }
                if(CustomerfunctionController.cart>0)
                {
                    root = FXMLLoader.load(getClass().getResource("../Resources/Cart_Items.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }

            }catch(Exception e)
            {

                e.printStackTrace();
            }

        });
    }


}
