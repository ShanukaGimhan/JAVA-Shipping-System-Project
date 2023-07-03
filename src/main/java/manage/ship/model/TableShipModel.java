package manage.ship.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import manage.ship.controllers.Ship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableShipModel {

    Connection conn = DB.getConn();

    public ObservableList getShipT() {

        ObservableList<Ship> ol = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `ship`";
        try {
            //`s_id`, `s_name`, `s_country`, `s_company`, `s_phone`, `s_mail`, `s_captain`, `s_date`
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                String id = rs.getString("s_id");
                String sName = rs.getString("s_name");
                String country = rs.getString("s_country");
                String company = rs.getString("s_company");
                String phone = rs.getString("s_phone");
                String mail = rs.getString("s_mail");
                String captainName = rs.getString("s_captain");
                String date = rs.getString("s_date");

               // list.add(new Ship(id, sName, country, company, phone, mail, captainName, date));
                ol.add(new Ship(id, sName, country, company, phone, mail, captainName, date));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ol;
    }

    public boolean delShip(String id) {
        boolean result = false;
        String sql = "DELETE FROM `ship` WHERE `s_id`=?";
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
