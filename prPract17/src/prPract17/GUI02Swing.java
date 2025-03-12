package prPract17;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class GUI02Swing {

	public static void main(String[] args) {
		
	// Crear un contenedor
		JFrame f = new JFrame("Titulo de JFrame");
		Container cp = f.getContentPane();
		JPanel principal = new JPanel(new FlowLayout());
		
		cp.add(principal);

	// ----------------------------------------------------------
	// VENTANA PRINCIPAL
	// ----------------------------------------------------------
		JButton b1 = new JButton("Botón 1");
		JButton b2 = new JButton("Botón 2");

		// Añadir todos los elementos a sus sitios respectivos
		principal.add(b1);
		principal.add(b2);
		
	// ----------------------------------------------------------
	// VENTANA DIÁLOGO
	// ----------------------------------------------------------
		JDialog d = new JDialog(f,"Título de diálogo",false);
		// this es el JFrame, he heredado de JFrame
		d.setLayout(new FlowLayout());
		d.add(new JLabel("Esto es una ventana de diálogo"));
		d.add(new JButton("OK"));
		d.pack();
		d.setSize(200, 90);
		d.setResizable(false);
		d.setVisible(true);
		d.setLocationRelativeTo(f);
		//d.setLocation(200,200);
		// Controlar el cierre del diálogo, OJO, se oculta, no se sale de la aplicación
		d.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
			
	// ----------------------------------------------------------
			
		// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
		// Dimensionar el contenedor(opcional)
		f.setSize(320,200);
		
		// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		// Programar el evento de cierre de ventana
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
