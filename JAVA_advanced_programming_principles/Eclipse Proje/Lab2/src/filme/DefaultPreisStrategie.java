/**
 * 
 */
package filme;

/**
 * @author Dan
 * Schnittstelle fur Preisberechnung
 */
public interface DefaultPreisStrategie {

	/**
	 * Liefert den Preis nach Rabbat
	 * @param preis double, der Basispreis
	 * @return Endpreis
	 */
	public double kalkulierePreis(double preis);
}
