/**
 * 
 */
package model;

import java.io.Serializable;

/**
 * @author Dan
 * Notebook Class - holds infor on the notebook
 */
public class Notebook  implements Serializable  {

	/**
	 *  serializer stuff
	 */
	private static final long serialVersionUID = -520897222046172906L;
	private String marke; 
	private String modell;
	private double preis;
	private boolean cdLaufWerk;
	
	
	
	public Notebook(String marke, String modell, double preis, boolean cdLaufWerk) {
		super();
		this.marke = marke;
		this.modell = modell;
		this.preis = preis;
		this.cdLaufWerk = cdLaufWerk;
	}
	

	
	public String getMarke() {
		return marke;
	}
	public void setMarke(String marke) {
		this.marke = marke;
	}
	public String getModell() {
		return modell;
	}
	public void setModell(String modell) {
		this.modell = modell;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public boolean isCdLaufWerk() {
		return cdLaufWerk;
	}
	public void setCdLaufWerk(boolean cdLaufWerk) {
		this.cdLaufWerk = cdLaufWerk;
	}

	@Override
	public String toString() {
		return "Notebook [marke=" + marke + ", modell=" + modell + ", preis=" + preis + ", cdLaufWerk=" + cdLaufWerk
				+ "]";
	}
	
	
}
