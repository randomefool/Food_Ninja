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

public class MenuListController implements Initializable {
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

    String currentmenu;
    int index;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().add(0,"Menu Name");
        List_Res_Id.getItems().add(0,"Restaurant ID");
        if(CustomerfunctionController.viewFood==0) {
            for (int i = 0; i < FoodWorld.menulist.size(); i++) {
                if (FoodWorld.menulist.get(i).getMenu_res_id().equals(RestaurantLoginController.res_id)) {
                    myListView.getItems().addAll(FoodWorld.menulist.get(i).getMenu());
                    List_Res_Id.getItems().addAll(FoodWorld.menulist.get(i).getMenu_res_id());
                }
            }
        }
        else
        {
            for (int i = 0; i < FoodWorld.menulist.size(); i++) {
                if (FoodWorld.menulist.get(i).getMenu_res_id().equals(FoodWorld.restaurantlist.get(Rest_List_Controller.Cus_select_Rest_index).getid())) {
                    myListView.getItems().addAll(FoodWorld.menulist.get(i).getMenu());
                    List_Res_Id.getItems().addAll(FoodWorld.menulist.get(i).getMenu_res_id());
                }
            }
        }



        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentmenu = myListView.getSelectionModel().getSelectedItem();
                    for (int i = 0; i < FoodWorld.menulist.size(); i++) {
                        if (currentmenu.equals(FoodWorld.menulist.get(i).getMenu())) {
                            index = i;
                            break;
                        }
                    }
            }
        });
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
            root = FXMLLoader.load(getClass().getResource("../Resources/Restaurant_List.fxml"));
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
                    root = FXMLLoader.load(getClass().getResource("../Resources/addfooddetail.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else
                {
                    root = FXMLLoader.load(getClass().getResource("../Resources/Food_List.fxml"));
                    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
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
