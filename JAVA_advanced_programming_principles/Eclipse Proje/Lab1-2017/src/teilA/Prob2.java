package teilA;
import helper.HelperTools;

public class Prob2 {

	private int nr_dat;
	public Prob2(int nr) {
		nr_dat = nr;
	}
	
	public void solve() {
		int nr2 = nr_dat;
		boolean res = false;
		while(!res) {
			nr2--;
			while(!HelperTools.isPrim(nr2)) {
				nr2--;
			}
			if(HelperTools.isPrim(nr_dat-nr2)) {
				res=true;
			}
			if(nr2<=0) {
				res=false;
				break;
			}
		}
		if(res) {
			System.out.println("Numerele sunt: "+nr2+", "+(nr_dat-nr2));
		}
		else {
			System.out.println("Nu se poate.");
		}
	}
}
