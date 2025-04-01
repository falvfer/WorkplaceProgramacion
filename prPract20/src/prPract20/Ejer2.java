package prPract20;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Ejer2 extends JFrame {

	private static final long serialVersionUID = -8024875578355712431L;
	
	private JCheckBox chDiesel, chAsientos, chTapiceria, chLlantas, chPintura;
	private JComboBox<String> cbRadios;
	private JList<String> listaColores;
	private JScrollPane spLista;
	private JLabel etiqueta;
	
	public Ejer2() {
		// Contenedor y Frame principal
		this.setTitle("Prueba de eventos");
		
		JPanel principal = new JPanel();
		 	principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		 	principal.setPreferredSize(new Dimension(300, 350));
			principal.setBorder(new EmptyBorder(15, 15, 15, 15));
			this.getContentPane().add(principal);
			
		principal.add(crearPanelExtras());
		principal.add(crearPanelLlantas());
		principal.add(crearPanelColor());
		principal.add(crearPanelAcciones());
			
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
				p.add(cbRadios);
		
		return p;
	}
	
	private JPanel crearPanelColor() {
		JPanel p = new JPanel();
			p.setPreferredSize(new Dimension(80, 80));
			p.setBorder(new TitledBorder("Elija color"));
			
				String[] arrColores = {"Rojo", "Verde"};
			listaColores = new JList<>(arrColores);
			
			spLista = new JScrollPane(listaColores);
				spLista.setPreferredSize(new Dimension(80, 40));
				p.add(spLista);
		
		return p;
	}
	
	private JPanel crearPanelAcciones() {
		JPanel p = new JPanel();
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			p.setBorder(new TitledBorder("Elija acciones realizadas"));
		
			etiqueta.setForeground(Color.BLUE);
		
		
		return p;
	}
	
	
	public static void main(String[] args) {
		Ejer2 v = new Ejer2();
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLocationRelativeTo(null);
	}
	
	class ControladorLanzar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
}
