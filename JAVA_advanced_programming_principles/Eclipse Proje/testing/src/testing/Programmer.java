package testing;

import java.util.ArrayList;
import java.util.List;

public class Programmer extends Writer {

	public static void write() {
		 System.out.println("Writing code");
		 }
		 public static void main(String[] args) {
		 /*Writer w = new Programmer();
		 w.write();
		 Writer a = new Author();
		 w.write(); */
			 List<String> items = new ArrayList<>();
			 items.add("Pen");
			 items.add("Pencil");
			 items.add("Box");
			 for (String i : items) {
			 if (i.indexOf("P") == 0) {
			 continue;
			 } else {
			 System.out.print(i+" ");
			 }
			 }
		 }

}
