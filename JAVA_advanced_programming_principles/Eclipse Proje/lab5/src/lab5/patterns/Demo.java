package lab5.patterns;

public class Demo {

	public static void main(String args[]) {
		Fahrzeug opel  = new FahrzeugBuilder("opel",1234,3500.0)
				.farbe("Schwarz")
				.mitBenzin(false)
				.build();
		System.out.println(opel.toString());
		
		Fahrzeug ferrari = new FahrzeugFactory().erstelleFerrari();
		System.out.println(ferrari.toString());
		
		
	}
}
