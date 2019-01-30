
package bestellungen;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Eine Bestellung hat ein Datum und eine Liste von Bestellungsartikel.
 * 
 * @author Dan
 *
 */
public class Bestellung {

	private Date datum;
	private List<BestellungsArtikel> listeBestellungsArtikel = new ArrayList<BestellungsArtikel>();

	public Bestellung() {
		super();
		datum = new Date();
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public List<BestellungsArtikel> getListeBestellungsArtikel() {
		return listeBestellungsArtikel;
	}

	public void setListeBestellungsArtikel(List<BestellungsArtikel> listeBestellungsArtikel) {
		this.listeBestellungsArtikel = listeBestellungsArtikel;
	}

	/**
	 * Addiert einen neuen Bestellungsartikel zu der listeBestellungsArtikel.
	 * 
	 * @param artikel
	 *            - BestellungsArtikel Objekt
	 */
	public void addBestellungsArtikel(BestellungsArtikel artikel) {
		listeBestellungsArtikel.add(artikel);
	}

	/**
	 * Entfernt ein BestellungsArtikel objekt von der listeBestellungsArtikel
	 * 
	 * @param artikel
	 *            - BestellungsArtikel Objekt
	 */
	public void removeBestellungsArtikel(BestellungsArtikel artikel) {
		Iterator<BestellungsArtikel> it = listeBestellungsArtikel.iterator();
		while (it.hasNext()) {
			if (it.next().equals(artikel)) {
				it.remove();
				break;
			}
		}
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof Bestellung))
			return false;
		Bestellung otherBestellung = (Bestellung) other;
		if (otherBestellung.getDatum() != datum) {
			return false;
		}
		if (otherBestellung.getListeBestellungsArtikel() != listeBestellungsArtikel) {
			return false;
		}
		return true;
	}

}
