/**
 * 
 */
package model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Board;
import model.BoardManager;

/**
 * @author Dan
 *
 */
class BoardManagerTests {

	@Test
	void getNextBoardState() {
		Board testTafel = new Board(20,20);
		BoardManager testManager = new BoardManager(testTafel);
		testManager.togglePawn(0, 0);
		testManager.togglePawn(0, 1);
		testManager.togglePawn(1, 0);
		 testManager.getNextBoardState();
		Board assertionTafel = new Board(10,10);
		assertionTafel.togglePawn(1, 1);
		assertionTafel.togglePawn(0, 0);
		assertionTafel.togglePawn(0, 1);
		assertionTafel.togglePawn(1, 0);
		BoardManager expectedManager = new BoardManager(assertionTafel);
		assertEquals(expectedManager,testManager);;
		
	}

}
