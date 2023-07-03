package manage.ship.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import manage.ship.Application;
import manage.ship.model.*;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class ShipController implements Initializable {

    @FXML
    private Button btnAllShip;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClear1;

    @FXML
    private Button btnCreg;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnManageShip;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSave1;

    @FXML
    private Button btnSearchShip;

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<String> comboShipName;

    @FXML
    private AnchorPane paneShipRegisterUpdate;

    @FXML
    private AnchorPane paneShipRegister;

    @FXML
    private DatePicker dateShip;

    @FXML
    private DatePicker dateShip1;

    @FXML
    private Label lblErro;

    @FXML
    private Label lblErro1;

    @FXML
    private Label lblIdErrorUpdate;
    @FXML
    private Label lblsuccessUp;

    @FXML
    private Label lblIdErrorUpdate1;
    @FXML
    private Label lblsuccessreg;

    @FXML
    private AnchorPane paneAllShip;

    @FXML
    private AnchorPane paneShipManage;

    @FXML
    private Rectangle rec1;

    @FXML
    private Rectangle rec2;

    @FXML
    private Rectangle rec3;

    @FXML
    private Rectangle rec4;

    @FXML
    private TableColumn<Ship, String> shipCaptain;

    @FXML
    private TableColumn<Ship, String> shipCaptaindel;

    @FXML
    private TableColumn<Ship, String> shipCompany;

    @FXML
    private TableColumn<Ship, String> shipCompanydel;

    @FXML
    private TableColumn<Ship, String> shipCountry;

    @FXML
    private TableColumn<Ship, String> shipCountrydel;

    @FXML
    private TableColumn<Ship, String> shipDate;

    @FXML
    private TableColumn<Ship, String> shipDatedel;

    @FXML
    private TableColumn<Ship, String> shipID;

    @FXML
    private TableColumn<Ship, String> shipIDdel;

    @FXML
    private AnchorPane shipMainPane;

    @FXML
    private TableColumn<Ship, String> shipName;

    @FXML
    private TableColumn<Ship, String> shipNamedel;

    @FXML
    private TableColumn<Ship, String> shipPhone;

    @FXML
    private TableColumn<Ship, String> shipPhonedel;

    @FXML
    private TableView<Ship> tableDelDelete;

    @FXML
    private TableView<Ship> tableShipAll;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtCompanyName1;

    @FXML
    private TextField txtCoptainName;

    @FXML
    private TextField txtCoptainName1;

    @FXML
    private TextField txtCountry;

    @FXML
    private TextField txtCountry1;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtMail1;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPhone1;

    @FXML
    private TextField txtShipName;

    @FXML
    private TableColumn<Ship, String> shipMail;
    @FXML
    private TableColumn<Ship, String> shipdelEmail;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        shipMainPane.setVisible(true);
        paneAllShip.setVisible(false);
        paneShipManage.setVisible(false);
        paneShipRegisterUpdate.setVisible(false);
        paneShipRegister.setVisible(true);

        rec1.setVisible(true);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(false);


    }


    //insert data
    public void insert(ActionEvent e) {

        lblErro.setText("");
        lblsuccessreg.setText("");

        ArrayList<Integer> error = new ArrayList<Integer>();

        String shipName = txtShipName.getText();
        String country = txtCountry.getText();
        String companyName = txtCompanyName.getText();
        String phone = txtPhone.getText();
        String mail = txtMail.getText();
        String captainName = txtCoptainName.getText();
        String date = null;
        if (dateShip.getValue() == null) {
            error.add(1);
        } else {
            date = String.valueOf(dateShip.getValue());
        }

        if (Validation.isEmpty(shipName) || Validation.isEmpty(country) || Validation.isEmpty(companyName) ||
                Validation.isEmpty(phone) || Validation.isEmpty(mail) || Validation.isEmpty(captainName) ||
                Validation.isEmpty(date)) {
            error.add(1);
            lblErro.setText("All Fields Are Required");
        } else {
            if (!Validation.isText(captainName)) {
                error.add(1);
                lblErro.setText("Invalid Name");
            }
            if (!Validation.isMobile(phone)) {
                error.add(1);
                lblErro.setText("Invalid Mobile Number");
            }
            if (!Validation.isEmail(mail)) {
                error.add(1);
                lblErro.setText("Invalid Email Address");
            }
        }
        if (error.size() == 0) {
            ShipModel shipModel = new ShipModel();
            boolean result = shipModel.regShip(shipName, country, companyName, phone, mail, captainName, date);
            if (result) {
                lblsuccessreg.setText("Ship Data Recorded");
            }
        }
    }

    //search update
    public void serchUpdate(ActionEvent e) {

        Connection conn = DB.getConn();
        PreparedStatement pst;
        String sql = "SELECT * FROM `ship` WHERE `s_name` = ? ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, comboShipName.getValue());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                //`s_id`, `s_name`, `s_country`, `s_company`, `s_phone`, `s_mail`, `s_captain`, `s_date`
                //  txt.setText(rs.getString("s_name"));
                txtCountry1.setText(rs.getString("s_country"));
                txtCompanyName1.setText(rs.getString("s_company"));
                txtPhone1.setText(rs.getString("s_phone"));
                txtMail1.setText(rs.getString("s_mail"));
                txtCoptainName1.setText(rs.getString("s_captain"));
                dateShip1.setValue(LocalDate.parse(rs.getString("s_date")));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    //update ship
    public void updates() {

        lblErro1.setText("");
        lblsuccessUp.setText("");

        ArrayList<Integer> error = new ArrayList<Integer>();

        String country = txtCountry1.getText();
        String companyName = txtCompanyName1.getText();
        String phone = txtPhone1.getText();
        String mail = txtMail1.getText();
        String captainName = txtCoptainName1.getText();
        String date = null;
        if (dateShip1.getValue() == null) {
            error.add(1);
        } else {
            date = String.valueOf(dateShip1.getValue());
        }

        if (Validation.isEmpty(country) || Validation.isEmpty(companyName) ||
                Validation.isEmpty(phone) || Validation.isEmpty(mail) || Validation.isEmpty(captainName) ||
                Validation.isEmpty(date)) {
            error.add(1);
            lblErro1.setText("All Fields Are Required");
        } else {
            if (!Validation.isText(captainName)) {
                error.add(1);
                lblErro1.setText("Invalid Name");
            }
            if (!Validation.isMobile(phone)) {
                error.add(1);
                lblErro1.setText("Invalid Mobile Number");
            }
            if (!Validation.isEmail(mail)) {
                error.add(1);
                lblErro1.setText("Invalid Email Address");
            }
        }
        if (error.size() == 0) {
            ShipModel shipModel = new ShipModel();
            boolean result = shipModel.insertUpdate(country, companyName, phone, mail, captainName, date, comboShipName.getValue());
            if (result) {
                lblsuccessUp.setText("Ship Data Recorded");
            }
        }
    }

    //all ship for table
    public void getShipData() {
//String id,sName,country,company,phone,mail,captainName,date

        try {
            TableShipModel tableShipModel = new TableShipModel();
            shipID.setCellValueFactory(new PropertyValueFactory<Ship, String>("Id"));
            shipName.setCellValueFactory(new PropertyValueFactory<Ship, String>("Name"));
            shipCountry.setCellValueFactory(new PropertyValueFactory<Ship, String>("Country"));
            shipCompany.setCellValueFactory(new PropertyValueFactory<Ship, String>("Company"));
            shipPhone.setCellValueFactory(new PropertyValueFactory<Ship, String>("Phone"));
            shipMail.setCellValueFactory(new PropertyValueFactory<Ship, String>("Mail"));
            shipCaptain.setCellValueFactory(new PropertyValueFactory<Ship, String>("CaptainName"));
            shipDate.setCellValueFactory(new PropertyValueFactory<Ship, String>("Date"));

            shipIDdel.setCellValueFactory(new PropertyValueFactory<Ship, String>("Id"));
            shipNamedel.setCellValueFactory(new PropertyValueFactory<Ship, String>("Name"));
            shipCountrydel.setCellValueFactory(new PropertyValueFactory<Ship, String>("Country"));
            shipCompanydel.setCellValueFactory(new PropertyValueFactory<Ship, String>("Company"));
            shipPhonedel.setCellValueFactory(new PropertyValueFactory<Ship, String>("Phone"));
            shipdelEmail.setCellValueFactory(new PropertyValueFactory<Ship, String>("mail"));
            shipCaptaindel.setCellValueFactory(new PropertyValueFactory<Ship, String>("CaptainName"));
            shipDatedel.setCellValueFactory(new PropertyValueFactory<Ship, String>("Date"));

            tableShipAll.setItems(tableShipModel.getShipT());
            tableDelDelete.setItems(tableShipModel.getShipT());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //delete ship
    public void deleteShip(ActionEvent e) {
        lblIdErrorUpdate1.setText("");

        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do You Want To Delete Data ?");
            alert.initStyle(StageStyle.UTILITY);
            alert.setHeaderText(null);
            alert.setGraphic(null);

            Optional<ButtonType> se = alert.showAndWait();
            if (se.get() == ButtonType.OK) {

                TableShipModel tb = new TableShipModel();
                String id = tableDelDelete.getSelectionModel().getSelectedItem().Id;
                boolean result = tb.delShip(id);
                if (result == true) {
                    lblIdErrorUpdate1.setText("Users Data Delete Success");
                    this.getShipData();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            // lblDelError.setText("Error Delete Data Select Filed");
        }

    }


    // show Register
    public void showReg(ActionEvent e) {

        shipMainPane.setVisible(true);
        paneAllShip.setVisible(false);
        paneShipManage.setVisible(false);
        paneShipRegisterUpdate.setVisible(false);
        paneShipRegister.setVisible(true);

        rec1.setVisible(true);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(false);

        this.clearReg(e);
        this.clearRegister(e);
    }

    //show All
    public void showAll(ActionEvent e) {

        shipMainPane.setVisible(true);
        paneAllShip.setVisible(true);
        paneShipManage.setVisible(false);
        paneShipRegisterUpdate.setVisible(false);
        paneShipRegister.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(false);
        rec3.setVisible(true);
        rec4.setVisible(false);

        this.getShipData();

        this.clearReg(e);
        this.clearRegister(e);
    }

    //show update
    public void showUpdate(ActionEvent e) {

        //get ship name for search
        ShipModel shipModel = new ShipModel();
        ResultSet rs = shipModel.getShip();
        ObservableList data= FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                data.add(rs.getString("s_name"));
                // comboShipName.getItems().add(rs.getString("s_name"));
            }
            comboShipName.setItems(data);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        shipMainPane.setVisible(true);
        paneAllShip.setVisible(false);
        paneShipManage.setVisible(false);
        paneShipRegisterUpdate.setVisible(true);
        paneShipRegister.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(true);
        rec3.setVisible(false);
        rec4.setVisible(false);

        this.clearReg(e);
        this.clearRegister(e);
    }


    //manage ship

    public void showManage(ActionEvent e) {

        shipMainPane.setVisible(true);
        paneAllShip.setVisible(false);
        paneShipManage.setVisible(true);
        paneShipRegisterUpdate.setVisible(false);
        paneShipRegister.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(true);

        this.getShipData();
        this.clearReg(e);
        this.clearRegister(e);
    }

    //clear ship update
    public void clearReg(ActionEvent e){
        txtCountry1.setText("");
        txtCompanyName1.setText("");
        txtPhone1.setText("");
        txtMail1.setText("");
        txtCoptainName1.setText("");
        dateShip1.setPromptText("SELECT DATE");
        dateShip1.setValue(null);
        lblErro1.setText("");
        lblsuccessUp.setText("");


    }

    //clear register
    public void clearRegister(ActionEvent e){

        txtShipName.setText("");
        txtCountry.setText("");
        txtCompanyName.setText("");
        txtPhone.setText("");
        txtMail.setText("");
        txtCoptainName.setText("");
        dateShip.setPromptText("SELECT DATE");
        dateShip.setValue(null);
        lblErro.setText("");
        lblsuccessreg.setText("");
    }


    // back main
    @FXML
    public void backMain(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainMenu-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setTitle("Main Menu");
            stage1.setScene(new Scene(root1));
            stage1.show();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();

    }


}
