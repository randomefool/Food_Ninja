package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.util.Optional;

public class RiderfunctionController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    static int pick=0;
    @FXML
    public void riderlogin (ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/RiderLogin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void loginas (ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/loginas.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Picked (ActionEvent event)throws Exception{
        pick++;
        root = FXMLLoader.load(getClass().getResource("../Resources/OrdersList.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void DeliverOrdser (ActionEvent event)throws Exception{
          // Delivered();
        Optional<ButtonType> isConfirmed=Delivered();
        if(isConfirmed.get()==ButtonType.OK)
        {
            PaymentController.run=0;
            for (int i=0;i<FoodWorld.orderlist.size();i++)
            {
                if(RiderLoginController.rider_id.equals(FoodWorld.orderlist.get(i).getRid_id()))
                {
                    FoodWorld.orderlist.remove(i);
                }
            }
            DeliveredInfo();
            root = FXMLLoader.load(getClass().getResource("../Resources/loginas.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {

        }
    }
    @FXML
    private Optional<ButtonType> Delivered()
    {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delivery Dialog");
        alert.setHeaderText("Confirmation Message");
        alert.setContentText("Have you Delivered Order ( Press Ok For 'Yes' Otherwise 'Cancel' )");
        return alert.showAndWait();
    }

    @FXML
    private void DeliveredInfo()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Order Reached it's Destination !!");
        alert.setContentText("Order Delivered Successfully !!");
        alert.showAndWait();
    }


}
