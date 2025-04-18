package vista;

import java.awt.Color;
import java.awt.FlowLayout;

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
import modelo.TipoPropiedad;
import modelo.TipoTerreno;
import modelo.TipoVivienda;

public class Vista extends JPanel {

	private static final long serialVersionUID = -8515973484614698808L;

// Variables
	private JTextField tfCodigo, tfPrecio, tfSuperficie, tfDireccion;
	private JTextArea taDescripcion;
	private JComboBox<TipoPropiedad> cbPropiedades;
	private JComboBox<TipoVivienda> cbViviendas;
	private JComboBox<Byte> cbDormitorios, cbBaños;
	private JComboBox<TipoTerreno> cbTerrenos;
	private JRadioButton[] rbElectricidad, rbAgua, rbVivienda;
	private JButton bGuardar, bBorrar, bLimpiar;
	private JPanel panelVivienda, panelFinca;
	
	// Getters
	public JTextField getTfCodigo() {return tfCodigo;}
	public JTextField getTfPrecio() {return tfPrecio;}
	public JTextField getTfSuperficie() {return tfSuperficie;}
	public JTextField getTfDireccion() {return tfDireccion;}
	public JTextArea getTaDescripcion() {return taDescripcion;}
	public JComboBox<TipoPropiedad> getCbPropiedades() {return cbPropiedades;}
	public JComboBox<TipoVivienda> getCbViviendas() {return cbViviendas;}
	public JComboBox<Byte> getCbDormitorios() {return cbDormitorios;}
	public JComboBox<Byte> getCbBaños() {return cbBaños;}
	public JComboBox<TipoTerreno> getCbTerrenos() {return cbTerrenos;}
	public JRadioButton[] getRbElectricidad() {return rbElectricidad;}
	public JRadioButton[] getRbAgua() {return rbAgua;}
	public JRadioButton[] getRbVivienda() {return rbVivienda;}
	public JButton getbGuardar() {return bGuardar;}
	public JButton getbBorrar() {return bBorrar;}
	public JButton getbLimpiar() {return bLimpiar;}
	public JPanel getPanelVivienda() {return panelVivienda;}
	public JPanel getPanelFinca() {return panelFinca;}
	
	public void limpiaInterfaz() {
		tfCodigo.setText("");
		tfPrecio.setText("");
		tfSuperficie.setText("");
		tfDireccion.setText("");
		taDescripcion.setText("");
		cbPropiedades.setSelectedItem(TipoPropiedad.FINCA);
		cbViviendas.setSelectedIndex(0);
		cbDormitorios.setSelectedIndex(0);
		cbBaños.setSelectedIndex(0);
		cbTerrenos.setSelectedIndex(0);
		rbElectricidad[0].setSelected(true);
		rbAgua[0].setSelected(true);
		rbVivienda[0].setSelected(true);
		bBorrar.setEnabled(false);
		bGuardar.setEnabled(true);
	}
	
// Constructor
	public Vista() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		panelPrincipal.add(crearGenerales());
		panelPrincipal.add(crearEspecificosVivienda());
		panelPrincipal.add(crearEspecificosFinca());
		panelPrincipal.add(crearOperaciones());
		
