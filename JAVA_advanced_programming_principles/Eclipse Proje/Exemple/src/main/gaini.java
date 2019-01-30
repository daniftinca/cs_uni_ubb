package main;

public class gaini {
	private int varsta, nr_oua_pe_zi;
	static int numar_total_gaini_create;
	
	public gaini() {
		numar_total_gaini_create++;
		this.varsta = 0;
		this.nr_oua_pe_zi = 0;
		System.out.println("O gaina de varsta "+ this.varsta + " si care face "+ this.nr_oua_pe_zi + " oua pe zi a fost creata.");
	}
	public gaini(int varsta_de_la_user, int nr_oua_pe_zi_de_la_user) {
		numar_total_gaini_create++;
		this.varsta = varsta_de_la_user;
		this.nr_oua_pe_zi = nr_oua_pe_zi_de_la_user;
		System.out.println("O gaina de varsta "+ this.varsta + " si care face "+ this.nr_oua_pe_zi + " oua pe zi a fost creata.");
	}
	
	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public int getNr_oua_pe_zi() {
		return nr_oua_pe_zi;
	}

	public void setNr_oua_pe_zi(int nr_oua_pe_zi) {
		this.nr_oua_pe_zi = nr_oua_pe_zi;
	}
	
}


