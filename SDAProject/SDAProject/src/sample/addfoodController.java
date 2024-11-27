package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addfoodController {
    FoodWorld FW=new FoodWorld();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField food_id,food_name,food_des,food_price;
    @FXML
    private Label Invalid_Label;

    @FXML
    public void restaurantfunction (ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/restaurantfunction.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void AddFood()
    {
        if(food_id.getText().equals("")||food_name.getText().equals("")||food_des.getText().equals("")||food_price.getText().equals(""))
        {
            Invalid_Label.setText("Please Fill All The Options");
        }
        else {
            try {
                Food f=new Food(food_name.getText(),food_id.getText(),food_des.getText(),Double.parseDouble(food_price.getText()),RestaurantLoginController.res_name,RestaurantLoginController.res_id);
                    FW.AddFood(f);
                      FoodAddedInfo();
                    Invalid_Label.setText("");

            }
            catch (Exception e)
            {
                Invalid_Label.setText("Invalid Price");
            }
        }
    }

    @FXML
    public void AddMore(){
        food_des.setText("");
        food_id.setText("");
        food_name.setText("");
        food_price.setText("");
    }

    @FXML
    private void FoodAddedInfo()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Food Addition Process !!");
        alert.setContentText("Food Added Successfully !!");
        alert.showAndWait();
    }

}
