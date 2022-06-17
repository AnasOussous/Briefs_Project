package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthDAOImp implements AuthDAO{
    @Override
    public void SignIn(String username,String psw) {
        String SQL = "Select * From users WHERE username=? and psw=?";
        ResultSet rs = null;
        try {
            Connection connection = ConnectDB.connection();
            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1,username);
            ps.setString(1,psw);

            int executeUpdate = ps.executeUpdate();


            if (executeUpdate == 1){}
        }catch (Exception e){

        }
    }
}
