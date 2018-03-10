import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
public class ListaSquadre {
	
	Vector<Squadra> lista = new Vector<Squadra>();
	
	public ListaSquadre(){
	}
	
	public void creaLista(Vector<Squadra> s){
		try{
			Scanner file_input =
				new Scanner ( new BufferedReader (
				new FileReader ("squadre.txt")));
				// legge tutto il file , aggiungendo i valori letti ai vettori
				while (file_input.hasNext()) {
					// nota : nome deve essere una singola parola ( usa next )
					lista.add(new Squadra(file_input.nextLine()));
					
				}file_input.close();	
		}
		catch ( IOException e) { // in caso di errori ...
			System . out . println (" ERRORE di I/O");
			System . out . println (e );
		}
	}
	
	public int size(){
		return lista.size();
	}
	
	public Squadra getSquadra(int i){
		return lista.get(i);
	}
}
