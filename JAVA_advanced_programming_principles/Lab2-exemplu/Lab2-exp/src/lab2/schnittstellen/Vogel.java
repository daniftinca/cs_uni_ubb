package lab2.schnittstellen;

public class Vogel extends Tier implements FliegenVerhalten{

	private String farbe;
	
	public Vogel(String name, int nrVonBeinen, String was, String farbe) {
		super(name, nrVonBeinen, was);
		this.farbe = farbe;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	@Override
	public void fliegt() {
		System.out.println(getName() + " fliegt");
	}

	@Override
	public void fliegtMitJet() {
		System.out.println(getName() + " fliegt mit Jet");
	}
}
