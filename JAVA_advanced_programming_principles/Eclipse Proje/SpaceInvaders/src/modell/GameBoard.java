/**
 * 
 */
package modell;

/**
 * the board class holds the board info inside.
 * @author Dan
 *
 */
public class GameBoard {

	private int[][] gameBoard;
	private int[][] initGameBoard;

	public GameBoard(int[][] gameboard) {
		super();
		this.gameBoard = gameboard;
		this.initGameBoard = gameboard;
	}

	public void reinitializeBoard() {
		gameBoard = initGameBoard;
	}
	
	public int getElemAt(int i, int j) {
		return gameBoard[i][j];
	}
	
	public void setElementAt(int i, int j, int num) {
		gameBoard[i][j] = num;
	}
	public GameBoard() {
		super();
		this.gameBoard = new int[19][19];
	}
	
	public int[][] getGameboard() {
		return gameBoard;
	}

	public void setGameboard(int[][] gameboard) {
		this.gameBoard = gameboard;
	}
	public void togglePawn(int i, int j) {
		if(gameBoard[i][j]==0) {
			gameBoard[i][j]=1;
		} else {
			gameBoard[i][j] = 0;
		}
	}
	
}
