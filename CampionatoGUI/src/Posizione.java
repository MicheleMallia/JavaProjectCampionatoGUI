
public class Posizione {
	
	private String squadra;
	private int punteggio;
	private int partiteVinte;
	private int partitePerse;
	private int partitePari;
	
	
	public Posizione(String s, int p, int v, int l, int x){
		this.squadra = s;
		this.punteggio = p;
		this.partiteVinte = v;
		this.partitePerse = l;
		this.partitePari = x;
	}
	
	public void vinciPartita(){
		partiteVinte++;
		punteggio = punteggio +3;
	}
	
	public void perdiPartita(){
		partitePerse++;
	}
	
	public void parZero(){
		partitePari++;
		punteggio++;
	}
	
	public void pareggio(){
		partitePari++;
		punteggio++;
	}
	
	public String getSquadra(){
		return squadra;
	}
	
	public int getPv(){
		return partiteVinte;
	}
	
	public int getPp(){
		return partitePerse;
	}
	
	public int getPpar(){
		return partitePari;
	}
	
	public int getPunteggio(){
		return punteggio;
	}
	
	public void setPunteggio(int n){
		punteggio = n;
	}
	
	public String toString(){
		return squadra+"		"+punteggio+"	"+partiteVinte+"	"+partitePerse+"	"+partitePari;
	}
	
	public String toHTML(){
		return "<td>" + squadra + "<td>" + punteggio + "<td>" + partiteVinte + "<td>" + partitePerse + "<td>" + partitePari;
	}
}
