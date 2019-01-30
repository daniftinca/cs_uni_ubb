package lab2.strategy;

public class HorrorStrategie implements PreisStrategie {

	@Override
	public double kalkuliereFinalePreis(double preis) {
		return preis * 0.5;
	}

}
