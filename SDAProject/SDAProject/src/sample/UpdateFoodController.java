package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UpdateFoodController implements Initializable {
    //FoodListController fl=new FoodListController();
    FoodWorld FW=new FoodWorld();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField food_id,food_name,food_des,food_price;
    @FXML
    private Label Invalid_Label;
    @FXML
    private Button Update_Button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        food_id.setText(FoodWorld.foodlist.get(FoodListController.index).getId());
        food_name.setText(FoodWorld.foodlist.get(FoodListController.index).getName());
        food_des.setText(FoodWorld.foodlist.get(FoodListController.index).getDescription());
        food_price.setText(String.valueOf(FoodWorld.foodlist.get(FoodListController.index).getPrice()));
    }

    @FXML
    public void Update(ActionEvent event) throws Exception
    {
        if(food_id.getText().equals("")||food_name.getText().equals("")||food_des.getText().equals("")||food_price.getText().equals(""))
        {
            Invalid_Label.setText("Please Fill All The Options");
        }
        else {
            try {
                Double price=Double.parseDouble(food_price.getText());
                FoodWorld.foodlist.get(FoodListController.index).setName(food_name.getText());
                FoodWorld.foodlist.get(FoodListController.index).setId(food_id.getText());
                FoodWorld.foodlist.get(FoodListController.index).setDescription(food_des.getText());
                FoodWorld.foodlist.get(FoodListController.index).setPrice(price);
                UpdateFoodAddedInfo();
                Invalid_Label.setText("");
                root = FXMLLoader.load(getClass().getResource("../Resources/restaurantfunction.fxml"));
                stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                scene=new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
            catch (Exception e)
            {
                Invalid_Label.setText("Invalid Price");
            }
        }
    }

    @FXML
    private void UpdateFoodAddedInfo()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Update Food Process !!");
        alert.setContentText("Food Updated Added Successfully !!");
        alert.showAndWait();
    }

}
