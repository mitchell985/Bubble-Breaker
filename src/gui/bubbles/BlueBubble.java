/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.bubbles;

import bubble.breaker.Bubble;

/**
 * sets label icon to blue
 *
 * @author mitchell
 */
public class BlueBubble extends JBubble {

	/**
	 * maps this JBubble to a Bubble on creation
	 *
	 * @param mBubble to map this JBubble too
	 */
	public BlueBubble(Bubble mBubble) {
		super(mBubble);
	}

	@Override
	String bubbleLocation() {
		return "blue.png";
	}
}
