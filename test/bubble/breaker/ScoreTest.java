/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.breaker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mitchell
 */
public class ScoreTest {
	
	final private static Score TSCORE = new Score("Test");
	
	public ScoreTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	/**
	 * Test of setName method, of class Score.
	 */
	@Test
	public void testSetName() {
		System.out.println("setName");
		String name = "Bob";
		Score instance = TSCORE;
		instance.setName(name);
		assertEquals(name,instance.getName());
	}

	/**
	 * Test of getName method, of class Score.
	 */
	@Test
	public void testGetName() {
		System.out.println("getName");
		Score instance = TSCORE;
		String expResult = "Test";
		String result = instance.getName();
		assertEquals(expResult, result);
	}

	/**
	 * Test of setScore method, of class Score.
	 * calculates the score based on if b = Number of Bubbles b^2-b
	 */
	@Test
	public void testSetScore() {
		System.out.println("setScore");
		int numberOfBubbles = 50;
		Score instance = TSCORE;
		double expResult = 2450.0;
		double result = instance.setScore(numberOfBubbles);
		assertEquals(expResult, result, 0.0);
	}

	/**
	 * Test of getScore method, of class Score.
	 */
	@Test
	public void testGetScore() {
		System.out.println("getScore");
		Score instance = TSCORE;
		int expResult = 0;
		int result = instance.getScore();
		assertEquals(expResult, result);
	}

	/**
	 * Test of toString method, of class Score.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		Score instance = TSCORE;
		String expResult = "Score: 0";
		String result = instance.toString();
		assertEquals(expResult, result);
	}
	
}
