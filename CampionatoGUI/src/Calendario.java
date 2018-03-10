import java.util.Vector;


public class Calendario {

	private Vector <Giornata> gironi = new Vector <Giornata>();
	private Vector <Giornata> esiti = new Vector <Giornata>();	
	
	public Calendario(ListaSquadre squadre){
		gironi = new Vector <Giornata>();
	}
	

	public void AlgoritmoDiBerger(ListaSquadre squadre){
		int numero_squadre = squadre.lista.size();
	    int giornate = (numero_squadre)*2;
	    
	    /*L'impostazione qua sotto è valida se c'è un numero di squadre
	     * dispari. Per le squadre pari si fa semplicemente (numero_squadre/2)
	     * e non si aggiungono né la squadra in mezzo né la squadra riposo
	     * 
	     * VA INSERITO IF N SQUADRE &2 == 0
	     */
	    
	    
	    /* crea gli array per le due liste in casa e fuori */
	    String[] casa = new String[(numero_squadre /2)+1];
	    String[] trasferta = new String[(numero_squadre /2)+1];
	    
	    for (int i = 0; i < numero_squadre /2; i++) {
	        casa [i] = squadre.getSquadra(i).toString(); 
	        trasferta[i] = squadre.getSquadra(numero_squadre - 1 - i).toString(); 
	    }
	   casa[numero_squadre/2] = squadre.getSquadra(9).toString();
	   trasferta[numero_squadre/2] = "riposo";
	  
	    for (int i = 0; i < giornate; i++) {
	        /* stampa le partite di questa giornata */
	    	//System.out.printf("%d^ Giornata\n",i+1);
	        Giornata gio = new Giornata();
	        Partita p;
	        /* alterna le partite in casa e fuori */
	        if (i % 2 == 0) {
	            for (int j = 0; j < numero_squadre /2 ; j++){
	                //System.out.printf("%d  %s - %s\n", j+1, trasferta[j], casa[j]);
	                p = new Partita(trasferta[j], casa[j]);
	                gio.aggiungiPartita(p);
	            }
	        }
	        else {
	            for (int j = 0; j < numero_squadre /2 ; j++) {
	                 //System.out.printf("%d  %s - %s\n", j+1, casa[j], trasferta[j]);
	                 p = new Partita(casa[j], trasferta[j]);
	                 gio.aggiungiPartita(p);
	            }
	        }
	        gironi.addElement(gio);
	       
	      
	        // Ruota in gli elementi delle liste, tenendo fisso il primo elemento
	        // Salva l'elemento fisso
	        String pivot = casa [0];
	 
	        /* sposta in avanti gli elementi di "trasferta" inserendo 
	           all'inizio l'elemento casa[1] e salva l'elemento uscente in "riporto" */
			   
	 		String riporto = trasferta[trasferta.length - 1];
			trasferta = shiftRight(trasferta, casa[1]);
	
	        /* sposta a sinistra gli elementi di "casa" inserendo all'ultimo 
	           posto l'elemento "riporto" */
			   
	        casa = shiftLeft(casa, riporto);
	 
	        // ripristina l'elemento fisso
	        casa[0] = pivot ;
	    }     
	}
	
	public void AlgoritmoDiBerger2(ListaSquadre squadre){	    
	    
		String[] squadre_string;
		int numero_squadre;
		int giornate;
		
		if(squadre.size()%2==1){
	    	squadre_string = new String[squadre.size() + 1];
	    	squadre_string[squadre.size()] = "Riposo";
	    	for(int i=0; i<squadre_string.length-1; i++)
		    	squadre_string[i] = squadre.getSquadra(i).toString();
		}
	    else{
	    	squadre_string = new String[squadre.size()];
	    	for(int i=0; i<squadre_string.length; i++)
		    	squadre_string[i] = squadre.getSquadra(i).toString();
	    }
		
		numero_squadre = squadre_string.length;
    	giornate = (numero_squadre) - 1;
	    
	    
	    
		String[] casa = new String[numero_squadre /2];
	    String[] trasferta = new String[numero_squadre /2];

	    for (int i = 0; i < numero_squadre / 2 ; i++) {
	        casa [i] = squadre_string[i]; 
	        trasferta[i] = squadre_string[numero_squadre - 1 - i];
	    }
	    
	    for (int i = 0; i < giornate; i++) {
	    	 Giornata gio = new Giornata();
		     Partita p = null;
		     if (i % 2 == 0) {
		    	 for (int j = 0; j < numero_squadre /2 ; j++) {
		    		 if( (!trasferta[j].equals("Riposo")) && (!casa[j].equals("Riposo")) ){
			          		p = new Partita(casa[j], trasferta[j]);
			          		gio.aggiungiPartita(p);
			          }
		    	 }
		     }
		     else {
		        for (int j = 0; j < numero_squadre /2 ; j++) {
		          	if( (!trasferta[j].equals("Riposo")) && (!casa[j].equals("Riposo")) ){
		          		p = new Partita(casa[j], trasferta[j]);
		          		gio.aggiungiPartita(p);
		          	}
		        }
		     }
		     
		     gironi.addElement(gio);
		     
		     String pivot = casa[0];
		     String riporto = trasferta[trasferta.length - 1];
			 trasferta = shiftRight(trasferta, casa[1]);

			 casa = shiftLeft(casa, riporto);
		 
		     casa[0] = pivot ;
	    }
	    
	    for (int i = 0; i < giornate; i++) {
	    	 Giornata gio = new Giornata();
		     Partita p = null;
		     if (i % 2 == 0) {
		    	 for (int j = 0; j < numero_squadre /2 ; j++) {
		    		 if( (!trasferta[j].equals("Riposo")) && (!casa[j].equals("Riposo")) ){
			          		p = new Partita(casa[j], trasferta[j]);
			          		gio.aggiungiPartita(p);
			          }
		    	 }
		     }
		     else {
		        for (int j = 0; j < numero_squadre /2 ; j++) {
		        	if( (!trasferta[j].equals("Riposo")) && (!casa[j].equals("Riposo")) ){
		          		p = new Partita(casa[j], trasferta[j]);
		          		gio.aggiungiPartita(p);
		          	}
		        }
		     }
		     
		     gironi.addElement(gio);
		     
		     String pivot = casa[0];
		     String riporto = trasferta[trasferta.length - 1];
			 trasferta = shiftRight(trasferta, casa[1]);

			 casa = shiftLeft(casa, riporto);
		 
		     casa[0] = pivot ;
	    }
	    
	    
	}
		
