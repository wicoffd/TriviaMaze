package Model;

import org.sqlite.SQLiteDataSource;
import java.sql.*;

public class SQLDatabase {
    static String fileName = "test.db";

    public static void setUp() {
        String url = "jdbc:sqlite:D:\\Documents\\My Games\\Trivia\\src\\db\\SqliteJavaDB.db" + fileName;
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //SQLiteDataSource dataSource = establishConnection()
    }

    public static void main(String[] args) {
        setUp();
    }

}
