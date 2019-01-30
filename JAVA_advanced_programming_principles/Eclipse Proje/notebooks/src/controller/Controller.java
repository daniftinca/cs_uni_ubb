package controller;

import java.util.List;
import java.util.stream.Collectors;

import exceptions.MyException;
import model.Notebook;
import repository.Repository;

public class Controller {

private Repository repo;
	
	public Controller(Repository repo) {
		super();
		this.repo = repo;
	}

	public Controller(String fileName) throws MyException {
		super();
		this.repo = new Repository(fileName);
	}
	
	/**
	 * filters all the Notebooks with CDstuff in them
	 * @return
	 */
	public List<Notebook> filterNotebooksWithCD() {
		List<Notebook> myFilterStuff = repo.getMyNotebookRepo()
				.stream()
				.filter(listElem -> listElem.isCdLaufWerk())
				.collect(Collectors.toList());;
		return myFilterStuff;
	}
	
	
	
	public Repository getRepo() {
		return repo;
	}

	public void setRepo(Repository repo) {
		this.repo = repo;
	}
}
