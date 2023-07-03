package manage.ship.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import manage.ship.controllers.TableCustomerCompany;
import manage.ship.controllers.TableCustomerIndividual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableCustomerModel {

    Connection conn = DB.getConn();


    //get individual data for table
    public ObservableList getDataIndividual() {

        ObservableList<TableCustomerIndividual> ol = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `customer_individual`";
        try {
// `c_idin`, `c_namein`, `c_addressin`, `c_idnumberin`, `c_phonein`, `c_mailin`, `c_datein`
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                String id = rs.getString("c_idin");
                String name = rs.getString("c_namein");
                String address = rs.getString("c_addressin");
                String idnumber = rs.getString("c_idnumberin");
                String phone = rs.getString("c_phonein");
                String mail = rs.getString("c_mailin");
                String date = rs.getString("c_datein");
                ol.add(new TableCustomerIndividual(id, name, address, idnumber, phone, mail, date));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ol;
    }

    public ObservableList getDataCompany() {
        ObservableList<TableCustomerCompany> ol = FXCollections.observableArrayList();
        String sql = "SELECT * FROM `customer_company`";
        try {
//`c_idcm`, `c_namecm`, `c_addresscm`, `c_phonecm`, `c_mailcm`, `c_desigcm`, `c_idnumbercm`, `c_datecm`
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {

                String id = rs.getString("c_idcm");
                String name = rs.getString("c_namecm");
                String address = rs.getString("c_addresscm");
                String phone = rs.getString("c_phonecm");
                String mail = rs.getString("c_mailcm");
                String designation = rs.getString("c_desigcm");
                String idNumber = rs.getString("c_idnumbercm");
                String date = rs.getString("c_datecm");
                ol.add(new TableCustomerCompany(id, name, address, phone, mail, designation, idNumber, date));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ol;
    }

    public boolean delIndividual(String val) {
        boolean result = false;
        String sql = "DELETE FROM `customer_individual` WHERE `c_idin`=?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, val);
            result = pst.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public boolean delCompany(String val){

        boolean result=false;
        String sql="DELETE FROM `customer_company` WHERE `c_idcm`=?";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,val);
            result=pst.executeUpdate()==1;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return result;
    }

}
