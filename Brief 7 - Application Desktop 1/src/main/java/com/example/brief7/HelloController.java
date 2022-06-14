package com.example.brief7;

import DAO.CandidatDAOImp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class HelloController implements Initializable {


    public Candidat Can;
    public CandidatDAOImp candDAO = new CandidatDAOImp();

    public ConnectDB con = new ConnectDB();

    @FXML
    private TableColumn<Candidat, String> adresse;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Integer id_candidat;
    @FXML
    private TableColumn<Candidat, Integer> id_candid;
    @FXML
    private TableColumn<Candidat, String> mail;
    @FXML
    private TableColumn<Candidat, String> nom;
    @FXML
    private TableColumn<Candidat, String> pays;
    @FXML
    private TableColumn<Candidat, String> prénom;
    @FXML
    private TableView<Candidat> table;
    @FXML
    private TextField txtAdresse;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtMail;
    @FXML
    private TextField txtPays;
    @FXML
    private TextField txtVille;
    @FXML
    private TableColumn<Candidat, String> ville;


    public ObservableList<Candidat> getCandidatList(){

        ObservableList<Candidat> candidatList = FXCollections.observableArrayList();

        ResultSet rs;
        try{
            //rs = con.connection().createStatement().executeQuery("select * from candidat");
            Connection connection = ConnectDB.connection();
            PreparedStatement ps = connection.prepareStatement("select * from candidat");
            rs = ps.executeQuery();
            while(rs.next()){
                Can =new Candidat(rs.getInt("id_candidat"),
                        rs.getString("nom"),
                        rs.getString("prénom"),
                        rs.getString("mail"),
                        rs.getString("adresse"),
                        rs.getString("ville"),
                        rs.getString("pays"));
                candidatList.add(Can);
            }

        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return candidatList;
    }

    public void AfficheCandidats(){

            ObservableList<Candidat> list =getCandidatList();
            id_candid.setCellValueFactory(new PropertyValueFactory<Candidat,Integer>("id_candidat"));
            nom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("nom"));
            prénom.setCellValueFactory(new PropertyValueFactory<Candidat,String>("prénom"));
            mail.setCellValueFactory(new PropertyValueFactory<Candidat,String>("mail"));
            adresse.setCellValueFactory(new PropertyValueFactory<Candidat,String>("adresse"));
            ville.setCellValueFactory(new PropertyValueFactory<Candidat,String>("ville"));
            pays.setCellValueFactory(new PropertyValueFactory<Candidat,String>("pays"));
            table.setItems(list);

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            AfficheCandidats();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    void Update(ActionEvent event) {

        try {
            candDAO.updateCandidatEmailById(txtMail.getText(), Integer.parseInt(txtId.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Success");
            alert.setHeaderText("Update Success");
            alert.setContentText("Candidat email is updated");
            alert.showAndWait();
            AfficheCandidats();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Error");
            alert.setHeaderText("Update Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    @FXML
    Candidat createCandidat(ActionEvent event) {
        try {
            Candidat candidat = new Candidat();
            candidat.setNom(txtLastName.getText());
            candidat.setPrénom(txtFirstName.getText());
            candidat.setMail(txtMail.getText());
            candidat.setVille(txtVille.getText());
            candidat.setAdresse(txtAdresse.getText());
            candidat.setId_candidat(Integer.parseInt(txtId.getText()));
            candidat.setPays(txtPays.getText());

            candDAO.createCandidat(candidat);


            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Success");
            alert.setHeaderText("Create Success");
            alert.setContentText("Candidat is Created Successfuly");
            alert.showAndWait();
            AfficheCandidats();

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
    void deleteCandidat(ActionEvent event) {
        try {


            candDAO.deleteCandidat(Integer.parseInt(txtId.getText()));

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Success");
            alert.setHeaderText("Delete Success");
            alert.setContentText("Candidat Deleted is Successfuly");
            alert.showAndWait();

            AfficheCandidats();
        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Error");
            alert.setHeaderText("Delete Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }


}
