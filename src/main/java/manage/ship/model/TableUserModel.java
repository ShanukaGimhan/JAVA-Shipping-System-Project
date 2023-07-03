package manage.ship.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import manage.ship.controllers.TableUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableUserModel {
    Connection conn = DB.getConn();


    public ObservableList getData() {

        ObservableList<TableUser> ol = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `user`";
        try {

            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                String id = rs.getString("u_id");
                String name = rs.getString("u_name");
                String address = rs.getString("u_address");
                String idnumber = rs.getString("u_idnumber");
                String mail = rs.getString("u_mail");
                String user = rs.getString("username");
                String role = rs.getString("u_role");
                ol.add(new TableUser(id, name, address, idnumber, mail, user, role));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ol;
    }

    public boolean delUser(String id) {
        boolean result = false;
        String sql = "DELETE FROM `user` WHERE `u_id` = ?";
        try {
            PreparedStatement ps;
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            result = ps.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  result;
    }
}
