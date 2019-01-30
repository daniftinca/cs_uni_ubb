package lab2.vererbung;

import lab2.schnittstellen.Tier;

public class Demo {
	public static void main(String[] args) {
		Tier hund = new Tier("hund", 4, "woof");
		hund.sagt();
		
		Tier katze = new Tier("katze", 4, "meow");
		katze.sagt();
		
		Tier adler = new Vogel("Adler",2,"???");
		adler.sagt();

		((Vogel)adler).fliegt();
	}
}
