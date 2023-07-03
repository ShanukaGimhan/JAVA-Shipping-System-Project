package manage.ship.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderCompanyModel {

    Connection conn=DB.getConn();
    ResultSet rs;
    PreparedStatement pst;


    public ResultSet getName() {

        String sql = "SELECT * FROM `customer_company`";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean regCompany(String namecm, String ordereridcm, String categorycm, String weightcm, String pricecm,String datecm) {
        boolean result = false;
        String sql = "INSERT INTO `order_company`(`o_namecm`, `o_ordereridcm`, `o_categorycm`, `o_weightcm`, `o_pricecm`, `o_datecm`) VALUES (?,?,?,?,?,?) ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, namecm);
            pst.setString(2, ordereridcm);
            pst.setString(3, categorycm);
            pst.setString(4, weightcm);
            pst.setString(5, pricecm);
            pst.setString(6, datecm);
            result = pst.executeUpdate() == 1;
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return result;
    }
}
