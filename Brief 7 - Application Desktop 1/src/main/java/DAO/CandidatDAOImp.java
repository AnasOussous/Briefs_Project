package DAO;

import com.example.brief7.Candidat;
import com.example.brief7.ConnectDB;
import javafx.scene.control.Alert;

import java.sql.*;

public class CandidatDAOImp implements candidatDAO {


    @Override
    public void createCandidat(Candidat candidat) {
        String SQL = "INSERT INTO candidat(id_candidat,nom,prénom,mail,adresse,ville,pays) VALUES(?,?,?,?,?,?,?)";
        try(
                Connection connection = ConnectDB.connection();
                PreparedStatement ps = connection.prepareStatement(SQL)
        ) {

            ps.setInt(1, candidat.getId_candidat());
            ps.setString(2, candidat.getNom());
            ps.setString(3, candidat.getPrénom());
            ps.setString(4, candidat.getMail());
            ps.setString(5, candidat.getAdresse());
            ps.setString(6, candidat.getVille());
            ps.setString(7, candidat.getPays());

            int executeUpdate = ps.executeUpdate();

            if(executeUpdate ==1){
                System.out.println("Candidat is created...");
                //ps.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public void updateCandidatEmailById(String newEmail, Integer CandidatId) {
        String SQL = "UPDATE candidat set mail=? WHERE id_candidat=?;";
        try(
                Connection connection = ConnectDB.connection();
                PreparedStatement ps = connection.prepareStatement(SQL)
        ) {

            ps.setString(1,newEmail);
            ps.setInt(2,CandidatId);

            int executeUpdate = ps.executeUpdate();

            if(executeUpdate ==1){
                System.out.println("Candidat email is updated..");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteCandidat(Integer CandidatId) {
        String SQL = "DELETE FROM candidat WHERE id_candidat=?;";
        try(
                Connection connection = ConnectDB.connection();
                PreparedStatement ps = connection.prepareStatement(SQL)
        ) {

            ps.setInt(1,CandidatId);

            int executeUpdate = ps.executeUpdate();

            if(executeUpdate == 1){
                System.out.println("Candidat is deleted with ID::"+CandidatId);

            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Delete Error");
            alert.setHeaderText("Delete Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

    }

    /*@Override
    public ObservableList<Candidat> getAllCandidatInfo() {
            ObservableList<Candidat> CanList = FXCollections.observableArrayList();
        String SQL = "SELECT * FROM candidat";
        try(
                Connection connection = ConnectDB.getConnection();
                PreparedStatement ps = connection.prepareStatement(SQL)
        ) {

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               int canId = rs.getInt("id_candidat");
                String CanNom = rs.getString("nom");
                String CanPré = rs.getString("prénom");
                String CanMail = rs.getString("mail");
                String CanAddr = rs.getString("adresse");
                String CanVille = rs.getString("ville");
                String CanPays = rs.getString("pays");

                Candidat candidat = new Candidat();
                candidat.setNom(rs.getString("nom"));
                candidat.setPrénom(rs.getString("prénom"));
                candidat.setVille(rs.getString("ville"));
                candidat.setMail(rs.getString("mail"));
                candidat.setAdresse(rs.getString("adresse"));
                candidat.setId_candidat(rs.getInt("id_candidat"));
                candidat.setPays(rs.getString("pays"));


                CanList.add(candidat);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return CanList;

    }*/
}
