package DAO;

import Model.Category;
import Model.ConnectDB;
import Model.Tache;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SaisirDAOImp implements SaisirDAO{

    @Override
    public void createTache(Tache tache) {
        String SQL = "INSERT INTO tache(id_tache,title,description,deadline,statue,id_Category) VALUES(?,?,?,?,?,?)";
        try(
                Connection connection = ConnectDB.connection();
                PreparedStatement ps = connection.prepareStatement(SQL)
        ) {

            ps.setInt(1, tache.getId_Category());
            ps.setString(2, tache.getTitle());
            ps.setString(3, tache.getDescription());
            ps.setString(4, tache.getDeadline());
            ps.setString(5, tache.getStatue());
            ps.setInt(6, tache.getId_Category());


            int executeUpdate = ps.executeUpdate();

            if(executeUpdate ==1){
                System.out.println("Tache is created...");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Create Success");
                alert.setHeaderText("Create Success");
                alert.setContentText("Tache is Created Successfuly");
                alert.showAndWait();

                //ps.close();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Error");
            alert.setHeaderText("Create Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @Override
    public void updateTache(Integer id_tache, String newtitle, String newdescription, String newdeadline, String newstatue) {
        String SQL = "UPDATE tache set title=?, description=?, deadline=?, statue=?  WHERE id_tache=?;";
        try(
                Connection connection = ConnectDB.connection();
                PreparedStatement ps = connection.prepareStatement(SQL)
        ) {



            ps.setString(1,newtitle);
            ps.setString(2,newdescription);
            ps.setString(3,newdeadline);
            ps.setString(4,newstatue);
            ps.setInt(5,id_tache);


            int executeUpdate = ps.executeUpdate();

            if(executeUpdate ==1){
                System.out.println("Tache is updated..");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Update Success");
                alert.setHeaderText("Update Success");
                alert.setContentText("Tache is updated..");
                alert.showAndWait();

            }else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error Tache");
                alert.setHeaderText("Error Tache");
                alert.setContentText("Tache not Found..");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update Error");
            alert.setHeaderText("Update Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @Override
    public void createCategory(Category category) {
        String SQL = "INSERT INTO category(id_Category,name_Category) VALUES(?,?)";
        try(
                Connection connection = ConnectDB.connection();
                PreparedStatement ps = connection.prepareStatement(SQL)
        ) {

            ps.setInt(1, category.getId_Category());
            ps.setString(2, category.getName_Category());

            int executeUpdate = ps.executeUpdate();

            if(executeUpdate ==1){
                System.out.println("Category is created...");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Create Success");
                alert.setHeaderText("Create Success");
                alert.setContentText("Category is Created Successfuly");
                alert.showAndWait();

                //ps.close();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Create Error");
            alert.setHeaderText("Create Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }
}
