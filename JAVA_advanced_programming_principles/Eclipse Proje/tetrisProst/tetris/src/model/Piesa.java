package model;

import java.util.Arrays;

public class Piesa {

	private int[][] piesa;
	int length = 2;
	int width = 3;
	int tip = 0;
	public Piesa(int tip) {
		if(tip == 1) {
			piesa = new int[][] {{1,1,1,1}};
			length = 1;
			width = 4;
		} else if(tip == 2) {
			piesa = new int[][] {{1,0,0},{1,1,1}};
		} else if(tip == 3) {
			piesa = new int[][] {{1,0,1},{1,1,1}};
		} else if(tip == 4) {
			piesa = new int[][] {{0,1,0},{1,1,1}};
		}
		this.tip = tip;
	}
	public int[][] getPiesa() {
		return piesa;
	}
	public void setPiesa(int[][] piesa) {
		this.piesa = piesa;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public Piesa copyPiesa() {
		Piesa newPiesa = new Piesa(tip);
		int[][] newMat = new int[length][width];
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				newMat[i][j] = piesa[i][j];
			}
		}
		newPiesa.setPiesa(newMat);
		newPiesa.setLength(length);
		newPiesa.setWidth(width);
		return newPiesa;
	}
	
	public void rotireStanga() {
		int[][] matriceRotita = new int[getWidth()][getLength()];
		
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				matriceRotita[j][i] = piesa[i][width - j - 1];
			}
		}
		this.piesa = matriceRotita;
		int aux = this.width;
		this.width = this.length;
		this.length = aux;
	}
	
	public String matriceToString() {
		String mat = "";
		for(int i = 0; i < length; i++) {
			for(int j = 0; j < width; j++) {
				mat = mat + piesa[i][j] + " ";
			}
			mat = mat + "\n";
		}
		return mat;
	}
	

	@Override
	public String toString() {
		return "Piesa [tip=" + tip + ", length=" + length + ", width=" + width + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(piesa);
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
		Piesa other = (Piesa) obj;
		if (!Arrays.deepEquals(piesa, other.piesa))
			return false;
		return true;
	}
	
	
}
