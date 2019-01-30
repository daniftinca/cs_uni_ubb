package seminar2;

public class Factory {

	@SuppressWarnings("unused")
	private Container container;
	
	public void create(String tip) {
		if(tip == "fifo") {
			container = new FifoContainer();
		}
		if(tip == "lifo") {
			container = new LifoContainer();
		}
	}
}
