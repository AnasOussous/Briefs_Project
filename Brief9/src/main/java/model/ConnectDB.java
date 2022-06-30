package model;

import java.sql.*;



public class ConnectDB {
	
    private static final String DB_DRIVER="org.postgresql.Driver";
    private static final String DB_USERNAME="postgres";
    private static final String DB_PASSWORD="1235";
    private static final String DB_URL ="jdbc:postgresql://localhost:5432/Brief8";

    static Connection conn =null;
public ConnectDB(){

}
public static Connection connection(){
    Connection conn =null;
    try {
        if (conn == null) {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }
    }catch (SQLException | ClassNotFoundException e){
        System.out.println(e);
    }
    return conn;
}
}
