/**
 * 
 */
package domain;

import java.util.Arrays;
import java.util.List;

/**
 * @author Dan
 *
 */
public class Notebook {

	private String mark;
	private String model;
	private int yearOfFabrication;
	private double rpm;
	private float litersPerHundredKM;
	private String fuelType;
	public Notebook(String mark, String model, int yearOfFabrication, double rpm, float litersPerHundredKM,
			String fuelType) {
		super();
		this.mark = mark;
		this.model = model;
		this.yearOfFabrication = yearOfFabrication;
		this.rpm = rpm;
		this.litersPerHundredKM = litersPerHundredKM;
		this.fuelType = fuelType;
	}
	
	public Notebook(String carLine)  {
		super();
		List<String> carData = Arrays.asList(carLine.split("&"));
		mark = carData.get(1);
		model = carData.get(2);
		yearOfFabrication = Integer.parseInt(carData.get(3));
		rpm = Double.parseDouble(carData.get(4));
		litersPerHundredKM = Float.parseFloat(carData.get(5));
		fuelType = carData.get(6);
		
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYearOfFabrication() {
		return yearOfFabrication;
	}
	public void setYearOfFabrication(int yearOfFabrication) {
		this.yearOfFabrication = yearOfFabrication;
	}
	public double getRpm() {
		return rpm;
	}
	public void setRpm(double rpm) {
		this.rpm = rpm;
	}
	public float getLitersPerHundredKM() {
		return litersPerHundredKM;
	}
	public void setLitersPerHundredKM(float litersPerHundredKM) {
		this.litersPerHundredKM = litersPerHundredKM;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + Float.floatToIntBits(litersPerHundredKM);
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		long temp;
		temp = Double.doubleToLongBits(rpm);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + yearOfFabrication;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notebook other = (Notebook) obj;
		if (fuelType == null) {
			if (other.fuelType != null)
				return false;
		} else if (!fuelType.equals(other.fuelType))
			return false;
		if (Float.floatToIntBits(litersPerHundredKM) != Float.floatToIntBits(other.litersPerHundredKM))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (Double.doubleToLongBits(rpm) != Double.doubleToLongBits(other.rpm))
			return false;
		if (yearOfFabrication != other.yearOfFabrication)
			return false;
		return true;
	}
}
