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
 * Tests PurpleBubble
 *
 * @author mitchell
 */
public class PurpleBubbleTest extends JBubbleTest{

	/**
	 * Test of bubbleLocation method, of class PurpleBubble.
	 */
	@Test
	@Override
	public void testBubbleLocation() {
		System.out.println("bubbleLocation");
		PurpleBubble instance = new PurpleBubble(TBUBBLE);
		String expResult = "purple.png";
		String result = instance.bubbleLocation();
		assertEquals(expResult, result);
	}
	
}
