package teilB;

import helper.HelperTools;

public class Prob8 {
private int nr_primit;
	
	public Prob8(int n){
		nr_primit = n;
	}
	
	public void solve() {
		int rezultat = nr_primit;
		while(!HelperTools.isPrim(rezultat)) {
			rezultat--;
		}
		System.out.println(rezultat);
	}
}
