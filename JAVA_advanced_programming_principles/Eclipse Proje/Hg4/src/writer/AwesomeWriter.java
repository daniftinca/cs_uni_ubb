/**
 * 
 */
package writer;

import java.util.ArrayList;

import exceptions.WriterException;
import filme.Film;

/**
 * @author Dan
 * Interface that defines the behavior of all the writer classes.
 */
public interface AwesomeWriter {
	
	/**
	 *  Writes from a list of movies to a File
	 * @param paramList
	 * @throws WriterException 
	 */
	public void writeMovies(ArrayList<Film> paramList, String fileName) throws WriterException;
	
}
