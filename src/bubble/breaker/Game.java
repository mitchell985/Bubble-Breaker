/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import java.util.Arrays;
import java.util.List;

/**
 * controls starting the game and what the players sees so helps a lot with
 * formatting
 *
 * @author mitchell
 */
public class Game {

	//final private static Scoreboard aScoreboard = new Scoreboard();
	private static Board aBoard;

	/**
	 * Unix-like console code to reset console colours
	 */
	public static final String RESET = "\u001B[0m";
	/**
	 * Unix-like console code for red
	 */
	public static final String RED = "\u001B[31m";
	/**
	 * Unix-like console code for green
	 */
	public static final String GREEN = "\u001B[32m";
	/**
	 * Unix-like console code for yellow
	 */
	public static final String YELLOW = "\u001B[33m";
	/**
	 * Unix-like console code for blue
	 */
	public static final String BLUE = "\u001B[34m";
	/**
	 * Unix-like console code for purple
	 */
	public static final String PURPLE = "\u001B[35m";

	/**
	 * creates a new game
	 */
	public static void startNewGame() {//new game - new player name - creates new score - prints a new board
		String aPlayer = newPlayer();
		if (!aPlayer.equals("-2")) {
			aBoard = new Board(new Score(aPlayer));
			gameLoop();
		}
	}

	/**
	 * creates a new player, and check the input of the user
	 *
	 * @return the name of the player
	 */
	private static String newPlayer() {
		String returnString = "";
		boolean loop = true;
		while (loop) {
			System.out.println("");
			returnString = Menu.stringMenu("Please enter a player name: ");
			if (returnString != null && !(returnString.equals("-1"))) {
				loop = false;
			}
		}
		System.out.println("The aim of this game is to remove as many of the Bubbles as possible.\nThis is done by lining up as many bubbles as possible to score as much as possible\n\nGood luck");
		return returnString;
	}

	/**
	 * main control between the game and user
	 */
	private static void gameLoop() {//alot of the board allows for dynamic generation, that trend could contine here by making the sizes public but it seems im going to hard-code it
		boolean loop = true;
		while (loop) {
			System.out.println("\n" + aBoard + "\n");
			String xy = Menu.stringMenu("Enter the XY postion of the Bubbles to select(A1-" + Board.parseIntToChar('A', Board.ROWS - 1) + Board.COLS + "/1A-" + Board.COLS + Board.parseIntToChar('A', Board.ROWS - 1) + "): ", 3);
			if (xy.equals("-2")) {
				loop = false;
			} else {
				int x = parseX(xy);
				char y = parseY(xy);
				y = Character.toUpperCase(y);//do this in parse y
				if (checkError(x, 1, 13)) {
					if (checkError((int) y, (int) 'A', (int) 'J')) {
						y -= 'A' - 1;//corrects value from A-J to numbers (removes 65 then one more to correct for 0)
						if (aBoard.click(x, y)) {
							loop = false;
						}
					}

				}
			}
		}
	}

	/**
	 * this transforms the XY string into the x integer, a number between 1 and
	 * COLS, placed at their the start of end of the string
	 *
	 * @param xy to change
	 * @return the x integer
	 */
	private static int parseX(String xy) {
		xy = xy.replaceAll("[^-?0-9]+", "");
		List xList = Arrays.asList(xy.trim().split(" "));

		if (!(xList.get(0).equals(""))) {
			return Integer.parseInt(xy);
		}
		return -1;//error
	}

	/**
	 * this transforms the XY string into the y char, a char between 1 and ROWS,
	 * placed at their the start of end of the string
	 *
	 * @param xy to change
	 * @return the y char to output
	 */
	private static char parseY(String xy) {
		xy = xy.toUpperCase();
		char mapSize = 'A' + Board.ROWS - 1;
		char[] yReturn;

		xy = xy.replaceAll("[^A-" + mapSize + "]+", "");//this gets rid of everthing but upper case letters between A and the max size of the map
		yReturn = xy.toCharArray();//this puts the string in to an array that can insure only one char is returned
		if (yReturn.length != 0) {
			return yReturn[0];
		}
		return 0;
	}

	/**
	 * checking parsing works correctly
	 *
	 * @param text to parse
	 * @return either the parsed number or a text
	 */
	public static Integer tryParseInt(String text) {
		if (text.toUpperCase().equals("E")) {//exit check
			return -2;//exit code
		}
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			return -1;//error code
		}
	}

	/**
	 * checks if passed value is inside a given numeric range, this one sets the
	 * default min to 1
	 *
	 * @param checkValue the value to check between min and max
	 * @param max the max possible value of checkValue
	 * @return true if the checkValue is inside min and max
	 */
	public static boolean checkError(int checkValue, int max) {
		if (max == 0) {
			return true;
		} else {
			return checkError(checkValue, 1, max);
		}
	}

	/**
	 * checks if passed value is inside a given numeric range
	 *
	 * @param checkValue the value to check between min and max
	 * @param min the min possible value of checkValue
	 * @param max the max possible value of checkValue
	 * @return true if the checkValue is inside min and max
	 */
	public static boolean checkError(int checkValue, int min, int max) {//needs to include min and max
		if (checkValue >= min && checkValue <= max) {
			return true;
		}
		System.out.println("Value is not within expected range");
		return false;
	}

	/**
	 * show the current scoreboard based on the save file
	 */
	public static void showScoreboard() {
		System.out.println("\n" + Scoreboard.printScoreboard());
	}

	/**
	 * a settings menu for changing things like the game colour mode
	 */
	public static void changeSettings() {
		boolean loop = true;
		while (loop) {
			int choose = Menu.intMenu("\nSettings\n--------", "Colour Mode: " + colourMode(), "Back");
			switch (choose) {
				case 1:
					changeColourMode();
					break;
				case 2:
					loop = false;
					break;
				case -2:
					loop = false;
					break;
			}
		}
	}

	/**
	 * a menu to change from full colour to black and white, and vice versa
	 */
	public static void changeColourMode() {
		boolean loop = true;
		while (loop) {
			int choose = Menu.intMenu("\nColour Mode: " + colourMode() + "\n-----------", "Full Colour (Linux or Mac Recommended)", "Black and White", "Back");
			switch (choose) {
				case 1:
					Scoreboard.setColour(true);
					break;
				case 2:
					Scoreboard.setColour(false);
					break;
				case 3:
					loop = false;
					break;
				case -2:
					loop = false;
					break;
			}
			Scoreboard.saveScore();
		}
	}

	/**
	 * finds what colour mode the program is in
	 *
	 * @return what colour mode the program is in 'Full Colour ' or 'Black and
	 * White '
	 */
	public static String colourMode() {
		if (Scoreboard.getColour()) {
			return "Full Colour";
		}
		return "Black and White";
	}

	/**
	 * for if only one space is needed
	 *
	 * @return the one space
	 */
	public static String formatSpaces() {
		return formatSpaces(1);
	}

	/**
	 * provides useful formatting functions
	 *
	 * @param spaces enter the number of spaces that need to looped
	 * @return the number of spaces requested
	 */
	public static String formatSpaces(int spaces) {
		String returnString = "";
		for (int i = 0; i < spaces; i++) {
			returnString += " ";
		}
		return returnString;
	}
}
