package lab7.exceptions;

import java.io.IOException;
import java.text.ParseException;

public abstract class Demo {
	int i;
	private static int j; 
	public static void main(String[] args) throws MeineException{
		j=3;
		try {
			werfeIOException();
		} catch (IOException e) {
			throw new MeineErsteException(e.getMessage());
		}
		
		try {
			werfeParseException();
		} catch (ParseException e) {
			throw new MeineZweiteException(e.getMessage());
		}

	}
	
	public static void werfeIOException() throws IOException{
		throw new IOException("Meine IO Exception");
		
	}
	
	public static void werfeParseException() throws ParseException{
		throw new ParseException("Maine Parse Exception", 0);
	}

}

class D extends Demo { 
	
	int k = j;
	
}
