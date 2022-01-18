/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.bubbles;

import bubble.breaker.Bubble;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * allows the Bubble to be printed to the Panel
 *
 * @author mitchell
 */
public abstract class JBubble extends JButton {

	final private ImageIcon icon = new ImageIcon(getClass().getResource("/" + bubbleLocation()));
	private Bubble mappedBubble;//add to constuctor or remember to set it

	/**
	 * setting the location of the HDD of the bubble image
	 *
	 * @return a String with the location of a bubble image
	 */
	abstract String bubbleLocation();

	/**
	 * changes the icon of this JLabel to the Image of the bubble
	 *
	 * @param mBubble mapping the JBubble to a Bubble used for x, y positions
	 */
	public JBubble(Bubble mBubble) {
		this.bubbleSetup();
		this.setBubble(mBubble);
	}

	/**
	 * easy access to the bubble mapped to this button
	 *
	 * @param mBubble the Bubble the bubble is mapped too
	 */
	private void setBubble(Bubble mBubble) {
		this.mappedBubble = mBubble;
	}

	/**
	 * easy access to the bubble mapped to this button
	 *
	 * @return the Bubble this Button is mapped too
	 */
	public Bubble getBubble() {
		return mappedBubble;
	}

	/**
	 * because a lot of these functions over rideable the constructor likes
	 * these to be in a private function
	 */
	private void bubbleSetup() {
		this.setIcon(icon);
		this.setHorizontalAlignment(JLabel.CENTER);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
	}
}
