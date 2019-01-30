package lab6.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {

	public static Person deserializiere(final String dateiName) {
		
		try {
			FileInputStream fis = new FileInputStream(dateiName);
			ObjectInputStream ojs = new ObjectInputStream(fis);
			
			return (Person) ojs.readObject();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
