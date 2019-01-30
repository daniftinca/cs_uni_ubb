package demo;

import java.util.ArrayList;

import filme.Film;
import reader.AwesomeDeserializer;
import writer.AwesomeSerializer;

public class Demo {

	public static void main(String[] args) throws Exception {
		//Nicht sicher was ich im Demo machen kann... Vielleicht einen live Datei Read/Write Demonstration? (aehnlich wie im UnitTests)
		//Habe nur die Serialization gemacht. Die anderen sind sehr ahnlich, nur verschiedene Objekte die das Read/Write machen.
		String[] listaActori= new String[100];
		listaActori[0] = "Adi";
		listaActori[1] = "Vasilica";
		Film film1 = new Film("TitluFilm1",2000,8,10 ,listaActori);
		Film film2 = new Film("TitluFilm2",2001,9,7 ,listaActori);
		
		ArrayList<Film> listaFilme = new ArrayList<Film>();
		
		listaFilme.add(film1);
		listaFilme.add(film2);
		
		String path1 = System.getProperty("user.dir")+"\\src\\demo\\filmeActual.ser";
		
		ArrayList<Film> demoArray = new ArrayList<Film>();
		
		AwesomeSerializer awsSerializer = new AwesomeSerializer();
		AwesomeDeserializer awsDeserializer = new AwesomeDeserializer();
		
		awsSerializer.writeMovies(listaFilme, path1);
		
		demoArray = awsDeserializer.readMovies(path1);
		
		for(int i=0;i<demoArray.size();i++) {
			System.out.println("----- ----- ----- -----");
			System.out.println("Title: "+demoArray.get(i).getTitel());
			System.out.println("Basispreis: "+demoArray.get(i).getBasispreis());
			System.out.println("Bewertung: "+demoArray.get(i).getBewertung());
			System.out.println("Jahr: "+demoArray.get(i).getErschienJahr());
			String[] schauspieler = demoArray.get(i).getListeSchauspieler();
			
			System.out.print("Schauspieler: ");
			for(int j=0;j<schauspieler.length;j++) {
				if(schauspieler[j]==null)
					break;
				System.out.print(schauspieler[j]+" ");
			}
			System.out.println("\n----- ----- ----- -----");
		}
	}

}
