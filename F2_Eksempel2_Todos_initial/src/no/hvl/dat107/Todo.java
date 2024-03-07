package no.hvl.dat107;

public class Todo {
	
	private int id;
	private String tekst;
	
	public Todo() {}

	public Todo(int id, String tekst) {
		this.id = id;
		this.tekst = tekst;
	}
	
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", tekst=" + tekst + "]";
	}
}
