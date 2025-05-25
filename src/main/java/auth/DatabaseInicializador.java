package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseInicializador {
    private static final String DB_URL = "jdbc:sqlite:usuarios.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }
}
