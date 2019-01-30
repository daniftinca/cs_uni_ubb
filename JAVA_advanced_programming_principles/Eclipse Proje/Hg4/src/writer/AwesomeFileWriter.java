/**
 * 
 */
package writer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import exceptions.FileWriterException;
import filme.Film;

/**
 * @author Dan Class that specializes in writing to normal files.
 */
public class AwesomeFileWriter implements AwesomeWriter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see writer.AwesomeWriter#writeMovies(java.util.ArrayList)
	 */
	@Override
	public void writeMovies(ArrayList<Film> paramList, String fileName) throws FileWriterException {

		try {
			InputStream outin = new FileInputStream(new File(fileName));
			outin.close();
			PrintWriter writer = null;
			String actorNames = "";
			writer = new PrintWriter(fileName, "UTF-8");
			System.out.println("Chiar am incercat sa scriu in asta: " + fileName);
			for (int i = 0; i < paramList.size(); i++) {

				Film film = paramList.get(i);

				writer.println(film.getTitel());
				writer.println(film.getErschienJahr());
				writer.println(film.getBewertung());
				String[] actorList = film.getListeSchauspieler();
				for (int j = 0; j < actorList.length; j++) {

					actorNames += actorList[j] + ", ";
				}
				writer.println(actorNames);
				writer.println(film.getBasispreis());
				actorNames = "";
			}
			writer.close();
		} catch (FileNotFoundException e) {
			throw new FileWriterException("FileWriterException: File not found");
		} catch (UnsupportedEncodingException e) {
			throw new FileWriterException("FileWriterException: Unsupported Encoding");
		} catch (Exception e) {
			throw new FileWriterException("Other Filewriter Exception");
		}

	}

}
