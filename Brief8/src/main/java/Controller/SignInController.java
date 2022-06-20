package Controller;


import Model.AuthDAOImp;
import Model.User;
import View.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class SignInController implements Initializable {

    public AuthDAOImp authDAOImp = new AuthDAOImp();

    User user = new User();
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUsername;

    @FXML
    void Login(ActionEvent event) {
        try {

                Parent root = FXMLLoader.load(getClass().getResource("/View/hello-view.fxml"));
                Stage window = (Stage) btnSignUp.getScene().getWindow();
                window.setScene(new Scene(root));


        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Error");
            alert.setHeaderText("Create Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


    @FXML
    void toSignUp(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/SignUp.fxml"));
            Stage window = (Stage) btnSignUp.getScene().getWindow();
            window.setScene(new Scene(root));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
