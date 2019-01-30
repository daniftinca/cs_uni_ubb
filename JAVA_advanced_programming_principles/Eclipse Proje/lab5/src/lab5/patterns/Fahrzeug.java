package lab5.patterns;

public class Fahrzeug {
	
	private String marke;
	private float preis;
	private double kapazitaet;
	private String farbe;
	private boolean mitBenzin;
	
	public Fahrzeug(String marke, float preis, double kapazitaet, String farbe, boolean mitBenzin) {
		super();
		this.marke = marke;
		this.preis = preis;
		this.kapazitaet = kapazitaet;
		this.farbe = farbe;
		this.mitBenzin = mitBenzin;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public float getPreis() {
		return preis;
	}

	public void setPreis(float preis) {
		this.preis = preis;
	}

	public double getKapazitaet() {
		return kapazitaet;
	}

	public void setKapazitaet(double kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public boolean isMitBenzin() {
		return mitBenzin;
	}

	public void setMitBenzin(boolean mitBenzin) {
		this.mitBenzin = mitBenzin;
	}

	@Override
	public String toString() {
		return "Fahrzeug [marke=" + marke + ", preis=" + preis + ", kapazitaet=" + kapazitaet + ", farbe=" + farbe
				+ ", mitBenzin=" + mitBenzin + "]";
	}
	
	

}
