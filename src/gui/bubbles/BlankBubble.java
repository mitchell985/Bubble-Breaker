/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.bubbles;

import bubble.breaker.Bubble;

/**
 * a blank bubble for when the bubble has been removed
 * @author mitchell
 */
public class BlankBubble extends JBubble{

	/**
	 * maps this JBubble to a Bubble on creation
	 *
	 * @param mBubble to map this JBubble too
	 */
	public BlankBubble(Bubble mBubble) {
		super(mBubble);
	}

	@Override
	String bubbleLocation() {
		this.setVisible(false);
		return "blank.png";//throws an error if its null :-(
	}
}