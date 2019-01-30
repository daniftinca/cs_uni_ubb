package helloworld;

import java.util.LinkedList;

public class joacaLinkedList {
	
	
	public static void joaca() {
		LinkedList<String> asdf = new LinkedList<String>();
		
		asdf.add("Primul");
		asdf.add("Al doilea");
		
		System.out.println(asdf);
		
		System.out.println(asdf.pop());
		System.out.println(asdf);
		}
}
