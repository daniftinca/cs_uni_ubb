package lab2.schnittstellen;

public class Tier {

	private String name;
	private int nrVonBeinen;
	private String was;

	public Tier(String name, int nrVonBeinen, String was) {
		super();
		this.name = name;
		this.nrVonBeinen = nrVonBeinen;
		this.was = was;
	}
	
	public void sagt() {
		System.out.println(name + " sagt " + was);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNrVonBeinen() {
		return nrVonBeinen;
	}
	public void setNrVonBeinen(int nrVonBeinen) {
		this.nrVonBeinen = nrVonBeinen;
	}
	public String getWas() {
		return was;
	}
	public void setWas(String was) {
		this.was = was;
	}
	
	
	
	
}
