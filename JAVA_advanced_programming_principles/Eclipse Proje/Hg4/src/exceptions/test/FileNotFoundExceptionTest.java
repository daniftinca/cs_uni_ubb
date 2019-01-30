package exceptions.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import exceptions.FileWriterException;
import filme.Film;
import writer.AwesomeFileWriter;
class FileNotFoundExceptionTest {

	

	
	@Test
	public void fileWriteExceptionTest() {
		
		try {
		   AwesomeFileWriter asdf = new AwesomeFileWriter();
		   asdf.writeMovies(new ArrayList<Film>(),"asdf");
		   fail("Exception was not thrown");
		}
		catch (FileWriterException e) {}
	}
}
