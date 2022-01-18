/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.bubbles;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test RedBubble
 *
 * @author mitchell
 */
public class RedBubbleTest extends JBubbleTest{
	

	/**
	 * Test of bubbleLocation method, of class RedBubble.
	 */
	@Test
	@Override
	public void testBubbleLocation() {
		System.out.println("bubbleLocation");
		RedBubble instance = new RedBubble(TBUBBLE);
		String expResult = "red.png";
		String result = instance.bubbleLocation();
		assertEquals(expResult, result);
	}
	
}
