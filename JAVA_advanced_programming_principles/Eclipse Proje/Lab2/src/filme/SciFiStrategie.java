/**
 * 
 */
package filme;

import java.io.Serializable;

/**
 * @author Dan
 *
 */
public class SciFiStrategie implements DefaultPreisStrategie, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1257332791386536554L;

	@Override
	public double kalkulierePreis(double preis) {
		return preis*0.9;
	}
}
