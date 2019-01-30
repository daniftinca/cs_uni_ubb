/**
 * 
 */
package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Board;

/**
 * @author Dan
 *
 */
class BoardTests {

	@Test
	void getPawnAtTest() {
		Board testTafel = new Board(3,3);
		
		assertEquals(0, testTafel.getPawnAt(2, 2));
	}
	
	
	
	@Test
	void togglePawnTest() {
		Board testTafel = new Board(3,3);
		
		testTafel.togglePawn(1, 1);
		testTafel.togglePawn(1, 2);		
		testTafel.togglePawn(1, 0);
		testTafel.togglePawn(1, 1);
		assertEquals(0, testTafel.getPawnAt(1, 1));
		assertEquals(1, testTafel.getPawnAt(1, 0));
		assertEquals(1, testTafel.getPawnAt(1, 2));
	}

}
