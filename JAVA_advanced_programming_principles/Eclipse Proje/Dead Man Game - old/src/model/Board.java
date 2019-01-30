/**
 * 
 */
package model;

import java.util.Arrays;

/**
 * @author Dan
 * Diese Klasse wird das Spieltafel enthalten.
 */
public class Board {
	int [][] spielTafel;

	public Board(int laenge, int breite) {
		super();
		spielTafel = new int[laenge][breite];
	}
	
	public Board(int[][] board) {
		super();
		spielTafel = board;
	}

	public int[][] getSpielTafel() {
		return spielTafel;
	}

	public void setSpielTafel(int[][] spielTafel) {
		this.spielTafel = spielTafel;
	}
	
	public void setPawnAt(int i, int j,int value) {
		spielTafel[i][j]=value;
	}
	
	public int getPawnAt(int i, int j) {
		return spielTafel[i][j];
	}
	
	public void togglePawn(int i, int j) {
		if(spielTafel[i][j]==0) {
			spielTafel[i][j]=1;
		} else {
			spielTafel[i][j] = 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(spielTafel);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Board other = (Board) obj;
		if (!Arrays.deepEquals(spielTafel, other.spielTafel))
			return false;
		return true;
	}
	
}
