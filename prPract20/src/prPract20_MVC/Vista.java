package prPract20_MVC;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Vista extends JPanel {
	
	private static final long serialVersionUID = 88259363022917391L;
	
	private JCheckBox chDiesel, chAsientos, chTapiceria, chLlantas, chPintura;
	private JComboBox<String> cbRadios;
	private JList<String> listaColores;
	private JScrollPane spLista;
	private JLabel etiqueta;
	
	private Map<String,Color> mapaColores;
	
	public Vista() {
		
		JPanel principal = new JPanel();
		 	principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		 	principal.setPreferredSize(new Dimension(300, 350));
			principal.setBorder(new EmptyBorder(15, 15, 15, 15));
			this.add(principal);

		iniciarColores();
		
		principal.add(crearPanelExtras());
		principal.add(crearPanelLlantas());
		principal.add(crearPanelColor());
		principal.add(crearPanelAcciones());
		
			
	}
	
	private void iniciarColores() {
		mapaColores = new HashMap<>();
		mapaColores.put("Rojo", Color.red);
		mapaColores.put("Verde", Color.green);
		mapaColores.put("Negro", Color.black);
		mapaColores.put("Azul", Color.blue);
		mapaColores.put("Amarillo", Color.yellow);
		mapaColores.put("Naranja", Color.orange);
	}
	
	private JPanel crearPanelExtras() {
		JPanel p = new JPanel(new GridLayout(5,1));
			p.setBorder(new TitledBorder("Elija extras"));
			
			chDiesel = new JCheckBox("Diesel", true);
				p.add(chDiesel);
				
			chAsientos = new JCheckBox("Asientos deportivos", true);
				p.add(chAsientos);
				
			chTapiceria = new JCheckBox("Tapicería de cuero", true);
				chTapiceria.setEnabled(false);
				p.add(chTapiceria);
				
			chLlantas = new JCheckBox("Llantas de aleación", false);
				p.add(chLlantas);
				
			chPintura = new JCheckBox("Pintura metalizada", true);
				p.add(chPintura);
			
		return p;
	}
	
	private JPanel crearPanelLlantas() {
		JPanel p = new JPanel();
			p.setBorder(new TitledBorder("Elija número de llantas"));
				String[] arrRadios = {"Tres radios", "Cinco radios", "Siete radios", "Nueve radios"};
			cbRadios = new JComboBox<>(arrRadios);
				cbRadios.setEnabled(false);
				p.add(cbRadios);
		
		return p;
	}
	
	private JPanel crearPanelColor() {
		JPanel p = new JPanel();
			p.setPreferredSize(new Dimension(80, 80));
			p.setBorder(new TitledBorder("Elija color"));
			
			listaColores = new JList<>(new Vector<String>(mapaColores.keySet()));
			
			spLista = new JScrollPane(listaColores);
				spLista.setPreferredSize(new Dimension(80, 40));
				p.add(spLista);
		
		return p;
	}
	
	private JPanel crearPanelAcciones() {
		JPanel p = new JPanel();
			p.setBorder(new TitledBorder("Elija acciones realizadas"));
		
			etiqueta = new JLabel("Información");
				etiqueta.setForeground(Color.BLUE);
				etiqueta.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
				p.add(etiqueta);
		
		return p;
	}
	
	public void control(Controlador ctr) {
		chDiesel.addItemListener(ctr);
		chAsientos.addItemListener(ctr);
		chTapiceria.addItemListener(ctr);
		chLlantas.addItemListener(ctr);
		chPintura.addItemListener(ctr);
		
		cbRadios.addItemListener(ctr);
		
		listaColores.addListSelectionListener(ctr);
	}

	public JCheckBox getChDiesel() {return chDiesel;}
	public JCheckBox getChAsientos() {return chAsientos;}
	public JCheckBox getChTapiceria() {return chTapiceria;}
	public JCheckBox getChLlantas() {return chLlantas;}
	public JCheckBox getChPintura() {return chPintura;}
	public JComboBox<String> getCbRadios() {return cbRadios;}
	public JList<String> getListaColores() {return listaColores;}
	public JScrollPane getSpLista() {return spLista;}
	public JLabel getEtiqueta() {return etiqueta;}
	public Map<String, Color> getMapaColores() {return mapaColores;}
}
