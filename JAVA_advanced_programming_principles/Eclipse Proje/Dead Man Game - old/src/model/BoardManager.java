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


	private int[] getNachbaren(int i, int j) {
		int[] nachbaren = new int[9];
		
		if(i==0 && j==0) {
			nachbaren[0] = spielTafel.getPawnAt(i, j+1);
			nachbaren[1] = spielTafel.getPawnAt(i+1, j+1);
			nachbaren[2] = spielTafel.getPawnAt(i+1, j);
		} else if(i>0 && j==0 && i<spielTafel.getSpielTafel().length-1) {
			nachbaren[0] = spielTafel.getPawnAt(i-1, j);
			nachbaren[1] = spielTafel.getPawnAt(i+1, j);
			nachbaren[2] = spielTafel.getPawnAt(i-1, j+1);
			nachbaren[3] = spielTafel.getPawnAt(i+1, j+1);
			nachbaren[4] = spielTafel.getPawnAt(i-1, j+1);
		} else if(i==spielTafel.getSpielTafel().length-1 && j==spielTafel.getSpielTafel().length-1) {
			nachbaren[0] = spielTafel.getPawnAt(i, j-1);
			nachbaren[1] = spielTafel.getPawnAt(i-1, j-1);
			nachbaren[2] = spielTafel.getPawnAt(i-1, j);
		} else if(i==0 && j==spielTafel.getSpielTafel().length-1) {
			nachbaren[0] = spielTafel.getPawnAt(i, j-1);
			nachbaren[1] = spielTafel.getPawnAt(i+1, j-1);
			nachbaren[2] = spielTafel.getPawnAt(i+1, j);
		} else if(i==spielTafel.getSpielTafel().length-1 && j==0) {
			nachbaren[0] = spielTafel.getPawnAt(i, j+1);
			nachbaren[1] = spielTafel.getPawnAt(i-1, j+1);
			nachbaren[2] = spielTafel.getPawnAt(i-1, j);
		} else if(i==0 && j>0 && j<spielTafel.getSpielTafel().length-1) {
			nachbaren[0] = spielTafel.getPawnAt(i, j-1);
			nachbaren[1] = spielTafel.getPawnAt(i, j+1);
			nachbaren[2] = spielTafel.getPawnAt(i+1, j-1);
			nachbaren[3] = spielTafel.getPawnAt(i+1, j);
			nachbaren[4] = spielTafel.getPawnAt(i+1, j+1);
		} else if(i>0 && j == spielTafel.getSpielTafel().length-1 && i<spielTafel.getSpielTafel().length-1) {
			nachbaren[0] = spielTafel.getPawnAt(i-1, j-1);
			nachbaren[1] = spielTafel.getPawnAt(i-1, j);
			nachbaren[2] = spielTafel.getPawnAt(i+1, j);
			nachbaren[3] = spielTafel.getPawnAt(i, j-1);
			nachbaren[4] = spielTafel.getPawnAt(i+1, j);
		} else if(i==spielTafel.getSpielTafel().length-1 && j>0 && j<spielTafel.getSpielTafel().length-1) {
			nachbaren[0] = spielTafel.getPawnAt(i, j-1);
			nachbaren[1] = spielTafel.getPawnAt(i-1, j-1);
			nachbaren[2] = spielTafel.getPawnAt(i-1, j+1);
			nachbaren[3] = spielTafel.getPawnAt(i-1, j);
			nachbaren[4] = spielTafel.getPawnAt(i, j+1);
		} else {
			nachbaren[0] = spielTafel.getPawnAt(i, j-1);
			nachbaren[1] = spielTafel.getPawnAt(i, j+1);
			nachbaren[2] = spielTafel.getPawnAt(i-1,j);
			nachbaren[3] = spielTafel.getPawnAt(i+1,j);
			nachbaren[4] = spielTafel.getPawnAt(i-1,j-1);
			nachbaren[5] = spielTafel.getPawnAt(i-1,j+1);
			nachbaren[6] = spielTafel.getPawnAt(i+1, j+1);
			nachbaren[7] = spielTafel.getPawnAt(i+1, j-1);
		}
		return nachbaren;
		
	}
	
	private boolean mussToggeln(int i, int j) {
		int noNachberen = 0;
		int[] nachbaren = getNachbaren(i, j);
		System.out.println("i: "+i+" j: "+j);
		for(int ind=0;ind<nachbaren.length;ind++) {
			System.out.print(nachbaren[ind]+" ");
			if(nachbaren[ind]!=0 && nachbaren[ind]!=2)
				noNachberen+=1;
		}
		System.out.println("\n NoNachbaren: "+ noNachberen);
		System.out.println("-------------");
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
	
	public void getNextBoardState() {
		for(int i=0;i<spielTafel.getSpielTafel().length;i++) {
			for(int j=0; j<spielTafel.getSpielTafel().length; j++) {
				if(mussToggeln(i, j))
					spielTafel.setPawnAt(i, j, 2);
			}
		}
		for(int i=0;i<spielTafel.getSpielTafel().length;i++) {
			for(int j=0; j<spielTafel.getSpielTafel().length; j++) {
				if(spielTafel.getPawnAt(i, j)==2) {
					spielTafel.setPawnAt(i, j, 1);
				}
			}
		}
	}
	
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
