import java.util.Vector;

import javax.swing.*;
public class Campionato {

	public static void main(String[] args){
		
		Vector <Squadra> squadre = new Vector <Squadra> ();
		ListaSquadre l = new ListaSquadre();
		Calendario c = new Calendario(l);
		l.creaLista(squadre);
		c.AlgoritmoDiBerger2(l);
		c.esitoPartite();
		Classifica cla = new Classifica();
		cla.CostruisciClassifica(c, l);
		
		String esiti = c.visualizzaEsito();
		String calendario = c.visualizzaCalendario();
		String classifica = cla.visualizzaClassifica();
		String classificaHTML = cla.toHTML();
		int scelta;
		do{
			scelta = JOptionPane.showConfirmDialog(null,"Vuoi generare un campionato?",
					"Scelta",JOptionPane.YES_NO_OPTION);
			switch(scelta){
			case JOptionPane.YES_OPTION:
				Gui f1 = new Gui(calendario, esiti, classifica, classificaHTML);
			break;
			case JOptionPane.NO_OPTION:
				scelta = 0;
			break;
			}
		} while (scelta!=0);
		
		
		
		
		
		/*
		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
		    fWriter = new FileWriter("Classifica.html");
		    writer = new BufferedWriter(fWriter);
		    writer.write(cla.toHTML());
		    writer.newLine();
		    writer.write(c.esitotoHTML());
		    writer.close(); //make sure you close the writer object 
		} catch (Exception e) {
		  //catch any exceptions here
		}
		File htmlFile = new File("Classifica.html");
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/

	}
}
