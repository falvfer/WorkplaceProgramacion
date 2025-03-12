package prPract16;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class GUI04Swing {

	public static void main(String[] args) {
		
	// Crear un contenedor
		JFrame f = new JFrame("Calculadora");
		Container cp = f.getContentPane();
		cp.setLayout(new FlowLayout());

	// ----------------------------------------------------------
	// PARTE DEL MENÚ
	// ----------------------------------------------------------
		JMenuBar mb = new JMenuBar();
		JMenu[] menus = {
				new JMenu("Archivo"),
				new JMenu("Edición"),
				new JMenu("Ver"),
				new JMenu("Ayuda")
		};
		
		JMenu mVHerramientas = new JMenu("Barra de herramientas");
			mVHerramientas.add(new JCheckBoxMenuItem("Formato"));
			mVHerramientas.add(new JCheckBoxMenuItem("Estándar"));
			mVHerramientas.add(new JCheckBoxMenuItem("Dibujo"));
			
		JMenuItem miVZoom = new JMenuItem("Zoom");
			miVZoom.setAccelerator(KeyStroke.getKeyStroke(
					KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		menus[2].add(new JMenuItem("Normal"));
		menus[2].add(new JMenuItem("Diseño de página"));
		menus[2].add(new JMenuItem("Esquema"));
		menus[2].addSeparator();
		menus[2].add(mVHerramientas);
		menus[2].add(new JMenuItem("Mapa del documento"));
		menus[2].addSeparator();
		menus[2].add(miVZoom);
		
		for (JMenu m: menus)
			mb.add(m);
		
		// Agregar la barra de menú
		f.setJMenuBar(mb);

	// ----------------------------------------------------------
	// PARTE DEL CONTENIDO
	// ----------------------------------------------------------
			String[] tiposDeLetra = {"Courier New", "Times New Roman", "Arial"};
		JComboBox<String> cbFuente = new JComboBox<>(tiposDeLetra);
		
		JCheckBox chNegrita = new JCheckBox("Negrita");
			chNegrita.setBackground(Color.orange);
		JCheckBox chCursiva = new JCheckBox("Cursiva");
			chCursiva.setBackground(Color.orange);
		JCheckBox chSubrayado = new JCheckBox("Subrayado");
			chSubrayado.setBackground(Color.orange);
		
		// Establecer la fuente y el color de "Negrita"
		chNegrita.setFont(new Font("Comic Sans MS", Font.BOLD|Font.ITALIC, 25));
		chNegrita.setForeground(Color.gray);
		
		// Agregar los elementos al contenedor
		cp.add(cbFuente);
		cp.add(chNegrita);
		cp.add(chCursiva);
		cp.add(chSubrayado);

	// ----------------------------------------------------------
		// Color de fondo
		cp.setBackground(Color.ORANGE);
		
		// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
		// Dimensionar el contenedor(opcional)
		f.setSize(480,200);
		
		// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		// Programar el evento de cierre de ventana
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
