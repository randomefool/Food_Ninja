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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RiderListController implements Initializable {
    FoodWorld fw = new FoodWorld();
    @FXML
    private ListView<String> myListView;
    @FXML
    private ListView<String> List_Rider_Id;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    String currentRider;
    static int Cus_select_Rider_index=-1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myListView.getItems().add(0,"Rider Name");
        List_Rider_Id.getItems().add(0,"Rider ID");
        for (int i = 0; i < FoodWorld.riderlist.size(); i++) {
            myListView.getItems().addAll(FoodWorld.riderlist.get(i).getName());
            List_Rider_Id.getItems().addAll(FoodWorld.riderlist.get(i).getId());
        }

        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {


            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

                currentRider = myListView.getSelectionModel().getSelectedItem();
                if (CustomerfunctionController.ride == 0) {
                    for (int i = 0; i < FoodWorld.riderlist.size(); i++) {
                        if (currentRider.equals(FoodWorld.riderlist.get(i).getName())) {
                            FoodWorld.riderlist.remove(i);
                        }
                    }
                }
                else
                {
                    for (int i = 0; i < FoodWorld.riderlist.size(); i++) {
                        if (currentRider.equals(FoodWorld.riderlist.get(i).getName())) {
                            Cus_select_Rider_index=i;
                            System.out.println("Index: "+Cus_select_Rider_index);
                            break;
                        }
                    }
                }
            }
        });
    }

    public void BACK(ActionEvent event) throws Exception{
        if(CustomerfunctionController.ride==0) {
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
                if(CustomerfunctionController.ride==0) {
                    root = FXMLLoader.load(getClass().getResource("../Resources/LoginPage1.fxml"));
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else
                {
                    root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
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