	 private String[] shiftLeft(String[] data, String add) {
			String[] temp = new String[data.length];
			for (int i = 0; i < data.length-1; i++) {
				temp[i] = data[i + 1];
			}
			temp[data.length - 1] = add;
			return temp;
		}
	 
		private String[] shiftRight(String[] data, String add) {
			String[] temp = new String[data.length];
			for (int i = 1; i < data.length; i++) {
				temp[i] = data[i - 1];
			}
			temp[0] = add;
			return temp;
		}
		
	public String toString(){
		return gironi.toString();
	}
	
	
	public String visualizzaCalendario(){
		String tmp = "";
		for(int i = 0; i<gironi.size();i++){
			tmp += "Giornata numero "+(i+1);
			tmp += "\n\n";
			for(int j = 0; j<gironi.get(i).size(); j++){
				if(!gironi.get(i).visualizzaPartite(j).getCasa().equals("riposo") && !gironi.get(i).visualizzaPartite(j).getOspite().equals("riposo")){
					tmp += gironi.get(i).visualizzaPartite(j).getCasa()+" - "+gironi.get(i).visualizzaPartite(j).getOspite()+"\n";
				}
			}
			tmp += "\n";
		}
		return tmp;
	}
	
	
	public void esitoPartite(){
		
		for(int i = 0; i<gironi.size();i++){
			Giornata gioEsito = new Giornata();
			Partita p;
			for(int j = 0; j<gironi.get(i).size(); j++){
				int gO=0;
				int gC=0;
				p = new Partita(gironi.get(i).visualizzaPartite(j).getCasa(), gironi.get(i).visualizzaPartite(j).getOspite(), gC,gO);
				gioEsito.aggiungiPartita(p);
			}
			esiti.addElement(gioEsito);
		}
	}
	
	public int size(){
		return esiti.size();
	}
	
	public Giornata getGiornata(int n){
		return esiti.get(n);
	}
	
	
	public String visualizzaEsito(){
		String tmp = "";
		for(int i = 0; i<esiti.size();i++){
			tmp += "Risultati giornata numero "+(i+1);
			tmp += "\n\n";
			for(int j = 0; j<esiti.get(i).size(); j++){
				if(!esiti.get(i).visualizzaPartite(j).getCasa().equals("riposo") && !esiti.get(i).visualizzaPartite(j).getOspite().equals("riposo")){
					tmp += esiti.get(i).visualizzaPartite(j).getCasa() +"  "+esiti.get(i).visualizzaPartite(j).getGoalCasa()+" - "+esiti.get(i).visualizzaPartite(j).getGoalOspite() + " " + esiti.get(i).visualizzaPartite(j).getOspite()+"\n";
				}
			}
			tmp += "\n";
		}
		return tmp;
	}
	
	public String esitotoHTML(){
		String tmp = "";
		for(int i = 0; i<esiti.size();i++){
			tmp += "<table style='display: inline-block; margin: 10px;'><tr><th>Giornata " + (i+1) + "</th><tr>"; 
			for(int j = 0; j<esiti.get(i).size(); j++){
				if(!esiti.get(i).visualizzaPartite(j).getCasa().equals("riposo") && !esiti.get(i).visualizzaPartite(j).getOspite().equals("riposo")){
					tmp+= "<tr><td style='width: 100px; text-align: right;'>" + esiti.get(i).visualizzaPartite(j).getCasa() +"</td><td style='width: 20px; text-align: right;'>"+esiti.get(i).visualizzaPartite(j).getGoalCasa()+"</td><td style='text-align: center;'>-</td><td style='width: 20px;'>"+esiti.get(i).visualizzaPartite(j).getGoalOspite() + "</td><td style='width: 100px;'>" + esiti.get(i).visualizzaPartite(j).getOspite() + "</td></tr>";
				}
			}
		}
		return tmp += "</table>";
	}
	
	
	
	
}
