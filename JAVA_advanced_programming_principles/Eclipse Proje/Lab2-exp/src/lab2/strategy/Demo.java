package lab2.strategy;

public class Demo {
	
	public static void main(String[] args) {
		
		Film film1 = new Film(100, new SciFiStrategie());
		System.out.println("Preis: " + film1.kalkulierePreis());
		
		Film film2 = new Film(100, new HorrorStrategie());
		System.out.println("Preis: " + film2.kalkulierePreis());

	}
	

}
