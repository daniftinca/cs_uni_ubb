package lab2.strategy;

public class SciFiStrategie implements PreisStrategie{

	@Override
	public double kalkuliereFinalePreis(double preis) {
		return preis * 0.9;
	}

}
