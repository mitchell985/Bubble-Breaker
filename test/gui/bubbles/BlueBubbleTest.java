/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.bubbles;

import bubble.breaker.Bubble;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests BlueBubble
 *
 * @author mitchell
 */
public class BlueBubbleTest extends JBubbleTest{

	/**
	 * Test of bubbleLocation method, of class BlueBubble.
	 */
	@Test
	@Override
	public void testBubbleLocation() {
		System.out.println("bubbleLocation");
		BlueBubble instance = new BlueBubble(TBUBBLE);
		String expResult = "blue.png";
		String result = instance.bubbleLocation();
		assertEquals(expResult, result);
	}
	
}