		this.add(panelPrincipal);
	}
	
	private JPanel crearGenerales() {
		// Panel principal
		JPanel principal = new JPanel();
		principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		estableceBorde(principal, "Datos generales");
		
			// Primera parte
			JPanel parte1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
			principal.add(parte1);
				// Crear las agrupaciones y añadirlas al panel principal
				JPanel[] grupos = new JPanel[4];
				for (int i = 0; i < grupos.length; i++) {
					grupos[i] = new JPanel();
					parte1.add(grupos[i]);
				}
				// Cargar en memoria los elementos
				tfCodigo = new JTextField(3);
				cbPropiedades = new JComboBox<TipoPropiedad>(TipoPropiedad.values());
				tfPrecio = new JTextField(6);
				tfSuperficie = new JTextField(3);
				// Añadir elementos
				grupos[0].add(new JLabel("Código:"));
				grupos[0].add(tfCodigo);
				grupos[1].add(new JLabel("Tipo Propiedad:"));
				grupos[1].add(cbPropiedades);
				grupos[2].add(new JLabel("Precio:"));
				grupos[2].add(tfPrecio);
				grupos[3].add(new JLabel("Superficie:"));
				grupos[3].add(tfSuperficie);
			
			// Segunda parte
			JPanel parte2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			principal.add(parte2);
				// Crear elementos
				tfDireccion = new JTextField(40);
				// Añadir elementos
				parte2.add(new JLabel("Dirección:"));
				parte2.add(tfDireccion);
				
			// Tercera parte
			JPanel parte3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			principal.add(parte3);
				// Crear elementos
				taDescripcion = new JTextArea(4,41);
				JScrollPane spDescripcion = new JScrollPane(taDescripcion);
				// Añadir elementos
				parte3.add(new JLabel("Descripción:"));
				parte3.add(spDescripcion);
		
		return principal;
	}
	
	private JPanel crearEspecificosVivienda() {
		// Panel principal
		panelVivienda = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		estableceBorde(panelVivienda, "Datos específicos para vivienda");
		
		// Crear las agrupaciones y añadirlas al panel principal
		JPanel[] grupos = new JPanel[3];
		for (int i = 0; i < grupos.length; i++) {
			grupos[i] = new JPanel();
			panelVivienda.add(grupos[i]);
		}
		
		// Cargar en memoria los elementos
		cbViviendas = new JComboBox<TipoVivienda>(TipoVivienda.values());
			Byte[] numeros = {0,1,2,3,4,5,6};
		cbDormitorios = new JComboBox<Byte>(numeros);
		cbBaños = new JComboBox<Byte>(numeros);
		
		// Añadir los elementos
		grupos[0].add(new JLabel("Tipo de vivienda:"));
		grupos[0].add(cbViviendas);
		grupos[1].add(new JLabel("Número de dormitorios:"));
		grupos[1].add(cbDormitorios);
		grupos[2].add(new JLabel("Número baños:"));
		grupos[2].add(cbBaños);
		
		return panelVivienda;
	}
	
	private JPanel crearEspecificosFinca() {
		// Panel principal
		panelFinca = new JPanel();
		panelFinca.setLayout(new BoxLayout(panelFinca, BoxLayout.Y_AXIS));
		estableceBorde(panelFinca, "Datos específicos para fincas rústicas");

		// Crear las agrupaciones y añadirlas al panel principal
		JPanel[] grupos = new JPanel[4];
		for (int i = 0; i < grupos.length; i++) {
			grupos[i] = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panelFinca.add(grupos[i]);
		}
		
		// Cargar en memoria los elementos
		cbTerrenos = new JComboBox<TipoTerreno>(TipoTerreno.values());
		rbElectricidad = new JRadioButton[2];
		rbElectricidad[0] = new JRadioButton("Sí");
			rbElectricidad[0].setSelected(true);
		rbElectricidad[1] = new JRadioButton("No");
		rbAgua = new JRadioButton[2];
		rbAgua[0] = new JRadioButton("Sí");
			rbAgua[0].setSelected(true);
		rbAgua[1] = new JRadioButton("No");
		rbVivienda = new JRadioButton[2];
		rbVivienda[0] = new JRadioButton("Sí");
			rbVivienda[0].setSelected(true);
		rbVivienda[1] = new JRadioButton("No");
		
		// Agrupar los botones
		ButtonGroup[] gruposBotones = {
				new ButtonGroup(),
				new ButtonGroup(),
				new ButtonGroup()};
		gruposBotones[0].add(rbElectricidad[0]);
		gruposBotones[0].add(rbElectricidad[1]);
		gruposBotones[1].add(rbAgua[0]);
		gruposBotones[1].add(rbAgua[1]);
		gruposBotones[2].add(rbVivienda[0]);
		gruposBotones[2].add(rbVivienda[1]);
		
		// Añadir los elementos
		grupos[0].add(new JLabel("Tipo terreno:"));
		grupos[0].add(cbTerrenos);
		grupos[1].add(new JLabel("Suministro eléctrico:"));
		grupos[1].add(rbElectricidad[0]);
		grupos[1].add(rbElectricidad[1]);
		grupos[2].add(new JLabel("Suministro de agua:"));
		grupos[2].add(rbAgua[0]);
		grupos[2].add(rbAgua[1]);
		grupos[3].add(new JLabel("Dispone de vivienda:"));
		grupos[3].add(rbVivienda[0]);
		grupos[3].add(rbVivienda[1]);
		
		return panelFinca;
	}
	
	private JPanel crearOperaciones() {
		// Panel principal
		JPanel principal = new JPanel();
		estableceBorde(principal, "Operaciones disponibles");
		
		// Cargar en memoria los botones
		bGuardar = new JButton("Guardar propiedad");
		bBorrar = new JButton("Borrar propiedad");
			bBorrar.setEnabled(false);
		bLimpiar = new JButton("Limpiar formulario");
		
		// Añadirlos al panel
		principal.add(bGuardar);
		principal.add(bBorrar);
		principal.add(bLimpiar);
		
		return principal;
	}
	
	private void estableceBorde(JPanel p, String titulo) {
		p.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder(new LineBorder(Color.black), titulo)));
	}
	
	public void control(Controlador ctrl) {
		bGuardar.addActionListener(ctrl);
		bBorrar.addActionListener(ctrl);
		bLimpiar.addActionListener(ctrl);
		
		cbPropiedades.addItemListener(ctrl);
		
		tfCodigo.addFocusListener(ctrl);
		tfPrecio.addFocusListener(ctrl);
		tfSuperficie.addFocusListener(ctrl);
		
		tfCodigo.addKeyListener(ctrl);
		tfPrecio.addKeyListener(ctrl);
		tfSuperficie.addKeyListener(ctrl);
	}
}
