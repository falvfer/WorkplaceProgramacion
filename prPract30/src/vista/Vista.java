package vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class Vista extends JPanel {

	private static final long serialVersionUID = -2972941501755724627L;

	// Variables
	
	
	// Getters
	
	
	// Constructor
		public Vista() {
			
		}

		private JPanel crearTitulo() {
			
		}
		
		private JPanel crearCoordenadas() {
			
		}
		
		private JPanel crearDescuentos() {
			
		}
		
		private JPanel crearPrecioDistancia() {
			
		}
		
		private JPanel crearBotones() {
			
		}
	
		private static void estableceBorde(JPanel p, String titulo) {
			p.setBorder(new CompoundBorder(
					new EmptyBorder(5,5,5,5),
					new TitledBorder(titulo)));
		}
		
		public void control(Controlador ctrl) {
			
		}

}