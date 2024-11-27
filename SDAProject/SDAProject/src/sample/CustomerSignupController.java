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

public class CustomerSignupController {

    FoodWorld FW=new FoodWorld();
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField C_name,C_username,C_contact;
    @FXML
    private DatePicker C_dob;
    @FXML
    private PasswordField C_pass,C_Conf_Pass;
    @FXML
    private Label Invalid_Label;

    @FXML
    public void Customer_SignUp(ActionEvent event) throws Exception
    {
        LocalDate date=C_dob.getValue();
        String ChangeDateFormat=date.format(DateTimeFormatter.ofPattern("MMM-dd-yyyy"));
        if(C_Conf_Pass.getText().equals("")||C_pass.getText().equals("")||C_contact.getText().equals("")||ChangeDateFormat.equals("")||C_name.getText().equals("")||C_username.getText().equals(""))
        {
            Invalid_Label.setText("Please Fill All The Options");
        }
        else {
            try {
                if(C_Conf_Pass.getText().equals(C_pass)==true)
                {
                    Invalid_Label.setText("Password Not Match");
                }
                else {
                    Customer c=new Customer(C_name.getText(),C_username.getText(),ChangeDateFormat,C_pass.getText(),C_pass.getText(),Long.parseLong(C_contact.getText()));
                    FW.AddCustomer(c);
                    CustomerAddedInfo();
                    Invalid_Label.setText("");
                    root = FXMLLoader.load(getClass().getResource("../Resources/customerlogin.fxml"));
                    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    scene=new Scene(root);
                    stage.setScene(scene);
                    stage.show();

                }
            }
            catch (Exception e)
            {
                Invalid_Label.setText("Invalid Contact Number");
            }
        }
    }

    public void CustomerLogin(ActionEvent event) throws Exception
    {
        root = FXMLLoader.load(getClass().getResource("../Resources/customerlogin.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void CustomerAddedInfo()
    {
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Sign Up Process !!");
        alert.setContentText("Sign Up Successfully !!");
        alert.showAndWait();
    }



}
