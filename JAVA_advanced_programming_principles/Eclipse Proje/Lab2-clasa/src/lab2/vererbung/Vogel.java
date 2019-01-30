package lab2.vererbung;

import lab2.schnittstellen.Tier;

public class Vogel extends Tier{

	public Vogel(String name, int nrVonBeinen, String was) {
		super(name, nrVonBeinen, was);
		// TODO Auto-generated constructor stub
	}
	
	public void fliegt() {
		System.out.println(getName() + " fliegt.");
	}
	
	
	
}
