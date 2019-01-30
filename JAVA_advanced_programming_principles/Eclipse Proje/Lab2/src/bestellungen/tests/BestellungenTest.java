package bestellungen.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bestellungen.Bestellung;
import bestellungen.BestellungsArtikel;
import filme.Film;
import filme.HorrorStrategie;
import filme.SciFiStrategie;

class BestellungenTest {

	@Test
	void testBestellungsArtikel() {
		
		String[] listeHorrorSchauspieler = {"Schausp1","Schausp2"};
		String[] listeSciFiSchauspieler = {"Schausp1","Schausp2"};
		Film filmHorror = new Film("horror film",2000,8,20,listeHorrorSchauspieler,new HorrorStrategie());
		Film filmSciFi = new Film("scifi film",2000,8,20,listeSciFiSchauspieler,new SciFiStrategie());
		BestellungsArtikel best1 = new BestellungsArtikel(filmHorror, 3);
		BestellungsArtikel best2 = new BestellungsArtikel(filmHorror, 3);
		BestellungsArtikel best3 = new BestellungsArtikel(filmSciFi, 3);
		BestellungsArtikel best4 = new BestellungsArtikel(filmHorror, 4);
		
		
		assertEquals(best1.equals(best1), true);
		assertEquals(best1.equals(best2), true);
		assertEquals(best1.equals(best3), false);
		assertEquals(best1.equals(best4), false);
	}
	
	@Test
	void testBestellungAddArtikel() {
		String[] listeHorrorSchauspieler = {"Schausp1","Schausp2"};
		Film filmHorror = new Film("horror film",2000,8,20,listeHorrorSchauspieler,new HorrorStrategie());
		BestellungsArtikel best1 = new BestellungsArtikel(filmHorror, 3);
		
		Bestellung bestellung = new Bestellung();
		
		bestellung.addBestellungsArtikel(best1);
		assertEquals(bestellung.getListeBestellungsArtikel().size()==1,true);
	}
	
	@Test
	void testBestellungRemoveArtikel() {
		String[] listeHorrorSchauspieler = {"Schausp1","Schausp2"};
		Film filmHorror = new Film("horror film",2000,8,20,listeHorrorSchauspieler,new HorrorStrategie());
		BestellungsArtikel best1 = new BestellungsArtikel(filmHorror, 3);
		BestellungsArtikel best2 = new BestellungsArtikel(filmHorror, 3);
		
		Bestellung bestellung = new Bestellung();
		
		bestellung.addBestellungsArtikel(best1);
		bestellung.addBestellungsArtikel(best2);
		bestellung.removeBestellungsArtikel(best1);
		assertEquals(bestellung.getListeBestellungsArtikel().size()==1,true);
	}

}
