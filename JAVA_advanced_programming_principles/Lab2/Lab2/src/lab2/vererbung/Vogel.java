package lab2.vererbung;

public class Vogel extends Tier {

	private String farbe;
	
	public Vogel(String name, int nrVonBeinen, String was, String farbe) {
		super(name, nrVonBeinen, was);
		this.farbe = farbe;
	}
	
	public void fliegt() {
		System.out.println(getName() + " fliegt");
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

}
