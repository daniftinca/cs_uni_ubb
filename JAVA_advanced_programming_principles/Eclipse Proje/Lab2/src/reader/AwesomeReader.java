/**
 * 
 */
package reader;

import java.util.ArrayList;

import filme.Film;

/**
 * @author Dan
 * Awesome Reader Interface. It defines the behavior of the Reader Classes.
 */
public interface AwesomeReader {
	
	/**
	 * Reads from a file and returns a list of Movies
	 * @return ArrayList
	 */
	public ArrayList<Film> readMovies(String filename);
}
