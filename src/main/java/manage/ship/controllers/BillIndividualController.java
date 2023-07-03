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

public class BillIndividualController implements Initializable {

    //bill componnent

    @FXML
    public Label lblCategory;

    @FXML
    public Label lblCustomerName;

    @FXML
    public Label lblDate;

    @FXML
    public Label lblIDNumber;

    @FXML
    public Label lblOId;

    @FXML
    public Label lblPrice;

    @FXML
    public Label lblWeight;

    @FXML
    public AnchorPane paneIndividualBill;

    @FXML
    private ComboBox<String> comboIndiId;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        BillModel billModel = new BillModel();
        ResultSet rst = billModel.getIdNum();
        ObservableList data = FXCollections.observableArrayList();
        try {
            while (rst.next()) {
                data.add(rst.getString("o_idnumberin"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        comboIndiId.setItems(data);


        //`o_namein`, `o_idnumberin`, `o_categoryin`, `o_weightin`, `o_pricein`, `o_datein`


        comboIndiId.setOnAction(event -> {

            String select = comboIndiId.getSelectionModel().getSelectedItem();

            Connection conn = DB.getConn();
            PreparedStatement pst;
            String sql = "SELECT * FROM `order_individual` WHERE `o_idnumberin`=? ";

            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, select);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    lblCustomerName.setText(rs.getString("o_namein"));
                    lblCategory.setText(rs.getString("o_categoryin"));
                    //txtIDnoUpdate.setText(rs.getString("u_idnumber"));
                    lblWeight.setText(rs.getString("o_weightin"));
                    lblPrice.setText(rs.getString("o_pricein"));
                    lblDate.setText(rs.getString("o_datein"));
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }


        });

    }

}
