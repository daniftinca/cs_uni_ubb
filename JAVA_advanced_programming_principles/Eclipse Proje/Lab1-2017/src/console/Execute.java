package console;
import teilA.*;
import teilD.*;
import teilB.*;
import teilC.*;

/**
 * Clasa care afiseaza rezultate pe ecran. nu face prea multe
 * @author Dan
 *
 */
public class Execute {

	public static void main(String[] args) {
	
		
		
		System.out.println("Problema 1: ");
		Prob1 prob1 = new Prob1(11);
		prob1.solve();
		
		System.out.println("Problema 2: ");		
		Prob2 prob2 = new Prob2(7);
		prob2.solve();
		
		System.out.println("Problema 3: ");
		Prob3 prob3 = new Prob3(2017,6,2);
		prob3.solve();
		
		System.out.println("Problema 4: ");		
		Prob4 prob4 = new Prob4(1);
		prob4.solve();
		
		System.out.println("Problema 5: ");
		Prob5 prob5 = new Prob5(3);
		prob5.solve();
		
		System.out.println("Problema 6: ");
		Prob6 prob6 = new Prob6(2273);
		prob6.solve();
		
		System.out.println("Problema 7: ");
		Prob7 prob7 = new Prob7(7);
		prob7.solve();
		
		System.out.println("Problema 8: ");
		Prob8 prob8 = new Prob8(10);
		prob8.solve();
		
		System.out.println("Problema 9: ");
		Prob9 prob9 = new Prob9(10);
		prob9.solve();
		
		System.out.println("Problema 10: ");
		Prob10 prob10 = new Prob10(14);
		prob10.solve();
		
		System.out.println("Problema 11: ");
		int[] listaProb11 = new int[] {10,11,2,4};
		Prob11 prob11 = new Prob11(listaProb11,4);
		prob11.solve();
		
		System.out.println("Problema 12: ");
		int[] listaProb12 = new int[] {10,11,2,3};
		Prob12 prob12 = new Prob12(listaProb12,4);
		prob12.solve();

		System.out.println("Problema 13: ");
		int[] sir = new int[] {3,4,7,10,11,12};
		Prob13 prob13 = new Prob13(sir,6);
		prob13.solve();
		
		System.out.println("Problema 14: ");
		int[] sir14 = new int[] {3,4,7,10,11,12};
		Prob14 prob14 = new Prob14(sir14,6);
		prob14.solve();
		
		System.out.println("Problema 15: ");
		int[] sir15 = new int[] {3,4,7,10,11,12};
		Prob15 prob15 = new Prob15(sir15,6);
		prob15
		.solve();
	}
}
