/**
 * 
 */
package token;

/**
 * @author Dan
 *  Die Nummertoken enthalt eine Nummer.
 *
 */
public class NumberToken extends Token {

	public NumberToken(String value) {
		super(value);
	}

	
	/**
	 * Konvertiert das Value-Attribut zu double und liefert es.
	 * @return
	 */
	public double getDouble() {
		return Double.parseDouble(this.getValue());
	}
}
