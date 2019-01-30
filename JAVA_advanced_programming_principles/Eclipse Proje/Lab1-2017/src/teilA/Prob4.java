package teilA;
import helper.HelperTools;

public class Prob4 {
	int nr_dat;
	
	public Prob4() {
		nr_dat=1;
	}
	public Prob4(int nr) {
		nr_dat = nr;
	}
	
	public void solve() {
		//System.out.println(nr_dat);
		int aux = nr_dat;
		while(true) {
			while(!HelperTools.isPrim(aux)) {
				aux++;
			}
			if(HelperTools.isPrim(aux+2)) {
				System.out.println("Numerele sunt: "+aux+", "+(aux+2));
				break;
			}
			aux++;
		}
	}
}
