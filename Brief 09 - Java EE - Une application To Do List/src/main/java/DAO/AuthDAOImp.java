package DAO;

import Model.ConnectDB;
import Model.User;
import java.sql.SQLException;

import java.sql.*;

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
	public int SignUp(User user) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users"
				+ "  (Prenom_User, Name_User, username, Psw) VALUES "
				+ " (?, ?, ?, ?);";

		int result = 0;
		try (Connection connection = ConnectDB.connection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getPrenom_User());
			preparedStatement.setString(2, user.getName_User());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPsw());

			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// process sql exception
			ConnectDB.printSQLException(e);
		}
		return result;
	}

}
