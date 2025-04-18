package prPract14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;

public class GUI02SwingV2 {

	public static void main(String[] args) {

	// Crear un contenedor
		JFrame f = new JFrame("Mi primer GUI");
		Container cp = f.getContentPane();
		
	// Seleccionar un gestor de esquemas para la inserción de los componentes
		cp.setLayout(new BorderLayout());
		
	// Crear los componentes adecuados
		JButton bNorte = new JButton("Norte");
		JButton bOeste = new JButton("Oeste");
		JButton bCentro = new JButton("Centro");
		JButton bEste = new JButton("Este");
		JButton bSur = new JButton("Sur");
		
		// Colores
		bNorte.setBackground(Color.red);
		bNorte.setForeground(Color.white);
		bSur.setBackground(Color.blue);
		bSur.setForeground(Color.white);
		
		// Cambiar el tamaño del boton del centro
		bCentro.setPreferredSize(new Dimension(100, 100));
		
		JPanel pCentro = new JPanel();
		pCentro.add(bCentro);
		
	// Agregarlos al contenedor
		cp.add(bNorte, BorderLayout.NORTH);
		cp.add(bOeste, BorderLayout.WEST);
		cp.add(pCentro, BorderLayout.CENTER);
		cp.add(bEste, BorderLayout.EAST);
		cp.add(bSur, BorderLayout.SOUTH);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor(opcional)
		f.setSize(250,200);
		
	// Mostrar el contenedor
		f.setVisible(true);
		
		// Bloquear cambios tamaño ventana
		f.setResizable(false);
		
	// Programar el evento de cierre de ventana
	  //f.addWindowListener(new ControlVentana());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
