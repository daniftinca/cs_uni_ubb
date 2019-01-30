package repository;

import java.util.List;

import exceptions.MyException;
import model.Notebook;

/**
 * Reader interface. Declares the notebook reading behavior
 * @author Dan
 *
 */
public interface NotebookRepoReader {

	/**
	 * Reads from a file to a list.
	 * @param fileName
	 * @return
	 * @throws MyException
	 */
	public List<Notebook> readreadFromFileToList(String fileName) throws MyException;
}
