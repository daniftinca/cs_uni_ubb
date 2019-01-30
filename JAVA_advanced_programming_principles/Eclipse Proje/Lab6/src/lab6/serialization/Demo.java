package lab6.serialization;

public class Demo {

	public static void main(String[] args) {
		
		Person hulk = createPerson();
		Serialization.serializiere(hulk);
		
		Person desHulk = Deserialization.deserializiere("person.ser");
		System.out.println(desHulk.toString());
	}
	
	
	
	private static Person createPerson() {
		return new Person("Hulk", 32, " Str. abcd 123", false);
	}

}
