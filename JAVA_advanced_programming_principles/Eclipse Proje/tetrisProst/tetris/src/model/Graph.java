package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Graph {

	private int nrNoduri=1;
	private Nod radacina;
	private List<Nod> noduri = new ArrayList<>();
	
	public Graph(Nod radacina) {
		this.radacina = radacina;
	}

	public int getNrNoduri() {
		return nrNoduri;
	}

	public void setNrNoduri(int nrNoduri) {
		this.nrNoduri = nrNoduri;
	}

	public Nod getRadacina() {
		return radacina;
	}

	public void setRadacina(Nod radacina) {
		this.radacina = radacina;
	}
	public List<Nod> getNoduri() {
		return noduri;
	}
	public void setNoduri(List<Nod> noduri) {
		this.noduri = noduri;
	}
	
	public List<Nod> createGraph(Set<List<Piesa>> piese) {
		List<Nod> graph = new ArrayList<>();
		
		radacina.setNivel(0);
		graph.add(radacina);
		nrNoduri++;
		int startPunct = 0;
		for(List<Piesa> list : piese) {
			for(int i = 0; i < list.size(); i++) {
				int stop = graph.size();
				int nrcopii = 0;
				System.out.println(startPunct + " " + stop);
				for(int j = startPunct; j < stop; j++) {
					//System.out.println(startPunct);
					if(graph.get(j).getNivel() == i) {
						
						
						Nod curentNod = graph.get(j);
						System.out.println(curentNod.getTabla().toString());
						curentNod.expand(list.get(i));
						
						for(Nod nod : curentNod.getCopii()) {
	
							graph.add(new Nod(nod.getTabla(), curentNod, curentNod.getNivel() + 1));
							nrNoduri++;
							nrcopii++;

						}
						
					}
					
				}
				startPunct = graph.size() - nrcopii;
			}
		}
		
		noduri = graph;
		
		return graph;
		
	}
	
}
