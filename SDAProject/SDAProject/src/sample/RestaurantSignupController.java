package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RestaurantSignupController {
    FoodWorld FW=new FoodWorld();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField Res_Name,Res_ID,Res_contact,Res_Loc,Res_City;
    @FXML
    private PasswordField Res_Pass,Res_Conf_Pass;
    @FXML
    private Label Invalid_Label;
    @FXML
    public void AdminLogin(ActionEvent event) throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/LoginPage1.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void AddRest()
    {
        if(Res_contact.getText().equals("")||Res_Loc.getText().equals("")||Res_Name.getText().equals("")||Res_ID.getText().equals("")||Res_Pass.getText().equals("")||Res_Conf_Pass.getText().equals("")||Res_City.getText().equals(""))
        {
            Invalid_Label.setText("Please Fill All The Options");
        }
        else {
            boolean valid=Res_Pass.getText().equals(Res_Conf_Pass.getText());
            try {

                if(valid==false)
                {

                    Invalid_Label.setText("Password Not Match");
                }
                else {
                    Restaurant r = new Restaurant(Res_Name.getText(), Res_ID.getText(), Res_Loc.getText(), Res_Pass.getText(), Res_Conf_Pass.getText(), Long.parseLong(Res_contact.getText()), Res_City.getText());
                    FW.AddRestaurant(r);
                    Invalid_Label.setText("");
                    RestAddedInfo();
                    Res_Pass.setText("");
                    Res_Conf_Pass.setText("");
                    Res_ID.setText("");
                    Res_Name.setText("");
                    Res_Loc.setText("");
                    Res_contact.setText("");
                    Res_City.setText("");
                }
            }
            catch (Exception e)
            {
                Invalid_Label.setText("Invalid Contact Number");
            }
        }
    }

    @FXML
    private void RestAddedInfo()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Restaurant Addition Process !!");
        alert.setContentText("Restaurant Added Successfully !!");
        alert.showAndWait();
    }



}
