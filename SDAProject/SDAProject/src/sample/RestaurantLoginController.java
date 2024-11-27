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

public class RestaurantLoginController {
    FoodWorld f=new FoodWorld();
    static String res_name,res_id;
    @FXML
    private TextField Res_name;
    @FXML
    private PasswordField Res_pass;
    @FXML
    private Label Invalid_Label;
    private Stage stage;
    private Scene scene;
    private Parent root;




    @FXML
    public void Login(ActionEvent event)throws Exception{
        int error = 0;
        for (int i = 0; i < FoodWorld.restaurantlist.size(); i++) {

            if (Res_name.getText().equals(FoodWorld.restaurantlist.get(i).getName()) && Res_pass.getText().equals(FoodWorld.restaurantlist.get(i).getPass())) {
                res_name=Res_name.getText();
                res_id=FoodWorld.restaurantlist.get(i).getid();
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
            root = FXMLLoader.load(getClass().getResource("../Resources/restaurantfunction.fxml"));
            stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }


    @FXML
    public void loginas (ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/loginas.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
