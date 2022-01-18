/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.bubbles;

import bubble.breaker.Bubble;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mitchell
 */
public class JBubbleTest {
	final static Bubble TBUBBLE = new Bubble(5,5,3);
	final private JBubble TJBUBBLE = new JBubbleImpl();
	
	/**
	 * Test of bubbleLocation method, of class JBubble.
	 */
	@Test
	public void testBubbleLocation() {
		System.out.println("bubbleLocation");
		JBubble instance = TJBUBBLE;
		String expResult = "blue.png";
		String result = instance.bubbleLocation();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getBubble method, of class JBubble.
	 */
	@Test
	public void testGetBubble() {
		System.out.println("getBubble");
		JBubble instance = TJBUBBLE;
		Bubble exp = new Bubble(5,5,3);
		Bubble res = instance.getBubble();
		assertTrue(exp.getX() == res.getX());//same xPos
		assertTrue(exp.getY() == res.getY());//same yPos
		assertTrue(exp.getColour() == res.getColour());//same Color
	}

	public class JBubbleImpl extends JBubble {

		public JBubbleImpl() {
			super(TBUBBLE);
		}

		public String bubbleLocation() {
			return "blue.png";
		}
	}	
}
