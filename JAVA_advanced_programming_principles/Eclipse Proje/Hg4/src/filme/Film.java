/**
 * 
 */
package filme;

import java.io.Serializable;
import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Dan 
 * Klasse die einen Film repraesentiert.
 */
@XmlRootElement
public class Film implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4747777346446034834L;
	private String titel;
	private int erschienJahr, bewertung;
	private float basisPreis;
	private String[] listeSchauspieler;

	//private DefaultPreisStrategie strat = new NormalPreisStrat();

	public Film(String titel, int erschienJahr, int bewertung, float basisPreis, String[] listeSchauspieler) {
		super();
		this.titel = titel;
		this.erschienJahr = erschienJahr;
		this.bewertung = bewertung;
		this.basisPreis = basisPreis;
		this.listeSchauspieler = listeSchauspieler;
		//this.strat = strat;
	}



	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public int getErschienJahr() {
		return erschienJahr;
	}

	public void setErschien_jahr(int erschienJahr) {
		this.erschienJahr = erschienJahr;
	}

	public int getBewertung() {
		return bewertung;
	}

	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}

	public float getBasispreis() {
		return basisPreis;
	}

	public void setBasisPreis(float basisPreis) {
		this.basisPreis = basisPreis;
	}

	public String[] getListeSchauspieler() {
		return listeSchauspieler;
	}

	public void setListeSchauspieler(String[] listeSchauspieler) {
		this.listeSchauspieler = listeSchauspieler;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(basisPreis);
		result = prime * result + bewertung;
		result = prime * result + erschienJahr;
		result = prime * result + Arrays.hashCode(listeSchauspieler);
		result = prime * result + ((titel == null) ? 0 : titel.hashCode());
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
		Film other = (Film) obj;
		if (Float.floatToIntBits(basisPreis) != Float.floatToIntBits(other.basisPreis))
			return false;
		if (bewertung != other.bewertung)
			return false;
		if (erschienJahr != other.erschienJahr)
			return false;
		if (titel == null) {
			if (other.titel != null)
				return false;
		} else if (!titel.equals(other.titel))
			return false;
		return true;
	}



}
