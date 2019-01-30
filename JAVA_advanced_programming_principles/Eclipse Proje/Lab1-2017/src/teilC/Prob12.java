package teilC;

import helper.HelperTools;

public class Prob12 {
	private int[] listaNr;
	private int nrElemente;
	
	public Prob12(int[] lista_Nr, int nrElem) {
		listaNr = lista_Nr;
		nrElemente = nrElem;
	}
	
	public void solve() {
		int suma=0;
		for(int i=0;i<nrElemente;i++) {
			if(HelperTools.isPrim(listaNr[i]))
				suma+=listaNr[i];
		}
		
		System.out.println("Suma este: "+suma);
	}
}
