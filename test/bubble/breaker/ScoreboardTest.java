/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Scoreboard
 * 
 * @author mitchell
 */
public class ScoreboardTest {

	/**
	 * Test of getColour method, of class Scoreboard.
	 */
	@Test
	public void testGetandSetColour() {
		System.out.println("getColour and setColour");
		Scoreboard.setColour(false);
		boolean result = Scoreboard.getColour();
		assertFalse(result);
	}

	/**
	 * Test of saveScore method, of class Scoreboard.
	 */
	@Test
	public void testSaveScore() {
		System.out.println("saveScore");
		Scoreboard.saveScore();
	}
	
}
