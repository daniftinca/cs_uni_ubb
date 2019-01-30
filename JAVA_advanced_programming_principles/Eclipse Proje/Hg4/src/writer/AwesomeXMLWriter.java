/**
 * 
 */
package writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import exceptions.XMLWriterException;
import filme.Film;

/**
 * @author Dan
 * Class that specializes in writing to XML files.
 */
public class AwesomeXMLWriter implements AwesomeWriter {

	/* (non-Javadoc)
	 * @see writer.AwesomeWriter#writeMovies(java.util.ArrayList)
	 */
	@Override
	public void writeMovies(ArrayList<Film> paramList, String fileName) throws XMLWriterException {
		
		
		
		try {
			FileOutputStream outputStream = new FileOutputStream(fileName);
		
		XStream xStream = new XStream(new StaxDriver());
		XStream.setupDefaultSecurity(xStream);
		String xmlString = xStream.toXML(paramList);
		outputStream.write(xmlString.getBytes());
		outputStream.close();
		} catch (FileNotFoundException e) {
			throw new XMLWriterException("XML Exception: File Not Found");
		} catch (IOException e) {
			throw new XMLWriterException("XML Exception: IO Problems");
		}
		
	}

}
