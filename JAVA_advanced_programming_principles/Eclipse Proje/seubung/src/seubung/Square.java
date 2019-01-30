package seubung;

import java.security.InvalidParameterException;

import javax.activity.InvalidActivityException;

public class Square {

	private int sidelength=1;
	
	public Square(int sidelength){
		
		if(sidelength>0) {
			this.sidelength = sidelength;
		} else {
			throw new InvalidParameterException();
		}
	}

	public int getSidelength() {
		return sidelength;
	}

	public void setSidelength(int sidelength) {
		this.sidelength = sidelength;
	}
	
	public int getArea() {
		return sidelength*sidelength;
	}
	
}
