package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5752211613049689258L;
	
	// Variables
		JTextField xOrigen, xDestino, yOrigen, yDestino;
	
	// Getters
		
	// Constructor
		public Vista() {
			JPanel panelPrincipal = new JPanel();
			panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
			
			panelPrincipal.add(crearTitulo());
			panelPrincipal.add(crearCoordenadas());
		//	panelPrincipal.add(crearDescuentos());
		//	panelPrincipal.add(crearPrecioDistancia());
			
			this.add(panelPrincipal);
		}
		
		private JLabel crearTitulo() {
			JLabel titulo = new JLabel("VENTA DE BILLETES DE TREN");
			titulo.setFont(new Font(Font.SERIF, Font.BOLD, 30));
			return titulo;
		}
		
		private JPanel crearCoordenadas() {
			// Crear los componentes
			JPanel principal = new JPanel();
				JPanel labelCoordenadas = new JPanel(new GridLayout(2,1));
					
				JPanel inputX = new JPanel(new GridLayout(2,1));
					JPanel x1 = new JPanel();
						xOrigen = new JTextField(5);
					JPanel x2 = new JPanel();
						xDestino = new JTextField(5);
					
				JPanel inputY = new JPanel(new GridLayout(2,1));
					JPanel y1 = new JPanel();
						yOrigen = new JTextField(5);
					JPanel y2 = new JPanel();
						yDestino = new JTextField(5);
			
			// Añadir todos los componentes
			principal.add(labelCoordenadas);
			principal.add(inputX);
			principal.add(inputY);
						
			labelCoordenadas.add(new JLabel("Coordenadas de origen:"));
			labelCoordenadas.add(new JLabel("Coordenadas de destino:"));
			
			inputX.add(x1);
				x1.add(new JLabel("X"));
				x1.add(xOrigen);
			inputX.add(x2);
				x2.add(new JLabel("X"));
				x2.add(xDestino);

			inputY.add(y1);
				y1.add(new JLabel("Y"));
				y1.add(xOrigen);
			inputY.add(y2);
				y2.add(new JLabel("Y"));
				y2.add(xDestino);
					
					
			// Ajustar el panel principal
			estableceBorde(principal, "Indique las coordenadas origen/destino");
			principal.setSize(new Dimension(400,200));
			
			
			
			return principal;
		}
		
	/*	private JPanel crearDescuentos() {
			
		}
		
		private JPanel crearPrecioDistancia() {
			
		}
	*/
		private static void estableceBorde(JPanel p, String titulo) {
			p.setBorder(new CompoundBorder(
					new EmptyBorder(5,5,5,5),
					new TitledBorder(titulo)));
		}
		
		public void control(Controlador ctrl) {
			
		}

}
