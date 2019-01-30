package lab2.schnittstellen;

import lab2.schnittstellen.Tier;

public class Demo {
	public static void main(String[] args) {
		Vogel adler = new Vogel("adler",2,"???");
		
		adler.sagt();
		
		adler.fliegt();
		adler.fliegen2(true);
		
		Flugzeug flugzeug = new Flugzeug();
		
		flugzeug.fliegt();
		flugzeug.fliegen2(true);
	}
}
