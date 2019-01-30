/**
 * 
 */
package repository;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import exceptions.MyException;
import model.Notebook;

/**
 * @author Dan
 *
 */
public class Repository implements NotebookRepoReader, NotebookRepoWriter {

	private List<Notebook> myNotebookRepo;

	public Repository(List<Notebook> myNotebookRepo) {
		super();
		this.myNotebookRepo = myNotebookRepo;
	}
	
	public Repository(String fileName) throws MyException {
		super();
		myNotebookRepo = readreadFromFileToList(fileName);
	}
	
	
	public List<Notebook> getMyNotebookRepo() {
		return myNotebookRepo;
	}

	public void setMyNotebookRepo(List<Notebook> myNotebookRepo) {
		this.myNotebookRepo = myNotebookRepo;
	}

	@SuppressWarnings("resource")
	@Override
	public List<Notebook> readreadFromFileToList(String fileName) throws MyException {
		List<Notebook> retList = new ArrayList<Notebook>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fileName));
			String line = reader.readLine();
			
			String marke,modell;
			double preis;
			boolean cdLaufWerk;
			
			while (line != null) {
				List<String> notebookData = Arrays.asList(line.split("\\|\\|"));
				marke = notebookData.get(0);
				modell= notebookData.get(1);
				preis = Double.parseDouble(notebookData.get(2));
				if(notebookData.get(3).equals("Ja"))
					cdLaufWerk = true;
				else 
					cdLaufWerk = false;
				
				retList.add(new Notebook(marke, modell, preis, cdLaufWerk));
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			throw new MyException("Serialized Exception: IO Problems");
		} catch (IOException e) {
			throw new MyException("Serialized Exception: IO Problems");
		}
		
		return retList;
		
		
		
	}
	
	

	@Override
	public void WriteFromListToFile(List<Notebook> notebookList,String fileName) throws MyException {
		try {
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(fos);
			oos.writeObject(notebookList);				
			fos.close();
		} catch (IOException e1) {
			throw new MyException("Serialized Exception: IO Problems");
		}
		
	} catch (FileNotFoundException e) {
		throw new MyException("Serialized Exception: File not found");
	}
		
	}

	
}
