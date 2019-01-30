package lab2.schnittstellen;

public interface FliegenVerhalten {

	public void fliegt();
	
	default void fliegtMitJet() {
		System.out.println("Fliegt mit Jet");
	}
}
