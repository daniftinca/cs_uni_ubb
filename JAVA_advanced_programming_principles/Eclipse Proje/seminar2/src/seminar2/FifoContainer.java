package seminar2;

import java.util.ArrayList;
import java.util.List;

public class FifoContainer implements Container {

	List<Task> container = new ArrayList<Task>();
	@Override
	public Task remove() {
		Task myObj = container.get(0);
		container.remove(0);
		return myObj;
	}

	@Override
	public void add(Task task) {
		container.add(task);
	}

	@Override
	public int size() {
		return container.size();
	}

	@Override
	public boolean isEmpty() {
		if(container.size()>0)
			return false;
		return true;
	}

}

  