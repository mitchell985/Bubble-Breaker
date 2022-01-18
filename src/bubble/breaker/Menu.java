/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import java.util.Scanner;

/**
 * trying to make controlling user input easier
 *
 * @author mitchell
 */
public class Menu {

	/**
	 * this will consist of a title, string array for a list.
	 *
	 * @param title the title of the menu (can use just this)
	 * @param list a list of list for the menu
	 */
	private static void printMenu(String title, String... list) {
		String print = title;

		if (list != null) {
			for (int i = 0; i <= list.length - 1; i++) {
				print += String.format("\n%d) %s ", i + 1, list[i]);
			}
		}
		System.out.println(print);
	}

	/**
	 * generates a menu that accepts an integer input to control the menu
	 *
	 * @param title what the menu is titled
	 * @param list of items in the menu
	 * @return the integer selected in the menu
	 */
	public static int intMenu(String title, String... list) {//setting a limit(up to number.. or list limit)
		Scanner s;
		s = new Scanner(System.in);
		//boolean loop = true;
		int returnInt;
		String toInt;

		//while (loop) {//this is error looping, could just throw -1 as error
		printMenu(title, list);
		toInt = s.nextLine();

		returnInt = Game.tryParseInt(toInt);
		if (returnInt != -2) {
			Game.checkError(returnInt, list.length);//this just tells the user they stuffed up
		}
		return returnInt;
	}

	/**
	 * a default method for the stringMenu with a limit of 15
	 *
	 * @param title for the menu
	 * @return a string of the menu
	 */
	public static String stringMenu(String title) {
		return stringMenu(title, 15);
	}

	/**
	 * creates a menu with a list that'll return a String
	 *
	 * @param title for the menu
	 * @param limit the limit to the size of the input of the menu
	 * @return a string of the menu
	 */
	public static String stringMenu(String title, int limit) {//only return if good else loop
		Scanner s;
		s = new Scanner(System.in);
		String returnString;

		printMenu(title);
		returnString = s.nextLine();
		if (returnString.length() == 0) {
			System.out.println("No input enter a Name or type E to exit");
			returnString = "-1";
		}
		if (returnString.length() > limit) {
			System.out.println("This input can only be " + limit + " letters long");
			//returnString = null;
			returnString = "-1";//error code
		}
		if (returnString.toUpperCase().equals("E")) {//alot of these exit codes are a quick hack (i maybe running out of time...)
			returnString = "-2";//exit code
		}
		return returnString;
	}
}
