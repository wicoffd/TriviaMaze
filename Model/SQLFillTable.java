package Model;

import org.sqlite.SQLiteDataSource;

import java.sql.*;

public class SQLFillTable {
    private static SQLiteDataSource ds = new SQLiteDataSource();
    private static Connection connect = null;
    private static Statement state = null;
    private static void SQLFillTable() throws SQLException {
        String dropTable = "IF EXISTS questions DROP TABLE questions;";
        String createTableSql = "" +
                "CREATE TABLE IF NOT EXISTS questions ("+
                "answer varchar(255), " +
                "question varchar(255) " +
                "); ";
        try ( Statement statement = connect.createStatement(); ) {

            state = statement;
            statement.execute(createTableSql);
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }

    }
    private static void newShortAnswer(SQLiteDataSource ds, String question, String answer ) throws SQLException {
        String query = "INSERT INTO questions ( TYPE, QUESTION, ANSWER ) VALUES ( 'Short Answer', '" +
                question + "', '" + answer + "' )";

        state.executeUpdate(query);

    }
    private static short queryTable(Connection conn, String question) throws SQLException {
        String selectSQL = "SELECT * from " + question;
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(selectSQL);
        resultSet.getShort("question");
        short answer;
        return answer = resultSet.getShort("answer");
    }
    private static Connection setUp(String fileName) {

        String url = "jdbc:sqlite:D:\\Documents\\My Games\\Trivia\\src\\db\\" + fileName;
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                return conn;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //SQLiteDataSource dataSource = establishConnection()
        return null;
    }
    public void fillTable() throws SQLException {
        newShortAnswer(ds,"does he look like a bitch", "what");
        try {
            System.out.println(queryTable(connect, "does he look like a bitch"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws SQLException {
        connect = setUp("test.db");
        SQLFillTable fill = new SQLFillTable();
        fill.fillTable();
    }
}
