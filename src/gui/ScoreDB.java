/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bubble.breaker.Score;
import bubble.breaker.Scoreboard;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * use me to control the database
 *
 * @author mitchell
 */
public class ScoreDB {

	final private static String URL = "jdbc:derby:ScoreDB; create=true";
	final private static String USER = "root";
	final private static String PASS = "toor";

	private static Connection conn;
	private static Statement sql_input;
	private static ArrayList<Score> ScoreboardList;

	/**
	 * connects and or creates the Java Database, holding the score
	 */
	static void connectToDB(){
		try {
			//Open a connection
			conn = DriverManager.getConnection(URL, USER, PASS);

			//Execute a query
			sql_input = conn.createStatement();

			//creates the standard table for scoring
			createScoresTable();

			//Gives the output to the console that everythings works because databases are hard
			successfulDB();
		} catch (SQLException ex) {
			errorSQLHandler(ex);
		}
		//Loads the newly connected database into the Scoreboard Array
		ScoreboardList = loadScore();
	}

	/**
	 * generates the standard table in the database
	 *
	 * @throws SQLException if anything goes wrong with the SQL
	 */
	private static void createScoresTable() throws SQLException {
		//Writing the create table, this is tidier
		String sql = "CREATE TABLE SCORES "
				+ "("
				+ "ID INTEGER not null,"
				+ "Name VARCHAR(20) not null,"
				+ "Score INTEGER not null,"
				+ "primary key (ID)"
				+ ")";

		//Execute the previous statement
		sql_input.executeUpdate(sql);
	}

	/**
	 * deletes the Scores table on the database
	 *
	 * @throws SQLException if anything goes wrong with the SQL
	 */
	private static void deleteScoresTable() throws SQLException {
		String sql = "DROP TABLE SCORES";

		sql_input.executeUpdate(sql);
	}

	/**
	 * adds an item to the score DB
	 *
	 * @param index used as the primary key in the database
	 * @param name of the user that scored the score
	 * @param score the score of the user
	 * @throws SQLException if anything goes wrong with the SQL
	 */
	private static void addToScoresTable(int index, String name, int score) throws SQLException {//sql injection...?
		String sql = "INSERT INTO SCORES VALUES (" + index + ", '" + name + "', " + score + ")";

		sql_input.executeUpdate(sql);
	}

	/**
	 * useful when outside this object
	 *
	 * @return the Scoreboard array
	 */
	static ArrayList<Score> getScoreboard() {
		return ScoreboardList;
	}

	/**
	 * loads the score information from the database, in to the scoreboard array
	 *
	 * @return a Scoreboard array full of the Score information from the
	 * Database
	 */
	private static ArrayList<Score> loadScore() {
		ArrayList<Score> returnScoreboard = new ArrayList<>();
		String sql = "SELECT Name, Score FROM Scores";

		try {
			//Getting a Set of Results, funny that...
			ResultSet results = sql_input.executeQuery(sql);

			while (results.next()) {//test me with a blank DB
				String Name = results.getString(1);
				int Score = results.getInt(2);
				returnScoreboard.add(new Score(Name, Score));
			}
			System.out.println("Database infomation loaded");
		} catch (SQLException ex) {
			errorSQLHandler(ex);
		}

		return returnScoreboard;
	}

	/**
	 * saves a new score to the database
	 *
	 * @param aScore the new score to save to the database
	 */
	public static void saveToDatabase(Score aScore) {
		ScoreboardList = Scoreboard.addToScoreboard(aScore, ScoreboardList);//returns me alovely ordered scoreboard with my new score in it yay

		try {
			//Refreshing the Scores Table on the DB
			deleteScoresTable();
			createScoresTable();

			//Adding the Scoreboard list to the Database
			for (int index = 0; index < ScoreboardList.size(); index++) {//messey...
				Score iScore = ScoreboardList.get(index);
				String name = iScore.getName();
				int score = iScore.getScore();

				addToScoresTable(index, name, score);
			}
		} catch (SQLException ex) {
			errorSQLHandler(ex);
		}
		System.out.println("Database updated");
		//ScoreboardList = loadScore();//not really needed but checks things are working
	}

	/**
	 * one method to control what happens if a SQLException happens
	 *
	 * @param ex the Exception
	 */
	private static void errorSQLHandler(SQLException ex) {
		if (ex.getSQLState().equals("X0Y32")) {//As catch is not for the Table exists
			successfulDB();
		} else {
			System.err.println("SQL Broke: " + ex.getMessage() + "\nError Code: " + ex.getSQLState());
			SQLException exc = ex.getNextException();
			if (exc != null) {
				System.err.println(exc);
			}
		}
	}

	/**
	 * provides a nice print out that the DB is working
	 */
	public static void successfulDB() {
		System.out.println("ScoreDB Connected, and Created");
	}
}
