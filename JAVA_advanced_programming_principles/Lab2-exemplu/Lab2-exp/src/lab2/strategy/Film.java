package lab2.strategy;

public class Film {
	
	private double preis;
	
	private PreisStrategie strategie;

	public Film(double preis, PreisStrategie strategie) {
		super();
		this.preis = preis;
		this.strategie = strategie;
	}
	
	public double kalkulierePreis() {
		return strategie.kalkuliereFinalePreis(preis);
	}
	
}
