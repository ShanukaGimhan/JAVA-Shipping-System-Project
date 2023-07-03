package manage.ship.model;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import manage.ship.Application;
import manage.ship.controllers.LoginController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserModel {

    private Connection conn = DB.getConn();
    private PreparedStatement pst;
    private ResultSet rs;


    public boolean regUser(String uName, String uAddress, String uidNumber, String uPhone, String uMail,
                           String userName, String password, String uStatus, String uRole) {
        boolean result = false;
        String sql = "INSERT INTO `user`(`u_name`, `u_address`, `u_idnumber`, `u_phone`, `u_mail`, `username`, `password`, `u_status`, `u_role`) VALUES (?,?,?,?,?,?,?,?,?) ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, uName);
            pst.setString(2, uAddress);
            pst.setString(3, uidNumber);
            pst.setString(4, uPhone);
            pst.setString(5, uMail);
            pst.setString(6, userName);
            pst.setString(7, password);
            pst.setString(8, uStatus);
            pst.setString(9, uRole);
            result = pst.executeUpdate() == 1;
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return result;
    }

    public boolean emailCheck(String mail) {
        boolean result = false;
        String sql = "SELECT COUNT(u_mail) FROM user WHERE u_mail = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, mail);
            ResultSet rs = pst.executeQuery();
            rs.next();
            result = rs.getInt(1) == 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean idCheck(String id) {

        boolean result = false;
        String sql = "SELECT COUNT(u_idnumber) FROM user WHERE u_idnumber = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            result = rs.getInt(1) == 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ResultSet getIdNum() {

        String sql = "SELECT * FROM `user`";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public ResultSet selectUpdate(String val) {
        String sql = "SELECT * FROM `user` WHERE `u_idnumber` = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, val);
            ResultSet rs = pst.executeQuery();
            rs.next();
            System.out.println(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean insertUpdate(String uName, String uAddress, String uPhone, String uMail,
                                String userName, String uIdnumber) {
        boolean results = false;

        String sql = "  UPDATE `user` SET `u_name`=?,`u_address`=?,`u_phone`=?,`u_mail`=?,`username`=? WHERE `u_idnumber`= ?";
        //  String sql = "INSERT INTO `user`(`u_name`, `u_address`, `u_phone`, `u_mail`, `username`) VALUES (?,?,?,?,?,)";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, uName);
            pst.setString(2, uAddress);
            pst.setString(3, uPhone);
            pst.setString(4, uMail);
            pst.setString(5, userName);
            pst.setString(6, uIdnumber);
            results = pst.executeUpdate() == 1;

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return results;
    }

    public boolean insertRole(String status, String idNumber) {
        boolean result = false;
        String sql = "UPDATE `user` SET `u_status`=? WHERE `u_idnumber`= ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, status);
            pst.setString(2, idNumber);

            result = pst.executeUpdate() == 1;

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        return result;

    }

    public boolean login(String user, String pass, String st) {
        boolean result = false;
        st = "DISABLE";

      //  String sql = "Select * FROM user WHERE username=?";
       String sql = "Select * FROM user WHERE username=? LIMIT 1";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                BCrypt.Result check = BCrypt.verifyer().verify(pass.toCharArray(), rs.getString("password"));
                result = check.verified;
                String str = rs.getString("u_status");
                String role = rs.getString("u_role");

                if (str.equals(st)) {

                    System.out.println("disable user");
                    result = false;

                    Alert alert = new Alert(Alert.AlertType.WARNING, "User Disable. Contact Admin", ButtonType.OK);
                    alert.initStyle(StageStyle.UNDECORATED);
                    alert.setHeaderText(null);
                    alert.setGraphic(null);
                    alert.show();


                } else {
                    if (role.equals("ADMIN")) {

                        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("userMain-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage dashboard = new Stage();
                        dashboard.setTitle("MAIN MENU");
                        dashboard.setMaximized(false);
                        dashboard.setScene(scene);
                        dashboard.setResizable(false);
                        dashboard.show();
                        result = true;


                        FXMLLoader fxmlLoader1 = new FXMLLoader(Application.class.getResource("login-view.fxml"));
                        Scene scene1 = new Scene(fxmlLoader1.load());
                        Stage dashboard1 = new Stage();
                        dashboard1.setScene(scene1);
                        dashboard1.close();

                    } else if (role.equals("USER")) {

                        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainMenu-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage dashboard = new Stage();
                        dashboard.setTitle("MAIN MENU");
                        dashboard.setMaximized(false);
                        dashboard.setScene(scene);
                        dashboard.setResizable(false);
                        dashboard.show();
                        result = true;

                        FXMLLoader fxmlLoader2 = new FXMLLoader(Application.class.getResource("login-view.fxml"));
                        Scene scene2 = new Scene(fxmlLoader2.load());
                        Stage dashboard2 = new Stage();
                        dashboard2.setScene(scene2);
                        dashboard2.close();


                    }
                    // System.out.println("enable user");
                    // result=true;
                }
            }else {
                result=false;
            }


        } catch (SQLException | IOException e) {
            System.out.println(e.getMessage());
        }

        return result;


    }


    public boolean getPass(String user,String pass) throws SQLException {

        boolean result = false;

        String sql = "SELECT *  FROM user WHERE username = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                BCrypt.Result check = BCrypt.verifyer().verify(pass.toCharArray(), rs.getString("password"));
                result = check.verified;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}