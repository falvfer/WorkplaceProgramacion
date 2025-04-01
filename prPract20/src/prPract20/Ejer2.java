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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		ContrCheckBox ccb = new ContrCheckBox();
		JPanel p = new JPanel(new GridLayout(5,1));
			p.setBorder(new TitledBorder("Elija extras"));
			
			chDiesel = new JCheckBox("Diesel", true);
				chDiesel.addActionListener(ccb);
				p.add(chDiesel);
				
			chAsientos = new JCheckBox("Asientos deportivos", true);
				chAsientos.addActionListener(ccb);
				p.add(chAsientos);
				
			chTapiceria = new JCheckBox("Tapicería de cuero", true);
				chTapiceria.addActionListener(ccb);
				chTapiceria.setEnabled(false);
				p.add(chTapiceria);
				
			chLlantas = new JCheckBox("Llantas de aleación", false);
				chLlantas.addActionListener(ccb);
				p.add(chLlantas);
				
			chPintura = new JCheckBox("Pintura metalizada", true);
				chPintura.addActionListener(ccb);
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
	
	class ContrListas implements ListSelectionListener {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if (e.getSource() instanceof JComboBox) {
				
			} else if (e.getSource() instanceof JList) {
				
			}
			
		}
	}
	
	class ContrCheckBox implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			etiqueta.setText(((JCheckBox)e.getSource()).getText());
			if (e.getSource() == chAsientos) {
				if (chAsientos.isSelected()) {
					chTapiceria.setSelected(true);
					chTapiceria.setEnabled(false);
				} else {
					chTapiceria.setEnabled(true);
				}
			}
		}
	}
}

















