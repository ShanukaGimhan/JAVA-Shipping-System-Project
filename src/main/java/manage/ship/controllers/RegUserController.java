package manage.ship.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import manage.ship.Application;

import java.io.IOException;

public class RegUserController {

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtPass;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtuName;


   public void close (ActionEvent e) throws IOException {

        Stage stage=new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("userReg-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
         stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }


}
