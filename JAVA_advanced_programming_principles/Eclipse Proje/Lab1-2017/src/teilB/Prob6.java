package teilB;
import helper.HelperTools;

public class Prob6 {
	int nr_dat;
	
	public Prob6(int nr) {
		nr_dat = nr;
	}
	
	public void solve() {
		System.out.println(HelperTools.get_palindrom(nr_dat));
	}
}
