/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bubble.breaker.Score;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

/**
 * lets the user view the current Highscores in the database
 *
 * @author mitchell
 */
public class HighscorePanel extends BBJPanel {

	final private ArrayList<Score> Scoreboard;
	final private JTable ScoreTable = new JTable();

	/**
	 * Creates new form HighscorePanel
	 *
	 * @param frame the frame the panel is in, let's this object control this
	 * frame
	 * @param Scoreboard the scoreboard that needs to be loaded into the JTable
	 */
	public HighscorePanel(BubbleBreaker frame, ArrayList<Score> Scoreboard) {
		super(frame);
		this.Scoreboard = Scoreboard;
		initComponents();
		loadJTable();
	}

	/**
	 * lays out and sets up the Highscores panel
	 */
	// <editor-fold defaultstate="collapsed" desc="Laying out the Highscore Panel">                          
	private void initComponents() {
		
		//defining and creating the components
		JLabel Title = new JLabel();
		JLabel TitleFormatting = new JLabel();
		JButton Back = new JButton();
		JScrollPane jScrollPane = new JScrollPane();

		//setting the background colour
		setBackground(Color.darkGray);

		//setting up the title
		Title.setForeground(Color.white);
		Title.setText("Highscores");

		//setting up a nice line below the title
		TitleFormatting.setForeground(Color.white);
		TitleFormatting.setText("---------");

		//setting up the back button
		Back.setText("Back");
		Back.addActionListener(this::BackClick);
		
		//adds the scoretable to a scrollable pane, needed?
		ScoreTable.setEnabled(false);
		jScrollPane.setViewportView(ScoreTable);
		if (ScoreTable.getColumnModel().getColumnCount() > 0) {
			ScoreTable.getColumnModel().getColumn(0).setResizable(false);
			ScoreTable.getColumnModel().getColumn(1).setResizable(false);
		}

		//positioning, spacing and add all components to a layout and adding that layout to the panel
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(Title, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(TitleFormatting, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
										.addComponent(Back, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
								.addContainerGap())
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(Title)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(TitleFormatting)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(Back)
								.addContainerGap())
		);
	}// </editor-fold>                        

	/**
	 * loads the database into the HighscorePanel ScoreTable
	 */
	private void loadJTable() {
		String[] titles = {"Rank","Name", "Score"};
		Object[][] data = new Object[10][3];

		for (int i = 0; i < Scoreboard.size(); i++) {
			data[i][0] = i+1;
			data[i][1] = Scoreboard.get(i).getName();
			data[i][2] = Scoreboard.get(i).getScore();
		}

		ScoreTable.setModel(new DefaultTableModel(data, titles));
	}

	/**
	 * controls what the back button does
	 *
	 * @param evt the event of the button click
	 */
	private void BackClick(ActionEvent evt) {
		frame.changeFrame(new MenuPanel(frame));
	}                 
}
