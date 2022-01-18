/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import java.util.Random;

/**
 * this object is the individual bubbles on the board, the only real information
 * they store is their colour
 *
 * @author mitchell
 */
public class Bubble {

	private int colour = 0;//the colour of the bubble object for the colour use enum
	private int x, y;//if i had time ill remove this

	/**
	 * on creation of the Bubble object sets the bubble with a random number
	 * between 1-5 symbolizing 1 of 5 colours
	 *
	 * @param x the current x position of the bubble object
	 * @param y the current x position of the bubble object
	 */
	public Bubble(int x, int y) {
		Random randomGenerator = new Random();
		colour = (randomGenerator.nextInt(5)) + 1;// genrates between 0-4 +1 so 1-5
		this.x = x;
		this.y = y;
	}

	/**
	 * allows the colour of the bubble to be set manually
	 *
	 * @param x the current x position of the bubble object
	 * @param y the current x position of the bubble object
	 * @param colour of the bubble
	 */
	public Bubble(int x, int y, int colour) {//remove me later, for debuging and manual creation of bubblemaps
		this.colour = colour;//colour = 5;
		this.x = x;
		this.y = y;
	}

	/**
	 * gives the x position
	 *
	 * @return the x position of the bubble
	 */
	public int getX() {
		return x;
	}

	/**
	 * gives the y position
	 *
	 * @return the y position of the bubble
	 */
	public int getY() {
		return y;
	}

	/**
	 * for setting the position of both x y of the bubble
	 *
	 * @param x position
	 * @param y position
	 */
	public void setBubbleXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * changes the toString method so that when it is printed, the colour of the
	 * bubble to printed
	 *
	 * @return a string to print
	 */
	@Override
	public String toString() {
		return String.format("%d", getColour());
	}

	/**
	 * @return the colour of the bubble
	 */
	public int getColour() {
		return colour;
	}
}
