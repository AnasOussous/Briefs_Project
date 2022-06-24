package Controller;

import DAO.TodoListDAOImp;
import Model.Category;
import Model.ConnectDB;
import Model.Tache;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public Tache tac;



    @FXML
    private ComboBox<Tache> category;
    @FXML
    private DatePicker dateDeadline;

    @FXML
    private TextField txtCategory;
    @FXML
    private TableColumn<Tache,String> deadline;

    @FXML
    private TableColumn<Tache,String> description;

    @FXML
    private TableColumn<Tache,Integer> id_tache;
    @FXML
    private TableView<Tache> table;

    @FXML
    private TableColumn<Tache,Integer> tblcategory;

    @FXML
    private TableColumn<Tache,String> tblstatue;

    @FXML
    private TableColumn<Tache,String> title;

    @FXML
    private TextField txtIdCtg;
    @FXML
    private Button CreateCategory;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnCreate;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtd;


    TodoListDAOImp todoListDAOImp = new TodoListDAOImp();


    /*public void setValue(ObservableList<String> value) {
        this.value = value;
    }*/


    public ObservableList<Tache> getTacheList(){

        ObservableList<Tache> tacheList = FXCollections.observableArrayList();

        //ResultSet rs;
        try{
            /*Connection connection = ConnectDB.connection();
            PreparedStatement ps = connection.prepareStatement("select * from tache");
            rs = ps.executeQuery();
            while(rs.next()){
                tac =new Tache(rs.getInt("id_tache"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("deadline"),
                        rs.getString("statue"),
                        rs.getInt("id_Category"));
                tacheList.add(tac);
            }*/
            todoListDAOImp.AffTache(tac, tacheList);
            //tacheList.add(tac);

        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return tacheList;
    }

    public void AfficheTache(){

        ObservableList<Tache> list =getTacheList();
        //id_tache.setCellValueFactory(new PropertyValueFactory<Tache,Integer>("id_tache"));
        title.setCellValueFactory(new PropertyValueFactory<Tache,String>("title"));
        description.setCellValueFactory(new PropertyValueFactory<Tache,String>("description"));
        deadline.setCellValueFactory(new PropertyValueFactory<Tache,String>("deadline"));
        tblstatue.setCellValueFactory(new PropertyValueFactory<Tache,String>("statue"));
        tblcategory.setCellValueFactory(new PropertyValueFactory<Tache,Integer>("id_Category"));
        table.setItems(list);

    }

    /*@FXML
    void Refreash(ActionEvent event) {
        /*String SQL = "Select * From statue";
        //ResultSet rs = null;
        try {
            Connection connection = ConnectDB.connection();
            //PreparedStatement ps = connection.prepareStatement(SQL);


            //rs = ps.executeQuery();
            ResultSet rs = connection.createStatement().executeQuery(SQL);
            ObservableList data = FXCollections.observableArrayList();

            while (rs.next()){
                data.add(new String(rs.getString(2)));
            }
            statue.setItems(data);

        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }*/

        /*String SQl = "Select * From Category";
        //ResultSet rs = null;
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
    }*/

    /*public void Statue(){

        String SQL = "Select * From statue";
        //ResultSet rs = null;
        try {
            Connection connection = ConnectDB.connection();
            //PreparedStatement ps = connection.prepareStatement(SQL);


            //rs = ps.executeQuery();
            ResultSet rs = connection.createStatement().executeQuery(SQL);
            ObservableList data = FXCollections.observableArrayList();

            while (rs.next()){
                data.add(new String(rs.getString(1)));
            }
            statue.setItems(data);

        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }*/

    /*@FXML
    Category CreateCategory(ActionEvent event) {
        try {
            Category category = new Category();
            category.setId_Category(Integer.parseInt(txtIdCtg.getText()));
            category.setName_Category(txtCategory.getText());


            todoListDAOImp.createCategory(category);


            //AfficheCandidats();

        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Error");
            alert.setHeaderText("Create Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;
    }*/


    @FXML
    Tache CreateTache(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CreateTache.fxml"));
        Stage window = (Stage) btnCreate.getScene().getWindow();
        window.setScene(new Scene(root));
        return null;
    }


    @FXML
    void deleteTache(ActionEvent event) {
        try {
            todoListDAOImp.deleteTache(Integer.parseInt(txtd.getText()));
            AfficheTache();

        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Error");
            alert.setHeaderText("Delete Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void UpdateTache(ActionEvent event) throws IOException {
        /*try {
            todoListDAOImp.updateTache(
                    Integer.parseInt(txtd.getText()),
                    txtTitle.getText() ,
                    txtDescription.getText(),
                    txtDeadline.getText(),
                    statue.getValue());



            AfficheTache();
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Update Error");
            alert.setHeaderText("Update Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }*/
        Parent root = FXMLLoader.load(getClass().getResource("/View/ModifyTache.fxml"));
        Stage window = (Stage) btnCreate.getScene().getWindow();
        window.setScene(new Scene(root));
    }

    @FXML
    public void handleMouseAction(MouseEvent event) {
        Tache tache = table.getSelectionModel().getSelectedItem();
        txtd.setText(""+tache.getId_tache());

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            //statue.setItems(value);
            AfficheTache();
            txtd.setEditable(false);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

}