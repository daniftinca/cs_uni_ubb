package lab5.patterns;

public class FahrzeugBuilder {

	private String marke;
	private float preis;
	private double kapazitaet;
	private String farbe;
	private boolean mitBenzin;
	public FahrzeugBuilder(String marke, float preis, double kapazitaet) {
		super();
		this.marke = marke;
		this.preis = preis;
		this.kapazitaet = kapazitaet;
		this.farbe = "rot";
		this.mitBenzin = true;
	}

	
	public FahrzeugBuilder farbe (String farbe) {
		this.farbe = farbe;
		return this;
	}
	
	public FahrzeugBuilder mitBenzin (boolean mitBenzin) {
		this.mitBenzin = mitBenzin;
		return this;
	}
	
	public Fahrzeug build() {
		return new Fahrzeug(marke,preis,kapazitaet,farbe,mitBenzin);
	}
	
	
}
