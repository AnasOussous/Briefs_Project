package Controller;

import Model.AuthDAOImp;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUpController {

    public AuthDAOImp authDAOImp = new AuthDAOImp();
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignup;

    @FXML
    private PasswordField txtPsw;

    @FXML
    private TextField txtusername;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtprenom;


    @FXML
    public void Signup(javafx.event.ActionEvent actionEvent) {
        try {
            User user = new User();
            user.setName_User(txtnom.getText());
            user.setPrenom_User(txtprenom.getText());
            user.setUsername(txtusername.getText());
            user.setPsw(txtPsw.getText());

            authDAOImp.SignUp(user);

            Parent root = FXMLLoader.load(getClass().getResource("/View/SignIn.fxml"));
            Stage window = (Stage) btnLogin.getScene().getWindow();
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
    void toLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/View/SignIn.fxml"));
            Stage window = (Stage) btnLogin.getScene().getWindow();
            window.setScene(new Scene(root));

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
