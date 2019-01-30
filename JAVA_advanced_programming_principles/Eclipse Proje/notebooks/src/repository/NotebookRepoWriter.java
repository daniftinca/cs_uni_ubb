package repository;

import java.util.List;

import exceptions.MyException;
import model.Notebook;
/**
 * Writer interface. Declares the notebook writer behavior
 * @author Dan
 *
 */
public interface NotebookRepoWriter {

	/**
	 * Writes from a list to a file
	 * @param notebookList
	 * @param fileName
	 * @throws MyException
	 */
	public void WriteFromListToFile(List<Notebook> notebookList,String fileName) throws MyException;
}
