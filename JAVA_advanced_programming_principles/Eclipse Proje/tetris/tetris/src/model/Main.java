package model;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Integer> lista = new ArrayList<>();
		lista.add(1);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		lista.add(3);
		
		
		Brain brain = new Brain(6, lista);
		
		Nod castig = brain.dfsUsingStack();
		//Nod castig = brain.gbfs();
		System.out.println(castig);
		
		Brain brain2 = new Brain(6,lista);
		Nod castig2 = brain2.gbfs();
		System.out.println(castig2);
		
	}

}
