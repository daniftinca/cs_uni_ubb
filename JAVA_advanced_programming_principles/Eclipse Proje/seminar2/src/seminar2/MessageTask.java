package seminar2;

public class MessageTask extends Task {

	
	public MessageTask(int id, String descriere) {
		super(id, descriere);
	}

	@Override
	public void execute() {
		System.out.println(toString());
	}

}
