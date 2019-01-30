package lab2.vererbung;

public class Demo {
	
	public static void main(String[] args) {
		
		Tier hund = new Tier("Cuci", 4, "woof");
		hund.sagt();
		
		Tier katze = new Tier("Puf", 4, "meow");
		katze.sagt();
		((Vogel)katze).fliegt();
		
		Tier adler = new Vogel("Adler", 2, "cip-cirip", "braun");
		adler.sagt();
		((Vogel)adler).fliegt();
		
	}
	
}
