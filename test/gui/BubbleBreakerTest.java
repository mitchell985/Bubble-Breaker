/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mitchell
 */
public class BubbleBreakerTest {
	
	/**
	 * Test of main method, of class BubbleBreaker.
	 */
	@Test
	public void testMain() {
		System.out.println("main");
		String[] args = null;
		BubbleBreaker.main(args);
	}

	/**
	 * Test of changeFrame method, of class BubbleBreaker.
	 */
	@Test
	public void testChangeFrame() {
		System.out.println("changeFrame");
		BubbleBreaker instance = new BubbleBreaker();
		BBJPanel changePanel = new MenuPanel(instance);
		instance.changeFrame(changePanel);
	}
	
}
