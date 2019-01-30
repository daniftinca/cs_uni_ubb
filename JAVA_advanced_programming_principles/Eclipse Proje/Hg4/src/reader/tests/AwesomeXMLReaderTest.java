/**
 * 
 */
package reader.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import filme.Film;
import reader.AwesomeXMLReader;
import writer.AwesomeXMLWriter;

/**
 * @author Dan
 *
 */
class AwesomeXMLReaderTest {

	@Test
	void test() throws Exception {
		String[] listaActori= new String[100];
		listaActori[0] = "Adi";
		listaActori[1] = "Vasilica";
		Film film1 = new Film("TitluFilm1",2000,8,10 ,listaActori);
		Film film2 = new Film("TitluFilm2",2000,8,10 ,listaActori);
		
		ArrayList<Film> listaFilme = new ArrayList<Film>();
		
		listaFilme.add(film1);
		listaFilme.add(film2);
		
		AwesomeXMLWriter writer = new AwesomeXMLWriter();
		String path = System.getProperty("user.dir")+"\\src\\reader\\tests\\filmeActual.json";
		writer.writeMovies(listaFilme,path);
		
		AwesomeXMLReader reader = new AwesomeXMLReader();	
		ArrayList<Film> actualList = reader.readMovies(path);
		
		assertEquals(listaFilme, actualList);
	}

}
