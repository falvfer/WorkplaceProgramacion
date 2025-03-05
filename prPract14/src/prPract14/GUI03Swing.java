package prPract14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class GUI03Swing {

	public static void main(String[] args) {
		
	// Crear un contenedor
		JFrame f = new JFrame("Mi primer GUI");
		Container cp = f.getContentPane();
		
	// Seleccionar un gestor de esquemas para la inserción de los componentes
		cp.setLayout(new BorderLayout());
		
	// Crear los componentes adecuados
		JButton bNorte = new JButton("Norte");
		JButton bOesteP1 = new JButton("Panel1");
		JButton bOesteP2 = new JButton("Panel2");
		JButton bCentro = new JButton("Centro");
		JButton bEste = new JButton("Este");
		JButton bSur = new JButton("Sur");
		
		// Colores
		bNorte.setBackground(Color.red);
		bNorte.setForeground(Color.white);
		bSur.setBackground(Color.blue);
		bSur.setForeground(Color.white);
		
		// Crear el panel oeste y añadirle los botones
		JPanel pOeste = new JPanel(new GridLayout(2,1));
		pOeste.add(bOesteP1);
		pOeste.add(bOesteP2);
		
	// Agregarlos al contenedor
		cp.add(bNorte, BorderLayout.NORTH);
		cp.add(pOeste, BorderLayout.WEST);
		cp.add(bCentro, BorderLayout.CENTER);
		cp.add(bEste, BorderLayout.EAST);
		cp.add(bSur, BorderLayout.SOUTH);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor(opcional)
		f.setSize(250,150);
		
	// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		// Bloquear cambios tamaño ventana
		f.setResizable(false);
		
		try {Thread.sleep(2500);} catch (InterruptedException e) {}
		
		bSur.setVisible(false);
		
	// Programar el evento de cierre de ventana
	  //f.addWindowListener(new ControlVentana());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
