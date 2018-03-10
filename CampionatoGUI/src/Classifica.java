import java.util.Vector;
public class Classifica {
	
	
	Vector<Posizione> classifica = new Vector<Posizione>();
	
	public Classifica(){
		classifica = new Vector<Posizione>();
	}
	
	public void CostruisciClassifica(Calendario c, ListaSquadre l){
		
		for(int k = 0; k<l.size();k++){
			Posizione p = new Posizione(l.getSquadra(k).toString(), 0,0,0,0);
			for(int i = 0; i<c.size();i++){
				for(int j = 0; j<c.getGiornata(i).size(); j++){
					//VITTORIA PERDITA PAREGGIO IN CASA
					if(l.getSquadra(k).toString().equals(c.getGiornata(i).visualizzaPartite(j).getCasa())){
						//VITTORIA
						if(c.getGiornata(i).visualizzaPartite(j).getGoalCasa() > c.getGiornata(i).visualizzaPartite(j).getGoalOspite()){
							p.vinciPartita();
						}
						//PERDITA
						else if(c.getGiornata(i).visualizzaPartite(j).getGoalCasa() < c.getGiornata(i).visualizzaPartite(j).getGoalOspite()){
							p.perdiPartita();
						}
						//PAREGGIO 0
						else if(c.getGiornata(i).visualizzaPartite(j).getGoalCasa() == c.getGiornata(i).visualizzaPartite(j).getGoalOspite() && c.getGiornata(i).visualizzaPartite(j).getGoalCasa() == 0 && c.getGiornata(i).visualizzaPartite(j).getGoalOspite() ==0){
							p.parZero();
						}
						//PAREGGIO
						else if(c.getGiornata(i).visualizzaPartite(j).getGoalCasa() == c.getGiornata(i).visualizzaPartite(j).getGoalOspite() && c.getGiornata(i).visualizzaPartite(j).getGoalCasa() > 0 && c.getGiornata(i).visualizzaPartite(j).getGoalOspite() >0){
							p.pareggio();
						}
					}
					//VITTORIA PERDITA PAREGGIO FUORI-CASA
					else if(l.getSquadra(k).toString().equals(c.getGiornata(i).visualizzaPartite(j).getOspite())){
						//VITTORIA
						if(c.getGiornata(i).visualizzaPartite(j).getGoalOspite() > c.getGiornata(i).visualizzaPartite(j).getGoalCasa()){
							p.vinciPartita();
						}
						//PERDITA
						else if(c.getGiornata(i).visualizzaPartite(j).getGoalOspite() < c.getGiornata(i).visualizzaPartite(j).getGoalCasa()){
							p.perdiPartita();
						}
						//PAREGGIO 0
						else if(c.getGiornata(i).visualizzaPartite(j).getGoalOspite() == c.getGiornata(i).visualizzaPartite(j).getGoalCasa() && c.getGiornata(i).visualizzaPartite(j).getGoalCasa() == 0 && c.getGiornata(i).visualizzaPartite(j).getGoalOspite() ==0){
							p.parZero();
						}
						//PAREGGIO
						else if(c.getGiornata(i).visualizzaPartite(j).getGoalOspite() == c.getGiornata(i).visualizzaPartite(j).getGoalCasa() && c.getGiornata(i).visualizzaPartite(j).getGoalCasa() > 0 && c.getGiornata(i).visualizzaPartite(j).getGoalOspite() >0){
							p.pareggio();
						}
					}
					
				}
			}
			classifica.add(p);
		}
		//Selection sort per ordinare il vettore in base al punteggio e alle partite vinte.
		for (int i = 0; i<classifica.size()-1;i++){
			int posmax = i;
			for(int j = i; j<classifica.size(); j++){
				if(classifica.get(j).getPunteggio()+classifica.get(j).getPv()>classifica.get(posmax).getPunteggio()+classifica.get(posmax).getPv())
					posmax=j;
			}
			
			Posizione tmp = new Posizione(classifica.get(i).getSquadra(), classifica.get(i).getPunteggio(), classifica.get(i).getPv(), classifica.get(i).getPp(), classifica.get(i).getPpar());
			classifica.set(i, classifica.get(posmax));
			classifica.set(posmax, tmp);
		}
		System.out.println("");
		
		for(int j = 0; j<classifica.size();j++){
			System.out.println(classifica.get(j));
		}
		
	}
	
	public String visualizzaClassifica(){
		String tmp = "Pos	Squadra		Punti	V	S	P\n";
		for(int j = 0; j<classifica.size();j++){
			tmp += (j+1) +"	"+ classifica.get(j).toString() + "\n";
		}
		return tmp;
	}
	
	public String toHTML(){
		String tmp = "<table style='max-width:450px; width: 100%; text-align: left; margin-left: auto; margin-right: auto; margin-bottom: 25px; margin-top: 5px;'><tr><th>Pos</th><th>Squadra</th><th>Punti</th><th>V</th><th>S</th><th>P</th></tr>";
		for(int j = 0; j<classifica.size();j++){
			tmp += "<tr><td>"+ (j+1) +"</td>"+ classifica.get(j).toHTML() + "</tr>";
		}
		return tmp+"</table>";
	}
	
	public void setClas(int i, Posizione p){
		classifica.set(i, p);
	}
	
	public void setPunt(int i, int n){
		classifica.get(i).setPunteggio(n);
	}
}
