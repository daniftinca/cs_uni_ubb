package lab2.strategy;

public interface PreisStrategie {
	
	default public double kalkuliereFinalePreis(double preis) {
		return preis;
	};
}
