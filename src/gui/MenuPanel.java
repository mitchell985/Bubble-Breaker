/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bubble.breaker.Game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;

/**
 * Controlling the panels and buttons for the main menu
 *
 * @author mitchell
 */
public class MenuPanel extends BBJPanel {

	/**
	 * Creates new form NewJPanel
	 *
	 * @param frame the frame the panel is in, let's this object control this
	 * frame
	 */
	public MenuPanel(BubbleBreaker frame) {
		super(frame);
		initComponents();
	}

	/**
	 * Huge function to layout the main menu
	 */
	// <editor-fold defaultstate="collapsed" desc="Laying out the Main Menu">                          
	private void initComponents() {
		//creating all the compontents
		JPanel VisualGroup = new JPanel();
		JLabel Title = new JLabel();
		JLabel Red = new JLabel();
		JLabel Green = new JLabel();
		JLabel Blue = new JLabel();
		JLabel Yellow = new JLabel();
		JLabel Purple = new JLabel();
		JPanel ButtonGroup = new JPanel();
		JButton Start = new JButton();
		JButton Highscore = new JButton();
		JButton Exit = new JButton();
		//setting the background colour
		setBackground(Color.darkGray);
		//setting the visualgroup background
		VisualGroup.setBackground(Color.darkGray);
		//setting up the title label
		Title.setForeground(Color.white);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setText("The Bubble Breaker Game");
		//setting up the red label
		Red.setHorizontalAlignment(SwingConstants.CENTER);
		Red.setIcon(new ImageIcon(getClass().getResource("/red.png"))); // NOI18N
		//setting up the green label
		Green.setHorizontalAlignment(SwingConstants.CENTER);
		Green.setIcon(new ImageIcon(getClass().getResource("/green.png"))); // NOI18N
		//setting up the blue label
		Blue.setHorizontalAlignment(SwingConstants.CENTER);
		Blue.setIcon(new ImageIcon(getClass().getResource("/blue.png"))); // NOI18N
		//setting up the yellow label
		Yellow.setHorizontalAlignment(SwingConstants.CENTER);
		Yellow.setIcon(new ImageIcon(getClass().getResource("/yellow.png"))); // NOI18N
		//setting up the purple
		Purple.setHorizontalAlignment(SwingConstants.CENTER);
		Purple.setIcon(new ImageIcon(getClass().getResource("/purple.png"))); // NOI18N
		//spacing and group, and add components to the visualgroup
		GroupLayout VisualGroupLayout = new GroupLayout(VisualGroup);
		VisualGroup.setLayout(VisualGroupLayout);
		VisualGroupLayout.setHorizontalGroup(
				VisualGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(VisualGroupLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(VisualGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(Title, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
										.addComponent(Purple, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Yellow, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Blue, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Green, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Red, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);
		VisualGroupLayout.setVerticalGroup(
				VisualGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, VisualGroupLayout.createSequentialGroup()
								.addContainerGap(96, Short.MAX_VALUE)
								.addComponent(Red)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Green)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Blue)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Yellow)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Purple)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Title)
								.addGap(204, 204, 204))
		);
		//setting the background of the buttongroup
		ButtonGroup.setBackground(Color.darkGray);
		//setting up the start button
		Start.setText("Start Game");
		Start.addActionListener(this::StartClick);
		//setting up the highscore button
		Highscore.setText("Highscores");
		Highscore.addActionListener(this::HighscoreClick);
		//setting up the exit button
		Exit.setText("Exit");
		Exit.addActionListener(this::ExitClick);
		//adding componts and spacing to the button group
		GroupLayout ButtonGroupLayout = new GroupLayout(ButtonGroup);
		ButtonGroup.setLayout(ButtonGroupLayout);
		ButtonGroupLayout.setHorizontalGroup(
				ButtonGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(ButtonGroupLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(ButtonGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(Highscore, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Start, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(Exit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);
		ButtonGroupLayout.setVerticalGroup(
				ButtonGroupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(ButtonGroupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(Start)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Highscore)
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(Exit)
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		//spacing for the whole panel
		GroupLayout panelLayout = new GroupLayout(this);
		this.setLayout(panelLayout);
		panelLayout.setHorizontalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(VisualGroup, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(ButtonGroup, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
		);
		panelLayout.setVerticalGroup(panelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(panelLayout.createSequentialGroup()
						.addComponent(VisualGroup, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(ButtonGroup, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
		);
	}// </editor-fold>                        

	/**
	 * this is what happens when the Start button is clicked
	 *
	 * @param evt
	 */
	private void StartClick(ActionEvent evt) {
		String username = JOptionPane.showInputDialog(frame, "What's your name?");

		if (username != null) {
			if (Game.checkError(username.length(), 20)) {
				frame.changeFrame(new GamePanel(frame, username));
			}else{
				JOptionPane.showMessageDialog(null, "Input can only be 1-20 characters", "Invaild Input", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	/**
	 * this is what happens when the Highscores button is clicked
	 *
	 * @param evt
	 */
	private void HighscoreClick(ActionEvent evt) {
		frame.changeFrame(new HighscorePanel(frame, ScoreDB.getScoreboard()));
	}

	/**
	 * this is what happens when the Exit button is clicked
	 *
	 * @param evt
	 */
	private void ExitClick(ActionEvent evt) {
		System.exit(0);
	}
}
