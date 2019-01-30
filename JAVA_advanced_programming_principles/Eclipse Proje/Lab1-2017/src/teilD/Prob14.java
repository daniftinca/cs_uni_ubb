package teilD;

import helper.HelperTools;

public class Prob14 {
	int[] sir_dat;
	int nr_elem;
	public Prob14(int[] sir,int nr_elems){
		sir_dat = sir;
		nr_elem = nr_elems;
	}
	
	public void solve() {
		int prim_minim = Integer.MAX_VALUE;
		for(int i=0;i<nr_elem;i++) {
			if(HelperTools.isPrim(sir_dat[i])) {
				if(sir_dat[i]<prim_minim)
					prim_minim = sir_dat[i];
			}
		}
		System.out.println("Minimul este: "+ prim_minim);
	}
}
