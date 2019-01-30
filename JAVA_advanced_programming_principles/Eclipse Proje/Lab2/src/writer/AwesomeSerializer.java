/**
 * 
 */
package writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import filme.Film;

/**
 * @author Dan
 * Serializes a list of movies and writes it to a file. 
 */
public class AwesomeSerializer implements AwesomeWriter {

	/* (non-Javadoc)
	 * @see writer.AwesomeWriter#writeMovies(java.util.ArrayList)
	 */
	@Override
	public void writeMovies(ArrayList<Film> paramList, String fileName) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos;
			try {
				oos = new ObjectOutputStream(fos);
				oos.writeObject(paramList);				
				fos.close();
			} catch (IOException e1) {
				System.out.println("OOS PROBLEM");
				e1.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("fos problem");
			e.printStackTrace();
		}

	}

}
