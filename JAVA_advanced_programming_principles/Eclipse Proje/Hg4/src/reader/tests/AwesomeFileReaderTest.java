/**
 * 
 */
package reader.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import filme.Film;
import reader.AwesomeFileReader;
import writer.AwesomeFileWriter;

/**
 * @author Dan
 *
 */
class AwesomeFileReaderTest {

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
		
		AwesomeFileWriter writer = new AwesomeFileWriter();
		String path = System.getProperty("user.dir")+"\\src\\reader\\tests\\filmeActual.fis";
		writer.writeMovies(listaFilme,path);
		
		AwesomeFileReader reader = new AwesomeFileReader();	
		ArrayList<Film> actualList = reader.readMovies(path);
		
		assertEquals(listaFilme, actualList);
	}

}
