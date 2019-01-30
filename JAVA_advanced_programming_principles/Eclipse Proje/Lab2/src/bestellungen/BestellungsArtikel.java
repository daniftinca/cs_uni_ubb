/**
 *  
 */
package bestellungen;

import filme.Film;

/**
 * Ein Bestellungsartikel besteht aus einem Filmobjekt und die Nummer von
 * ahnliche Filme in der Bestellung.
 * 
 * @author Dan
 *
 */
public class BestellungsArtikel {

	private Film film;
	private int amount;

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public BestellungsArtikel(Film film, int amount) {
		super();
		this.film = film;
		this.amount = amount;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (!(other instanceof BestellungsArtikel))
			return false;
		BestellungsArtikel otherBestellungsArtikel = (BestellungsArtikel) other;
		if (otherBestellungsArtikel.getFilm() != film) {
			return false;
		}
		if (otherBestellungsArtikel.getAmount() != amount) {
			return false;
		}
		return true;
	}

}
