package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application {
FoodWorld fw=new FoodWorld();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Resources/firstpage.fxml"));
        primaryStage.setTitle("Hello Food World");
        primaryStage.setScene(new Scene(root, 750, 770));
        primaryStage.setOnCloseRequest(event -> {  // -> for lemda function
            event.consume();
            LogOut(primaryStage);
        });
//        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public void LogOut(Stage primaryStage)
    {
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You are about to Logout!");
        alert.setContentText("Do you want to save before Exit? ");
        if(alert.showAndWait().get()== ButtonType.OK)
        {
            primaryStage.close();
            fw.AddToFile();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
