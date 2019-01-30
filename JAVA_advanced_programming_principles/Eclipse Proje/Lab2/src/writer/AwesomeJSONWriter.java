/**
 * 
 */
package writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import filme.Film;

/**
 * @author Dan
 * Class that specializes in writing to JSON files.
 */
public class AwesomeJSONWriter implements AwesomeWriter {
	/* (non-Javadoc)
	 * @see writer.AwesomeWriter#writeMovies(java.util.ArrayList)
	 */
	@Override
	public void writeMovies(ArrayList<Film> paramList, String fileName) {
	
		try {
			FileOutputStream outputStream = new FileOutputStream(fileName);
			Gson gson = new GsonBuilder().create();
			String jsonOutput = gson.toJson(paramList);
			outputStream.write(jsonOutput.getBytes());
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
