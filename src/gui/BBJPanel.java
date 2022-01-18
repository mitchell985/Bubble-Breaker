/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JPanel;

/**
 * the template for all BubbleBreakerPanels
 *
 * @author mitchell
 */
public abstract class BBJPanel extends JPanel {

	final BubbleBreaker frame;//final static ???

	BBJPanel(BubbleBreaker frame) {//how to remove BubbleBreaker frame?
		this.frame = frame;
	}
}
