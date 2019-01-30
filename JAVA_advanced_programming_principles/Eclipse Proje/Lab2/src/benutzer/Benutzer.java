/**
 * 
 */
package benutzer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import bestellungen.*;

/**
 * Ein Benutzer kann Bestellungen machen, bearbeiten und entfernen. Er hat
 * Vorname,Nachname, Bestellungsliste und ein user ID. Man benutzt das UserId
 * fur Login.
 * 
 * @author Dan
 *
 */
public class Benutzer {

	private String vorname, nachname;
	private String userID;

	private List<Bestellung> listeBestellungen = new ArrayList<Bestellung>();

	public Benutzer(String vorname, String nachname, String userID) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.userID = userID;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public List<Bestellung> getListeBestellungen() {
		return listeBestellungen;
	}

	public void setListeBestellungen(List<Bestellung> listeBestellungen) {
		this.listeBestellungen = listeBestellungen;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof BestellungsArtikel))
			return false;
		Benutzer otherBenutzer = (Benutzer) other;
		if (otherBenutzer.getUserID() != userID) {
			return false;
		}
		return true;
	}

	/**
	 * Addiert eine Bestellung zu der Bestellungsliste
	 * 
	 * @param bestellung
	 */
	public void addBestellung(Bestellung bestellung) {
		listeBestellungen.add(bestellung);
	}

	/**
	 * Entfernt eine Bestellung von der Bestellungsliste
	 * 
	 * @param bestellung
	 */
	public void removeBestellung(Bestellung bestellung) {
		Iterator<Bestellung> it = listeBestellungen.iterator();
		while (it.hasNext()) {
			if (it.next().equals(bestellung)) {
				it.remove();
				break;
			}
		}
	}



}
