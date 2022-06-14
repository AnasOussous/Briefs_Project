package com.example.brief7;

import javafx.scene.control.Alert;

import java.sql.*;

public class ConnectDB {
    private static final String DB_DRIVER="org.postgresql.Driver";
    private static final String DB_USERNAME="postgres";
    private static final String DB_PASSWORD="1235";
    private static final String DB_URL ="jdbc:postgresql://localhost:5432/Brief5";


    public static Connection connection() {

        try {

            return (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);


        }catch(SQLException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connection Error");
            alert.setHeaderText("Connection Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return null;
    }


}
