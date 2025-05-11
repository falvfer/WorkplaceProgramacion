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
import modelo.EnumDescuentos;

public class Vista extends JPanel {

	private static final long serialVersionUID = -5752211613049689258L;
	
	// Variables
		// Coordenadas
		JTextField[] tfCoordenadas; /* 0 = X Origen
		 							 * 1 = Y Origen
									 * 2 = X Destino
									 * 3 = Y Destino
									 */
		// Descuentos
		JComboBox<EnumDescuentos> cbTipoDescuento;
		JCheckBox cbBilleteFamiliar;
		JLabel lDescuentoAplicar;
		
		// Distancia y precio
		JLabel lDistancia, lPrecio;
		
		// Botones
		JButton bVender, bCancelar; // He visto inutil el boton de calcular ya que el programa
									// lo hace automáticamente cada vez que se cambia algo
	// Getters
		public JTextField[] getTfCoordenadas() {return tfCoordenadas;}
		public JComboBox<EnumDescuentos> getCbTipoDescuento() {return cbTipoDescuento;}
		public JCheckBox getCbBilleteFamiliar() {return cbBilleteFamiliar;}
		public JLabel getlDescuentoAplicar() {return lDescuentoAplicar;}
		public JLabel getlDistancia() {return lDistancia;}
		public JLabel getlPrecio() {return lPrecio;}
		public JButton getbCancelar() {return bCancelar;}
		public JButton getbVender() {return bVender;}
		
	// Constructor
		public Vista() {
			JPanel panelPrincipal = new JPanel();
			panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
			panelPrincipal.setPreferredSize(new Dimension(520, 330));
			
			panelPrincipal.add(crearTitulo());
			panelPrincipal.add(crearCoordenadas());
			panelPrincipal.add(crearDescuentos());
			panelPrincipal.add(crearPrecioDistancia());
			panelPrincipal.add(crearBotones());
			
			this.add(panelPrincipal);
		}

		private JPanel crearTitulo() {
			JPanel principal = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel titulo = new JLabel("VENTA DE BILLETES DE TREN");
			titulo.setFont(new Font(Font.SERIF, Font.BOLD, 20));
			principal.add(titulo);
			return principal;
		}
		
		private JPanel crearCoordenadas() {
			// Crear los tf de origen y destino
			tfCoordenadas = new JTextField[4];
			
			// Crear los componentes
			JPanel principal = new JPanel(new FlowLayout(FlowLayout.LEFT));
				JPanel labelCoordenadas = new JPanel(new GridLayout(2,1));
					
				JPanel inputX = new JPanel(new GridLayout(2,1));
					JPanel x1 = new JPanel();
						tfCoordenadas[0] = new JTextField("0", 4);
					JPanel x2 = new JPanel();
						tfCoordenadas[2] = new JTextField("0", 4);
					
				JPanel inputY = new JPanel(new GridLayout(2,1));
					JPanel y1 = new JPanel();
						tfCoordenadas[1] = new JTextField("0", 4);
					JPanel y2 = new JPanel();
						tfCoordenadas[3] = new JTextField("0", 4);
			
			// Añadir todos los componentes al panel principal
			principal.add(labelCoordenadas);
			principal.add(inputX);
			principal.add(inputY);
			
			// Añadir los label al panel coordenadas
			labelCoordenadas.add(new JLabel("Coordenadas de origen:"));
			labelCoordenadas.add(new JLabel("Coordenadas de destino:"));
			
			// Añadir los componentes al panel de las coodenadas X
			inputX.add(x1);
				x1.add(new JLabel("X"));
				x1.add(tfCoordenadas[0]);
			inputX.add(x2);
				x2.add(new JLabel("X"));
				x2.add(tfCoordenadas[2]);

			// Añadir los componentes al panel de las coodenadas Y
			inputY.add(y1);
				y1.add(new JLabel("Y"));
				y1.add(tfCoordenadas[1]);
			inputY.add(y2);
				y2.add(new JLabel("Y"));
				y2.add(tfCoordenadas[3]);

			// Ponerle el tamaño al labelCoordenadas para que se vea bien
			labelCoordenadas.setPreferredSize(new Dimension(150, inputX.getPreferredSize().height));
					
			// Ajustar el panel principal
			estableceBorde(principal, "Indique las coordenadas origen/destino");
			
			// Devolver el panel principal creado
			return principal;
		}
		
		private JPanel crearDescuentos() {
			// Crear los componentes
			JPanel principal = new JPanel(new FlowLayout(FlowLayout.CENTER));
				cbTipoDescuento = new JComboBox<>(EnumDescuentos.values());
				cbBilleteFamiliar = new JCheckBox("Billete familiar");
				lDescuentoAplicar = new JLabel();
				
			// Añadir todo al panel principal
			principal.add(new JLabel("Tipo descuento"));
			principal.add(cbTipoDescuento);
			principal.add(cbBilleteFamiliar);
			principal.add(new JLabel("Descuento a aplicar:"));
			principal.add(lDescuentoAplicar);
			
			// Ajustar el panel principal
			estableceBorde(principal, "Posibles descuentos");
			
			// Devolver el panel principal creado
			return principal;
		}
		
		private JPanel crearPrecioDistancia() {
			// Crear los componentes
			JPanel principal = new JPanel(new GridLayout(2,2));
			lDistancia = new JLabel("0.00 km");
			lPrecio = new JLabel("0 €");
			
			JLabel labelDistancia = new JLabel("Distancia: ");
			JLabel labelPrecio = new JLabel("Precio Billete: ");
			
			// Añadir todo al panel principal
			principal.add(labelDistancia);
			principal.add(lDistancia);
			principal.add(labelPrecio);
			principal.add(lPrecio);
			
			// Ajustar labels a la derecha
			labelDistancia.setHorizontalAlignment(SwingConstants.RIGHT);
			labelPrecio.setHorizontalAlignment(SwingConstants.RIGHT);
			
			// Ajustar el panel principal
			estableceBorde(principal, "Posibles descuentos");
			
			// Devolver el panel principal creado
			return principal;
		}
		
		private JPanel crearBotones() {
			// Crear los componentes
			JPanel principal = new JPanel(new FlowLayout(FlowLayout.CENTER));
			bVender = new JButton("Vender billete");
			bCancelar = new JButton("Cancelar");
			
			// Añadir todo al panel principal
			principal.add(bVender);
			principal.add(bCancelar);
			
			// Devolver el panel principal creado
			return principal;
		}
	
		private static void estableceBorde(JPanel p, String titulo) {
			p.setBorder(new CompoundBorder(
					new EmptyBorder(5,5,5,5),
					new TitledBorder(titulo)));
		}
		
		public void control(Controlador ctrl) {
			cbBilleteFamiliar.addItemListener(ctrl);
			cbTipoDescuento.addItemListener(ctrl);
			for (JTextField tf: tfCoordenadas)
				tf.addFocusListener(ctrl);
			bCancelar.addActionListener(ctrl);
			bVender.addActionListener(ctrl);
		}

}
