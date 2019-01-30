package lab6.serialization;

import java.io.Serializable;

public class Person implements Serializable{


	private static final long serialVersionUID = 8956047306153893859L;
	private String name;
	private int alter;
	private String adresse;
	private boolean hatFuererschein;
	public Person(String name, int alter, String adresse, boolean hatFuererschein) {
		super();
		this.name = name;
		this.alter = alter;
		this.adresse = adresse;
		this.hatFuererschein = hatFuererschein;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAlter() {
		return alter;
	}
	public void setAlter(int alter) {
		this.alter = alter;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public boolean isHatFuererschein() {
		return hatFuererschein;
	}
	public void setHatFuererschein(boolean hatFuererschein) {
		this.hatFuererschein = hatFuererschein;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", alter=" + alter + ", adresse=" + adresse + ", hatFuererschein="
				+ hatFuererschein + "]";
	}
	
	
}
