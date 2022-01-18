/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test of the Board class
 *
 * @author mitchell
 */
public class BoardTest {

	/**
	 * Test of click method, of class Board.
	 */
	@Test
	public void testClick() {
		System.out.println("click");
		int x = 1;
		char y = 1;
		Board instance = new Board(new Score("Test"));
		boolean expResult = false;
		boolean result = instance.click(x, y);
		assertEquals(expResult, result);
	}

	/**
	 * Test of clickBubble method, of class Board.
	 */
	@Test
	public void testClickBubble() {
		System.out.println("clickBubble");
		int x = 0;
		int y = 0;
		Board instance = new Board(new Score("Test"));
		boolean expResult = false;
		boolean result = instance.clickBubble(x, y);
		assertEquals(expResult, result);
	}

	/**
	 * Test of parseIntToChar method, of class Board.
	 */
	@Test
	public void testParseIntToChar() {
		System.out.println("parseIntToChar");
		char start = 'A';
		int number = 0;
		char expResult = 'A';
		char result = Board.parseIntToChar(start, number);
		assertEquals(expResult, result);
		//fail("Converting 0 to A failed");
	}	
}
