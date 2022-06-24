package Controller;

import DAO.SaisirDAOImp;
import Model.Category;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreatCategoryController {
    SaisirDAOImp saisirDAOImp = new SaisirDAOImp();
    @FXML
    private Button CreateCategory;
    @FXML
    private Button btnReturn;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtIdCtg;

    @FXML
    void CreateCategory(ActionEvent event) {
        try {
            Category category = new Category();
            category.setId_Category(Integer.parseInt(txtIdCtg.getText()));
            category.setName_Category(txtCategory.getText());


            saisirDAOImp.createCategory(category);

            Parent root = FXMLLoader.load(getClass().getResource("/View/CreateTache.fxml"));
            Stage window = (Stage) CreateCategory.getScene().getWindow();
            window.setScene(new Scene(root));


            //AfficheCandidats();

        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Error");
            alert.setHeaderText("Create Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void Return(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CreateTache.fxml"));
        Stage window = (Stage) btnReturn.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
