/**
 * 
 */
package repository;

import java.util.ArrayList;

/**
 * @author Dan
 * Repository Class, Tasked with holding objects in an arraylist. 
 */
public class Repository<T> {
	ArrayList<T> repoList = new ArrayList<T>();

	public Repository(ArrayList<T> paramList) {
		super();
		repoList = paramList;
	}

	public ArrayList<T> getRepoList() {
		return repoList;
	}

	public void setRepoList(ArrayList<T> repoList) {
		this.repoList = repoList;
	}
	
	
}
