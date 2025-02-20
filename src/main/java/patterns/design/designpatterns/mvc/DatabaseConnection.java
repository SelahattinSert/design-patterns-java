package patterns.design.designpatterns.mvc;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        String createDB = "CREATE DATABASE IF NOT EXISTS student_db";
        String useDB = "USE student_db";
        String createTable = """
                CREATE TABLE IF NOT EXISTS students (
                student_id VARCHAR(20) PRIMARY KEY,
                first_name VARCHAR(20) NOT NULL,
                last_name VARCHAR(20) NOT NULL,
                email VARCHAR(100) UNIQUE NOT NULL,
                phone VARCHAR(20),
                date_of_birth DATE,
                gender VARCHAR(20),
                address TEXT,
                course VARCHAR(50),
                semester VARCHAR(20),
                registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                )
                """;

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement()) {
            stmt.execute(createDB);
            stmt.execute(useDB);
            stmt.execute(createTable);
            System.out.println("Database created successfully");
        }
        catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showConfirmDialog(null,"Database could not be created: "
                    + e.getMessage(),"Database Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
