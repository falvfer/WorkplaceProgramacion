package prPract20;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Ejer2 extends JFrame {

	private static final long serialVersionUID = -8024875578355712431L;
	
	private JCheckBox chDiesel, chAsientos, chTapiceria, chLlantas, chPintura;
	private JComboBox<String> cbRadios;
	private JList<String> listaColores;
	private JScrollPane spLista;
	private JLabel etiqueta;
	
	private Map<String,Color> mapaColores;
	
	public Ejer2() {
		// Contenedor y Frame principal
		this.setTitle("Prueba de eventos");
		
		JPanel principal = new JPanel();
		 	principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		 	principal.setPreferredSize(new Dimension(300, 350));
			principal.setBorder(new EmptyBorder(15, 15, 15, 15));
			this.getContentPane().add(principal);

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
		ContrItem ccb = new ContrItem();
		JPanel p = new JPanel(new GridLayout(5,1));
			p.setBorder(new TitledBorder("Elija extras"));
			
			chDiesel = new JCheckBox("Diesel", true);
				chDiesel.addItemListener(ccb);
				p.add(chDiesel);
				
			chAsientos = new JCheckBox("Asientos deportivos", true);
				chAsientos.addItemListener(ccb);
				p.add(chAsientos);
				
			chTapiceria = new JCheckBox("Tapicería de cuero", true);
				chTapiceria.addItemListener(ccb);
				chTapiceria.setEnabled(false);
				p.add(chTapiceria);
				
			chLlantas = new JCheckBox("Llantas de aleación", false);
				chLlantas.addItemListener(ccb);
				p.add(chLlantas);
				
			chPintura = new JCheckBox("Pintura metalizada", true);
				chPintura.addItemListener(ccb);
				p.add(chPintura);
			
		return p;
	}
	
	private JPanel crearPanelLlantas() {
		JPanel p = new JPanel();
			p.setBorder(new TitledBorder("Elija número de llantas"));
				String[] arrRadios = {"Tres radios", "Cinco radios", "Siete radios", "Nueve radios"};
			cbRadios = new JComboBox<>(arrRadios);
				cbRadios.setEnabled(false);
				cbRadios.addItemListener(new ContrItem());
				p.add(cbRadios);
		
		return p;
	}
	
	private JPanel crearPanelColor() {
		JPanel p = new JPanel();
			p.setPreferredSize(new Dimension(80, 80));
			p.setBorder(new TitledBorder("Elija color"));
			
			listaColores = new JList<>(new Vector<String>(mapaColores.keySet()));
				listaColores.addListSelectionListener(new ContrLista());
			
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
	
	
	public static void main(String[] args) {
		Ejer2 v = new Ejer2();
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLocationRelativeTo(null);
	}
	
	class ContrLista implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			String strColor = listaColores.getSelectedValue();
			etiqueta.setText("Color pintura: " + strColor);
			etiqueta.setForeground(mapaColores.get(strColor));
		}
	}
	
	class ContrItem implements ItemListener {
		@Override
		
		public void itemStateChanged(ItemEvent e) {
			Object source = e.getSource();
			
			if (source == cbRadios) {
				etiqueta.setText("Número de radios: " + cbRadios.getSelectedItem());
				return;
			}

			etiqueta.setText(((JCheckBox)source).getText());
			
			if (source == chAsientos) {
				if (chAsientos.isSelected()) {
					chTapiceria.setSelected(true);
					chTapiceria.setEnabled(false);
				} else
					chTapiceria.setSelected(false);
				return;
			}
				
			if (source == chLlantas) {
				cbRadios.setEnabled(chLlantas.isSelected());
				return;
			}
			
			if (source == chPintura) {
				listaColores.setEnabled(chPintura.isSelected());
				return;
			}
			
		}
	}
	
	
	
	
	
}

















