package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class LoginPage1Controller  {

    @FXML
    private Button Add_Res_button,Rem_Res_Button;
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;

    @FXML
    public void AddRes(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/restaurantsignup.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void RemoveRes(ActionEvent event) throws Exception{
        CustomerfunctionController.viewFood=0;
        root = FXMLLoader.load(getClass().getResource("../Resources/Restaurant_List.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void AddRider(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/RiderSignup.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void RemoveRider(ActionEvent event) throws Exception{
        CustomerfunctionController.ride=0;
        root = FXMLLoader.load(getClass().getResource("../Resources/RiderList.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void back(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/Adminlogin.fxml"));
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


}
