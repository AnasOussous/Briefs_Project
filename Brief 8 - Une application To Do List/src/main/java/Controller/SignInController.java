package Controller;


import DAO.AuthDAOImp;
import Model.ConnectDB;
import Model.User;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    public void SignIn(String username, String psw){
        String SQL = "Select * From users WHERE username=? and psw=?";
        ResultSet rs = null;
        try {
            Connection connection = ConnectDB.connection();
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1,username);
            ps.setString(2,psw);

            rs = ps.executeQuery();



            if (!rs.next()){
                infoBox("Enter Correct Email and Password", "Failed", null);

            }else{
                infoBox("Login Successfull", "Success", null);
                Parent root = FXMLLoader.load(getClass().getResource("/View/hello-view.fxml"));
                Stage window = (Stage) btnSignUp.getScene().getWindow();
                window.setScene(new Scene(root));
            }







        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Error");
            alert.setHeaderText("Create Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


    @FXML
    void Login(ActionEvent event) {
        /*try {

            if (txtUsername.getText().isEmpty()) {
                infoBox("Username Blank", "Username Blank", "Form Error!");
                return;
            }
            if (txtPassword.getText().isEmpty()) {
                infoBox("Password Blank", "Password Blank", "Form Error!");
                return;
            }

            String Username = txtUsername.getText();
            String password = txtPassword.getText();


                if (authDAOImp.SignIn(Username,password)){
                Parent root = FXMLLoader.load(getClass().getResource("/View/hello-view.fxml"));
                Stage window = (Stage) btnSignUp.getScene().getWindow();
                window.setScene(new Scene(root));

            }else{
                System.out.println("IYFYIFYICYI");
            }
            if (authDAOImp.SignIn(txtUsername.getText(),txtPassword.getText()).next()){

            }*/
        try {
            if (txtUsername.getText().isEmpty()) {
                infoBox("Enter Username", "Username Blank", null);
                return;
            }
            if (txtPassword.getText().isEmpty()) {
                infoBox("Enter Password", "Password Blank", null);
                return;
            }
        String Username = txtUsername.getText();
        String password = txtPassword.getText();
        SignIn(Username,password);


        }catch(Exception e){
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

    public static void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
