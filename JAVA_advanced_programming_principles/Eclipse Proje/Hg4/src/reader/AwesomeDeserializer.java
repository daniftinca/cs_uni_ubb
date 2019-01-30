/**
 * 
 */
package reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import exceptions.DeserializerException;
import filme.Film;

/**
 * @author Dan
 * Reads from a file a serialized string and deserializes it. 
 */
public class AwesomeDeserializer implements AwesomeReader {

	/* (non-Javadoc)
	 * @see reader.AwesomeReader#readMovies()
	 */
	@SuppressWarnings({ "unchecked", "resource" })
	@Override
	public ArrayList<Film> readMovies(String fileName)  throws DeserializerException{
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ojs = new ObjectInputStream(fis);
			
			return (ArrayList<Film>) ojs.readObject();
		} catch (FileNotFoundException e){
			throw new DeserializerException("Deserializer Exception: File Not Found");
		} catch (IOException e) {
			throw new DeserializerException("Deserializer Exception: IO Problems");
		} catch (ClassNotFoundException e) {
			throw new DeserializerException("Deserializer Exception: Class Not Found");
		}
	}

}
