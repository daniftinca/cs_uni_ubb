/**
 * 
 */
package reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import exceptions.XMLReaderException;
import filme.Film;

/**
 * @author Dan
 * Class that specializes in reading from an XML file and turning the contents into an ArrayList of movies.
 */
public class AwesomeXMLReader implements AwesomeReader {

	/* (non-Javadoc)
	 * @see reader.AwesomeReader#readMovies()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Film> readMovies(String fileName) throws XMLReaderException {
		byte[] encoded;
		try {
			encoded = Files.readAllBytes(Paths.get(fileName));
			String xml =  new String(encoded, "UTF-8");
			XStream xStream = new XStream(new StaxDriver());
			XStream.setupDefaultSecurity(xStream); 
			xStream.addPermission(AnyTypePermission.ANY);
			ArrayList<Film> movieList = (ArrayList<Film>)xStream.fromXML(xml);
			return movieList;
		} catch (IOException e) {
			throw new XMLReaderException("XML Reader Exception: File not found");
		}
	}
}
