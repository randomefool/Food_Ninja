package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.awt.*;
import java.util.ArrayList;

public class AdminloginController {

    // Loader.loadController
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private AnchorPane pane;
    @FXML
    private PasswordField Admin_Pass_txt;
    @FXML
    private Label Warn_Label ;
    @FXML
    private javafx.scene.control.TextField admin_username_tf;
    FoodWorld f=new FoodWorld();


    @FXML
    public void Login(ActionEvent event)throws Exception{
        int error = 0;
       // f.addAdmin();
        for (int i = 0; i < FoodWorld.adminList.size(); i++) {

            if (admin_username_tf.getText().equals(FoodWorld.adminList.get(i).getUsername()) && Admin_Pass_txt.getText().equals(FoodWorld.adminList.get(i).getPassword())) {
                error=0;
                break;
            }
            else
            {
                error++;
            }
        }
            if(error>0)
            {
                Warn_Label.setText("Invalid Username or Password");
            }
            else
            {
                root = FXMLLoader.load(getClass().getResource("../Resources/LoginPage1.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
    }
    public void Back(ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/loginas.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}


