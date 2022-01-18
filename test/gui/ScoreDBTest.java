/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import bubble.breaker.Score;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests the ScoreDB
 *
 * @author mitchell
 */
public class ScoreDBTest {

	@BeforeClass
	public static void setUpClass() {
		ScoreDB.connectToDB();
	}

	/**
	 * Test of connectToDB method, of class ScoreDB.
	 */
	@Test
	public void testConnectToDB() {
		System.out.println("connectToDB");
		ScoreDB.connectToDB();
	}

	/**
	 * Test of saveToDatabase method, of class ScoreDB.
	 */
	@Test
	public void testSaveToDatabase() {
		System.out.println("saveToDatabase");
		Score aScore = new Score("Test");
		ScoreDB.saveToDatabase(aScore);
	}

	/**
	 * Test of successfulDB method, of class ScoreDB.
	 */
	@Test
	public void testSuccessfulDB() {
		System.out.println("successfulDB");
		ScoreDB.successfulDB();
	}
}
