package Model;

import java.sql.*;
import java.time.LocalDate;

public class ConnectDB {
	private static final String DB_DRIVER="org.postgresql.Driver";
    private static final String DB_USERNAME="postgres";
    private static final String DB_PASSWORD="1235";
    private static final String DB_URL ="jdbc:postgresql://localhost:5432/Brief9";

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
public static void printSQLException(SQLException ex) {
	for (Throwable e : ex) {
		if (e instanceof SQLException) {
			e.printStackTrace(System.err);
			System.err.println("SQLState: " + ((SQLException) e).getSQLState());
			System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
			System.err.println("Message: " + e.getMessage());
			Throwable t = ex.getCause();
			while (t != null) {
				System.out.println("Cause: " + t);
				t = t.getCause();
			}
		}
	}
}

public static Date getSQLDate(LocalDate date) {
	return java.sql.Date.valueOf(date);
}

public static LocalDate getUtilDate(Date sqlDate) {
	return sqlDate.toLocalDate();
}
}
