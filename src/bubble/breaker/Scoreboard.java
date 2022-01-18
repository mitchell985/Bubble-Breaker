/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * makes, loads, saves and controls a scoreboard
 *
 * @author mitchell
 */
public class Scoreboard {

	//first question how does the score work
	//bubbles (b), score (s)
	//2 bubbles = 2
	//3 bubbles = 6
	//4 bubbles = 12
	//s = b^2-b
	//make one static cos only one scoreboard?
	private static boolean colour = false;
	private static ArrayList<Score> ScoreboardList = loadScore();
	private final static String SCORELOCATION = "score.breaker";

	/**
	 * sets the colour
	 *
	 * @param colour the colour state needed
	 */
	public static void setColour(boolean colour) {
		Scoreboard.colour = colour;
	}

	/**
	 * get the colour
	 *
	 * @return the current colour
	 */
	public static boolean getColour() {
		return colour;
	}

	/**
	 * sets the scoreboard on this to an updated score from addToScoreboard
	 *
	 * @param aScore to be added to the scoreboard
	 */
	public static void addToCUIScoreboard(Score aScore) {
		Scoreboard.ScoreboardList = addToScoreboard(aScore, Scoreboard.ScoreboardList);
	}

	/**
	 * sorts and orders and adds a new score to a Scoreboard
	 *
	 * @param aScore a score to be saved
	 * @param aScoreboard that the score needs adding too
	 * @return the ordered ScoreboardList with the new score
	 */
	public static ArrayList<Score> addToScoreboard(Score aScore, ArrayList<Score> aScoreboard) {//make more general
		if (aScoreboard.isEmpty()) {
			aScoreboard.add(aScore);//this needs to be ordered
		} else {
			//ordering the scores
			for (int i = 0; i < aScoreboard.size(); i++) {//it ends, there is always a need to loop but size is no problem, the if is the solution
				if (aScoreboard.get(i).getScore() <= aScore.getScore()) {//this current score less then or equal to the score to add
					aScoreboard.add(i, aScore);//add the current score at position i moving the whole scoreboard down one
					i = aScoreboard.size();//force loop exit
				}
			}
			if (!aScoreboard.contains(aScore)) {//adding to the end of the list
				aScoreboard.add(aScore);
			}
			if (aScoreboard.size() > 10) {//trims the size of the board if it is over 10
				aScoreboard.remove(aScoreboard.size() - 1);
			}
		}
		return aScoreboard;
	}

	/**
	 * loads the score from a file in to an ArrayList
	 */
	private static ArrayList<Score> loadScore() {//private? return a score to print? load and print?
		ArrayList<Score> loadScoreboard = new ArrayList<>();
		try {//load 
			FileReader fr = new FileReader(SCORELOCATION);
			//try {
			BufferedReader inputStream;
			inputStream = new BufferedReader(fr);
			String line = inputStream.readLine();
			while (line != null) {
				String name = "";//this is here for being added to the array
				int score = 0;//this too
				if (line.contains("Colour: ")) {
					colour = Boolean.parseBoolean(line.replace("Colour: ", ""));
					line = inputStream.readLine();
				}
				if (line.contains("Name: ")) {
					name = line.replace("Name: ", "");
					line = inputStream.readLine();
				}
				if (line.contains("Score: ")) {
					score = Integer.parseInt(line.replace("Score: ", ""));//try...	
					line = inputStream.readLine();
					loadScoreboard.add(new Score(name, score));
				}
			}
			inputStream.close();
			//}
		} catch (FileNotFoundException e) {//add a gui flag to stop creation in gui mode
			saveScore();
		} catch (IOException e) {
			System.out.println("Error reading from file ");
		} catch (NullPointerException e) {
			//System.out.println("No Scores to load");
		}
		return loadScoreboard;
	}

	/**
	 * saves the score from an ArrayList to a file
	 */
	public static void saveScore() {
		try (PrintWriter outputStream = new PrintWriter(new FileOutputStream(SCORELOCATION))) {
			outputStream.flush();
			outputStream.println("Colour: " + colour);
			Iterator<Score> it = ScoreboardList.iterator();
			while (it.hasNext()) {
				Score saving = it.next();
				outputStream.println("Name: " + saving.getName());//xml is better...
				outputStream.println("Score: " + saving.getScore());
			}
			outputStream.flush();
			outputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (NullPointerException e) {//...stops things from breaking
			//System.out.println("No Scores to load");
		}
	}

	/**
	 * prints a list of the current Highscores
	 *
	 * @return a list of the current scores in the correct format to print
	 */
	public static String printScoreboard() {
		String returnString = "";
		returnString += "Highscores\n";
		returnString += "----------\n";//dynamically make a box around the highscores? and limit name size
		if (ScoreboardList.isEmpty()) {
			returnString += "No Scores play a game";
		} else {
			Iterator<Score> it = ScoreboardList.iterator();
			while (it.hasNext()) {
				Score print = it.next();
				returnString += ("Name: " + print.getName() + "\n");
				returnString += ("Score: " + print.getScore() + "\n");
			}
		}

		return returnString;
	}
}
