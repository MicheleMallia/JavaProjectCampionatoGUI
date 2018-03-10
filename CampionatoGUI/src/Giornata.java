import java.util.Vector;

public class Giornata {

	Vector <Partita> partite = new Vector <Partita>() ;
	
	public Giornata(){
	}
	
	public void aggiungiPartita(Partita partita){
		partite.add(partita);
	}
	
	/*
	public void aggiungiPartitaConEsito(PartitaConEsito partita2){
		partite.add(partita2);
	}
	*/
	
	
	public String toString(){
		return partite.toString();
	}
	
	public int size(){
		return partite.size();
	}
	
	public Partita visualizzaPartite(int j){
		return partite.get(j);
	}
}
