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

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerMainController implements Initializable {
    @FXML
    private Button btnAllCustomer;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnBackIndividual;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClear1;

    @FXML
    private Button btnCompanyTable;

    @FXML
    private Button btnCompanyUpdateClear;

    @FXML
    private Button btnCompanyUpdateSave;

    @FXML
    private Button btnCreg;

    @FXML
    private Button btnDeleteCompany;

    @FXML
    private Button btnDeleteIndividual;

    @FXML
    private Button btnIndividualUpdateClear;

    @FXML
    private Button btnIndividualUpdateSave;

    @FXML
    private Button btnManageUser;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSave1;

    @FXML
    private Button btnSelectBackCompany;

    @FXML
    private Button btnSelectCompanyCustomer;

    @FXML
    private Button btnSelectIndividualCustomer;

    @FXML
    private Button btnSerchCompanyCustomer;

    @FXML
    private Button btnSerchIndividualCustomer;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnindividualTable;

    @FXML
    private AnchorPane customerMainPane;

    @FXML
    private AnchorPane customerRegCompanyPane;

    @FXML
    private AnchorPane customerRegIndividualPane;

    @FXML
    private DatePicker dataCompanyUpdate;

    @FXML
    private DatePicker dateCompany;

    @FXML
    private DatePicker dateIndividual;

    @FXML
    private DatePicker dateIndividualUpdate;

    @FXML
    private Label lblErro;

    @FXML
    private Label lblErro1;

    @FXML
    private Label lblIdErrordelIn;
    @FXML
    private Label lblIdErrordelCm1;

    @FXML
    private Label lblIdErrorUpdate1;

    @FXML
    private AnchorPane paneAllUsers;

    @FXML
    private AnchorPane paneCompanyCustomerUpdate;

    @FXML
    private AnchorPane paneCustomerManege;

    @FXML
    private AnchorPane paneSelectCustomer;

    @FXML
    private AnchorPane panecustomerUpdateIndividual;

    @FXML
    private Rectangle rec1;

    @FXML
    private Rectangle rec11;

    @FXML
    private Rectangle rec12;

    @FXML
    private Rectangle rec2;

    @FXML
    private Rectangle rec21;

    @FXML
    private Rectangle rec22;

    @FXML
    private Rectangle rec3;

    @FXML
    private Rectangle rec4;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableAddress;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableAddress1;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyAddress;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyAddress1;

    @FXML
    private TableView<TableCustomerCompany> tableCompanyCustomer;

    @FXML
    private TableView<TableCustomerCompany> tableCompanyCustomerManage;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyDate;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyDate1;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyEmail;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyEmail1;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyID;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyID1;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyName;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyName1;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyOrdererDesignation;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyOrdererDesignation1;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyOrdererID;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyOrdererID1;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyPhone;

    @FXML
    private TableColumn<TableCustomerCompany, String> tableCompanyPhone1;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableDate;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableDate1;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableEmail;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableEmail1;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableID;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableID1;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableIDNo;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableIDNo1;

    @FXML
    private TableView<TableCustomerIndividual> tableIndividualCustomer;

    @FXML
    private TableView<TableCustomerIndividual> tableIndividualCustomerManege;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableName;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tableName1;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tablePhone;

    @FXML
    private TableColumn<TableCustomerIndividual, String> tablePhone1;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAddress1;

    @FXML
    private TextField txtCompanyAddressUpdate;

    @FXML
    private TextField txtCompanyDesignationUpdate;

    @FXML
    private TextField txtCompanyMailUpdate;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtCompanyNameUpdate;

    @FXML
    private TextField txtCompanyOrdererUpdate;

    @FXML
    private TextField txtCompanyPhoneUpdate;

    @FXML
    private TextField txtDesignation;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtIDNumber;

    @FXML
    private TextField txtIDno;

    @FXML
    private TextField txtIndividualAddressUpdate;

    @FXML
    private TextField txtIndividualFullNameUpdate;

    @FXML
    private TextField txtIndividualIDnoUpdate;

    @FXML
    private TextField txtIndividualMailUpdate;

    @FXML
    private TextField txtIndividualPhoneUpdate;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtMail1;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPhone1;

    @FXML
    private Button btnSelectIndi;
    @FXML
    private Button btnSelectCm;
    @FXML
    private Label lblSuccsess;
    @FXML
    private Label lblSucessIndi;
    @FXML
    private ComboBox<String> comboCompanyNameup;

    @FXML
    private ComboBox<String> comboIdNumberup;
    @FXML
    private Label lblErrorUpdate;
    @FXML
    private Label lblSuccessUUpdate;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


        customerMainPane.setVisible(true);
        paneSelectCustomer.setVisible(true);
        paneAllUsers.setVisible(false);
        paneCustomerManege.setVisible(false);
        paneCompanyCustomerUpdate.setVisible(false);
        panecustomerUpdateIndividual.setVisible(false);
        customerRegCompanyPane.setVisible(false);
        customerRegIndividualPane.setVisible(false);
        btnIndividualUpdateSave.setVisible(false);

        rec1.setVisible(true);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(false);

        rec12.setVisible(true);
        rec22.setVisible(false);
        rec21.setVisible(true);


    }

    //insert individual
    public void Insert(ActionEvent e) {

        lblSucessIndi.setText("");
        lblErro1.setText("");

        ArrayList<Integer> error = new ArrayList<Integer>();

        String name = txtFullName.getText();
        String address = txtAddress1.getText();
        String iDNumber = txtIDno.getText();
        String phone = txtPhone1.getText();
        String mail = txtMail1.getText().toLowerCase();
        String date = null;
        if (dateIndividual.getValue() == null) {
            error.add(1);
        } else {
            date = String.valueOf(dateIndividual.getValue());
        }


        if (Validation.isEmpty(name) || Validation.isEmpty(address) || Validation.isEmpty(iDNumber) || Validation.isEmpty(phone)
                || (Validation.isEmpty(date))) {

            error.add(1);
            lblErro1.setText("All Filed Required Except Mail");
        } else {
            if (!Validation.isText(name)) {
                error.add(1);
                lblErro1.setText("Invalid name");
            }
            if (!Validation.isMobile(phone)) {
                error.add(1);
                lblErro1.setText("Invalid Phone Number");
            }
            if (!Validation.isEmail(mail)) {
                error.add(1);
                lblErro1.setText("Invalid Mail");
            }
            if ((!Validation.isIdNumber(iDNumber)) && (!Validation.isIdNumberNew(iDNumber))) {
                error.add(1);
                lblErro1.setText("Invalid ID Number");
            }
        }
        if (error.size() == 0) {
            CustomerModel customerModel = new CustomerModel();

            boolean result = customerModel.regIndividualCustomer(name, address, iDNumber, phone, mail, date);
            if (result) {
                lblSucessIndi.setText("Customer Register Success");
                System.out.println("add");
            }
        }
    }


    //select update for individual customer
    public void serchUpdateIndividual(ActionEvent e) {

        Connection conn = DB.getConn();
        PreparedStatement pst;
        String sql = "SELECT * FROM `customer_individual` WHERE `c_idnumberin`= ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, comboIdNumberup.getValue());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtIndividualFullNameUpdate.setText(rs.getString("c_namein"));
                txtIndividualAddressUpdate.setText(rs.getString("c_addressin"));
                txtIndividualPhoneUpdate.setText(rs.getString("c_phonein"));
                txtIndividualMailUpdate.setText(rs.getString("c_mailin"));
                dateIndividualUpdate.setValue(LocalDate.parse(rs.getString("c_datein")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //update individual
    public void updateIndividual(ActionEvent e) {

        lblErrorUpdate.setText("");
        lblSuccessUUpdate.setText("");

        ArrayList<Integer> error = new ArrayList<Integer>();
        String name = txtIndividualFullNameUpdate.getText();
        String address = txtIndividualAddressUpdate.getText();
        String phone = txtIndividualPhoneUpdate.getText();
        String mail = txtIndividualMailUpdate.getText();
        String date = null;
        if (dateIndividualUpdate.getValue() == null) {
            error.add(1);
        } else {
            date = String.valueOf(dateIndividualUpdate.getValue());
        }

        if (Validation.isEmpty(name) || Validation.isEmpty(address) || Validation.isEmpty(phone)
                || (Validation.isEmpty(date))) {
            error.add(1);
            lblErrorUpdate.setText("All Filed Required Except Mail");
        } else {
            if (!Validation.isText(name)) {
                error.add(1);
                lblErrorUpdate.setText("Invalid name");
            }
            if (!Validation.isMobile(phone)) {
                error.add(1);
                lblErrorUpdate.setText("Invalid Phone Number");
            }
            if (!Validation.isEmail(mail)) {
                error.add(1);
                lblErrorUpdate.setText("Invalid Mail");
            }

        }
        if (error.size() == 0) {
            CustomerModel customerModel = new CustomerModel();
            boolean result = customerModel.insertIndividualUpdate(name, address, phone, mail, date, comboIdNumberup.getValue());
            lblSuccessUUpdate.setText("Customer Update Success");
        }
    }


    //clear register individual
    public void clearRegIndividual(ActionEvent e) {

        lblSucessIndi.setText("");
        lblErro1.setText("");

        txtFullName.setText("");
        txtAddress1.setText("");
        txtIDno.setText("");
        txtPhone1.setText("");
        txtMail1.setText("");
        dateIndividual.setPromptText("SELECT DATE");
        dateIndividual.setValue(null);
    }

    //insert company

    public void insertCm(ActionEvent e) {

        lblSuccsess.setText("");
        lblErro.setText("");

        ArrayList<Integer> error = new ArrayList<Integer>();

        String name = txtCompanyName.getText();
        String address = txtAddress.getText();
        String iDNumber = txtIDNumber.getText();
        String phone = txtPhone.getText();
        String mail = txtMail.getText().toLowerCase();
        String designation = txtDesignation.getText();
        String date = null;
        if (dateCompany.getValue() == null) {
            error.add(1);
        } else {
            date = String.valueOf(dateCompany.getValue());
        }
        if (Validation.isEmpty(name) || Validation.isEmpty(address) || Validation.isEmpty(iDNumber) || Validation.isEmpty(phone)
                || (Validation.isEmpty(date)) || Validation.isEmpty(mail) || Validation.isEmpty(designation)) {

            error.add(1);
            lblErro.setText("All Filed Required");
        } else {

            if (!Validation.isMobile(phone)) {
                error.add(1);
                lblErro.setText("Invalid Phone Number");
            }
            if (!Validation.isEmail(mail)) {
                error.add(1);
                lblErro.setText("Invalid Mail");
            }
            if ((!Validation.isIdNumber(iDNumber)) && (!Validation.isIdNumberNew(iDNumber))) {
                error.add(1);
                lblErro.setText("Invalid ID Number");
            }
        }
        if (error.size() == 0) {
            CustomerModel customerModel = new CustomerModel();
            boolean result = customerModel.regCompanyCustomer(name, address, phone, mail, designation, iDNumber, date);
            if (result) {
                lblSuccsess.setText("Customer Register Success");
                System.out.println("add");
            }
        }
    }

    //select data for update company

    public void selectUpdateCompany(ActionEvent e) {
        Connection conn = DB.getConn();
        PreparedStatement pst;
        String sql = "SELECT * FROM `customer_company` WHERE `c_namecm` = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, comboCompanyNameup.getValue());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                txtCompanyAddressUpdate.setText(rs.getString("c_addresscm"));
                txtCompanyPhoneUpdate.setText(rs.getString("c_phonecm"));
                txtCompanyMailUpdate.setText(rs.getString("c_mailcm"));
                txtCompanyDesignationUpdate.setText(rs.getString("c_desigcm"));
                txtCompanyOrdererUpdate.setText(rs.getString("c_idnumbercm"));
                dataCompanyUpdate.setValue(LocalDate.parse(rs.getString("c_datecm")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    //update company
    public void updateCompany(ActionEvent e) {

        lblErrorUpdate.setText("");
        lblSuccessUUpdate.setText("");

        ArrayList<Integer> error = new ArrayList<Integer>();

        String address = txtCompanyAddressUpdate.getText();
        String phone = txtCompanyPhoneUpdate.getText();
        String mail = txtCompanyMailUpdate.getText();
        String designation = txtCompanyDesignationUpdate.getText();
        String idNumber = txtCompanyOrdererUpdate.getText();
        String date = null;
        if (dataCompanyUpdate.getValue() == null) {
            error.add(1);
        } else {
            date = String.valueOf(dataCompanyUpdate.getValue());
        }

        if (Validation.isEmpty(address) || Validation.isEmpty(phone) || Validation.isEmpty(mail) || Validation.isEmpty(designation)
                || (Validation.isEmpty(idNumber)) || Validation.isEmpty(date)) {

            error.add(1);
            lblErrorUpdate.setText("All Filed Required");
        } else {

            if (!Validation.isMobile(phone)) {
                error.add(1);
                lblErrorUpdate.setText("Invalid Phone Number");
            }
            if (!Validation.isEmail(mail)) {
                error.add(1);
                lblErrorUpdate.setText("Invalid Mail");
            }
            if ((!Validation.isIdNumber(idNumber)) && (!Validation.isIdNumberNew(idNumber))) {
                error.add(1);
                lblErrorUpdate.setText("Invalid ID Number");
            }
        }
        if (error.size() == 0) {
            CustomerModel customerModel = new CustomerModel();
            boolean result = customerModel.insertCompanyUpdate(address, phone, mail, designation, idNumber, date, comboCompanyNameup.getValue());
            if ((result)) {
                lblSuccessUUpdate.setText("Customer Update Success");
            } else {
                System.out.println("error");
            }
        }
    }

    //Table all customer Individual
    public void selectIndividual() {
// String id, name, address, idNumber, phone, mail, date;
        TableCustomerModel tc = new TableCustomerModel();
        tableID.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("name"));
        tableAddress.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("address"));
        tableIDNo.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("idNumber"));
        tablePhone.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("phone"));
        tableEmail.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("mail"));
        tableDate.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("date"));

        tableID1.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("id"));
        tableName1.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("name"));
        tableAddress1.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("address"));
        tableIDNo1.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("idNumber"));
        tablePhone1.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("phone"));
        tableEmail1.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("mail"));
        tableDate1.setCellValueFactory(new PropertyValueFactory<TableCustomerIndividual, String>("date"));


        tableIndividualCustomer.setItems(tc.getDataIndividual());
        tableIndividualCustomerManege.setItems(tc.getDataIndividual());
    }

    //Table all Customer Company
    public void selectCompany() {
        //  String id,name,address,phone,mail,designation,idNumber,date;
        TableCustomerModel tableCustomerModel = new TableCustomerModel();

        tableCompanyID.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("id"));
        tableCompanyName.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("name"));
        tableCompanyAddress.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("address"));
        tableCompanyPhone.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("phone"));
        tableCompanyEmail.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("mail"));
        tableCompanyOrdererDesignation.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("designation"));
        tableCompanyOrdererID.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("idNumber"));
        tableCompanyDate.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("date"));

        tableCompanyID1.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("id"));
        tableCompanyName1.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("name"));
        tableCompanyAddress1.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("address"));
        tableCompanyPhone1.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("phone"));
        tableCompanyEmail1.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("mail"));
        tableCompanyOrdererDesignation1.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("designation"));
        tableCompanyOrdererID1.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("idNumber"));
        tableCompanyDate1.setCellValueFactory(new PropertyValueFactory<TableCustomerCompany, String>("date"));

        tableCompanyCustomer.setItems(tableCustomerModel.getDataCompany());
        tableCompanyCustomerManage.setItems(tableCustomerModel.getDataCompany());

    }

    //delete individual customer
    public void deleteIn(ActionEvent e) {
        lblIdErrordelIn.setText("");
        lb1.setText("");
        lb2.setText("");
        lblIdErrordelCm1.setText("");
        try {
            if (tableIndividualCustomerManege.getSelectionModel().getSelectedItem() == null) {
                lb1.setText("Select Row First");
            }
            TableCustomerModel tableCustomerModel = new TableCustomerModel();
            String id = tableIndividualCustomerManege.getSelectionModel().getSelectedItem().id;

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do You Want To Delete Data ?");
            alert.initStyle(StageStyle.UTILITY);
            alert.setHeaderText(null);
            alert.setGraphic(null);

            Optional<ButtonType> se = alert.showAndWait();
            if (se.get() == ButtonType.OK) {


                boolean result = tableCustomerModel.delIndividual(id);
                if (result == true) {
                    lblIdErrordelIn.setText("Customer Delete Success");
                    this.selectIndividual();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    //delete company customer
    public void deleteCm(ActionEvent e) {
        lblIdErrordelCm1.setText("");
        lb2.setText("");
        lb1.setText("");
        lblIdErrordelIn.setText("");

        try {
            if (tableCompanyCustomerManage.getSelectionModel().getSelectedItem() == null) {
                lb2.setText("Select Row First");
            }

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do You Want To Delete Data ?");
            alert.initStyle(StageStyle.UTILITY);
            alert.setHeaderText(null);
            alert.setGraphic(null);

            Optional<ButtonType> se = alert.showAndWait();
            if (se.get() == ButtonType.OK) {

                TableCustomerModel tableCustomerModel = new TableCustomerModel();
                String id = tableCompanyCustomerManage.getSelectionModel().getSelectedItem().id;
                boolean result = tableCustomerModel.delCompany(id);
                if (result == true) {
                    lblIdErrordelCm1.setText("Customer Delete Success");
                    this.selectCompany();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    //clear register company
    public void clearRegCompany(ActionEvent e) {

        lblSuccsess.setText("");
        lblErro.setText("");

        txtCompanyName.setText("");
        txtAddress.setText("");
        txtIDNumber.setText("");
        txtPhone.setText("");
        txtMail.setText("");
        txtDesignation.setText("");
        dateCompany.setPromptText("SELECT DATE");
        dateCompany.setValue(null);

    }


    //show choice
    public void showReg(ActionEvent e) {

        customerMainPane.setVisible(true);
        paneSelectCustomer.setVisible(true);
        paneAllUsers.setVisible(false);
        paneCustomerManege.setVisible(false);
        paneCompanyCustomerUpdate.setVisible(false);
        panecustomerUpdateIndividual.setVisible(false);
        customerRegCompanyPane.setVisible(false);
        customerRegIndividualPane.setVisible(false);
        btnIndividualUpdateSave.setVisible(false);

        rec1.setVisible(true);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(false);

        this.clearRegIndividual(e);
        this.clearRegCompany(e);

        this.clearUpCompany(e);
        this.clearUpIndividual(e);
    }

    //show update
    public void showUpdate(ActionEvent e) {


        //combo load id number for update
        CustomerModel userModel = new CustomerModel();
        ResultSet rs = userModel.getIdNumber();
        ObservableList data = FXCollections.observableArrayList();
        try {
            while (rs.next()) {
                data.add(rs.getString("c_idnumberin"));
                // comboIdNumberup.getItems().add(rs.getString("c_idnumberin"));
            }
            comboIdNumberup.setItems(data);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        //combo load company name

        ResultSet rs1 = userModel.getCompanyName();
        ObservableList data1 = FXCollections.observableArrayList();
        try {
            while (rs1.next()) {
                data1.add(rs1.getString("c_namecm"));

            }
            comboCompanyNameup.setItems(data1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        customerMainPane.setVisible(true);
        paneSelectCustomer.setVisible(false);
        paneAllUsers.setVisible(false);
        paneCustomerManege.setVisible(false);
        paneCompanyCustomerUpdate.setVisible(false);//for inside form button
        panecustomerUpdateIndividual.setVisible(true);
        customerRegCompanyPane.setVisible(false);
        customerRegIndividualPane.setVisible(false);

        lblErrorUpdate.setText("");
        lblSuccessUUpdate.setText("");
        btnIndividualUpdateSave.setVisible(true);
        lblSuccessUUpdate.setVisible(true);


        rec1.setVisible(false);
        rec2.setVisible(true);
        rec3.setVisible(false);
        rec4.setVisible(false);

        rec11.setVisible(true);
        rec21.setVisible(false);

        this.clearRegIndividual(e);
        this.clearRegCompany(e);

        this.clearUpCompany(e);
        this.clearUpIndividual(e);

    }

    //clear update individual
    public void clearUpIndividual(ActionEvent e) {

        lblErrorUpdate.setText("");
        lblSuccessUUpdate.setText("");

        txtIndividualFullNameUpdate.setText("");
        txtIndividualAddressUpdate.setText("");
        txtIndividualPhoneUpdate.setText("");
        txtIndividualMailUpdate.setText("");
        dateIndividualUpdate.setPromptText("SELECT DATE");
        dateIndividualUpdate.setValue(null);


    }

    //clear update Company
    public void clearUpCompany(ActionEvent e) {
        lblErrorUpdate.setText("");
        lblSuccessUUpdate.setText("");

        txtCompanyAddressUpdate.setText("");
        txtCompanyPhoneUpdate.setText("");
        txtCompanyMailUpdate.setText("");
        txtCompanyDesignationUpdate.setText("");
        txtCompanyOrdererUpdate.setText("");
        dataCompanyUpdate.setPromptText("SELECT DATE");


    }

    //show individual update
    public void showUpdateIndividual(ActionEvent e) {

        panecustomerUpdateIndividual.setVisible(true);
        paneCompanyCustomerUpdate.setVisible(false);
        rec11.setVisible(true);
        rec21.setVisible(false);
        lblErrorUpdate.setText("");
        lblSuccessUUpdate.setText("");

        this.clearUpCompany(e);
        this.clearUpIndividual(e);

    }

    //show company update
    public void ShowUpdateCompany(ActionEvent e) {
        panecustomerUpdateIndividual.setVisible(true);
        paneCompanyCustomerUpdate.setVisible(true);
        rec11.setVisible(false);
        rec21.setVisible(true);
        lblErrorUpdate.setText("");
        lblSuccessUUpdate.setText("");

        this.clearUpCompany(e);
        this.clearUpIndividual(e);
    }

    //show all
    public void showAll(ActionEvent e) {

        customerMainPane.setVisible(true);
        paneSelectCustomer.setVisible(false);
        paneAllUsers.setVisible(true);
        paneCustomerManege.setVisible(false);
        paneCompanyCustomerUpdate.setVisible(false);
        panecustomerUpdateIndividual.setVisible(false);
        customerRegCompanyPane.setVisible(false);
        customerRegIndividualPane.setVisible(false);
        btnIndividualUpdateSave.setVisible(false);
        tableIndividualCustomer.setVisible(true);
        tableCompanyCustomer.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(false);
        rec3.setVisible(true);
        rec4.setVisible(false);
        rec12.setVisible(true);
        rec22.setVisible(false);

        this.selectIndividual();
        this.selectCompany();

        this.clearRegIndividual(e);
        this.clearRegCompany(e);

        this.clearUpCompany(e);
        this.clearUpIndividual(e);

    }

    //show individual register
    public void showIndividual(ActionEvent e) {
        customerRegIndividualPane.setVisible(true);
        paneSelectCustomer.setVisible(false);
    }

    //show company register
    public void showCompany(ActionEvent e) {
        paneSelectCustomer.setVisible(false);
        customerRegCompanyPane.setVisible(true);
    }

    //show choice
    public void backChoice(ActionEvent e) {
        paneSelectCustomer.setVisible(true);
        customerRegIndividualPane.setVisible(false);
        customerRegCompanyPane.setVisible(false);

        this.clearRegCompany(e);
        this.clearRegIndividual(e);

    }

    //show all individual
    public void showAllTableIndividual(ActionEvent e) {

        paneAllUsers.setVisible(true);
        rec12.setVisible(true);
        rec22.setVisible(false);
        tableIndividualCustomer.setVisible(true);
        tableCompanyCustomer.setVisible(false);
    }

    //show all company
    public void showAllTableCompany(ActionEvent e) {

        paneAllUsers.setVisible(true);
        rec12.setVisible(false);
        rec22.setVisible(true);
        tableIndividualCustomer.setVisible(false);
        tableCompanyCustomer.setVisible(true);
    }

    //show manage
    public void showManege(ActionEvent e) {

        customerMainPane.setVisible(true);
        paneSelectCustomer.setVisible(false);
        paneAllUsers.setVisible(false);
        paneCustomerManege.setVisible(true);
        paneCompanyCustomerUpdate.setVisible(false);
        panecustomerUpdateIndividual.setVisible(false);
        customerRegCompanyPane.setVisible(false);
        customerRegIndividualPane.setVisible(false);
        btnIndividualUpdateSave.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(true);

        this.clearRegIndividual(e);
        this.clearRegCompany(e);

        this.clearUpCompany(e);
        this.clearUpIndividual(e);
        this.selectCompany();
        this.selectIndividual();
    }


    //back main
    @FXML
    public void backMain(ActionEvent e) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainMenu-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();

    }


}
