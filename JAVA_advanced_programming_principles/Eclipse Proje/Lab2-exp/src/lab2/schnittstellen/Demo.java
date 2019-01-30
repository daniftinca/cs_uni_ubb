package lab2.schnittstellen;

public class Demo {
	
	public static void main(String[] args) {
		
		Vogel vogel = new Vogel("Adler", 2, "cip-cirip", "braun");
		vogel.sagt();
		vogel.fliegt();
		vogel.fliegtMitJet();
		
		System.out.println();
		
		Flugzeug flugzeug = new Flugzeug();
		flugzeug.fliegt();
		flugzeug.fliegtMitJet();
		
	}
	
}
