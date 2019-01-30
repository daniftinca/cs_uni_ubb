/**
 * 
 */
package repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import domain.Notebook;

/**
 * @author Dan
 *
 */
public class Repository {
	private List<Notebook> myCarRepo;

	public Repository(List<Notebook> myCarRepo) {
		super();
		this.myCarRepo = myCarRepo;
	}
	
	public Repository(String fileName) {
		super();
		loadFromFile(fileName);
	}
	
	private void loadFromFile(String fileName) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			
			while (line != null) {
				myCarRepo.add(new Notebook(line));
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	public List<Notebook> getMyNotebookRepo() {
		// TODO Auto-generated method stub
		return null;
	}
}
