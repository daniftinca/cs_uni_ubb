package teilC;
import helper.HelperTools;

public class Prob9 {
	private int nrDat;
	
	public Prob9(int nr) {
		nrDat = nr;
	}
	
	public void solve() {
		int aux = nrDat;
		while(!HelperTools.isPerfect(aux)) {
			aux--;
		}
		System.out.println(aux);
	}
}
