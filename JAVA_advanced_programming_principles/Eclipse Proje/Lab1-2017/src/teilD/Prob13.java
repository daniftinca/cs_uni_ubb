package teilD;
import helper.HelperTools;

public class Prob13 {
	int[] sir_dat;
	int nr_elem;
	public Prob13(int[] sir,int nr_elems){
		sir_dat = sir;
		nr_elem = nr_elems;
	}
	
	public void solve() {
		int prim_maxim = Integer.MIN_VALUE;
		for(int i=0;i<nr_elem;i++) {
			if(HelperTools.isPrim(sir_dat[i])) {
				if(sir_dat[i]>prim_maxim)
					prim_maxim = sir_dat[i];
			}
		}
		System.out.println("Maximul este: "+ prim_maxim);
	}
}
