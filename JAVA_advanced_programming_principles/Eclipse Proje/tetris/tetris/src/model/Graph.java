package model;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Nod> createGraph(List<Piesa> piese) {
		List<Nod> graph = new ArrayList<>();
		
		radacina.setNivel(0);
		graph.add(radacina);
		nrNoduri++;
		
		for(int i = 0; i < piese.size(); i++) {
			int stop = graph.size();
			
			for(int j = 0; j < stop; j++) {
				
				if(graph.get(j).getNivel() == i) {
					
					Nod curentNod = graph.get(j);
					curentNod.expand(piese.get(i));
					
					for(Nod nod : curentNod.getCopii()) {

						graph.add(new Nod(nod.getTabla(), curentNod, curentNod.getNivel() + 1));
						nrNoduri++;
						
					}
					
				}
				
			}
			
		}
		
		noduri = graph;
		
		return graph;
		
	}
	
}
