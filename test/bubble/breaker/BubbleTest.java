/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing the Bubble class
 *
 * @author mitchell
 */
public class BubbleTest {
	final private static int XPOS = 5;
	final private static int YPOS = 8;
	final private static int COLOUR = 3;//purple
	final private static Bubble TESTB = new Bubble(XPOS,YPOS,COLOUR);
	
	/**
	 * Test of getX method, of class Bubble.
	 */
	@Test
	public void testGetX() {
		System.out.println("getX");
		Bubble instance = TESTB;
		int expResult = 5;
		int result = instance.getX();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getY method, of class Bubble.
	 */
	@Test
	public void testGetY() {
		System.out.println("getY");
		Bubble instance = TESTB;
		int expResult = 8;
		int result = instance.getY();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setBubbleXY method, of class Bubble.
	 */
	@Test
	public void testSetBubbleXY() {
		System.out.println("setBubbleXY");
		int x = 8;
		int y = 5;
		Bubble instance = TESTB;
		instance.setBubbleXY(x, y);
		int expResult = x;
		int result = instance.getX();
		assertEquals(expResult, result);//test if x changed
		expResult = y;
		result = instance.getY();
		assertEquals(expResult, result);//test if y changed
	}

	/**
	 * Test of toString method, of class Bubble.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Bubble instance = TESTB;
		String expResult = "3";
		String result = instance.toString();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getColour method, of class Bubble.
	 */
	@Test
	public void testGetColour() {
		System.out.println("getColour");
		Bubble instance = TESTB;
		int expResult = 3;
		int result = instance.getColour();
		assertEquals(expResult, result);
	}
	
}
