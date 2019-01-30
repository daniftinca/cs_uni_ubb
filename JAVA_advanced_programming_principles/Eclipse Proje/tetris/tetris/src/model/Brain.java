package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Brain {
	private Tabla tabla;
	private List<Piesa> piese = new ArrayList<Piesa>();
	private Nod radacina;
	private Graph graph;

	public Brain(int tablaSize, List<Integer> pieseList) {
		tabla = new Tabla(tablaSize);
		radacina = new Nod(tabla);
		graph = new Graph(radacina);
		for (int i = 0; i < pieseList.size(); i++) {
			piese.add(new Piesa(pieseList.get(i)));
			//System.out.println(piese.get(i).getPiesa().toString());
		}

		this.graph.createGraph(piese);

	}

	public Tabla getTabla() {
		return tabla;
	}

	public void setTabla(Tabla tabla) {
		this.tabla = tabla;
	}

	public List<Piesa> getPiese() {
		return piese;
	}

	public void setPiese(List<Piesa> piese) {
		this.piese = piese;
	}

	public Nod getRadacina() {
		return radacina;
	}

	public void setRadacina(Nod radacina) {
		this.radacina = radacina;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public void createGraph() {
		graph.createGraph(piese);
	}

	public Nod dfsUsingStack() {
		int maxCond = 0;
		Nod nodCastigator = new Nod();
		Nod nod = this.radacina;
		Stack<Nod> stack = new Stack<Nod>();
		stack.add(nod);
		nod.setVisited(true);
		while (!stack.isEmpty()) {
			Nod element = stack.pop();
			// System.out.println(element);

			List<Nod> neighbours = element.getNeighbours(graph);
			for (int i = 0; i < neighbours.size(); i++) {
				Nod n = neighbours.get(i);
				if (n != null && !n.getVisited()) {
					stack.add(n);
					n.setVisited(true);
					// System.out.println(n.getConditie());
					if (n.getConditie() > maxCond && n.getNivel() == piese.size()) {
						maxCond = n.getConditie();

						nodCastigator = n;
					}

				}
			}
		}
		return nodCastigator;
	}
	
	public List<Nod> sortNoduri(List<Nod> noduri) {
		List<Nod> newList = noduri;
		Collections.sort(newList, new Comparator<Nod>() {
		    @Override
		    public int compare(Nod lhs, Nod rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		        return lhs.getConditie() > rhs.getConditie() ? -1 : (lhs.getConditie()< rhs.getConditie()) ? 1 : 0;
		    }
		});
		Collections.reverse(newList); 
		return newList;
	}

	public Nod gbfs() {
		//int maxCond = 0;
		Nod nodCastigator = new Nod();
		Nod nod = this.radacina;
		Stack<Nod> stack = new Stack<Nod>();
		stack.add(nod);
		nod.setVisited(true);
		while (!stack.isEmpty()) {
			Nod element = stack.pop();
			// System.out.println(element);

			List<Nod> neighbours = element.getNeighbours(graph);
			neighbours = sortNoduri(neighbours);
			for (int i = 0; i < neighbours.size(); i++) {
				Nod n = neighbours.get(i);
				if (n != null && !n.getVisited()) {
					stack.add(n);
					n.setVisited(true);
					// System.out.println(n.getConditie());
					if ( n.getNivel() == piese.size()) {
						

						return nodCastigator = n;
					}

				}
			}
		}
		return nodCastigator;
	}

}
