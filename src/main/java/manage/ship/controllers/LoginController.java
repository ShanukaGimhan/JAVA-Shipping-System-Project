package manage.ship.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import manage.ship.Application;
import manage.ship.model.DB;
import manage.ship.model.LoginModel;
import manage.ship.model.UserModel;
import manage.ship.model.Validation;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private AnchorPane LoginPane;

    @FXML
    private Label txtus;

    @FXML
    private AnchorPane PasswordresetPane;

    @FXML
    private Button btnForget;

    @FXML
    private Button btnLog;

    @FXML
    private Button btnLog2;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSignUp;

    @FXML
    private Label lblCureentPassError;

    @FXML
    private Label lblErrorPass;

    @FXML
    private Label lblNewPassError;

    @FXML
    private Label lblPasswordResetDone;

    @FXML
    private AnchorPane loginPane;

    @FXML
    private TextField txtCurrentPass;

    @FXML
    private PasswordField txtNewtPass;

    @FXML
    private PasswordField txtPass;

    @FXML
    private TextField txtUserName;

    @FXML
    public Label lblErrorUser;

    @FXML
    private TextField combotext;

    @FXML
    private Label lblCureentPassError1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        PasswordresetPane.setVisible(false);
        LoginPane.setVisible(true);

    }

    //login

    public void log(ActionEvent e) throws IOException, SQLException {

        lblErrorPass.setText("");
        lblErrorUser.setText("");

        String username = txtUserName.getText();
        String password = txtPass.getText();

        String str = "DISABLE";


        if (Validation.isEmpty(username)) {
            lblErrorUser.setText("Enter User Name");

        } else if (Validation.isEmpty(password)) {
            lblErrorPass.setText("Enter Password");
        } else {

            //check

            Connection conn = DB.getConn();
            boolean result = false;
            String st = "DISABLE";
            String sql = "Select * FROM user WHERE username=? LIMIT 1";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, username);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    BCrypt.Result check = BCrypt.verifyer().verify(password.toCharArray(), rs.getString("password"));
                    boolean result1 = check.verified;
                    String str1 = rs.getString("u_status");
                    String role = rs.getString("u_role");

                    if (result1) {

                        if (str1.equals(st)) {

                            System.out.println("disable user");
                            result = false;

                            Alert alert = new Alert(Alert.AlertType.WARNING, "User Disable. Contact Admin", ButtonType.OK);
                            alert.initStyle(StageStyle.UNDECORATED);
                            alert.setHeaderText(null);
                            alert.setGraphic(null);
                            alert.show();


                        } else if (role.equals("ADMIN")) {

                            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("userMain-view.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            Stage dashboard = new Stage();
                            dashboard.setTitle("MAIN MENU");
                            dashboard.setMaximized(false);
                            dashboard.setScene(scene);
                            dashboard.setResizable(false);
                            dashboard.show();
                           // result = true;

                            Stage stage = (Stage) btnLog.getScene().getWindow();
                            stage.close();


                        } else if (role.equals("USER")) {

                            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainMenu-view.fxml"));
                            Scene scene = new Scene(fxmlLoader.load());
                            Stage dashboard = new Stage();
                            dashboard.setTitle("MAIN MENU");
                            dashboard.setMaximized(false);
                            dashboard.setScene(scene);
                            dashboard.setResizable(false);
                            dashboard.show();

                            Stage stage = (Stage) btnLog.getScene().getWindow();
                            stage.close();


                        }

                    } else {
                        lblErrorUser.setText("Incorrect User Name or Password ");

                    }

                }
            } catch (SQLException | IOException ex) {
                System.out.println(ex.getMessage());


            }


        }


    }

    public void changePassword(ActionEvent e) throws SQLException {

        lblCureentPassError.setText("");
        lblNewPassError.setText("");
        lblPasswordResetDone.setText("");
        lblCureentPassError1.setText("");

        String oldPass = txtCurrentPass.getText();
        String newPass = txtNewtPass.getText();
        String user = combotext.getText();

        ArrayList<Integer> errors = new ArrayList<Integer>();

        if (Validation.isEmpty(oldPass) || Validation.isEmpty(newPass) || Validation.isEmpty(user)) {
            lblCureentPassError1.setText("Required All Fields ");
            errors.add(1);
        } else {

            if (!Validation.minLen(oldPass, 5)) {
                lblCureentPassError.setText("password Need 5 Characters");
                errors.add(1);
            }
            if (!Validation.minLen(newPass, 5)) {
                lblNewPassError.setText("New Password Need 5 Characters");
                errors.add(1);
            }
        }
        if (errors.size() == 0) {

            UserModel userModel = new UserModel();
            boolean result = userModel.getPass(user, oldPass);
            if (result) {
                System.out.println("done");


                //update
                boolean result1 = false;
                String sql = "UPDATE `user` SET `password`=? WHERE `username`=?";
                String hash = BCrypt.withDefaults().hashToString(12, newPass.toCharArray());

                try {
                    Connection coon = DB.getConn();
                    PreparedStatement ps1 = coon.prepareStatement(sql);
                    ps1.setString(1, hash);
                    ps1.setString(2, user);
                    result1 = ps1.executeUpdate() == 1;
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

                if (result1) {
                    lblPasswordResetDone.setText("Password Update Success");
                }


            } else {
                lblCureentPassError1.setText("Invalid User Name or Password");


            }
        }




    }


    public void passwordReset(ActionEvent e) throws IOException {
        LoginPane.setVisible(false);
        PasswordresetPane.setVisible(true);

        txtPass.setText("");
        txtUserName.setText("");
        lblCureentPassError.setText("");
        lblNewPassError.setText("");

        lblCureentPassError.setText("");
        lblNewPassError.setText("");
        lblPasswordResetDone.setText("");


    }

    public void showLogin(ActionEvent e) throws IOException {
        LoginPane.setVisible(true);
        PasswordresetPane.setVisible(false);
        lblCureentPassError.setText("");
        lblNewPassError.setText("");

        lblCureentPassError.setText("");
        lblNewPassError.setText("");
        lblPasswordResetDone.setText("");


        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage dashboard = new Stage();
        dashboard.setTitle("MAIN MENU");
        dashboard.setMaximized(false);
        dashboard.setScene(scene);
        dashboard.setResizable(false);
        dashboard.show();


        Stage stage = (Stage) btnLog2.getScene().getWindow();
        stage.close();

    }
}

