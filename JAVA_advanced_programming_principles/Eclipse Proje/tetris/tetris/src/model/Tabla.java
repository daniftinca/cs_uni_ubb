package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tabla {
	int[][] tabla;
	Map<List<Integer>,Piesa> mapPiese = new HashMap<>();
	int sizeX;
	public Tabla(int sizeX) {
		this.tabla = new int[sizeX][sizeX];
		this.sizeX = sizeX;
	}
	public Tabla(int[][] tabla, int sizeX) {
		int[][] current = new int[sizeX][sizeX];
		for(int i=0; i<tabla.length; i++)
			  for(int j=0; j<tabla[i].length; j++)
			    current[i][j]=tabla[i][j];
		this.tabla = current;
		this.sizeX = sizeX;
	}
	public int[][] getTabla() {
		return tabla;
	}
	public void setTabla(int[][] tabla) {
		this.tabla = tabla;
	}
	
	public Tabla punePiesaTry(Piesa piesa, int coordX, int coordY) {
		int[][] tablaCurrent = this.getTabla();
		int[][] piesaMat = piesa.getPiesa();
		int i2=0;int j2=0;
		for(int i=coordX;i<coordX+piesa.getLength();i++) {
			for(int j=coordY;j<coordY+piesa.getWidth();j++) {
				tablaCurrent[i][j]+=piesaMat[i2][j2];
				j2++;
			}
			i2++;
			j2=0;
		}
		Tabla tabla = new Tabla(tablaCurrent, this.getSizeX());
		return tabla;
	}
	
	public Tabla scoatePiesaTry(Piesa piesa, int coordX, int coordY) {
		int[][] tablaCurrent = this.getTabla();
		int[][] piesaMat = piesa.getPiesa();
		int i2=0;int j2=0;
		for(int i=coordX;i<coordX+piesa.getLength();i++) {
			for(int j=coordY;j<coordY+piesa.getWidth();j++) {
				tablaCurrent[i][j]-=piesaMat[i2][j2];
				j2++;
			}
			i2++;
			j2=0;
		}
		Tabla tabla = new Tabla(tablaCurrent, this.getSizeX());
		return tabla;
	}
	
	
	
	public boolean tablaIsBuna(Tabla tabla,int size) {
		int[][] matrix = tabla.getTabla();
		for(int i = 0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(matrix[i][j]>1) {
					return false;
				}
			
			}
		}
		return true;
		
	}
	
	public int getSizeX() {
		return sizeX;
	}
	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}
	public List<Tabla> expand(Piesa piesa){
		Tabla tablaCurent = new Tabla(this.getTabla(), this.getSizeX());
		List<Tabla> listaNoduri = new ArrayList<>();
		for(int i=0;i<sizeX-piesa.getLength()+1;i++) {
			for(int j=0;j<sizeX-piesa.getWidth()+1;j++) {
				tablaCurent = tablaCurent.punePiesaTry(piesa, i, j);
				if(tablaIsBuna(tablaCurent, tablaCurent.getSizeX())) {
					listaNoduri.add(tablaCurent);
					List<Integer> coords = new ArrayList<>();
					coords.add(i);
					coords.add(j);
					mapPiese.put(coords, piesa);
				}
				tablaCurent = new Tabla(this.getTabla(), this.getSizeX());
			} 
		}
		return listaNoduri;	
	}
	
	public int getConditie() {
		int sum=0;
		for(int i=(this.sizeX/2);i<this.sizeX;i++) {
			for(int j=0;j<this.sizeX;j++)
				sum+=this.tabla[i][j];
		}
		return sum;
	}
	
	@Override
	public String toString() {

		for(int i=0;i<sizeX;i++) {
			for(int j=0;j<sizeX;j++) {
				System.out.print(tabla[i][j]+" ");
				
			}
			System.out.println(" ");
		}
		
		return "Tabla [tabla=" + Arrays.toString(tabla) + "]";
	}
}
