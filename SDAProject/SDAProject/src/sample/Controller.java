package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private Pane mypane;
    @FXML
    private Button Next;
    @FXML
    private ColorPicker colorP;
    @FXML
    private Color color;
    FoodWorld fw=new FoodWorld();
    public void loginas (ActionEvent event)throws Exception{
        fw.ReadFromFile();
        root = FXMLLoader.load(getClass().getResource("../Resources/loginas.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void changeColor(ActionEvent e)
    {
        Color MyColor=colorP.getValue();
        mypane.setBackground(new Background(new BackgroundFill(MyColor,null,null)));
    }

}
