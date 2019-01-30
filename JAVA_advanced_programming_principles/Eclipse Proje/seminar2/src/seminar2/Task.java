package seminar2;

public abstract class Task {

	private  int id;
	private String descriere;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescriere() {
		return descriere;
	}
	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}
	public Task(int id, String descriere) {
		super();
		this.id = id;
		this.descriere = descriere;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", descriere=" + descriere + "]";
	}
	
	public abstract void execute();
}
