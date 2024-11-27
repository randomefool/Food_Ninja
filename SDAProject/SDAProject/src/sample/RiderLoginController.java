package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RiderLoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    static String rider_id;
    FoodWorld f=new FoodWorld();
    @FXML
    private TextField username;
    @FXML
    private PasswordField rider_pass;
    @FXML
    private Label Invalid_Label;

    @FXML
    public void loginas (ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/loginas.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void riderfunction(ActionEvent event)throws Exception{
        int error = 0;
        for (int i = 0; i < FoodWorld.riderlist.size(); i++) {
            if (username.getText().equals(FoodWorld.riderlist.get(i).getUsername()) && rider_pass.getText().equals(FoodWorld.riderlist.get(i).getPass())) {
                rider_id=FoodWorld.riderlist.get(i).getId();
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
            Invalid_Label.setText("Invalid Username or Password");
        }
        else
        {
            root = FXMLLoader.load(getClass().getResource("../Resources/RiderFunction.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }



}
