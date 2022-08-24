package Controller;

import DAO.SaisirDAOImp;
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
import java.util.ResourceBundle;

public class ModifyController implements Initializable {

    SaisirDAOImp saisirDAOImp = new SaisirDAOImp();

    ObservableList<String> value = FXCollections.observableArrayList("To Do", "In Progress", "Done");

    @FXML
    private Button btnUpdate;

    @FXML
    private ComboBox<?> category;
    @FXML
    private DatePicker dateDeadline;

    @FXML
    private ComboBox<String> statue = new ComboBox<>(value);

    @FXML
    private TextField txtDeadline;
    @FXML
    private Button btnReturn;

    @FXML
    private TextArea txtDescription;

    @FXML
    private TextField txtIdCtg;

    @FXML
    private TextField txtTitle;

    @FXML
    private TextField txtd;

    @FXML
    void Refreash(ActionEvent event) {

    }

    @FXML
    void UpdateTache(ActionEvent event) {
        try {
            saisirDAOImp.updateTache(
                    Integer.parseInt(txtd.getText()),
                    txtTitle.getText() ,
                    txtDescription.getText(),
                    dateDeadline.getValue().toString(),
                    statue.getValue());

            Parent root = FXMLLoader.load(getClass().getResource("/View/hello-view.fxml"));
            Stage window = (Stage) btnUpdate.getScene().getWindow();
            window.setScene(new Scene(root));

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Error");
            alert.setHeaderText("Update Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
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

    @FXML
    void Return(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/hello-view.fxml"));
        Stage window = (Stage)  btnReturn.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
