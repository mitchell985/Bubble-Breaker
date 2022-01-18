/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Game class
 * 
 * @author mitchell
 */
public class GameTest {
	
	/**
	 * Test of tryParseInt method, of class Game.
	 */
	@Test
	public void testTryParseInt() {
		//correct
		System.out.println("tryParseInt");
		String text = "12475896";
		int expResult = 12475896;
		int result = Game.tryParseInt(text);
		assertTrue(expResult == result);
		
		//exit code 1
		text = "e";
		expResult = -2;
		result = Game.tryParseInt(text);
		assertTrue(expResult == result);
		//exit code 2
		text = "E";
		expResult = -2;
		result = Game.tryParseInt(text);
		assertTrue(expResult == result);
		//error code
		text = "Eagirgiorehg";
		expResult = -1;
		result = Game.tryParseInt(text);
		assertTrue(expResult == result);
	}

	/**
	 * Test of checkError method, of class Game.
	 */
	@Test
	public void testCheckError_int_int() {
		//no error
		System.out.println("checkError");
		int checkValue = 3;
		int max = 5;
		boolean result = Game.checkError(checkValue, max);
		assertTrue(result);//backwards
		
		//error
		checkValue = 7;
		result = Game.checkError(checkValue, max);
		assertFalse(result);//?
	}

	/**
	 * Test of checkError method, of class Game.
	 */
	@Test
	public void testCheckError_3args() {
		//no error
		System.out.println("checkError");
		int checkValue = -2;
		int min = -5;
		int max = 5;
		boolean result = Game.checkError(checkValue, min, max);
		assertTrue(result);
		
		//error
		checkValue = -6;
		result = Game.checkError(checkValue, min, max);
		assertFalse(result);
	}

	/**
	 * Test of showScoreboard method, of class Game.
	 */
	@Test
	public void testShowScoreboard() {
		System.out.println("showScoreboard");
		Game.showScoreboard();
	}

	/**
	 * Test of formatSpaces method, of class Game.
	 */
	@Test
	public void testFormatSpaces_0args() {
		System.out.println("formatSpaces");
		String expResult = " ";
		String result = Game.formatSpaces();
		assertEquals(expResult, result);
	}

	/**
	 * Test of formatSpaces method, of class Game.
	 */
	@Test
	public void testFormatSpaces_int() {
		System.out.println("formatSpaces");
		int spaces = 5;
		String expResult = "     ";
		String result = Game.formatSpaces(spaces);
		assertEquals(expResult, result);
	}
	
}
