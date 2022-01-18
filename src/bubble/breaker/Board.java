/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This object Creates a new board then controls all actions on the board
 *
 * @author mitchell
 */
public class Board { //The Board is going to be 13x10, only ever one board change to static?

	/**
	 * number of x columns on the board
	 */
	final public static int COLS = 13;
	/**
	 * number of y rows on the board
	 */
	final public static int ROWS = 10;

	final private Bubble[][] BubbleMap = new Bubble[COLS][ROWS];//The Board
	private final Score aScore;

	/**
	 * insures a new score is added to a game (this score is saved to a file and
	 * use in the CUI version of the game)
	 *
	 * @param aScore takes a Score that will be linked to this board for this game
	 */
	public Board(Score aScore) {
		genBoard();
		this.aScore = aScore;
	}

	/**
	 * This method simply generates the playing board
	 */
	private void genBoard() {
		for (int x = 0; x < COLS; x++) {
			for (int y = 0; y < ROWS; y++) {
				BubbleMap[x][y] = new Bubble(x, y);
			}
		}

		if (checkEoG()) {//highly unlikey to happen
			genBoard();
		}
	}

	/**
	 * changes coordinates for 1-13, A-J to a format that the array can 0-12,
	 * 0-9, and ends the game if needed
	 *
	 * @param x the x location of the bubble on the BubbleMap
	 * @param y the y location of the bubble on the BubbleMap
	 * @return the boolean of if its is and end of the game or not
	 */
	public boolean click(int x, char y) {
		if (clickBubble(x - 1, y - 1)) {
			System.out.println("Game Over you Scored: " + aScore.getScore());
			System.out.println("\n" + toString());
			Scoreboard.addToCUIScoreboard(aScore);
			Scoreboard.saveScore();
			return true;
		}
		return false;
	}

	/**
	 * This is the public call for selecting a group of bubble to remove its
	 * also used to control's most of the user interaction with the board
	 *
	 * @param x the x location of the bubble on the BubbleMap
	 * @param y the y location of the bubble on the BubbleMap
	 * @return the boolean of if its is and end of the game or not
	 */
	public boolean clickBubble(int x, int y) {
		if (BubbleMap[x][y] == null) {
			System.out.println("No Bubble Selected\n");
		} else {
			ArrayList<Bubble> clearBubbles = new ArrayList<>();//an array to store the selected bubbles
			searchBubbles(x, y, clearBubbles);
			//printing collected the bubbles
			Iterator<Bubble> it = clearBubbles.iterator();
			if (clearBubbles.size() < 2) {//if the bubble is less then 2
				System.out.println("Not Enough Bubbles");
			} else {
				System.out.println("Color: " + numberToName(BubbleMap[x][y]));
				while (it.hasNext()) {
					Bubble aBubble = it.next();//cycling through the selected bubbles
					BubbleMap[aBubble.getX()][aBubble.getY()] = null;//deleting the moved, selected bubbles
				}
				gravityAndShove();//cleaning the map up
			}
			System.out.println("Size: " + clearBubbles.size());
			System.out.println("Score: " + (int) aScore.setScore(clearBubbles.size()));
		}
		return checkEoG();
	}

	/**
	 * does some pre-req for searching for bubbles to clean up code in other
	 * functions, before going into recursion
	 *
	 * @param x the x location of the bubble on the BubbleMap
	 * @param y the y location of the bubble on the BubbleMap
	 * @param clearBubbles the ArrayList that will list all the bubbles in the
	 * same colour and location to be cleared
	 */
	private void searchBubbles(int x, int y, ArrayList<Bubble> clearBubbles) {
		clearBubbles.add(BubbleMap[x][y]);
		searchFourDirections(x, y, clearBubbles);
	}

	/**
	 * checks all 4 directions for the next bubble
	 *
	 * @param x the x location of the bubble on the BubbleMap
	 * @param y the y location of the bubble on the BubbleMap
	 * @param clearBubbles the ArrayList that will list all the bubbles in the
	 * same colour and location to be cleared
	 */
	private void searchFourDirections(int x, int y, ArrayList<Bubble> clearBubbles) {//could remove the direction searched from to save processing power
		findBubble(x - 1, y, clearBubbles);//top
		findBubble(x, y + 1, clearBubbles);//right
		findBubble(x + 1, y, clearBubbles);//bottom
		findBubble(x, y - 1, clearBubbles);//left
	}

	/**
	 * recursively checks for bubbles that match the clicked bubble in colour,
	 * without being out of bounds of the BubbleMap array, that the current
	 * bubble being searched is not null and if the Bubble is already in the
	 * ArrayList to be cleared
	 *
	 * @param x the x location of the bubble on the BubbleMap
	 * @param y the y location of the bubble on the BubbleMap
	 * @param clearBubbles the ArrayList that will list all the bubbles in the
	 * same colour and location to be cleared
	 */
	private void findBubble(int x, int y, ArrayList<Bubble> clearBubbles) {//move to click bubble? as not longer recusive
		if (!(x < 0 || x >= COLS || y < 0 || y >= ROWS)) {//edge cases
			if (BubbleMap[x][y] != null) {//null check
				if (!(clearBubbles.contains(BubbleMap[x][y]))) {//clearBubbles array check
					if (clearBubbles.get(0).getColour() == BubbleMap[x][y].getColour()) {//colour check
						clearBubbles.add(BubbleMap[x][y]);
						searchFourDirections(x, y, clearBubbles);// remove me?
					}//colour check
				}//clearbubbles array check
			}//null check
		}//edge check
	}

