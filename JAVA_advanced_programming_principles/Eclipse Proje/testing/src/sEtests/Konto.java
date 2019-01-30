package sEtests;

import java.security.InvalidParameterException;

public class Konto {

	private int kontoNummer;
	private double kontoStand;
	private int kundenAlter;
	private int kredit;
	
	
	public Konto(int kontoNummer, double kontoStand, int kundenAlter, int kredit) {
		super();
		this.kontoNummer = kontoNummer;
		this.kontoStand = kontoStand;
		if(this.kontoStand<0) {
			throw new InvalidParameterException("Keinen negativen Kontostand");
		}

		this.kundenAlter = kundenAlter;
		this.kredit = kredit;
		
	}



	public int getKontoNummer() {
		return kontoNummer;
	}



	public void setKontoNummer(int kontoNummer) {
		this.kontoNummer = kontoNummer;
	}



	public double getKontoStand() {
		return kontoStand;
	}



	public void setKontoStand(double kontoStand) {
		this.kontoStand = kontoStand;
	}



	public double abheben(double betrag) {
		if(betrag<0) {
			throw new InvalidParameterException("Bitte einen positiven Betrag eingeben");
		}
		if(betrag==0) {
			throw new InvalidParameterException("Der Betrag ist 0");
		}
		if(kontoStand-betrag>=0) {
			this.kontoStand = kontoStand-betrag;

			return kontoStand;
		}else {
			throw new InvalidParameterException("Bitte versuchen Sie nicht mehr als Sie haben abzuheben");
		}

	}

	public void kreditNehmen(double betrag){
		if(this.kundenAlter<18){

			throw new InvalidParameterException("Zu viel verlangt");
		}
		else if(this.kundenAlter>=18 && this.kundenAlter<=25){
			if((this.kredit+betrag)>=1000){
				throw new InvalidParameterException("Zu viel verlangt");
			}
		} else if(this.kundenAlter>25){
			kredit +=betrag;
		}

	}

    public int getKundenAlter() {
        return kundenAlter;
    }

    public void setKundenAlter(int kundenAlter) {
        this.kundenAlter = kundenAlter;
    }

    public int getKredit() {
        return kredit;
    }

    public void setKredit(int kredit) {
        this.kredit = kredit;
    }
}
