package com.simplilearn.Brief5;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class CandidatDAOImp implements CandidatDAO {

	@Override
	public void createCandidat(Candidat candidat) {
		String SQL = "INSERT INTO candidat(id_candidat,nom,prénom,mail,adresse,ville,pays)VALUES(?,?,?,?,?,?,?)";
		try(
				Connection connection = ConnectDB.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQL)
			) {
			
			ps.setInt(1, candidat.getId_candidat());
			ps.setString(2, candidat.getNom());
			ps.setString(3, candidat.getPrénom());
			ps.setString(4, candidat.getVille());
			ps.setString(5, candidat.getMail());
			ps.setString(6, candidat.getAdresse());
			ps.setString(7, candidat.getPays());
			
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate ==1){
				System.out.println("Candidat is created...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Candidat getCandidatById(Integer CandidatId) {
		Candidat candidat = null;
		String SQL = "SELECT *FROM candidat WHERE id_candidat=?";
		try(
				Connection connection = ConnectDB.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQL)
			) {
			
			ps.setInt(1, CandidatId);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int canId = rs.getInt("id_candidat");
				String CanNom = rs.getString("nom");
				String CanPré = rs.getString("prénom");
				String CanMail = rs.getString("mail");
				String CanAddr = rs.getString("adresse");
				String CanVille = rs.getString("ville");
				String CanPays = rs.getString("pays");
				
				candidat = new Candidat();
				candidat.setNom(CanNom);
				candidat.setPrénom(CanPré);
				candidat.setVille(CanVille);
				candidat.setMail(CanMail);
				candidat.setAdresse(CanAddr);
				candidat.setId_candidat(canId);
				candidat.setPays(CanPays);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return candidat;
	}

	@Override
	public void updateCandidatEmailById(String newEmail, Integer CandidatId) {
		String SQL = "UPDATE candidat set mail=? WHERE id_candidat=?;";
		try(
				Connection connection = ConnectDB.getConnection();
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
	public void deleteCandidatById(Integer CandidatId) {
		String SQL = "DELETE FROM candidat WHERE id_candidat=?;";
		try(
				Connection connection = ConnectDB.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQL)
			) {
			
			ps.setInt(1,CandidatId);
			
			int executeUpdate = ps.executeUpdate();
			
			if(executeUpdate ==1){
				System.out.println("Candidat is deleted with ID::"+CandidatId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Candidat> getAllCandidatInfo() {
		List<Candidat> CanList = new ArrayList<>();
		String SQL = "SELECT * FROM candidat";
		try(
				Connection connection = ConnectDB.getConnection();
				PreparedStatement ps = connection.prepareStatement(SQL)
			) {
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int canId = rs.getInt("id_candidat");
				String CanNom = rs.getString("nom");
				String CanPré = rs.getString("prénom");
				String CanMail = rs.getString("mail");
				String CanAddr = rs.getString("adresse");
				String CanVille = rs.getString("ville");
				String CanPays = rs.getString("pays");
				
				Candidat candidat = new Candidat();
				candidat.setNom(CanNom);
				candidat.setPrénom(CanPré);
				candidat.setVille(CanVille);
				candidat.setMail(CanMail);
				candidat.setAdresse(CanAddr);
				candidat.setId_candidat(canId);
				candidat.setPays(CanPays);
				
				CanList.add(candidat);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return CanList;
		
	}


}
