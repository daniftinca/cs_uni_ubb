/**
 * 
 */
package filme;

import java.io.Serializable;

/**
 * @author Dan
 *
 */
public class NormalPreisStrat implements DefaultPreisStrategie, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6976274523641873017L;

	@Override
	public double kalkulierePreis(double preis) {
		return preis;
	}
}
