/**
 * 
 */
package seminar2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dan
 *
 */
public class LifoContainer implements Container {

	List<Task> container = new ArrayList<Task>();
	/* (non-Javadoc)
	 * @see seminar2.Container#remove()
	 */
	@Override
	public Task remove() {
		Task myObj = container.get(container.size());
		container.remove(container.size());
		return myObj;
	}

	/* (non-Javadoc)
	 * @see seminar2.Container#add(seminar2.Task)
	 */
	@Override
	public void add(Task task) {
		container.add(task);

	}

	/* (non-Javadoc)
	 * @see seminar2.Container#size()
	 */
	@Override
	public int size() {
		return container.size();
	}

	/* (non-Javadoc)
	 * @see seminar2.Container#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		if(container.size()>0)
			return false;
		return true;
	}

}
