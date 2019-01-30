/**
 * 
 */
package writer;

import java.util.ArrayList;

import filme.Film;

/**
 * @author Dan
 * Interface that defines the behavior of all the writer classes.
 */
public interface AwesomeWriter {
	
	/**
	 *  Writes from a list of movies to a File
	 * @param paramList
	 */
	public void writeMovies(ArrayList<Film> paramList, String fileName);
	
}
