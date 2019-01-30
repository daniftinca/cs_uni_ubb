package teilB;
import helper.HelperTools;
public class Prob7 {
	int nrDat;
	//de intrebat: de ce nu se pun bine numerele in array.
	public Prob7(int nr_dat) {
		nrDat = nr_dat;
	}
	
	public void solve() {
		if(HelperTools.isPerfect(nrDat))
			System.out.println("Numarul este perfect");
		else
			System.out.println("Numarul nu este perfect");
	}
}
