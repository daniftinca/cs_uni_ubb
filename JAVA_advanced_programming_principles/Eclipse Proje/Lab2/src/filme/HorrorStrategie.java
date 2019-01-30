/**
 * 
 */
package filme;

import java.io.Serializable;

/**
 * @author Dan
 *
 */
public class HorrorStrategie implements DefaultPreisStrategie, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9072898032473266196L;

	@Override
	public double kalkulierePreis(double preis) {
		return preis * 0.5;
	}
}
