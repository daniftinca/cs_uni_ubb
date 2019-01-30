/**
 * 
 */
package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import exceptions.FileReaderExcepion;
import filme.Film;

/**
 * @author Dan 
 * Class that specializes in reading from a specially formatted file
 * and turning the contents into an ArrayList of movies.
 */
public class AwesomeFileReader implements AwesomeReader {

	/*
	 * (non-Javadoc)
	 * 
	 * @see reader.AwesomeReader#readMovies()
	 */
	@Override
	public ArrayList<Film> readMovies(String fileName) throws FileReaderExcepion {
		try {
			ArrayList<Film> movieList = new ArrayList<Film>();
			BufferedReader reader;

			reader = new BufferedReader(new FileReader(fileName));

			String line = reader.readLine();
			while (line != null) {
				String filmName = line;
				line = reader.readLine();
				int filmErschienJahr = Integer.parseInt(line);
				line = reader.readLine();
				int bewertung = Integer.parseInt(line);
				line = reader.readLine();
				String[] listeSchauspieler = line.split(", ");
				line = reader.readLine();
				float preis = Float.parseFloat(line);
				Film film = new Film(filmName, filmErschienJahr, bewertung, preis, listeSchauspieler);
				movieList.add(film);
				line = reader.readLine();
			}
			reader.close();
			return movieList;
		} catch (FileNotFoundException e) {
			throw new FileReaderExcepion("File Reader Exception: File not found");
		} catch (IOException e) {
			throw new FileReaderExcepion("File Reader Exception: IO Problems");
		}
	}
}
