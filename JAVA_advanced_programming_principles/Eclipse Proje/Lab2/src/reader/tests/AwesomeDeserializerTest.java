package reader.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import filme.Film;
import filme.NormalPreisStrat;
import reader.AwesomeDeserializer;
import writer.AwesomeSerializer;

class AwesomeDeserializerTest{

	@Test
	void testReadMovies()  throws Exception  {
		String[] listaActori= new String[100];
		listaActori[0] = "Adi";
		listaActori[1] = "Vasilica";
		Film film1 = new Film("TitluFilm1",2000,8,10 ,listaActori);
		Film film2 = new Film("TitluFilm2",2000,8,10 ,listaActori);
		
		ArrayList<Film> expectedArray = new ArrayList<Film>();
		
		expectedArray.add(film1);
		expectedArray.add(film2);
		
		AwesomeSerializer writer = new AwesomeSerializer();
		String path1 = System.getProperty("user.dir")+"\\src\\reader\\tests\\filmeActual.ser";
		writer.writeMovies(expectedArray,path1);
		
		AwesomeDeserializer reader = new AwesomeDeserializer();
		ArrayList<Film> actualArray = reader.readMovies(path1);
		
		assertEquals(expectedArray, actualArray);
	}

}
