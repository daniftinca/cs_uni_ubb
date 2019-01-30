/**
 * 
 */
package reader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import exceptions.JSONReaderException;
import filme.Film;

/**
 * @author Dan
 * Class that specializes in reading from a JSON file and turning the contents into an ArrayList of movies.
 */
public class AwesomeJSONReader implements AwesomeReader {

	/* (non-Javadoc)
	 * @see reader.AwesomeReader#readMovies()
	 */
	@SuppressWarnings("resource")
	@Override
	public ArrayList<Film> readMovies(String fileName) throws JSONReaderException {
		FileInputStream fis;
		try {
			fis = new FileInputStream(fileName);
		
			 InputStreamReader isr = new InputStreamReader(fis);
			 BufferedReader bufferedReader = new BufferedReader(isr);
			 StringBuilder sb = new StringBuilder();
			 String line;
			 while ((line = bufferedReader.readLine()) != null) {
			     sb.append(line);
			 }
			 
			 String json = sb.toString();
			 TypeToken<ArrayList<Film>> token = new TypeToken<ArrayList<Film>>() {};
			 ArrayList<Film> returnList = new Gson().fromJson(json, token.getType());
			 
			 return returnList;
		 } catch (FileNotFoundException e1) {
			 throw new JSONReaderException("JSON Reader Exception: File not found");
		 } catch (IOException e) {
			 throw new JSONReaderException("JSON Reader Exception: IO Problems");
		 }
	}
}