	/**
	 * check if the game is at an end
	 *
	 * @return if the game has ended
	 */
	private boolean checkEoG() {//can use searchFourDirections?
		for (int x = 0; x < BubbleMap.length; x++) {
			for (int y = 0; y < BubbleMap[x].length; y++) {
				if (BubbleMap[x][y] != null) {//null check
					ArrayList<Bubble> EoG = new ArrayList<>();
					searchBubbles(x, y, EoG);
					if (EoG.size() >= 2) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Pulls the bubbles to the ground(down) and then across (left).
	 * Okay this is not elegant but it works well.
	 */
	private void gravityAndShove() {
		gravity();
		shove();
	}

	/**
	 * moves all the bubbles that need to be moved down first
	 */
	private void gravity() {
		for (int x = 0; x < BubbleMap.length; x++) {
			for (int y = 0; y < BubbleMap[x].length; y++) {
				if (BubbleMap[x][y] != null) {//current null check
					if (x <= COLS - 2) {//border check
						if (BubbleMap[x + 1][y] == null) {//up null check,
							BubbleMap[x][y].setBubbleXY(x + 1, y);
							BubbleMap[x + 1][y] = BubbleMap[x][y];
							BubbleMap[x][y] = null;
							gravity();
						}
					}
				}
			}
		}
	}

	/**
	 * then across, this insures one thing happens before the other
	 */
	private void shove() {
		for (int x = 0; x < BubbleMap.length; x++) {
			for (int y = 0; y < BubbleMap[x].length; y++) {
				if (BubbleMap[x][y] != null) {
					if (y > 0) {//border check
						if (BubbleMap[x][y - 1] == null) {//right null check
							BubbleMap[x][y].setBubbleXY(x, y - 1);
							BubbleMap[x][y - 1] = BubbleMap[x][y];
							BubbleMap[x][y] = null;
							shove();
						}
					}
				}
			}
		}
	}

	/**
	 * creates a string with the background colour required
	 *
	 * @param findColour the Bubble that needs a colour String made
	 * @return an o with the correct background colour
	 */
	private static String numberToColour(Bubble findColour) {
		String returnString = "";
		switch (findColour.getColour()) {
			case 1://Red
				returnString += Game.RED;
				break;
			case 2://Green
				returnString += Game.GREEN;
				break;
			case 3://Blue
				returnString += Game.BLUE;
				break;
			case 4://Yellow
				returnString += Game.YELLOW;
				break;
			case 5://Purple
				returnString += Game.PURPLE;
				break;
		}
		return returnString += ("O" + Game.formatSpaces() + Game.RESET);
	}

	/**
	 * to be used in black and white mode
	 *
	 * @param findLetter the Bubble that needs Letter assigned to it
	 * @return a letter to represent a colour
	 */
	private static String numberToLetter(Bubble findLetter) {
		String returnString = "";
		switch (findLetter.getColour()) {
			case 1://Red
				returnString += "R";
				break;
			case 2://Green
				returnString += "G";
				break;
			case 3://Blue
				returnString += "B";
				break;
			case 4://Yellow
				returnString += "Y";
				break;
			case 5://Purple
				returnString += "P";
				break;
		}
		return returnString += Game.formatSpaces();
	}

	/**
	 * changes a number to a name
	 *
	 * @param findLetter the Bubble that needs naming
	 * @return the String of the Bubbles Colour
	 */
	private static String numberToName(Bubble findLetter) {
		String returnString = "";
		switch (findLetter.getColour()) {
			case 1://Red
				returnString += "Red";
				break;
			case 2://Green
				returnString += "Green";
				break;
			case 3://Blue
				returnString += "Blue";
				break;
			case 4://Yellow
				returnString += "Yellow";
				break;
			case 5://Purple
				returnString += "Purple";
				break;
		}
		return returnString += Game.formatSpaces();
	}

	/**
	 * changes an integer to a char, e.g ('A',0) = A
	 *
	 * @param start the char to start from
	 * @param number the number to convert
	 * @return the resulting char
	 */
	public static char parseIntToChar(char start, int number) {
		return (char) (start + (int) number);
	}

	/**
	 * is creates a string of the current layout of the board
	 *
	 * @return a view of the current board
	 */
	@Override
	public String toString() {//rewrite the print fuction previous one to messey, and try add colour
		String returnString = aScore.toString() + "\n";
		int xNumbers = 0;
		//x direction labeling
		for (Bubble[] xBubble : BubbleMap) {
			xNumbers++;
			if (xNumbers < 10) {
				returnString += xNumbers + Game.formatSpaces();
			} else {
				returnString += xNumbers;
			}
			returnString += "|";

			for (Bubble xyBubble : xBubble) {
				if (xyBubble == null) {//check if bubble has not been deleted
					returnString += Game.formatSpaces(2);
				} else {
					if (Scoreboard.getColour()) {
						returnString += numberToColour(xyBubble);
					} else {
						returnString += numberToLetter(xyBubble);
					}
				}
			}
			returnString += "\n";
		}
		//y direction labeling
		returnString += Game.formatSpaces(3);
		for (int i = 0; i < ROWS; i++) {
			returnString += "-" + Game.formatSpaces();
		}
		returnString += "\n";
		returnString += Game.formatSpaces(3);
		//char aLetter = 'A';
		for (int i = 0; i < ROWS; i++) {
			returnString += parseIntToChar('A', i) + Game.formatSpaces();
		}
		returnString += "\n";

		return returnString;
	}

	/**
	 * used for printing to the GUI interface
	 *
	 * @return the whole board
	 */
	public Bubble[][] getBoard() {
		return BubbleMap;
	}
}
