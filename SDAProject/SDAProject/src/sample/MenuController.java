package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MenuController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField Menu_tf;
    @FXML
    private Button add_btn,AddMore,back;
    @FXML
    private Label Invalid_Label;

    @FXML
    public void Add(ActionEvent event) throws Exception
    {
        if(Menu_tf.getText().equals(""))
        {
            Invalid_Label.setText("Please Fill the Option");
        }
        else
        {
            Restaurant menu=new Restaurant(Menu_tf.getText(),RestaurantLoginController.res_name,RestaurantLoginController.res_id);
            FoodWorld.menulist.add(menu);
            MenuAddedInfo();
        }
    }

    @FXML
    public void AddMore()
    {
        Menu_tf.setText("");
    }

    @FXML
    public void back(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("../Resources/restaurantfunction.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void MenuAddedInfo()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Menu Addition Process !!");
        alert.setContentText("Menu Added Successfully !!");
        alert.showAndWait();
    }


}
