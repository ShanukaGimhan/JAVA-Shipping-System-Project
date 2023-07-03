package manage.ship.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import manage.ship.model.BillModel;
import manage.ship.model.DB;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BillCompanyController implements Initializable {

    @FXML
    private ComboBox<String> comboIndiId;

    @FXML
    private Label lblCategory;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblWeight;

    @FXML
    private AnchorPane paneIndividualBill;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        BillModel billModel = new BillModel();
        ResultSet rst = billModel.getNamecm();
        ObservableList data= FXCollections.observableArrayList();
        try {
            while (rst.next()) {
                data.add(rst.getString("o_namecm"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        comboIndiId.setItems(data);

        //`o_idcm`, `o_namecm`, `o_ordereridcm`, `o_categorycm`, `o_weightcm`, `o_pricecm`, `o_datecm



        comboIndiId.setOnAction(event -> {

            String select=  comboIndiId.getSelectionModel().getSelectedItem();

            Connection conn = DB.getConn();
            PreparedStatement pst;
            String sql = "SELECT * FROM `order_company` WHERE `o_namecm` = ?";

            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, select);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    lblCustomerName.setText(rs.getString("o_ordereridcm"));
                    lblCategory.setText(rs.getString("o_categorycm"));
                    //txtIDnoUpdate.setText(rs.getString("u_idnumber"));
                    lblWeight.setText(rs.getString("o_weightcm"));
                    lblPrice.setText(rs.getString("o_pricecm"));
                    lblDate.setText(rs.getString("o_datecm"));
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }


        });


    }
}
