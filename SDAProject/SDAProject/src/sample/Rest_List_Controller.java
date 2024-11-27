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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Rest_List_Controller implements Initializable {
    FoodWorld fw = new FoodWorld();
    @FXML
    private ListView<String> myListView;
    @FXML
    private ListView<String> List_Res_Id;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    String currentRest;
    static int Cus_select_Rest_index;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            myListView.getItems().add(0,"Restaurant Name");
            List_Res_Id.getItems().add(0,"Restaurant ID");
        for (int i = 0; i < FoodWorld.restaurantlist.size(); i++) {
            myListView.getItems().addAll(FoodWorld.restaurantlist.get(i).getName());
            List_Res_Id.getItems().addAll(FoodWorld.restaurantlist.get(i).getid());
        }

        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentRest = myListView.getSelectionModel().getSelectedItem();
                if(CustomerfunctionController.viewFood==0) {
                    for (int i = 0; i < FoodWorld.restaurantlist.size(); i++) {
                        if (currentRest.equals(FoodWorld.restaurantlist.get(i).getName())) {
                            FoodWorld.restaurantlist.remove(i);
                        }
                    }
                }
                else
                {
                    for (int i = 0; i < FoodWorld.restaurantlist.size(); i++) {
                        if (currentRest.equals(FoodWorld.restaurantlist.get(i).getName())) {
                            Cus_select_Rest_index=i;
                        }
                    }
                }

            }
        });
    }

    @FXML
    public void BACK(ActionEvent event) throws Exception{
        if(CustomerfunctionController.viewFood==0) {
            root = FXMLLoader.load(getClass().getResource("../Resources/LoginPage1.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
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
                      root = FXMLLoader.load(getClass().getResource("../Resources/LoginPage1.fxml"));
                      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                      Scene scene = new Scene(root);
                      stage.setScene(scene);
                      stage.show();
                  }
                  else
                  {
                      root = FXMLLoader.load(getClass().getResource("../Resources/MenuList.fxml"));
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


