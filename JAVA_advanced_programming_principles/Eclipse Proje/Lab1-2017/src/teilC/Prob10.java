package teilC;
import helper.HelperTools;

public class Prob10 {
	private int nrDat;
	
	public Prob10(int nr) {
		nrDat = nr;
	}
	
	public void solve() {
		System.out.println(HelperTools.fibo(nrDat));
	}
}
