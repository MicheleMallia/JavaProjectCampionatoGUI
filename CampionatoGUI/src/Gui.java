import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;

// questa classe rappresenta una finestra con una etichetta di
// testo e un bottone. Visto che l'unico evento generato
// è la pressione del bottone, la stessa classe farà anche
// da gestore dell'evento
public class Gui extends JFrame implements ActionListener {

	static String calendario = null;
	static String esiti = null;
	static String classifica = null;
	static String classificaHTML = null;
	// memorizza un riferimento all'altra finestra
	private JTextArea textarea;
	private JButton btn_1 = null;
	private JButton btn_2 = null;
	private JScrollPane scrollpanel = null;
	
	// costruttore (fa tutto il lavoro)
	public Gui(String calendario, String esiti, String classifica, String classificaHTML) {
		this.calendario = calendario;
		this.esiti = esiti;
		this.classifica = classifica;
		this.classificaHTML = classificaHTML;
		this.setTitle("Calendario");
		
		textarea = new JTextArea(10,30);
		textarea.setEditable(false);
		textarea.setText(calendario);
		scrollpanel = new JScrollPane(textarea);
		scrollpanel.setPreferredSize(new Dimension(360, 180));
		this.setSize(420,280);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JButton btn_1 = new JButton("Esito Partite");
		btn_1 = new JButton("Esito Partite");
		btn_1.setActionCommand("ESITO");
		btn_1.addActionListener(this);
		btn_2 = new JButton("Classifica");
		btn_2.setActionCommand("CLASSIFICA");
		btn_2.addActionListener(this);
		JPanel panel = new JPanel();
		panel.add(scrollpanel);
		panel.add(btn_1);
		panel.add(btn_2);
		// visualizza tutto
		this.add(panel);
		//this.add(panel);
		// visualizza la finestra
		this.setVisible(true);
	}

	// gestore dell'evento di pressione del bottone
	public void actionPerformed(ActionEvent evt) {
		
		switch (evt.getActionCommand()){
		case "ESITO":
			this.setTitle("Esiti");
			textarea.setText(esiti);
			textarea.setCaretPosition(20);
			this.setSize(420,280);
			scrollpanel.setPreferredSize(new Dimension(360, 180));
			btn_1.setText("Calendario");
			btn_1.setActionCommand("CALENDARIO");
			btn_2.setText("Classifica");
			btn_2.setActionCommand("CLASSIFICA");
			break;
		case "CALENDARIO":
			this.setTitle("Calendario");
			textarea.setText(calendario);
			textarea.setCaretPosition(20);
			this.setSize(420,280);
			scrollpanel.setPreferredSize(new Dimension(360, 180));
			btn_1.setText("Esito Partite");
			btn_1.setActionCommand("ESITO");
			break;
		case "CLASSIFICA":
			this.setTitle("Classifica");
			textarea.setText(classifica);
			textarea.setCaretPosition(20);
			this.setSize(680,300);
			scrollpanel.setPreferredSize(new Dimension(600, 200));
			btn_1.setText("Indietro");
			btn_1.setActionCommand("ESITO");
			btn_2.setText("HTML");
			btn_2.setActionCommand("HTML");
			break;
		case "HTML":
			FileWriter fWriter = null;
			BufferedWriter writer = null;
			try {
			    fWriter = new FileWriter("Classifica.html");
			    writer = new BufferedWriter(fWriter);
			    writer.write(classificaHTML);
			    //writer.newLine();
			    //writer.write(esiti);
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
			break;
		}
		
	}
	
}
