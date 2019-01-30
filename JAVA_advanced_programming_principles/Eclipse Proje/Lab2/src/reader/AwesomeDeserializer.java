/**
 * 
 */
package reader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

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
	public ArrayList<Film> readMovies(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ojs = new ObjectInputStream(fis);
			
			return (ArrayList<Film>) ojs.readObject();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
