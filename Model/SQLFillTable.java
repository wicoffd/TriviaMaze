package Model;

import java.sql.*;
import java.util.ArrayList;

import org.sqlite.SQLiteDataSource;

public class SQLFillTable {
    public static ArrayList<Question> questionsList;
    //public ArrayList<Question> questionsList;
    public SQLFillTable() {
        questionsList = new ArrayList<Question>();
    }
    public static void setUp() {
        SQLiteDataSource dataSource = getDataSource("jdbc:sqlite:D:\\Documents\\My Games\\Trivia\\src\\db\\triviaQuestions.db");
        populateTable(dataSource);

        newShortAnswer(dataSource, "What is the color of night? 1 word.", "sanguine");
        newTrueFalse(dataSource, "Is Blizzard a trustworthy company?", "false");
        newShortAnswer(dataSource, "Who sings, This is America?", "childish gambino");
        newShortAnswer(dataSource, "What song contains the lyric: Never going to say goodbye, never going to tell a lie. 5 words", "never gonna give you up");
        newShortAnswer(dataSource, "What tree has pink petals that bloom in spring/near march? 3 words.", "american cherry blossom");
        newShortAnswer(dataSource, "How does America make its money? 1 word.", "war");
        ArrayList<Question> questions = createQuestionList(dataSource);
        setQuestionsList(questions);
    }

    private static SQLiteDataSource getDataSource(String url) {
        SQLiteDataSource ds = null;

        try {
            ds = new SQLiteDataSource();
            ds.setUrl(url);
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }

        return ds;
    }
    private static void populateTable(SQLiteDataSource ds) {
        String dropTable = "DROP TABLE IF EXISTS questions;";
        String query = "CREATE TABLE IF NOT EXISTS questions ( " +
                //"TYPE TEXT NOT NULL, " +
                "QUESTION TEXT NOT NULL, " +
                "ANSWER TEXT NOT NULL " +
                ")";
        try ( Connection conn = ds.getConnection();
              Statement statement = conn.createStatement(); ) {
            statement.executeUpdate( dropTable );
            statement.executeUpdate( query );
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }
    private static void newTrueFalse(SQLiteDataSource ds, String q, String a) {
        String query = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '" +
                q + "', '" + a + "' )";
        try ( Connection conn = ds.getConnection();
              Statement stmt = conn.createStatement(); ) {
            stmt.executeUpdate( query );
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }

    private static void newShortAnswer(SQLiteDataSource theDS, String q, String a) {
        String query = "INSERT INTO questions ( QUESTION, ANSWER ) VALUES ( '" +
                q + "', '" + a + "' )";
        try ( Connection conn = theDS.getConnection();
              Statement statement = conn.createStatement(); ) {
            statement.executeUpdate( query );
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }
    }

    public static ArrayList<Question> createQuestionList(SQLiteDataSource ds) {
        ArrayList<Question> result = new ArrayList<Question>();
        String query = "SELECT * FROM questions";
        try ( Connection conn = ds.getConnection();
              Statement statement = conn.createStatement(); ) {
            ResultSet rs = statement.executeQuery(query);
            while ( rs.next() ) {
                String question = rs.getString( "QUESTION" );
                String answer = rs.getString( "ANSWER" );
                Question q = new Question(question, answer);
                result.add(q);
            }
        } catch ( SQLException e ) {
            e.printStackTrace();
            System.exit( 0 );
        }

        return result;
    }
    public static void setQuestionsList(ArrayList<Question> theQuestionList) {
        questionsList = theQuestionList;
    }

}
