/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.bubbles;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests GreenBubble
 *
 * @author mitchell
 */
public class GreenBubbleTest extends JBubbleTest {

	/**
	 * Test of bubbleLocation method, of class GreenBubble.
	 */
	@Test
	@Override
	public void testBubbleLocation() {
		System.out.println("bubbleLocation");
		GreenBubble instance = new GreenBubble(TBUBBLE);
		String expResult = "green.png";
		String result = instance.bubbleLocation();
		assertEquals(expResult, result);
	}

}
