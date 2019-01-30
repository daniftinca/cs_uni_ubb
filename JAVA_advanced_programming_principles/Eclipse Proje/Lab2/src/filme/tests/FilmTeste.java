package filme.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import filme.Film;
import filme.HorrorStrategie;
import filme.NormalPreisStrat;
import filme.SciFiStrategie;

class FilmTeste {

	@Test
	void preisTest() {

		Film filmHorror, filmSciFi, filmNormal;

		String[] listeHorrorSchauspieler = { "Schausp1", "Schausp2" };
		String[] listeSciFiSchauspieler = { "Schausp1", "Schausp2" };
		String[] listeNormalSchauspieler = { "Schausp1", "Schausp2" };
		filmHorror = new Film("horror film", 2000, 8, 20, listeHorrorSchauspieler, null);
		filmSciFi = new Film("scifi film", 2000, 8, 20, listeSciFiSchauspieler);
		filmNormal = new Film("horror film", 2000, 8, 20, listeNormalSchauspieler);

		double horrorPreis = filmHorror.kalkulierePreis();
		double scifiPreis = filmSciFi.kalkulierePreis();
		double normalPreis = filmNormal.kalkulierePreis();

		assertEquals(10, horrorPreis);
		assertEquals(18, scifiPreis);
		assertEquals(20, normalPreis);
	}

}
