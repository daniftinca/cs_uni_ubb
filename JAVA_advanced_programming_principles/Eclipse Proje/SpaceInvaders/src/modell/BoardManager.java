/**
 * 
 */
package modell;

/**
 * The board manager class makes operations using a board object.
 * @author Dan
 *
 */
public class BoardManager {
	GameBoard gameBoard = new GameBoard();
	int direction=1;
	public BoardManager(GameBoard gameBoard) {
		super();
		this.gameBoard = gameBoard;
	}
	
	public BoardManager() {
		super();
		this.gameBoard = new GameBoard();
	}

	public int[] getMostLeftPart(){
		int[] returnCoord = new int[2];
		returnCoord[0]=19;
		returnCoord[1]=19;
		for(int i =0; i<19;i++) {
			for(int j=0;j<19;j++) {
				if(gameBoard.getElemAt(i, j) == 1) {
					if(j<returnCoord[1]) {
						returnCoord[1]=j;
						returnCoord[0]=i;
					}
				}
			}
		}
		return returnCoord;
	}
	
	public int[] getMostRightPart(){
		int[] returnCoord = new int[2];
		returnCoord[0]=0;
		returnCoord[1]=0;
		for(int i =0; i<19;i++) {
			for(int j=0;j<19;j++) {
				if(gameBoard.getElemAt(i, j) == 1) {
					if(j>returnCoord[1]) {
						returnCoord[1]=j;
						returnCoord[0]=i;
					}
				}
			}
		}
		return returnCoord;
	}
	
	public int[] getMostDownPart(){
		int[] returnCoord = new int[2];
		returnCoord[0]=0;
		returnCoord[1]=0;
		for(int i =0; i<19;i++) {
			for(int j=0;j<19;j++) {
				if(gameBoard.getElemAt(i, j) == 1) {
					if(i>returnCoord[0]) {
						returnCoord[1]=j;
						returnCoord[0]=i;
					}
				}
			}
		}
		return returnCoord;
	}
	
	
	public void shiftCharacterRight() {
		for(int i =18; i>=0;i--) {
			for(int j=18;j>=0;j--) {
				gameBoard.setElementAt(i, j, gameBoard.getElemAt(i, j-1));
			}
		}
	}
	
	public void shiftCharacterLeft() {
		for(int i =0; i<19;i++) {
			for(int j=0;j<19;j++) {
				gameBoard.setElementAt(i, j, gameBoard.getElemAt(i, j+1));
			}
		}
	}
	
	public void shiftCharacterDown() {
		for(int j =18; j>=0;j--) {
			for(int i=18;i>=0;i--) {
				gameBoard.setElementAt(i, j, gameBoard.getElemAt(i, j+1));
			}
		}
	}
	
	public boolean arrivedAtRightEdge() {
		int[] coords = getMostRightPart();
		if(coords[1] == 18)
			return true;
		return false;
	}
	
	public boolean arrivedAtLeftEdge() {
		int[] coords = getMostLeftPart();
		if(coords[1] == 0)
			return true;
		return false;
	}
	
	
	public boolean arrivedAtBottomEdge() {
		int[] coords = getMostDownPart();
		if(coords[0] == 18)
			return true;
		return false;
	}
	
	private void reinitialize() {
		gameBoard.reinitializeBoard();
	}
	
	public void doOneStep() {
		if(arrivedAtBottomEdge()) {
			reinitialize();
			direction = 1;
		}
		else if(direction == 1) {
			if(arrivedAtRightEdge()) {
				shiftCharacterDown();
				direction = 0;
			}
			else {
				shiftCharacterRight();
			}
		}
		else if(direction == 0) {
			if(arrivedAtLeftEdge()) {
				shiftCharacterDown();
				direction = 1;
			}
			else {
				shiftCharacterLeft();
			}
		}
		
	}
	
	
	
	/**
	 * Toggelt einen Pawn.
	 * @param i row
	 * @param j column
	 */
	public void togglePawn(int i, int j) {
		gameBoard.togglePawn(i, j);
	}
	
	public GameBoard getGameBoard() {
		return gameBoard;
	}

	public void setGameBoard(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
	
	
}
