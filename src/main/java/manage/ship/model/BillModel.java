package manage.ship.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BillModel {
    ResultSet rs ;
    public ResultSet getIdNum() {

        String sql = "SELECT * FROM `order_individual`";

        try {
            Connection conn = DB.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }


    public ResultSet getNamecm() {

        String sql = "SELECT * FROM `order_company`";

        ResultSet rst = null;
        try {
            Connection conn = DB.getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            rst = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rst;

    }

}
