package manage.ship.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import manage.ship.model.StudentModel;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    /*public void bc(ActionEvent e){
        String password = "1234";
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
// $2a$12$US00g/uMhoSBm.HiuieBjeMtoN69SN.GE25fCpldebzkryUyopws6

        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), bcryptHashString);
// result.verified == true
        System.out.println(result);
    }*/


    @FXML
    private TableView<Student> tableView;
    @FXML
    private TableColumn<Student, String> tableID;

    @FXML
    private TableColumn<Student, String> tableName;

    @FXML
    private Button btnDelete;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.viewData();
    }

    public void viewData() {

        StudentModel stuModel = new StudentModel();

        tableID.setCellValueFactory(new PropertyValueFactory<Student, String>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));


        tableView.setItems(stuModel.getStu());
    }

    public void delData(ActionEvent e) {

        String id = tableView.getSelectionModel().getSelectedItem().id;
        StudentModel stuModel = new StudentModel();

        boolean result = stuModel.delUser(id);
        System.out.println(result);
    }


}
