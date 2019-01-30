package lab6.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void serializiere(Person person) {
		
		try {
			FileOutputStream fos = new FileOutputStream("person.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(person);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
