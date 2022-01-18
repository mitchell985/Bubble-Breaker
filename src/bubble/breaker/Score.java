/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

/**
 * makes, loads, saves and controls a scoreboard
 *
 * @author mitchell
 */
public class Score {

	private String name = "";
	private int score = 0;

	/**
	 * creates a score
	 *
	 * @param name of the player linked to the score
	 */
	public Score(String name) {
		this.name = name;
	}

	/**
	 * using in loading the score from the save file
	 *
	 * @param name of the player saved
	 * @param score of the player saved
	 */
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}

	/**
	 * sets a name for the current player
	 *
	 * @param name of the player
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets the name of the current player in this object
	 *
	 * @return name of the current player
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * calculates the score based on if b = Number of Bubbles b^2-b
	 *
	 * @param numberOfBubbles size of the selected bubbles to delete
	 * @return what the score is going to be increased by
	 */
	public double setScore(int numberOfBubbles) {
		score += Math.pow(numberOfBubbles, 2) - numberOfBubbles;
		return Math.pow(numberOfBubbles, 2) - numberOfBubbles;
	}

	/**
	 * gets the score
	 *
	 * @return the current score of the object
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * prints the current score in format Score: 0, if score 0
	 *
	 * @return prints the current score
	 */
	@Override
	public String toString() {
		return "Score: " + score;
	}
}
