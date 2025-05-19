package vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.nio.file.Path;
import java.util.concurrent.Flow;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controlador.Controlador;

public class VistaDialog extends JPanel {

	private static final long serialVersionUID = -2972941501755724627L;

	// Variables
	JTextField tfLibros, tfClientes;
	JButton bCrearConArchivos, bCrearVacio;
	
	// Getters
	public JTextField getTfLibros() {return tfLibros;}
	public JTextField getTfClientes() {return tfClientes;}
	public JButton getbCrearConArchivos() {return bCrearConArchivos;}
	public JButton getbCrearVacio() {return bCrearVacio;}
	
	// Constructor
	public VistaDialog() {
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		panelPrincipal.setPreferredSize(new Dimension(365,210));
		
		panelPrincipal.add(crearDatosExistentes());
		panelPrincipal.add(crearNuevo());
		
		this.add(panelPrincipal);
	}

	private JPanel crearDatosExistentes() {
		// Creacion de JPanel
		JPanel principal = new JPanel();
		principal.setLayout(new BoxLayout(principal, BoxLayout.Y_AXIS));
		estableceBorde(principal, "Creación de Biblioteca a partir de datos existentes");
		
		// Creacion de componentes internos
		tfLibros = new JTextField(15);
		tfClientes = new JTextField(15);
		JPanel boton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JPanel[] grids = {new JPanel(new GridLayout(1,2)),
						new JPanel(new GridLayout(1,2))};
		grids[0].setBorder(new EmptyBorder(0, 0, 10, 0));
		JLabel[] labels = {new JLabel("Nombre fichero libros"),
						new JLabel("Nombre fichero clientes")};
		bCrearConArchivos = new JButton("Crear Biblioteca");
		
		// Alineamiento de los labels
		for (JLabel l: labels) {
			l.setHorizontalAlignment(SwingConstants.RIGHT);
			l.setBorder(new EmptyBorder(0, 0, 0, 10));
		}
		
		// Añadir componentes y organizarlos
		grids[0].add(labels[0]);
		grids[1].add(labels[1]);
		grids[0].add(tfLibros);
		grids[1].add(tfClientes);
		
		boton.add(bCrearConArchivos);
		
		principal.add(grids[0]);
		principal.add(grids[1]);
		principal.add(boton);
		
		return principal;
	}
	
	private JPanel crearNuevo() {
		JPanel principal = new JPanel(new FlowLayout(FlowLayout.CENTER));
		estableceBorde(principal, "Creación de Biblioteca sin datos previos (en blanco)");
		bCrearVacio = new JButton("Crear Biblioteca");
		principal.add(bCrearVacio);
		return principal;
	}

	private static void estableceBorde(JPanel p, String titulo) {
		p.setBorder(new CompoundBorder(
				new EmptyBorder(5,5,5,5),
				new TitledBorder(titulo)));
	}
	
	public void control(Controlador ctrl) {
		
	}

}