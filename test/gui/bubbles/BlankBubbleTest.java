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
 * Tests BlankBubble
 *
 * @author mitchell
 */
public class BlankBubbleTest extends JBubbleTest{

	/**
	 * Test of bubbleLocation method, of class BlankBubble.
	 */
	@Test
	@Override
	public void testBubbleLocation() {
		System.out.println("bubbleLocation");
		BlankBubble instance = new BlankBubble(TBUBBLE);
		String expResult = "blank.png";
		String result = instance.bubbleLocation();
		assertEquals(expResult, result);
	}
	
}
