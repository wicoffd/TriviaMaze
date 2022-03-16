package Model;

import org.sqlite.SQLiteDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLFillTable {
    private static void createTable(Connection conn) throws SQLException {
        String createTableSql = "" +
                "CREATE TABLE questions "+
                "( " +
                "answer varchar(255), " +
                "question varchar(255) " +
                "); "+
                "";
        Statement statement = conn.createStatement();
        statement.execute(createTableSql);
    }
    private static void newShortAnswer(SQLiteDataSource ds, String question, String answer ) {
        String query = "INSERT INTO questions ( TYPE, QUESTION, ANSWER ) VALUES ( 'Short Answer', '" +
                question + "', '" + answer + "' )";
        try ( Connection conn = ds.getConnection();Statement statement = conn.createStatement(); ) {
            statement.executeUpdate(query);
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
    private static void queryTable(Connection conn, String question, String answer) throws SQLException {
        String selectSQL = "SELECT * from " + question;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(selectSQL);
        resultSet.getShort("question");
    }
}
