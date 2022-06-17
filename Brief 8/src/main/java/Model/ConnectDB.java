package Model;

import javafx.scene.control.Alert;

import java.sql.*;


public class ConnectDB {
    private static final String DB_DRIVER="org.postgresql.Driver";
    private static final String DB_USERNAME="postgres";
    private static final String DB_PASSWORD="1235";
    private static final String DB_URL ="jdbc:postgresql://localhost:5432/Brief5";

    static Connection conn =null;

    public static Connection connection(){
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        }catch (SQLException | ClassNotFoundException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Connection Error");
            alert.setHeaderText("Connection Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        return conn;
    }

}
