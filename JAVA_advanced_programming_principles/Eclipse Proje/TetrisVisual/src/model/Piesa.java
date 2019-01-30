package model;

public class Piesa {

	private int[][] piesa;
	int length = 2;
	int width = 3;
	int tip;
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
	
	public int getTip() {
		return tip;
	}

	public void setTip(int tip) {
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
	
	
}
