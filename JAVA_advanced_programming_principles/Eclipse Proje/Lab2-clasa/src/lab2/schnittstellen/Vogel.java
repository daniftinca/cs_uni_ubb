package lab2.schnittstellen;

public class Vogel extends Tier implements FliegenVerhalten {

	public Vogel(String name, int nrVonBeinen, String was) {
		super(name, nrVonBeinen, was);
	}

	@Override
	public void fliegt() {
		System.out.println(getName()+" fliegt");

	}

	@Override
	public void fliegen2(boolean mitJet) {
		if(mitJet) {
			System.out.println(getName()+" fliegt mit Jet");
		} else {
			fliegt();
		}
		
	}

}
