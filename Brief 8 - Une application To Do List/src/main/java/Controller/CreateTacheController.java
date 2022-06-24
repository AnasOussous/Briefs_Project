package Controller;

import DAO.SaisirDAO;
import DAO.SaisirDAOImp;
import DAO.TodoListDAOImp;
import Model.Category;
import Model.ConnectDB;
import Model.Tache;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class CreateTacheController implements Initializable {

    SaisirDAOImp saisirDAOImp = new SaisirDAOImp();

    ObservableList<String> value = FXCollections.observableArrayList("To Do", "In Progress", "Done");



    @FXML
    private Button CreateCategory;
    @FXML
    private Button btnCreate;
    @FXML
    private ComboBox<?> category;
    @FXML
    private Button btnReturn;
    @FXML
    private ComboBox<String> statue = new ComboBox<>(value);
    @FXML
    private TextArea txtDescription;
    @FXML
    private TextField txtIdCtg;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtd;
    @FXML
    private DatePicker DateDeadline;


    @FXML
    Category CreateCategory(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CreatCategory.fxml"));
        Stage window = (Stage) btnCreate.getScene().getWindow();
        window.setScene(new Scene(root));
        return null;
    }

    @FXML
    Object CreateTache(ActionEvent event) {
        try {
            Tache tache = new Tache();

            tache.setId_tache(Integer.parseInt(txtd.getText()));
            tache.setTitle(txtTitle.getText());
            tache.setDescription(txtDescription.getText());
            tache.setDeadline(DateDeadline.getValue().toString());
            tache.setStatue(statue.getValue());
            tache.setId_Category(Integer.parseInt(txtIdCtg.getText()));
            saisirDAOImp.createTache(tache);

            Parent root = FXMLLoader.load(getClass().getResource("/View/hello-view.fxml"));
            Stage window = (Stage) btnCreate.getScene().getWindow();
            window.setScene(new Scene(root));


        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Error");
            alert.setHeaderText("Create Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;
    }

    @FXML
    void Refreash(ActionEvent event) {
        String SQl = "Select * From Category";
        try {
            Connection connection = ConnectDB.connection();
            //PreparedStatement ps = connection.prepareStatement(SQl);


            //rs = ps.executeQuery();
            ResultSet rs = connection.createStatement().executeQuery(SQl);
            ObservableList data = FXCollections.observableArrayList();

            while (rs.next()){
                data.add(new String(rs.getString(2)));
            }
            category.setItems(data);

        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void Return(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/hello-view.fxml"));
        Stage window = (Stage) btnReturn.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            statue.setItems(value);


        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}
