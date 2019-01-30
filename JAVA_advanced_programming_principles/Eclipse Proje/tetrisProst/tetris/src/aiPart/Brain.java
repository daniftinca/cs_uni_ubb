package aiPart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.google.common.collect.Sets;

import model.Graph;
import model.Nod;
import model.Piesa;
import model.Tabla;

public class Brain {
	private Tabla tabla = new Tabla(4);
	private List<Piesa> piese = new ArrayList<Piesa>();
	private Nod radacina = new Nod(tabla);	
	private Graph graph = new Graph(radacina);
	
	private Set<List<Piesa>> multePiese = new HashSet<>();

	public Brain(int tablaSize, List<Integer> pieseList) {
		tabla= new Tabla(tablaSize);
		for(int i=0;i<pieseList.size();i++) {
			piese.add(new Piesa(pieseList.get(i)));
			//System.out.println(piese.get(i).getPiesa().toString());
		}
		populatePiese();
		createGraph();
	}
	
	public void populatePiese() {
		List<Set<Piesa>> sets = new ArrayList<>();
		for(Piesa piesa : piese) {
			sets.add(getAllRotations(piesa));
			
		}
		
		Set<List<Piesa>> result = Sets.cartesianProduct(sets);
		
		multePiese = result;
		
		/*for(List<Piesa> list : result) {
			for(Piesa piesa : list) {
				System.out.println(piesa.matriceToString());
			}
			System.out.println("gfregter");
		}*/
		//System.out.println(result);
	}
	
	private Set<Piesa> getAllRotations(Piesa piesa) {
		Set<Piesa> pieseList = new HashSet<Piesa>();
		pieseList.add(piesa.copyPiesa());
		for(int i=0;i<3;i++) {
			piesa.rotireStanga();
			pieseList.add(piesa.copyPiesa());
		}
		return pieseList;
	}
	

	
	public void createGraph() {		
		graph.createGraph(multePiese);
	}
	
	
	public  void dfsUsingStack()
	{
		Nod nod = this.radacina;
		Stack<Nod> stack = new Stack<Nod>();
		stack.add(nod);
		nod.setVisited(true);
		while (!stack.isEmpty())
		{
			Nod element = stack.pop();
			//System.out.println(element);
 
			List<Nod> neighbours = element.getNeighbours(graph);
			for (int i = 0; i < neighbours.size(); i++) {
				Nod n=neighbours.get(i);
				if(n!=null && !n.getVisited())
				{
					stack.add(n);
					n.setVisited(true);

				}
			}
		}
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

	public Set<List<Piesa>> getMultePiese() {
		return multePiese;
	}

	public void setMultePiese(Set<List<Piesa>> multePiese) {
		this.multePiese = multePiese;
	}

	
	
	
}
