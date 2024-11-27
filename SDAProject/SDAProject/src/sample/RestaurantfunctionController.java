package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RestaurantfunctionController {

    private Stage stage;
    static int remove=0;
    static int res_order=0;
    private Scene scene;
    static int update=0;
    private Parent root;

    public void addfood (ActionEvent event)throws Exception{
        CustomerfunctionController.viewFood=0;
        root = FXMLLoader.load(getClass().getResource("../Resources/MenuList.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    public void loginas (ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/restaurantlogin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void Update (ActionEvent event)throws Exception{
        CustomerfunctionController.viewFood=0;
        root = FXMLLoader.load(getClass().getResource("../Resources/Food_List.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        update++;
        remove=0;
        stage.show();
    }

    @FXML
    public void RemoveFood(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/Food_List.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        remove++;
        update=0;
        stage.show();
    }
    @FXML
    public void AddMenu(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/Menu.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        remove++;
        update=0;
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

    @FXML
    public void CheckOrder(ActionEvent event) throws Exception{
        res_order++;
        root = FXMLLoader.load(getClass().getResource("../Resources/OrdersList.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



}
