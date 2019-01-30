package main;
import main.gaini;
public class Exemple {

	public static void main(String[] args) {
		gaini gaina_1 = new gaini(1,3);
		gaini gaina_2 = new gaini(2,2);
		
		gaina_1.setNr_oua_pe_zi(5);
		
		System.out.println(gaina_1.getNr_oua_pe_zi());
		
		gaini gaina_3 = new gaini();
		
		System.out.println(gaini.numar_total_gaini_create);

	}

}
