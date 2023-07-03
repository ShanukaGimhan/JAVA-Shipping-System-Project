package manage.ship.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import manage.ship.controllers.OrderCompany;
import manage.ship.controllers.OrderIndividual;
import manage.ship.controllers.Ship;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableOrder {

    Connection conn = DB.getConn();

    //order individual
    public ObservableList getInOT() {

        ObservableList<OrderIndividual> ol = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `order_individual`";
        try {
            //SELECT `o_idin`, `o_namein`, `o_idnumberin`, `o_categoryin`, `o_weightin`, `o_pricein`, `o_datein`
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                String idIn = rs.getString("o_idin");
                String nameIn = rs.getString("o_namein");
                String idNumberIn = rs.getString("o_idnumberin");
                String categoryIn = rs.getString("o_categoryin");
                String weightIn = rs.getString("o_weightin");
                String pricein = rs.getString("o_pricein");
                String datein = rs.getString("o_datein");

                ol.add(new OrderIndividual(idIn, nameIn, idNumberIn, categoryIn, weightIn, pricein, datein));
                // list.add(new Ship(id, sName, country, company, phone, mail, captainName, date));
                // ol.add(new Ship(id, sName, country, company, phone, mail, captainName, date));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ol;
    }


    //order company

    public ObservableList getComOT() {

        ObservableList<OrderCompany> ol = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `order_company`";
        try {
            //`o_idcm`, `o_namecm`, `o_ordereridcm`, `o_categorycm`, `o_weightcm`, `o_pricecm`, `o_datecm`
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                String idcm = rs.getString("o_idcm");
                String namecm = rs.getString("o_namecm");
                String ordereridcm = rs.getString("o_ordereridcm");
                String categorycm = rs.getString("o_categorycm");
                String weightcm = rs.getString("o_weightcm");
                String pricecm = rs.getString("o_pricecm");
                String datecm = rs.getString("o_datecm");

                ol.add(new OrderCompany(idcm, namecm, ordereridcm, categorycm, weightcm, pricecm, datecm));
                // list.add(new Ship(id, sName, country, company, phone, mail, captainName, date));
                // ol.add(new Ship(id, sName, country, company, phone, mail, captainName, date));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ol;
    }

}
