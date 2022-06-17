package Controller;


import Model.AuthDAO;
import Model.AuthDAOImp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSignUp;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    void Login(ActionEvent event) {
        AuthDAO.SignIn
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
