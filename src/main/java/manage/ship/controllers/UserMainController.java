package manage.ship.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import manage.ship.Application;
import manage.ship.model.DB;
import manage.ship.model.TableUserModel;
import manage.ship.model.UserModel;
import manage.ship.model.Validation;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class UserMainController implements Initializable {
    @FXML
    private Button btnAllUser;

    @FXML
    private Button btnBack;
    @FXML
    private Button btnload;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnCusUpdateClear;

    @FXML
    private Button btnCusUpdateSave;

    @FXML
    private Button btnCusUpdateSearch;

    @FXML
    private Button btnDeactivate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnUreg;

    @FXML
    private Button btnUserSearch;

    @FXML
    private ComboBox<String> comboRole;

    @FXML
    private ComboBox<String> comboIDUpdate;

    @FXML
    private ComboBox<String> comboStatus;

    @FXML
    private Label lblIdErrorUpdate1;

    @FXML
    private AnchorPane mainUserPane;

    @FXML
    private AnchorPane paneAllUsers;

    @FXML
    private AnchorPane paneManageUser;

    @FXML
    private AnchorPane paneupdateCustomer;

    @FXML
    private Rectangle rec1;

    @FXML
    private Rectangle rec2;

    @FXML
    private Rectangle rec3;

    @FXML
    private Rectangle rec4;

    @FXML
    private AnchorPane regPane;

    @FXML
    private TableView<TableUser> tableALLUSER;

    @FXML
    private TableView<TableUser> tableUser;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtAddressUpdate;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtFullNameUpdate;

    @FXML
    private TextField txtIDno;

    @FXML
    private TextField txtIDnoUpdate;

    @FXML
    private TextField txtIDnoUpdate1;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtMailUpdate;

    @FXML
    private TextField txtPass;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPhoneUpdate;

    @FXML
    private TextField txtuName;

    @FXML
    private TextField txtuNameUpdate;

    @FXML
    private TableColumn<TableUser, String> uAddress;

    @FXML
    private TableColumn<TableUser, String> uAddress1;

    @FXML
    private TableColumn<TableUser, String> uID;

    @FXML
    private TableColumn<TableUser, String> uID1;

    @FXML
    private TableColumn<TableUser, String> uIDNumber;

    @FXML
    private TableColumn<TableUser, String> uIDNumber1;

    @FXML
    private TableColumn<TableUser, String> uMail;

    @FXML
    private TableColumn<TableUser, String> uMail1;

    @FXML
    private TableColumn<TableUser, String> uName;

    @FXML
    private TableColumn<TableUser, String> uName1;

    @FXML
    private TableColumn<TableUser, String> userName;

    @FXML
    private TableColumn<TableUser, String> userName1;

    @FXML
    private TableColumn<TableUser, String> userRole;

    @FXML
    private TableColumn<TableUser, String> userRole1;

    @FXML
    private Label lblerrorRegUser;
    @FXML
    private Label lblinsert;
    @FXML
    private Label lblUpdatesuccess;
    @FXML
    private Label lblerrUpdate;
    @FXML
    private Label lblDelSuccess;
    @FXML
    private Label lblDelError;
    @FXML
    private ComboBox<String> comboIdManege;
    @FXML
    private ComboBox<String> comboRoleManege;
    @FXML
    private Label lbldis;

    @FXML
    private Button btnLogOutAdmin;

    ObservableList<String> state = FXCollections.observableArrayList("ACTIVATE", "DISABLE");

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //call all user table
        // this.select();


        ObservableList<String> role = FXCollections.observableArrayList("ADMIN", "USER");
        comboRole.setItems(role);

       // ObservableList<String> state = FXCollections.observableArrayList("ACTIVATE", "DISABLE");
        comboStatus.setItems(state);

        mainUserPane.setVisible(true);
        regPane.setVisible(true);
        paneupdateCustomer.setVisible(false);
        paneAllUsers.setVisible(false);
        paneManageUser.setVisible(false);

        rec1.setVisible(true);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(false);

        /*//combo load for update
        UserModel userModel = new UserModel();
        ResultSet rst = userModel.getIdNum();
        try {
            while (rst.next()) {
                comboIDUpdate.getItems().add(rst.getString("u_idnumber"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
    }


    public void insert(ActionEvent e) {
        lblerrorRegUser.setText("");
        lblinsert.setText("");

        String u_name = txtFullName.getText();
        String u_address = txtAddress.getText();
        String u_idnumber = txtIDno.getText();
        String u_phone = txtPhone.getText();
        String u_mail = txtMail.getText().toLowerCase();
        String username = txtuName.getText();
        String password = txtPass.getText();
        String u_status = comboStatus.getValue();
        String u_role = comboRole.getValue();

        ArrayList<Integer> error = new ArrayList<Integer>();
        if (Validation.isEmpty(u_name) || Validation.isEmpty(u_address) || Validation.isEmpty(u_idnumber) ||
                Validation.isEmpty(u_phone) || Validation.isEmpty(u_mail) || Validation.isEmpty(username) ||
                Validation.isEmpty(password) || Validation.isEmpty(u_status) || Validation.isEmpty(u_role)) {
            error.add(1);
            lblerrorRegUser.setText("All Fields Are Required");
        } else {
            if (!Validation.isText(u_name)) {
                error.add(1);
                lblerrorRegUser.setText("Invalid Name");
            }
            if (!Validation.isMobile(u_phone)) {
                error.add(1);
                lblerrorRegUser.setText("Invalid Mobile Number");
            }
            if (!Validation.isEmail(u_mail)) {
                error.add(1);
                lblerrorRegUser.setText("Invalid Email Address");
            }
            if (!Validation.minLen(password, 5)) {
                error.add(1);
                lblerrorRegUser.setText("Password must 5 Five Character");
            }
            if ((!Validation.isIdNumber(u_idnumber)) && (!Validation.isIdNumberNew(u_idnumber))) {
                error.add(1);
                lblerrorRegUser.setText("Invalid ID Number");
            }


        }
        if (error.size() == 0) {
            UserModel userModel = new UserModel();
            if (!userModel.emailCheck(u_mail)) {
                lblerrorRegUser.setText("Email Already Registered");
            }else if(!userModel.idCheck(u_idnumber)){
                lblerrorRegUser.setText("ID Number Already Register");
            }
            else {
                String hashpass = BCrypt.withDefaults().hashToString(12, password.toCharArray());
                boolean result = userModel.regUser(u_name, u_address, u_idnumber, u_phone, u_mail, username, hashpass, u_status, u_role);
                if (result) {
                    lblinsert.setText("User Register Success");
                }
            }
        }
    }

    //search update
    public void updateSerch(ActionEvent e) {
        Connection conn = DB.getConn();
        PreparedStatement pst;
        String sql = "SELECT * FROM `user` WHERE `u_idnumber` = ? ";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, comboIDUpdate.getValue());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtFullNameUpdate.setText(rs.getString("u_name"));
                txtAddressUpdate.setText(rs.getString("u_address"));
                //txtIDnoUpdate.setText(rs.getString("u_idnumber"));
                txtPhoneUpdate.setText(rs.getString("u_phone"));
                txtMailUpdate.setText(rs.getString("u_mail"));
                txtuNameUpdate.setText(rs.getString("username"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    //search manege role
    public void searchRole(ActionEvent e){

        Connection conn = DB.getConn();
        PreparedStatement pst;
        String sql = "SELECT * FROM `user` WHERE `u_idnumber` = ? ";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, comboIdManege.getValue());
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {

                comboRoleManege.setValue(rs.getString("u_status"));
            }
           // comboRoleManege.getItems().add("DISABLE");
           // comboRoleManege.getItems().add("ACTIVATE");

            comboRoleManege.setItems(state);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //update status
    public void updateRole(ActionEvent e){

        lbldis.setText("");

        UserModel userModel=new UserModel();
        boolean result=userModel.insertRole(comboRoleManege.getSelectionModel().getSelectedItem(),comboIdManege.getSelectionModel().getSelectedItem());
        if(result){
            lbldis.setText("Status Update Success");
        }
        this.select();
    }

    // update
    public void update(ActionEvent e) {

        lblUpdatesuccess.setText("");
        lblerrUpdate.setText("");
        lbldis.setText("");

        String u_name = txtFullNameUpdate.getText();
        String u_address = txtAddressUpdate.getText();
        String u_phone = txtPhoneUpdate.getText();
        String u_mail = txtMailUpdate.getText().toLowerCase();
        String username = txtuNameUpdate.getText().toUpperCase();

        ArrayList<Integer> error = new ArrayList<Integer>();
        if (Validation.isEmpty(u_name) || Validation.isEmpty(u_address) ||
                Validation.isEmpty(u_phone) || Validation.isEmpty(u_mail) || Validation.isEmpty(username)) {
            error.add(1);
            lblerrUpdate.setText("All Fields Are Required");
        } else {
            if (!Validation.isText(u_name)) {
                error.add(1);
                lblerrUpdate.setText("Invalid Name");
            }
            if (!Validation.isMobile(u_phone)) {
                error.add(1);
                lblerrUpdate.setText("Invalid Mobile Number");
            }
            if (!Validation.isEmail(u_mail)) {
                error.add(1);
                lblerrUpdate.setText("Invalid Email Address");
            }
        }
        if (error.size() == 0) {

            UserModel userModel = new UserModel();
            boolean result = userModel.insertUpdate(u_name, u_address, u_phone, u_mail, username, comboIDUpdate.getValue());
            if (result) {
                lblUpdatesuccess.setText("User Update Success");
            }
        }


    }



    //select All User for Table
    public void select() {


        try {
            TableUserModel tm = new TableUserModel();
            //   ObservableList<TableUser> list = tm.getData();
            uID.setCellValueFactory(new PropertyValueFactory<TableUser, String>("id"));
            uName.setCellValueFactory(new PropertyValueFactory<TableUser, String>("name"));
            uAddress.setCellValueFactory(new PropertyValueFactory<TableUser, String>("address"));
            uIDNumber.setCellValueFactory(new PropertyValueFactory<TableUser, String>("idnumber"));
            uMail.setCellValueFactory(new PropertyValueFactory<TableUser, String>("mail"));
            userName.setCellValueFactory(new PropertyValueFactory<TableUser, String>("user"));
            userRole.setCellValueFactory(new PropertyValueFactory<TableUser, String>("role"));

            uID1.setCellValueFactory(new PropertyValueFactory<TableUser, String>("id"));
            uName1.setCellValueFactory(new PropertyValueFactory<TableUser, String>("name"));
            uAddress1.setCellValueFactory(new PropertyValueFactory<TableUser, String>("address"));
            uIDNumber1.setCellValueFactory(new PropertyValueFactory<TableUser, String>("idnumber"));
            uMail1.setCellValueFactory(new PropertyValueFactory<TableUser, String>("mail"));
            userName1.setCellValueFactory(new PropertyValueFactory<TableUser, String>("user"));
            userRole1.setCellValueFactory(new PropertyValueFactory<TableUser, String>("role"));

            tableALLUSER.setItems(tm.getData());
            tableUser.setItems(tm.getData());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        lblUpdatesuccess.setText("");
        lblerrUpdate.setText("");


    }

    //delete
    public void delete(ActionEvent e) {
        lblDelError.setText("");
        lblDelSuccess.setText("");

        try {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Do You Want To Delete Data ?");
            alert.initStyle(StageStyle.UTILITY);
            alert.setHeaderText(null);
            alert.setGraphic(null);

            Optional<ButtonType> se = alert.showAndWait();
            if (se.get() == ButtonType.OK) {

                TableUserModel tb = new TableUserModel();
                String id = tableUser.getSelectionModel().getSelectedItem().id;
                boolean result = tb.delUser(id);
                if (result == true) {
                    lblDelSuccess.setText("Users Data Delete Success");
                    this.select();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            lblDelError.setText("Error Delete Data. Select Filed");
        }

        //load combo id for manage
        UserModel userModel = new UserModel();
        ResultSet rst = userModel.getIdNum();
        ObservableList data=FXCollections.observableArrayList();
        try {
            while (rst.next()) {
                data.add(rst.getString("u_idnumber"));
                //comboIDUpdate.getItems().add(rst.getString("u_idnumber"));
            }
            comboIdManege.setItems(data);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


    //clear register
    public void clearData() {
        lblerrorRegUser.setText("");
        lblinsert.setText("");
        txtFullName.setText("");
        txtAddress.setText("");
        txtIDno.setText("");
        txtPhone.setText("");
        txtMail.setText("");
        txtuName.setText("");
        txtPass.setText("");
        comboStatus.getSelectionModel().clearSelection();
        comboRole.getSelectionModel().clearSelection();
    }

    public void clearUpdate() {
        txtFullNameUpdate.setText("");
        txtuNameUpdate.setText("");
        txtMailUpdate.setText("");
        txtPhoneUpdate.setText("");
        comboIDUpdate.getSelectionModel().clearSelection();
        txtAddressUpdate.setText("");
        lblUpdatesuccess.setText("");
        lblerrUpdate.setText("");
    }

    public void showUpdate() {

        //combo load for update
        UserModel userModel = new UserModel();
        ResultSet rst = userModel.getIdNum();
        ObservableList data=FXCollections.observableArrayList();
        try {
            while (rst.next()) {
                data.add(rst.getString("u_idnumber"));
                //comboIDUpdate.getItems().add(rst.getString("u_idnumber"));
            }
            comboIDUpdate.setItems(data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        mainUserPane.setVisible(true);
        regPane.setVisible(false);
        paneupdateCustomer.setVisible(true);
        paneAllUsers.setVisible(false);
        paneManageUser.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(true);
        rec3.setVisible(false);
        rec4.setVisible(false);


        //register data clear
        lblerrorRegUser.setText("");
        lblinsert.setText("");
        txtFullName.setText("");
        txtAddress.setText("");
        txtIDno.setText("");
        txtPhone.setText("");
        txtMail.setText("");
        txtuName.setText("");
        txtPass.setText("");
        comboStatus.getSelectionModel().clearSelection();
        comboRole.getSelectionModel().clearSelection();

        this.select();

        lblUpdatesuccess.setText("");
        lblerrUpdate.setText("");
        lbldis.setText("");
    }


    public void showAll() {
        mainUserPane.setVisible(true);
        regPane.setVisible(false);
        paneupdateCustomer.setVisible(false);
        paneAllUsers.setVisible(true);
        paneManageUser.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(false);
        rec3.setVisible(true);
        rec4.setVisible(false);

        //register data clear
        lblerrorRegUser.setText("");
        lblinsert.setText("");
        txtFullName.setText("");
        txtAddress.setText("");
        txtIDno.setText("");
        txtPhone.setText("");
        txtMail.setText("");
        txtuName.setText("");
        txtPass.setText("");
        comboStatus.getSelectionModel().clearSelection();
        comboRole.getSelectionModel().clearSelection();

        lblUpdatesuccess.setText("");
        lblerrUpdate.setText("");
        lbldis.setText("");

        this.select();
    }

    public void showManage() {

        //combo load for update
        UserModel userModel = new UserModel();
        ResultSet rst = userModel.getIdNum();
        ObservableList data=FXCollections.observableArrayList();
        try {
            while (rst.next()) {
                data.add(rst.getString("u_idnumber"));
                //comboIDUpdate.getItems().add(rst.getString("u_idnumber"));
            }
            comboIdManege.setItems(data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        mainUserPane.setVisible(true);
        regPane.setVisible(false);
        paneupdateCustomer.setVisible(false);
        paneAllUsers.setVisible(false);
        paneManageUser.setVisible(true);

        rec1.setVisible(false);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(true);

        //register data clear
        lblerrorRegUser.setText("");
        lblinsert.setText("");
        txtFullName.setText("");
        txtAddress.setText("");
        txtIDno.setText("");
        txtPhone.setText("");
        txtMail.setText("");
        txtuName.setText("");
        txtPass.setText("");
        comboStatus.getSelectionModel().clearSelection();
        comboRole.getSelectionModel().clearSelection();

        this.select();
        lblUpdatesuccess.setText("");
        lblerrUpdate.setText("");

        lbldis.setText("");
    }

    public void showReg() {

        mainUserPane.setVisible(true);
        regPane.setVisible(true);
        paneupdateCustomer.setVisible(false);
        paneAllUsers.setVisible(false);
        paneManageUser.setVisible(false);

        rec1.setVisible(true);
        rec2.setVisible(false);
        rec3.setVisible(false);
        rec4.setVisible(false);

        //register data clear
        lblerrorRegUser.setText("");
        lblinsert.setText("");
        txtFullName.setText("");
        txtAddress.setText("");
        txtIDno.setText("");
        txtPhone.setText("");
        txtMail.setText("");
        txtuName.setText("");
        txtPass.setText("");
        comboStatus.getSelectionModel().clearSelection();
        comboRole.getSelectionModel().clearSelection();

        lblUpdatesuccess.setText("");
        lblerrUpdate.setText("");
        lbldis.setText("");
    }

    //log out admin

    public void logoutAd(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage dashboard = new Stage();
        dashboard.setTitle("MAIN MENU");
        dashboard.setMaximized(false);
        dashboard.setScene(scene);
        dashboard.setResizable(false);
        dashboard.show();

        Stage stage = (Stage) btnLogOutAdmin.getScene().getWindow();
        stage.close();

    }

    //change User
    public void changeUser(ActionEvent e) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainMenu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage dashboard = new Stage();
        dashboard.setTitle("MAIN MENU");
        dashboard.setMaximized(false);
        dashboard.setScene(scene);
        dashboard.setResizable(false);
        dashboard.show();

        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }



}

