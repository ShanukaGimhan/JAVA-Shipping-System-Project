package manage.ship.model;

import javafx.event.ActionEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;

public class CustomerModel {

    private Connection conn = DB.getConn();
    private PreparedStatement pst;
    private ResultSet rs;

    public boolean regIndividualCustomer(String name, String address, String iDNumber, String phone, String mail, String date) {

        boolean result = false;
        String sql = "INSERT INTO `customer_individual`(`c_namein`, `c_addressin`, `c_idnumberin`, `c_phonein`, `c_mailin`, `c_datein`) VALUES (?,?,?,?,?,?)";
        try {

            pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, address);
            pst.setString(3, iDNumber);
            pst.setString(4, phone);
            pst.setString(5, mail);
            pst.setString(6, date);

            result = pst.executeUpdate() == 1;
            System.out.println("result return");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public boolean regCompanyCustomer(String cName, String cAddress, String cPhone, String cMail, String designation, String iDNumber, String cDate) {

        boolean result = false;
        String sql = "INSERT INTO `customer_company`( `c_namecm`, `c_addresscm`, `c_phonecm`, `c_mailcm`, `c_desigcm`, `c_idnumbercm`, `c_datecm`) VALUES (?,?,?,?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, cName);
            pst.setString(2, cAddress);
            pst.setString(3, cPhone);
            pst.setString(4, cMail);
            pst.setString(5, designation);
            pst.setString(6, iDNumber);
            pst.setString(7, cDate);
            result = pst.executeUpdate() == 1;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public ResultSet getIdNumber() {

        String sql = "SELECT * FROM `customer_individual`";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public ResultSet getCompanyName() {

        String sql = "SELECT * FROM `customer_company`";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean insertIndividualUpdate(String name,String address,String phone,String mail,String date,String idNumber){
        boolean result=false;

        String sql="UPDATE `customer_individual` SET `c_namein`=?,`c_addressin`=?,`c_phonein`=?,`c_mailin`=?,`c_datein`=? WHERE `c_idnumberin`=?";

        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,name);
            pst.setString(2,address);
            pst.setString(3,phone);
            pst.setString(4,mail);
            pst.setString(5,date);
            pst.setString(6,idNumber);
            result =pst.executeUpdate()==1;

        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }

    public boolean insertCompanyUpdate(String address,String phone,String mail,String designation,String idNumber,String date,String name){
        boolean result=false;
        String sql="UPDATE `customer_company` SET `c_addresscm`=?,`c_phonecm`=?,`c_mailcm`=?,`c_desigcm`=?,`c_idnumbercm`=?,`c_datecm`=? WHERE `c_namecm`=?";
      //  String sql="UPDATE `customer_company` SET `addresscm`=?,`c_phonecm`=?,`c_mailcm`=?,`c_desigcm`=?,`c_idnumbercm`=?,`c_datecm`=? WHERE `c_namecm`=?";

        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1,address);
            pst.setString(2,phone);
            pst.setString(3,mail);
            pst.setString(4,designation);
            pst.setString(5,idNumber);
            pst.setString(6,date);
            pst.setString(7,name);
            result=pst.executeUpdate()==1;

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println(result);
        return result;
    }


}
