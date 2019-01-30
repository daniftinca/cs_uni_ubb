/**
 * 
 */
package model.tests;

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
		Board testTafel = new Board(10,10);
		BoardManager testManager = new BoardManager(testTafel);
		testManager.togglePawn(0, 0);
		testManager.togglePawn(0, 1);
		testManager.togglePawn(1, 0);
		testManager.togglePawn(1, 1);
		testManager.getNextBoardState();
		int[][] displayActual = testManager.getSpielTafel().getSpielTafel();
		for(int i =0;i<displayActual.length;i++) {
			for(int j=0;j<displayActual.length;j++) {
				System.out.print(displayActual[i][j]+" ");
			}
			System.out.println("\n");
			
		}
		
		Board assertionTafel = new Board(10,10);
		assertionTafel.togglePawn(1, 1);
		assertionTafel.togglePawn(0, 0);
		assertionTafel.togglePawn(0, 1);
		assertionTafel.togglePawn(1, 0);
		BoardManager expectedManager = new BoardManager(assertionTafel);
		assertEquals(expectedManager,testManager);
		
	}

}
