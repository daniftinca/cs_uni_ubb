package writer.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import filme.Film;
import writer.AwesomeFileWriter;

class AwesomeFileWriterTest {

	@Test
	void test() throws Exception{
		String[] listaActori= new String[100];
		listaActori[0] = "Adi";
		listaActori[1] = "Vasilica";
		Film film1 = new Film("TitluFilm1",2000,8,10 ,listaActori);
		Film film2 = new Film("TitluFilm2",2000,8,10 ,listaActori);
		
		ArrayList<Film> listaFilme = new ArrayList<Film>();
		
		listaFilme.add(film1);
		listaFilme.add(film2);
		
		AwesomeFileWriter writer = new AwesomeFileWriter();
		String path1 = System.getProperty("user.dir")+"\\src\\writer\\tests\\filmeActual.fis";
		String path2 = System.getProperty("user.dir")+"\\src\\writer\\tests\\filmeExpected.fis";
		writer.writeMovies(listaFilme,path1);
		
		
		File file1 = new File(path1);
		File file2 = new File(path2);
	    assertTrue(FileUtils.contentEquals(file1, file2));
	}

}
