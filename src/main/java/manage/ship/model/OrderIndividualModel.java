package manage.ship.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderIndividualModel {

    Connection conn=DB.getConn();
    ResultSet rs;
    PreparedStatement pst;


    public ResultSet getName() {

        String sql = "SELECT * FROM `customer_individual`";
        try {
             pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean regIndividual(String namein, String idnumberin, String categoryin, String weightin, String pricein,String date) {
        boolean result = false;
        String sql = "INSERT INTO `order_individual`(`o_namein`, `o_idnumberin`, `o_categoryin`, `o_weightin`, `o_pricein`, `o_datein`) VALUES (?,?,?,?,?,?) ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, namein);
            pst.setString(2, idnumberin);
            pst.setString(3, categoryin);
            pst.setString(4, weightin);
            pst.setString(5, pricein);
            pst.setString(6, date);

            result = pst.executeUpdate() == 1;
        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        return result;
    }


}
