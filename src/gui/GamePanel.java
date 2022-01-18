/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bubble.breaker.Board;
import bubble.breaker.Bubble;
import bubble.breaker.Score;
import gui.bubbles.BlankBubble;
import gui.bubbles.BlueBubble;
import gui.bubbles.GreenBubble;
import gui.bubbles.JBubble;
import gui.bubbles.PurpleBubble;
import gui.bubbles.RedBubble;
import gui.bubbles.YellowBubble;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle;

/**
 * lets the user control the game
 *
 * @author mitchell
 */
public class GamePanel extends BBJPanel {

	Score gameScore;
	Board gameBoard;

	/**
	 * Creates new form GamePanel
	 *
	 * @param frame the frame the panel is in, let's this object control this
	 * frame
	 * @param name of the player to be added to the score
	 */
	public GamePanel(BubbleBreaker frame, String name) {
		super(frame);
		this.gameScore = new Score(name);
		this.gameBoard = new Board(gameScore);
		initComponents();
	}

	/**
	 * refreshes the GamePanel
	 *
	 * @param frame the standard frame control
	 * @param aScore the latest Score
	 * @param aBoard the latest Board
	 */
	private GamePanel(BubbleBreaker frame, Score aScore, Board aBoard) {
		super(frame);
		this.gameScore = aScore;
		this.gameBoard = aBoard;
		initComponents();
	}

	/**
	 * attempts to lay everything on the game panel out nicely
	 */
	// <editor-fold defaultstate="collapsed" desc="Laying out the Game board">                          
	private void initComponents() {

		//defining and creating the components
		JLabel ScoreLabel = new JLabel();
		JLayeredPane JBubbleGroup = new JLayeredPane();
		JButton EndGame = new JButton();
		
		//setting the background colour
		setBackground(Color.darkGray);
		
		//setting up the score label
		ScoreLabel.setForeground(Color.white);
		ScoreLabel.setText("Score: " + gameScore.getScore());

		//setting up the JBubbleGroup
		JBubbleGroup.setBorder(BorderFactory.createEmptyBorder(1, 100, 1, 100));
		JBubbleGroup.setLayout(new GridLayout(Board.COLS, Board.ROWS));

		//setting up the end the game button
		EndGame.setText("End Game");
		EndGame.addActionListener(this::EndGameClick);

		//add all the components to a grouplayout and adding that layout to the gamepanel
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(JBubbleGroup)
										.addComponent(ScoreLabel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
										.addComponent(EndGame, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(ScoreLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(JBubbleGroup, GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(EndGame)
								.addContainerGap())
		);

		// <editor-fold defaultstate="collapsed" desc="Adding Bubbles for Map to Panel as JBubbles">
		Bubble[][] BubbleMap = gameBoard.getBoard();

		for (Bubble[] yBubble : BubbleMap) {
			for (Bubble xyBubble : yBubble) {
				JBubbleGroup.add(bubbleToJButton(xyBubble), BorderLayout.CENTER);
			}
		}

		//print out that it worked
		System.out.println("JBubbles added");
		// </editor-fold>  
	}// </editor-fold>                        

	/**
	 * lets the user end the game early
	 * @param evt 
	 */
	private void EndGameClick(ActionEvent evt) {
		if (gameScore.getScore() > 0) {//else save the score
			saveGameOption();
		} else {
			frame.changeFrame(new MenuPanel(frame));
		}
	}

	/**
	 * converts a Bubble to a JBubble
	 *
	 * @param aBubble the Bubble that need converting to a JBubble
	 * @return the JBubble converted from the Bubble
	 */
	private JBubble bubbleToJButton(Bubble aBubble) {
		JBubble rJBubble = new BlankBubble(aBubble);//Default?

		if (aBubble == null) {//needed?
			rJBubble = new BlankBubble(aBubble);
		} else if (aBubble.getColour() == 1) {
			rJBubble = new RedBubble(aBubble);
		} else if (aBubble.getColour() == 2) {
			rJBubble = new GreenBubble(aBubble);
		} else if (aBubble.getColour() == 3) {
			rJBubble = new BlueBubble(aBubble);
		} else if (aBubble.getColour() == 4) {
			rJBubble = new YellowBubble(aBubble);
		} else if (aBubble.getColour() == 5) {
			rJBubble = new PurpleBubble(aBubble);
		}

		//Add listener to each JBubble
		rJBubble.addActionListener(this::JBubbleClick);

		return rJBubble;//get it ? returnJBubble
	}

	/**
	 * control what happens when the user click on any JBubble
	 * @param evt 
	 */
	private void JBubbleClick(ActionEvent evt) {
		JBubble aJBubble = (JBubble) evt.getSource();
		int clickX = aJBubble.getBubble().getX();//needed? no but tidier
		int clickY = aJBubble.getBubble().getY();//needed? no but tidier

		if (!gameBoard.clickBubble(clickX, clickY)) {//if not the End of the Game contine playing
			frame.changeFrame(new GamePanel(frame, gameScore, gameBoard));
		} else {
			frame.changeFrame(new GamePanel(frame, gameScore, gameBoard));//one more refresh, show the user how the game ended
			saveGameOption();
		}

	}

	/**
	 * controls whether or not the game is saved
	 */
	private void saveGameOption() {
		Object[] options = {"No, it's too embarrassing", "Yes, my score is great"};
		int save = JOptionPane.showOptionDialog(
				frame,
				"Well done you scored: " + gameScore.getScore() + "\n"
				+ "Would you like to save your score ?",
				"Save your score?",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null, //do not use a custom Icon
				options, //the titles of buttons
				options[1]); //default button title

		if (save == 1) {//yes
			ScoreDB.saveToDatabase(gameScore);
		}
		frame.changeFrame(new MenuPanel(frame));
	}               
}
