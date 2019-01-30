package teilA;
import java.util.Date;
import java.util.Calendar;
import java.util.concurrent.*;

public class Prob3 {
	private Date birthDate,today = new Date();
	private Calendar cal = Calendar.getInstance();
	
	
	
	public Prob3(int an,int luna, int zi) {
		
		cal.set(Calendar.YEAR, an);
		cal.set(Calendar.MONTH, luna-1);
		cal.set(Calendar.DAY_OF_MONTH, zi);
		birthDate = cal.getTime();
	}
	
	public void solve() {
		long diff = today.getTime() - birthDate.getTime();
		System.out.println("Nr. zile: "+(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)+2));
	}
}
