package manage.ship.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import manage.ship.Application;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    @FXML
    private Button btnCustomer;

    @FXML
    private Button btnLogOut;

    @FXML
    private Button btnPayment;

    @FXML
    private Button btnShips;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    @FXML
    public void showCustomer(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("customerMain-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Customer Menu");
            stage1.setScene(new Scene(root1));
            stage1.show();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Stage stage = (Stage) btnCustomer.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void showShip(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("shipMain-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Ship Menu");
            stage1.setScene(new Scene(root1));
            stage1.show();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Stage stage = (Stage) btnShips.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void showOrder(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("takeOrderMain-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Take Order Menu");
            stage1.setScene(new Scene(root1));
            stage1.show();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Stage stage = (Stage) btnPayment.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void showLogin(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Login");
            stage1.setScene(new Scene(root1));
            stage1.show();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();

    }



}
