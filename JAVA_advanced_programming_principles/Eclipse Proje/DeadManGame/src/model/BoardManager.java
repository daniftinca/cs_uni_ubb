/**
 * 
 */
package model;

/**
 * @author Dan
 * Der BoardManager macht Operationen auf dem Spieltafel.
 */
public class BoardManager {
	Board spielTafel;

	public BoardManager(int i, int j) {
		super();
		this.spielTafel = new Board(i,j);
	}
	
	public BoardManager(Board spielTafel) {
		super();
		this.spielTafel = spielTafel;
	}
	
	
	public Board getSpielTafel() {
		return spielTafel;
	}


	public void setSpielTafel(Board spielTafel) {
		this.spielTafel = spielTafel;
	}


	/**
	 * Liefert die Anzahl der Nachbaren eines Pawn
	 * @param i row
	 * @param j column
	 * @return int
	 */
	private int getNachbarenNr(int i, int j) {
		int nachbaren=0;
		
		if((i-1>=0) && (j-1>=0)){
			nachbaren = (spielTafel.getPawnAt(i-1, j-1)==1 || spielTafel.getPawnAt(i-1, j-1)==3)? nachbaren+1 : nachbaren;
		}
		
		if((i>=0) && (j-1>=0)) {
			nachbaren = (spielTafel.getPawnAt(i, j-1)==1 || spielTafel.getPawnAt(i, j-1)==3)? nachbaren+1 : nachbaren;
		}
	
	    if ((i + 1 < spielTafel.getSpielTafel().length) && (j - 1 >= 0)) {
	        nachbaren = spielTafel.getPawnAt(i+1, j-1)==1 || spielTafel.getPawnAt(i+1, j-1)==3 ? nachbaren + 1 : nachbaren;
	    }
	 
	    if ((i + 1 < spielTafel.getSpielTafel().length) && (j < spielTafel.getSpielTafel().length)) {
	        nachbaren = spielTafel.getPawnAt(i+1, j)==1 || spielTafel.getPawnAt(i+1, j)==3 ? nachbaren + 1 : nachbaren;
	    }

	    if ((i + 1 < spielTafel.getSpielTafel().length) && (j + 1 < spielTafel.getSpielTafel().length)) {
	        nachbaren = spielTafel.getPawnAt(i+1, j+1)==1 || spielTafel.getPawnAt(i+1, j+1)==3 ? nachbaren + 1 : nachbaren;
	    }
	  
	    if ((i < spielTafel.getSpielTafel().length) && (j + 1 < spielTafel.getSpielTafel().length)) {
	        nachbaren = spielTafel.getPawnAt(i, j+1)==1 || spielTafel.getPawnAt(i, j+1)==3 ? nachbaren + 1 : nachbaren;
	    }
	
	    if ((i - 1 >= 0) && (j + 1 < spielTafel.getSpielTafel().length)) {
	        nachbaren = spielTafel.getPawnAt(i-1, j+1)==1 || spielTafel.getPawnAt(i-1, j+1)==3 ? nachbaren + 1 : nachbaren;
	    }
	   
	    if ((i - 1 >= 0) && (j < spielTafel.getSpielTafel().length)) {
	        nachbaren = spielTafel.getPawnAt(i-1, j)==1 || spielTafel.getPawnAt(i-1, j)==3 ? nachbaren + 1 : nachbaren;
	    }
	    
	    return nachbaren;

	}
	
	/**
	 * Ueberprueft ob einen Pawn getoggled werden muss.
	 * @param i row
	 * @param j column
	 * @return boolean
	 */
	private boolean mussToggeln(int i, int j) {
		int noNachberen = getNachbarenNr(i, j);
		
		if(spielTafel.getPawnAt(i, j)==1) {
			if(noNachberen<2 || noNachberen>3) {
				return true;
			}
		} else {
			if(noNachberen == 3) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 *  Veraendert den Board indem es die Spielregeln Beachtet. 
	 */
	public void getNextBoardState() {
		for(int i=0;i<spielTafel.getSpielTafel().length;i++) {
			for(int j=0; j<spielTafel.getSpielTafel().length; j++) {
				if(mussToggeln(i, j))
					if(spielTafel.getPawnAt(i, j)==0) {
						spielTafel.setPawnAt(i, j, 2);
					}
					else {
						spielTafel.setPawnAt(i, j, 3);
					}
			}
		}
		for(int i=0;i<spielTafel.getSpielTafel().length;i++) {
			for(int j=0; j<spielTafel.getSpielTafel().length; j++) {
				if(spielTafel.getPawnAt(i, j)==2) {
					spielTafel.setPawnAt(i, j, 1);
				}
				if(spielTafel.getPawnAt(i, j)==3) {
					spielTafel.setPawnAt(i, j, 0);
				}
			}
		}
	}
	
	/**
	 * Toggelt einen Pawn.
	 * @param i row
	 * @param j column
	 */
	public void togglePawn(int i, int j) {
		spielTafel.togglePawn(i, j);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((spielTafel == null) ? 0 : spielTafel.hashCode());
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
		BoardManager other = (BoardManager) obj;
		if (spielTafel == null) {
			if (other.spielTafel != null)
				return false;
		} else if (!spielTafel.equals(other.spielTafel))
			return false;
		return true;
	}
	
}
