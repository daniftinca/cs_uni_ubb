package lab2.schnittstellen;

public class Flugzeug implements FliegenVerhalten {

	@Override
	public void fliegt() {
		System.out.println("Flugzeug fliegt");
	}

	@Override
	public void fliegen2(boolean mitJet) {
		if(mitJet) {
		System.out.println("Flugzeug fliegt mit jet");
		} else {
			fliegt();
		}
	}

}
