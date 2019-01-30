package model;

import java.util.ArrayList;
import java.util.List;

import aiPart.Brain;

public class Main {

	public static void main(String[] args) {
		Tabla tabla = new Tabla(5);
		Piesa piesa = new Piesa(1);
		piesa.rotireStanga();
		Piesa piesa2 = new Piesa(2);
		piesa2.rotireStanga();
		piesa2.rotireStanga();
		piesa2.rotireStanga();
		Piesa piesa3 = new Piesa(3);
		/*System.out.println(piesa.getLength()+" "+piesa.getWidth());
		//tabla.punePiesaTry(piesa, 2, 1);
		List<Tabla> table = tabla.expand(piesa);
		List<Tabla> table2 = table.get(0).expand(piesa2);	
		for(Tabla t : table2) {
			t.toString();
			System.out.println(" ");
		}*/
		
		List<Piesa> piese = new ArrayList<>();
		piese.add(piesa);
		piese.add(piesa2);
		piese.add(piesa3);
		
		Nod radacina = new Nod(tabla);		
		
		
		
		/*int ct = 1;
		for(Nod nod : nodGraph) {
			if(ct == 87) {
			System.out.println(nod.toString());
			}
			ct++;
		}*/
		
		List<Integer> lista = new ArrayList<>();
		
		lista.add(1);
		lista.add(2);
		lista.add(3);
		
		
		Brain brain = new Brain(4, lista);
		System.out.println("incepe dfs");
		brain.dfsUsingStack();
		System.out.println(brain.getGraph().getNrNoduri());
		
		
	}

}
