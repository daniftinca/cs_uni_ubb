package benutzer;

import java.util.Iterator;

import bestellungen.Bestellung;
import bestellungen.BestellungsArtikel;

public class KalkulierePreis {

	/**
	 * Berechnet der Gesamtpreis einer Bestellung.
	 * 
	 * @param bestellung
	 * @return float - Gesamtpreis
	 */
	public static double calculatePrice(Bestellung bestellung) {
		Iterator<BestellungsArtikel> it = bestellung.getListeBestellungsArtikel().iterator();
		double preisSumme = 0;
		while (it.hasNext()) {
			BestellungsArtikel current = it.next();
			preisSumme += current.getFilm().kalkulierePreis() * (double) current.getAmount();

		}
		return preisSumme;
	}

	/**
	 * Berechnet der Gesamtpreis aller Bestellungen eines Benutzers.
	 * 
	 * @return float - Gesamtpreis
	 */
	public static double calculateTotalPrice(Benutzer benutzer) {
		Iterator<Bestellung> it = benutzer.getListeBestellungen().iterator();
		double totalPreis = 0;
		while (it.hasNext()) {
			totalPreis += calculatePrice(it.next());
		}
		return totalPreis;
	}
}
