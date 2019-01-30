package teilC;
import helper.HelperTools;

public class Prob11 {
	private int[] listaNr;
	private int nrElemente;
	
	public Prob11(int[] lista_Nr, int nrElem) {
		listaNr = lista_Nr;
		nrElemente = nrElem;
	}
	
	public void solve() {
		int produs=1;
		for(int i=0;i<nrElemente;i++) {
			if(HelperTools.isPrim(listaNr[i]))
				produs*=listaNr[i];
		}
		
		System.out.println("Produsul este: "+produs);
	}
}
