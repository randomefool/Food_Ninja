package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PaymentController {
    FoodWorld f=new FoodWorld();
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    private RadioButton online,Cash;
    @FXML
    private Label L_cn,L_cp,l1,l2,Invalid_Label;
    @FXML
    private TextField tf_cn;
    @FXML
    private PasswordField pf_cp;

    static int run=0;


    @FXML
    public void Place_Order(ActionEvent event) throws Exception
    {
        try {
            if(online.isSelected()) {
                Long cardno = Long.parseLong(tf_cn.getText());
                int pin = Integer.parseInt(pf_cp.getText());
                if (tf_cn.getText().length() == 16 && pf_cp.getText().length() == 4) {
                    for (int i = 0; i < FoodWorld.cartlist.size(); i++) {
                        String price = String.valueOf(FoodWorld.cartlist.get(i).getItem_price());
                        Order order = new Order(FoodWorld.cartlist.get(i).getItem_id(), FoodWorld.cartlist.get(i).getItem_name(), price, FoodWorld.cartlist.get(i).getRes_id(), FoodWorld.cartlist.get(i).getCus_username(),FoodWorld.riderlist.get(RiderListController.Cus_select_Rider_index).getId());
                        f.AddOrders(order);
                        run++;
                    }
                    FoodWorld.cartlist.clear();
                    root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
                    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } else {
                    Invalid_Label.setText("Invalid pin or card number");
                }
            }
            else if(Cash.isSelected())
            {
                for (int i = 0; i < FoodWorld.cartlist.size(); i++) {
                    String price = String.valueOf(FoodWorld.cartlist.get(i).getItem_price());
                    Order order = new Order(FoodWorld.cartlist.get(i).getItem_id(), FoodWorld.cartlist.get(i).getItem_name(), price, FoodWorld.cartlist.get(i).getRes_id(), FoodWorld.cartlist.get(i).getCus_username(),FoodWorld.riderlist.get(RiderListController.Cus_select_Rider_index).getId());
                    f.AddOrders(order);
                    run++;
                }
                FoodWorld.cartlist.clear();
                root = FXMLLoader.load(getClass().getResource("../Resources/customerfunction.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
        catch (Exception e)
        {
            Invalid_Label.setText("Kindly Select The Ride !!");
        }
    }

    @FXML
    public void CardInfo(ActionEvent event) throws Exception
    {
        if(online.isSelected()) {
            L_cn.setOpacity(1);
            L_cp.setOpacity(1);
            tf_cn.setOpacity(1);
            pf_cp.setOpacity(1);
            l1.setOpacity(1);
            l2.setOpacity(1);
        }
        else if(Cash.isSelected())
        {
            L_cn.setOpacity(0);
            L_cp.setOpacity(0);
            tf_cn.setOpacity(0);
            pf_cp.setOpacity(0);
            l1.setOpacity(0);
            l2.setOpacity(0);
        }
    }

    @FXML
    public void back(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("../Resources/ItemList.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
