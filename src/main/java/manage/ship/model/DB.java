package manage.ship.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public static Connection DBConn;

    public static Connection getConn () {

        try {
            DBConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/java_data", "root", "");
            System.out.println("connect");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return DBConn;

    }




}
