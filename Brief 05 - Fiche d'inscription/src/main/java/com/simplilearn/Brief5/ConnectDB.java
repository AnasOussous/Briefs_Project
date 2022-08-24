package com.simplilearn.Brief5;
import java.sql.*;



public class ConnectDB {
	
	 
		private static final String DB_DRIVER="org.postgresql.Driver";
		private static final String DB_USERNAME="postgres";
		private static final String DB_PASSWORD="1235";
		private static final String DB_URL ="jdbc:postgresql://localhost:5432/Brief5";
		
		private static Connection connection = null;
		static{
			try {
				Class.forName(DB_DRIVER);
				connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection(){
			return connection;
		}
}
