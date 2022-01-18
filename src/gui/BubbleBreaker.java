/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * controls the frame for the GUI version of the game
 *
 * @author mitchell
 */
public class BubbleBreaker extends JFrame {

	/**
	 * sets up the frame and starts the database
	 */
	BubbleBreaker() {
		setupFrame();
		ScoreDB.connectToDB();
	}

	/**
	 * sets up the first frame including styling and basic positioning
	 *
	 * @param args a list statements, not used
	 */
	public static void main(String[] args) {
		//WARNING DUE TO JAVA SWING BEING A LOVELY PIECE OF COVFEFE
		//IN MICROSOFT WINDOWS YOU MAY NEED TO MANUALLY RESIZE THE WINDOW TO MAKE
		//EVERTHING FIT WELL ON THE GAMEPANEL (IT WORKS FINE ON MAC)
		BubbleBreaker mainFrame = new BubbleBreaker();
		
		mainFrame.add(new MenuPanel(mainFrame));
		
		mainFrame.setVisible(true);
	}

	/**
	 * configures all the frame settings, tides the main up
	 */
	private void setupFrame() {
		this.setTitle("Bubble Breaker Game");
		int xSize = 750;
		int ySize = 800;

		//this.setResizable(false);
		this.setBackground(Color.darkGray);
		this.setSize(xSize, ySize);
		this.setLocation(30,30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * changes the current panel to the new changePanel provided
	 * @param changePanel that this method change too
	 */
	public void changeFrame(BBJPanel changePanel){
		this.clearFrame();
		this.add(changePanel);
		this.setVisible(true);
	}
	
	/**
	 * clears the frame ready to be re-populated with new information
	 */
	private void clearFrame() {
		this.getContentPane().removeAll();
		this.revalidate();//make sure the removed stuff are removed
		this.repaint();//ready for adding new stuff
	}
}
