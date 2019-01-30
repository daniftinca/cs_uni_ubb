package model;

import java.util.ArrayList;
import java.util.List;

public class Nod {
	private Tabla tabla;
	private Nod parinte;
	private List<Nod> copii;
	private int nivel;
	private boolean visited = false;

	public Nod(Tabla tabla, Nod parinte, List<Nod> copii, int nivel) {
		super();
		this.tabla.setTabla(tabla.getTabla());
		this.parinte = parinte;
		this.copii = copii;
		this.nivel = nivel;
	}

	public Nod(Tabla tabla, Nod parinte, int nivel) {
		super();
		this.tabla = tabla;
		this.parinte = parinte;
		this.copii = new ArrayList<Nod>();
		this.nivel = nivel;
	}

	public Nod(Tabla tabla) {
		super();
		this.tabla = tabla;
		this.parinte = new Nod();
		this.copii = new ArrayList<>();
	}

	public Nod() {
		super();
	}

	public int getConditie() {
		return this.tabla.getConditie();
	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

	public Nod getParinte() {
		return parinte;
	}

	public void setParinte(Nod parinte) {
		this.parinte = parinte;
	}

	public List<Nod> getCopii() {
		return copii;
	}

	public void setCopii(List<Nod> copii) {
		this.copii = copii;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public boolean getVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Nod> getNeighbours(Graph graph) {
		List<Nod> neighbours = new ArrayList<>();
		for (int i = 0; i < graph.getNrNoduri() - 1; i++) {
			if (graph.getNoduri().get(i).getParinte() == this) {
				neighbours.add(graph.getNoduri().get(i));
			}
		}
		return neighbours;
	}

	public void expand(Piesa piesa) {
		List<Tabla> table = tabla.expand(piesa);

		for (Tabla tabla : table) {

			copii.add(new Nod(tabla, this, this.nivel + 1));

		}

	}

	@Override
	public String toString() {
		return "Nod [tabla=" + tabla.toString() + "]";
	}

}
