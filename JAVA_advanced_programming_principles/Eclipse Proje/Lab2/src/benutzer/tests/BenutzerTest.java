package benutzer.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import benutzer.Benutzer;
import bestellungen.Bestellung;
import bestellungen.BestellungsArtikel;
import filme.Film;
import filme.HorrorStrategie;
import benutzer.KalkulierePreis;

class BenutzerTest {

	@Test
	void testAddBestellung() {
		String[] listeHorrorSchauspieler = {"Schausp1","Schausp2"};
		Film filmHorror = new Film("horror film",2000,8,20,listeHorrorSchauspieler,new HorrorStrategie());
		BestellungsArtikel best1 = new BestellungsArtikel(filmHorror, 3);
		BestellungsArtikel best2 = new BestellungsArtikel(filmHorror, 3);
		
		Bestellung bestellung1 = new Bestellung();
		Bestellung bestellung2 = new Bestellung();
		bestellung1.addBestellungsArtikel(best1);
		bestellung1.addBestellungsArtikel(best2);
		bestellung2.addBestellungsArtikel(best2);
		
		Benutzer benutzer = new Benutzer("Test","Tester","tester");
		
		benutzer.addBestellung(bestellung1);
		benutzer.addBestellung(bestellung2);
		
		assertEquals(benutzer.getListeBestellungen().size()==2,true);
	}
	
	@Test
	void testRemoveBestellung() {
		String[] listeHorrorSchauspieler = {"Schausp1","Schausp2"};
		Film filmHorror = new Film("horror film",2000,8,20,listeHorrorSchauspieler,new HorrorStrategie());
		BestellungsArtikel best1 = new BestellungsArtikel(filmHorror, 3);
		BestellungsArtikel best2 = new BestellungsArtikel(filmHorror, 3);
		
		Bestellung bestellung1 = new Bestellung();
		Bestellung bestellung2 = new Bestellung();
		bestellung1.addBestellungsArtikel(best1);
		bestellung1.addBestellungsArtikel(best2);
		bestellung2.addBestellungsArtikel(best2);
		
		Benutzer benutzer = new Benutzer("Test","Tester","tester");
		
		benutzer.addBestellung(bestellung1);
		benutzer.addBestellung(bestellung2);
		benutzer.removeBestellung(bestellung1);
		
		assertEquals(benutzer.getListeBestellungen().size()==1,true);
	}
	
	@Test
	void testcalculatePrice() {
		String[] listeHorrorSchauspieler = {"Schausp1","Schausp2"};
		Film filmHorror = new Film("horror film",2000,8,20,listeHorrorSchauspieler,new HorrorStrategie());
		BestellungsArtikel best1 = new BestellungsArtikel(filmHorror, 3);
		BestellungsArtikel best2 = new BestellungsArtikel(filmHorror, 2);
		
		Bestellung bestellung1 = new Bestellung();
		bestellung1.addBestellungsArtikel(best1);
		bestellung1.addBestellungsArtikel(best2);
		
		Benutzer benutzer = new Benutzer("Test","Tester","tester");
		benutzer.addBestellung(bestellung1);

		assertEquals(KalkulierePreis.calculatePrice(bestellung1)==50,true);
	}
	
	@Test
	void testCalculateTotalPrice() {
		String[] listeHorrorSchauspieler = {"Schausp1","Schausp2"};
		Film filmHorror = new Film("horror film",2000,8,20,listeHorrorSchauspieler,new HorrorStrategie());
		BestellungsArtikel best1 = new BestellungsArtikel(filmHorror, 3);
		BestellungsArtikel best2 = new BestellungsArtikel(filmHorror, 3);
		
		Bestellung bestellung1 = new Bestellung();
		Bestellung bestellung2 = new Bestellung();
		bestellung1.addBestellungsArtikel(best1);
		bestellung1.addBestellungsArtikel(best2);
		bestellung2.addBestellungsArtikel(best2);
		
		Benutzer benutzer = new Benutzer("Test","Tester","tester");
		
		benutzer.addBestellung(bestellung1);
		benutzer.addBestellung(bestellung2);
		
		assertEquals(KalkulierePreis.calculateTotalPrice(benutzer),90);
	}

}
