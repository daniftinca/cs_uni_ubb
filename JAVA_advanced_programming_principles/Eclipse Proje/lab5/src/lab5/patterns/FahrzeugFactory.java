package lab5.patterns;

public class FahrzeugFactory {

	public Fahrzeug erstelleOpel() {
		return new Fahrzeug("opel", 1234, 3500.0, "rot", true);
	}
	
	public Fahrzeug erstelleFerrari() {
		return new Fahrzeug("ferrari", 12000, 2200.0, "blau", true);
	}
}
