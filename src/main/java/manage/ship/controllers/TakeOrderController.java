package manage.ship.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import manage.ship.Application;
import manage.ship.model.OrderCompanyModel;
import manage.ship.model.OrderIndividualModel;
import manage.ship.model.TableOrder;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TakeOrderController implements Initializable {

    @FXML
    private Button btnAllOrders;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClearCompany;

    @FXML
    private Button btnCompanyWeight;

    @FXML
    private Button btnOrderCompanyBill;

    @FXML
    private Button btnOrderIndividualBill;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSaveCompany;

    @FXML
    private Button btnSelectCompanyCustomer;

    @FXML
    private Button btnSelectIndividualCustomer;

    @FXML
    private Button btnWeight;

    @FXML
    private ComboBox<String> comboCategory;

    @FXML
    private ComboBox<String> comboCompanyCategory;

    @FXML
    private ComboBox<String> comboCompanyName;

    @FXML
    private ComboBox<String> comboCompanyWeight;

    @FXML
    private ComboBox<String> comboID;

    @FXML
    private ComboBox<String> comboName;

    @FXML
    private ComboBox<String> comboOrdererID;

    @FXML
    private ComboBox<String> comboWeight;

    @FXML
    private DatePicker dateOrderCompany;

    @FXML
    private DatePicker dateOrderIndividual;

    @FXML
    private Label lblErro;

    @FXML
    private Label lblErro1;

    @FXML
    private Label lblIdErrorUpdate;

    @FXML
    private TableColumn<OrderCompany, String> oCategoryCompany;

    @FXML
    private TableColumn<OrderIndividual, String> oCategoryIndividual;

    @FXML
    private TableColumn<OrderCompany, String> oDataCompany;

    @FXML
    private TableColumn<OrderIndividual, String> oDataIndividual;

    @FXML
    private TableColumn<OrderCompany, String> oICompany;

    @FXML
    private TableColumn<OrderIndividual, String> oIDIndividual;

    @FXML
    private TableColumn<OrderIndividual, String> oIdNumberIndividual;

    @FXML
    private TableColumn<OrderCompany, String> oIdOrdererCompany;

    @FXML
    private TableColumn<OrderCompany, String> oNameCompany;

    @FXML
    private TableColumn<OrderIndividual, String> oNameIndividual;

    @FXML
    private TableColumn<OrderCompany, String> oPriceCompany;

    @FXML
    private TableColumn<OrderIndividual, String> oPriceIndividual;

    @FXML
    private TableColumn<OrderCompany, String> oWeightCompany;

    @FXML
    private TableColumn<OrderIndividual, String> oWeightIndividual;

    @FXML
    private AnchorPane orderMainPane;

    @FXML
    private AnchorPane paneOrderAll;

    @FXML
    private AnchorPane paneOrderCompany;

    @FXML
    private AnchorPane paneOrderIndividual;

    @FXML
    private Rectangle rec1;

    @FXML
    private Rectangle rec2;

    @FXML
    private Rectangle rec3;

    @FXML
    private TableView<?> tableOrderAllCompany;

    @FXML
    private TableView<OrderIndividual> tableOrderAllIndividual;

    @FXML
    private TextField txtCompanyPrice;

    @FXML
    private TextField txtPrice;
    @FXML
    private TextArea tArea;

    @FXML
    private TextArea tArea1;
    @FXML
    private Label lblindiOrder;

    @FXML
    private Label lbl01;





    //value indi category
    ObservableList<String> categoryIndividual = FXCollections.observableArrayList("FOODS", "CLOTHS", "PLANTS AND SEEDS", "OTHERS");

    //value com category
    ObservableList<String> categoryCompany = FXCollections.observableArrayList("FOODS", "CLOTHS", "FURNITURE", "OTHERS");

    //value indi weight
    ObservableList<String> weightIndividual = FXCollections.observableArrayList("0-1KG", "1KG-5KG", "5KG-10KG", "10KG-25KG", "25KG-50KG");

    //value com weight
    ObservableList<String> weightCompany = FXCollections.observableArrayList("0-10KG", "10KG-25KG", "25KG-100KG", "100KG-250KG", "250KG-500KG");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

//in cat
        comboCategory.setItems(categoryIndividual);

//com cat
        comboCompanyCategory.setItems(categoryCompany);

//in wei
        comboWeight.setItems(weightIndividual);

//com wei
        comboCompanyWeight.setItems(weightCompany);


        //price individual
        tArea.setText("FOODS \n 0kg-1kg -> 1500 \n 1kg-5kg -> 8000 \n 5KG-10KG -> 12000 \n 10KG-25KG -> 25000 \n 25KG-50KG -> 50000 \n" +
                " CLOTHS \n 0kg-1kg -> 1000 \n 1kg-5kg -> 5000 \n 5KG-10KG -> 8000 \n 10KG-25KG -> 15000 \n 25KG-50KG -> 30000 \n" +
                "PLANTS AND SEEDS \n 0kg-1kg -> 2000 \n 1kg-5kg -> 8000 \n 5KG-10KG -> 12000 \n 10KG-25KG -> 25000 \n 25KG-50KG -> 50000 \n" +
                "OTHERS \n 0kg-1kg -> 1500 \n 1kg-5kg -> 4000 \n 5KG-10KG -> 12000 \n 10KG-25KG -> 18000 \n 25KG-50KG -> 25000 \n");


        //price company
        tArea1.setText("FOODS \n 0kg-10kg -> 15000 \n 10kg-25kg -> 50000 \n 25KG-100KG -> 300000 \n 100KG-250KG -> 800000 \n 250KG-500KG -> 1400000 \n" +
                "CLOTHS \n 0kg-10kg -> 10000 \n 10kg-25kg -> 20000 \n 25KG-100KG -> 15000 \n 100KG-250KG -> 500000 \n 250KG-500KG -> 1000000 \n" +
                "FURNITURE \n 0kg-10kg -> 25000 \n 10kg-25kg -> 75000 \n 25KG-100KG -> 200000 \n 100KG-250KG -> 800000 \n 250KG-500KG -> 1500000 \n" +
                "OTHERS \n 0kg-10kg -> 10000 \n 10kg-25kg -> 20000 \n 25KG-100KG -> 50000 \n 100KG-250KG -> 150000 \n 250KG-500KG -> 800000 \n");

        orderMainPane.setVisible(true);
        paneOrderAll.setVisible(false);
        paneOrderCompany.setVisible(false);
        paneOrderIndividual.setVisible(true);

        rec1.setVisible(true);
        rec2.setVisible(false);
        rec3.setVisible(false);

        //get data for order in individual customer

        OrderIndividualModel orderIndividualModel = new OrderIndividualModel();
        ResultSet rs = orderIndividualModel.getName();
        ObservableList data = FXCollections.observableArrayList();
        ObservableList data0 = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
                data.add(rs.getString("c_namein"));
                data0.add(rs.getString("c_idnumberin"));
            }
            comboName.setItems(data);
            comboID.setItems(data0);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    //show individual
    public void showIndividual(ActionEvent e) {

        //get data for order in individual customer
        OrderIndividualModel orderIndividualModel = new OrderIndividualModel();
        ResultSet rs = orderIndividualModel.getName();
        ObservableList data = FXCollections.observableArrayList();
        ObservableList data0 = FXCollections.observableArrayList();

        try {
            while (rs.next()) {
                data.add(rs.getString("c_namein"));
                data0.add(rs.getString("c_idnumberin"));
            }
            comboName.setItems(data);
            comboID.setItems(data0);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        orderMainPane.setVisible(true);
        paneOrderAll.setVisible(false);
        paneOrderCompany.setVisible(false);
        paneOrderIndividual.setVisible(true);

        rec1.setVisible(true);
        rec2.setVisible(false);
        rec3.setVisible(false);

        this.clearIn(e);
        this.clearCm(e);
    }

    //show order company
    public void showCompany(ActionEvent e) {

        //get data for order in company customer

        OrderCompanyModel orderCompanyModel = new OrderCompanyModel();
        ResultSet rs1 = orderCompanyModel.getName();
        ObservableList data2 = FXCollections.observableArrayList();
        ObservableList data3 = FXCollections.observableArrayList();

        try {
            while (rs1.next()) {
                data2.add(rs1.getString("c_namecm"));
                data3.add(rs1.getString("c_idnumbercm"));
            }
            comboCompanyName.setItems(data2);
            comboOrdererID.setItems(data3);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        orderMainPane.setVisible(true);
        paneOrderAll.setVisible(false);
        paneOrderCompany.setVisible(true);
        paneOrderIndividual.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(true);
        rec3.setVisible(false);

        this.clearIn(e);
        this.clearCm(e);
    }

    //cal price individual
    public void calPriceIndividual(ActionEvent e) {

       /* if(comboCategory.getSelectionModel().select(1)""){
            System.out.println();
        }*/
        String out = txtPrice.getText();
        txtPrice.setText("");
        int price = 0;
        lblindiOrder.setText("");


        String ct = comboCategory.getValue();
        String wt = comboWeight.getValue();
        if (comboCategory.getValue() == null) {
            lblindiOrder.setText("Select Filed First");
        } else if (comboWeight.getValue() == null) {
            lblindiOrder.setText("Select Filed First");
        } else {
            switch (ct) {
                case "FOODS":
                case "PLANTS AND SEEDS":
                    // price=1000;
                    switch (wt) {//"0-1KG", "1KG-5KG", "5KG-10KG", "10KG-25KG", "25KG-50KG");
                        case "0-1KG":
                            price += 2000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "1KG-5KG":
                            price += 8000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "5KG-10KG":
                            price += 12000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "10KG-25KG":
                            price += 25000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "25KG-50KG":
                            price += 50000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                    }
                    break;
                case "CLOTHS":
                    switch (wt) {////"0-1KG", "1KG-5KG", "5KG-10KG", "10KG-25KG", "25KG-50KG");
                        case "0-1KG":
                            price += 1000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "1KG-5KG":
                            price += 5000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "5KG-10KG":
                            price += 8000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "10KG-25KG":
                            price += 15000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "25KG-50KG":
                            price += 30000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                    }
                    break;
                case "OTHERS":
                    switch (wt) {////"0-1KG", "1KG-5KG", "5KG-10KG", "10KG-25KG", "25KG-50KG");
                        case "0-1KG":
                            price += 1500;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "1KG-5KG":
                            price += 4000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "5KG-10KG":
                            price += 12000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "10KG-25KG":
                            price += 18000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                        case "25KG-50KG":
                            price += 25000;
                            txtPrice.setText(String.valueOf(price));
                            break;
                    }
                    break;
            }
        }

    }

    // insert individual

    public void insertIn() {

        String category = comboCategory.getValue();
        String weight = comboWeight.getValue();
        String name = comboName.getValue();
        String id = comboID.getValue();
        String priceIn = txtPrice.getText();
        lblErro1.setText("");
        String date = null;
        if (dateOrderIndividual.getValue() == null) {
            lblindiOrder.setText("Select All Field and Calculate Price");
        } else {
            date = String.valueOf(dateOrderIndividual.getValue());
        }

        lblindiOrder.setText("");

        if (category == null || name == null || id == null || priceIn == null) {
            lblindiOrder.setText("Select All Field and Calculate Price");

        } else if (date == null) {
            lblindiOrder.setText("Select Date");

        } else if (weight == null) {
            lblindiOrder.setText("Select Weight");
        } else {
            OrderIndividualModel orderIndividualModel = new OrderIndividualModel();
            boolean result = orderIndividualModel.regIndividual(name, id, category, weight, priceIn, date);
            if (result) {
                lblErro1.setText("Data Recorder");
                comboWeight.getSelectionModel().clearSelection();
            }
        }
    }


    //insert company

    public void insertCm(ActionEvent e) {

        String category = comboCompanyCategory.getValue();
        String weight = comboCompanyWeight.getValue();
        String name = comboCompanyName.getValue();
        String id = comboOrdererID.getValue();
        String priceIn = txtCompanyPrice.getText();
        lbl01.setText("");
        String date = null;
        if (dateOrderCompany.getValue() == null) {
            lblErro.setText("Select All Field and Calculate Price");
        } else {
            date = String.valueOf(dateOrderCompany.getValue());
        }

        lblErro.setText("");

        if (category == null || name == null || id == null || priceIn == null) {
            lblErro.setText("Select All Field and Calculate Price");

        } else if (date == null) {
            lblErro.setText("Select Date");

        } else if (weight == null) {
            lblErro.setText("Select Weight");
        } else {
            OrderCompanyModel orderCompanyModel = new OrderCompanyModel();
            boolean result = orderCompanyModel.regCompany(name, id, category, weight, priceIn, date);
            if (result) {
                lbl01.setText("Data Recorder");
                comboCompanyWeight.getSelectionModel().clearSelection();
            }
        }
    }


    //cal price company
    public void calPriceCompany(ActionEvent e) {

       /* if(comboCategory.getSelectionModel().select(1)""){
            System.out.println();
        }*/
        String out = txtPrice.getText();
        txtPrice.setText("");
        int price = 0;
        lblErro.setText("");


        String ct = comboCompanyCategory.getValue();
        String wt = comboCompanyWeight.getValue();
        if (comboCompanyCategory.getValue() == null) {
            lblErro.setText("Select Filed First");
        } else if (comboCompanyWeight.getValue() == null) {
            lblErro.setText("Select Filed First");
        } else {
            switch (ct) {
                case "FOODS":
                case "OTHERS":
                    // price=1000;
                    switch (wt) {//"0-10KG", "10KG-25KG", "25KG-100KG", "100KG-250KG", "250KG-500KG"
                        case "0-10KG":
                            price += 15000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "10KG-25KG":
                            price += 50000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "25KG-100KG":
                            price += 300000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "100KG-250KG":
                            price += 800000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "250KG-500KG":
                            price += 1400000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                    }
                    break;
                case "CLOTHS":
                    switch (wt) {///"0-10KG", "10KG-25KG", "25KG-100KG", "100KG-250KG", "250KG-500KG"");
                        case "0-10KG":
                            price += 10000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "10KG-25KG":
                            price += 50000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "25KG-100KG":
                            price += 150000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "100KG-250KG":
                            price += 500000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "250KG-500KG":
                            price += 100000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                    }
                    break;
                case "FURNITURE":
                    switch (wt) {////"0-10KG", "10KG-25KG", "25KG-100KG", "100KG-250KG", "250KG-500KG"
                        case "0-10KG":
                            price += 25000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "10KG-25KG":
                            price += 75000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "25KG-100KG":
                            price += 200000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "100KG-250KG":
                            price += 800000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                        case "250KG-500KG":
                            price += 1500000;
                            txtCompanyPrice.setText(String.valueOf(price));
                            break;
                    }
                    break;
            }
        }

    }


    //load tables
    public void getTable() {

        TableOrder tableOrder = new TableOrder();
//String IdIn,NameIn,IdNumberIn,CategoryIn,WeightIn,PriceIn,DateIn;
        oIDIndividual.setCellValueFactory(new PropertyValueFactory<OrderIndividual, String>("IdIn"));
        oNameIndividual.setCellValueFactory(new PropertyValueFactory<OrderIndividual, String>("NameIn"));
        oIdNumberIndividual.setCellValueFactory(new PropertyValueFactory<OrderIndividual, String>("IdNumberIn"));
        oCategoryIndividual.setCellValueFactory(new PropertyValueFactory<OrderIndividual, String>("CategoryIn"));
        oWeightIndividual.setCellValueFactory(new PropertyValueFactory<OrderIndividual, String>("WeightIn"));
        oPriceIndividual.setCellValueFactory(new PropertyValueFactory<OrderIndividual, String>("PriceIn"));
        oDataIndividual.setCellValueFactory(new PropertyValueFactory<OrderIndividual, String>("DateIn"));


        //String IdCm,NameCm,IdNumberCm,CategoryCm,WeightCm,PriceCm,DateCm;
        oICompany.setCellValueFactory(new PropertyValueFactory<OrderCompany, String>("IdCm"));
        oNameCompany.setCellValueFactory(new PropertyValueFactory<OrderCompany, String>("NameCm"));
        oIdOrdererCompany.setCellValueFactory(new PropertyValueFactory<OrderCompany, String>("IdNumberCm"));
        oCategoryCompany.setCellValueFactory(new PropertyValueFactory<OrderCompany, String>("CategoryCm"));
        oWeightCompany.setCellValueFactory(new PropertyValueFactory<OrderCompany, String>("WeightCm"));
        oPriceCompany.setCellValueFactory(new PropertyValueFactory<OrderCompany, String>("PriceCm"));
        oDataCompany.setCellValueFactory(new PropertyValueFactory<OrderCompany, String>("DateCm"));


        tableOrderAllIndividual.setItems(tableOrder.getInOT());
        tableOrderAllCompany.setItems(tableOrder.getComOT());


    }

    //clear individual

    public void clearIn(ActionEvent e) {

        txtPrice.setText("");
        comboWeight.setPromptText("SELECT WEIGHTS");
        lblindiOrder.setText("");
        lblErro1.setText("");

        dateOrderIndividual.setPromptText("SELECT DATE");
        dateOrderIndividual.setValue(null);
    }


    //clear company

    public void clearCm(ActionEvent e) {
        txtCompanyPrice.setText("");
        comboCompanyWeight.setPromptText("SELECT WEIGHTS");
        lbl01.setText("");
        lblErro.setText("");

        dateOrderCompany.setPromptText("SELECT DATE");
        dateOrderCompany.setValue(null);
    }


    //show all
    public void showAll(ActionEvent e) {

        orderMainPane.setVisible(true);
        paneOrderAll.setVisible(true);
        paneOrderCompany.setVisible(false);
        paneOrderIndividual.setVisible(false);

        rec1.setVisible(false);
        rec2.setVisible(false);
        rec3.setVisible(true);

        this.getTable();
        this.clearIn(e);
        this.clearCm(e);
    }

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

    @FXML
    public void showBillIn(ActionEvent e) {



        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("billIndividual-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.setTitle("Individual Customer Bill");
            stage1.show();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    public void showBillCn() {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("billCompany-view.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.setTitle("Company Customer Bill");
            stage1.show();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

      //  paneIndividualBill.setVisible(true);
    }
}