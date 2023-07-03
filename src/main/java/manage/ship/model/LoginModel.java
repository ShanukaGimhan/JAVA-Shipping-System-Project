package manage.ship.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {
    Connection conn=DB.getConn();
    PreparedStatement pst;

    ResultSet rs;
    public ResultSet isStatus() {

        String sql = "SELECT * FROM `user`";

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            rs.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;

    }
}
