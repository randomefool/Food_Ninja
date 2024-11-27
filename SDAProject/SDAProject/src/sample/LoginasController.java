package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginasController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void restaurantlogin(ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/restaurantlogin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void customerlogin(ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/customerlogin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void adminlogin(ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/Adminlogin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void firstpage(ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/firstpage.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void riderlogin(ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/RiderLogin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
