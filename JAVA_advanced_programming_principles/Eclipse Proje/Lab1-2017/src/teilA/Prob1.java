package teilA;
import helper.HelperTools;

public class Prob1 {
	private int nr_primit;
	
	public Prob1(int n){
		nr_primit = n;
	}
	
	
	public void solve() {
		int rezultat = nr_primit+1;
		while(!HelperTools.isPrim(rezultat)) {
			rezultat++;
		}
		System.out.println(rezultat);
	}
}
