/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.bubbles;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests YellowBubble
 *
 * @author mitchell
 */
public class YellowBubbleTest extends JBubbleTest{
	
	/**
	 * Test of bubbleLocation method, of class YellowBubble.
	 */
	@Test
	@Override
	public void testBubbleLocation() {
		System.out.println("bubbleLocation");
		YellowBubble instance = new YellowBubble(TBUBBLE);
		String expResult = "yellow.png";
		String result = instance.bubbleLocation();
		assertEquals(expResult, result);
	}
	
}
