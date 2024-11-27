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

public class CustomerLoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    static String C_user;
    FoodWorld f=new FoodWorld();
    @FXML
    private TextField username;
    @FXML
    private PasswordField pass;
    @FXML
    private Label Invalid_Label;
    @FXML

    public void CustomerSignup(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/Customersignup.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void customerfunction (ActionEvent event)throws Exception{
        int error = 0;
       // f.AddCustomer(f.c);
        for (int i = 0; i < FoodWorld.customerlist.size(); i++) {
            if (username.getText().equals(FoodWorld.customerlist.get(i).getUsername()) && pass.getText().equals(FoodWorld.customerlist.get(i).getPass())) {
                C_user=username.getText();
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
            root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
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
