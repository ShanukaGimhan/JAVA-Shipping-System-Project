package manage.ship.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShipModel {
    Connection conn = DB.getConn();
    PreparedStatement pst;
    ResultSet rs;


    public boolean regShip(String shipName, String country, String companyName,
                           String phone, String mail, String captainName, String date) {

        boolean result = false;
        String sql = "INSERT INTO `ship`(`s_name`, `s_country`, `s_company`, `s_phone`, `s_mail`, `s_captain`, `s_date`) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, shipName);
            pst.setString(2, country);
            pst.setString(3, companyName);
            pst.setString(4, phone);
            pst.setString(5, mail);
            pst.setString(6, captainName);
            pst.setString(7, date);
            result = pst.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ResultSet getShip() {

        String sql = "SELECT * FROM `ship`";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean insertUpdate(String shipName, String country, String companyName,
                                String phone, String mail, String captainName, String date) {

//UPDATE `ship` SET `s_country`=?,`s_company`=?,`s_phone`=?,`s_mail`=?,`s_captain`=?,`s_date`=? WHERE `s_name`=?

        boolean result = false;
        String sql = "UPDATE `ship` SET `s_country`=?,`s_company`=?,`s_phone`=?,`s_mail`=?,`s_captain`=?,`s_date`=? WHERE `s_name`=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, shipName);
            pst.setString(2, country);
            pst.setString(3, companyName);
            pst.setString(4, phone);
            pst.setString(5, mail);
            pst.setString(6, captainName);
            pst.setString(7, date);
            result = pst.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
