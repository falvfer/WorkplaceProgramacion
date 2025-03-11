package prPract16;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class GUI02Swing {

	public static void main(String[] args) {

	// Crear un contenedor
		JFrame f = new JFrame("Componentes varios");
		
	// Crear los componentes adecuados
		// Crear la barra y los menus
		JMenuBar barraMenu = new JMenuBar();
		JMenu menu1 = new JMenu("Entrada 1");
		JMenu menu2 = new JMenu("Entrada 2");
		JMenu menuAyuda = new JMenu("Ayuda");
		
		// Crear los items de los menus
		JMenuItem m1s1 = new JMenuItem("Subentrada 1.1.");
		JMenuItem m1s2 = new JMenuItem("Subentrada 1.2.");
		JMenu m1s3 = new JMenu("Subentrada 1.3.");
		
		// Crear los subitems del item m1s3
		JMenuItem m1s3s1 = new JMenuItem("Subentrada 1.3.1.");
		JCheckBoxMenuItem m1s3s2 = new JCheckBoxMenuItem("Subentrada 1.3.2.");
		
		// Añadir la combinacion "Ctrl-E" al item 1.2
		m1s2.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		// Agregar los subitems del m1s3
		m1s3.add(m1s3s1);
		m1s3.add(m1s3s2);
		
		// Agregar los items a los menus
		menu1.add(m1s1);
		menu1.addSeparator();
		menu1.add(m1s2);
		menu1.addSeparator();
		menu1.add(m1s3);
		
		// Agregar los componentes a la barra de menú
		barraMenu.add(menu1);
		barraMenu.add(menu2);
		barraMenu.add(menuAyuda);
		
	// Agregarlos al contenedor
		f.setJMenuBar(barraMenu);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor(opcional)
		f.setSize(300,150);
		
	// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
	// Programar el evento de cierre de ventana
	  //f.addWindowListener(new ControlVentana());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
