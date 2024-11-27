package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RiderSignupController {
    FoodWorld FW=new FoodWorld();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField rider_name,rider_id;

    @FXML
    private TextField rider_username;

    @FXML
    private TextField rider_mob_no;

    @FXML
    private PasswordField rider_pass;

    @FXML
    private PasswordField rider_Conf_Pass;

    @FXML
    private DatePicker rid_dob;

    @FXML
    private Label Invalid_Label;

    @FXML
    public void riderlogin(ActionEvent event)throws Exception{
        root = FXMLLoader.load(getClass().getResource("../Resources/LoginPage1.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void Rider_Signup(ActionEvent event) throws Exception {

        LocalDate date = rid_dob.getValue();
        String ChangeDateFormat = date.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));

        if(rider_id.getText().equals("")||rider_Conf_Pass.getText().equals("")||rider_pass.getText().equals("")||rider_mob_no.getText().equals("")||ChangeDateFormat.equals("")||rider_name.getText().equals("")||rider_username.getText().equals(""))
        {
            Invalid_Label.setText("Please Fill All The Options");
        }
        else {
            try {
                if(rider_Conf_Pass.getText().equals(rider_pass)==true)
                {
                    Invalid_Label.setText("Password Not Match");
                }
                else {
                    Rider rid=new Rider(rider_id.getText(),rider_name.getText(),rider_username.getText(),ChangeDateFormat,rider_pass.getText(),rider_Conf_Pass.getText(),Long.parseLong(rider_mob_no.getText()));
                    FW.AddRider(rid);
                    Invalid_Label.setText("");
                    RiderAddedInfo();
                    rider_id.setText("");
                    rider_name.setText("");
                    rider_username.setText("");
                    rid_dob.setValue(null);
                    rider_pass.setText("");
                    rider_Conf_Pass.setText("");
                    rider_mob_no.setText("");
                }
            }
            catch (Exception e)
            {
                Invalid_Label.setText("Invalid Contact Number");
            }
        }
    }

    @FXML
    private void RiderAddedInfo()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Rider Addition Process !!");
        alert.setContentText("Rider Added Successfully !!");
        alert.showAndWait();
    }
}
