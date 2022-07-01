package DAO;

import java.sql.*;
import java.sql.ResultSet;

import Model.ConnectDB;
import Model.User;

public class AuthDAOImp implements AuthDAO{
	public User user = new User();

	@Override
	public boolean SignIn(String username, String psw) {
		String SQL = "Select * From users WHERE username=? and psw=?";
        ResultSet rs = null;
        boolean login = false;
        try {
            Connection connection = ConnectDB.connection();
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1,username);
            ps.setString(2,psw);

            rs = ps.executeQuery();

            login = rs.next();

//            while (rs.next()){
//            	user.setName_User(rs.getString(2));
//            	user.setPrenom_User(rs.getString(3));
//            	user.setUsername(rs.getString(4));
//            	user.setPsw(rs.getString(5));
//            	//System.out.println("Not Found");
//
//            }

            }catch(Exception e){
                System.out.println(e);
            }
		return login;
	}

	@Override
	public void SignUp(User user) {
		String SQL = "INSERT INTO users(name_User,prenom_User,username,psw) VALUES(?,?,?,?)";
        try (
                Connection connection = ConnectDB.connection();
                PreparedStatement ps =connection.prepareStatement(SQL)
        ){
            ps.setString(1, user.getName_User());
            ps.setString(2, user.getPrenom_User());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPsw());

            int executeUpdate = ps.executeUpdate();

            if (executeUpdate == 1){
                System.out.println("iuqe");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}
	
}