package prob1;
import java.util.Random;

public class RandNumGenerator {
	Random rnd = new Random();
	
	/**
	 * Random number generator
	 * @param range upper limit (lower limit = 0)
	 * @return rand int
	 */
	public int generate(int range) {
		return (int)Math.random()*range;
	}
	
	/**
	 * La fel ca cealalta doar ca in alt mod
	 * @param range upper limit (lower limit = 0)
	 * @return rand int
	 */
	public int generateNext(int range) {

		return rnd.nextInt(range);
	}
}
