package prPract16;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GUI01Swing {

	public static void main(String[] args) {

	// Crear un contenedor
		JFrame f = new JFrame("Ejemplo GUI");
		Container cp = f.getContentPane();
			cp.setLayout(new FlowLayout());
		
	// Crear los componentes adecuados
		JButton[] botones = {
				new JButton("Primero"),
				new JButton("Segundo"),
				new JButton("Tercero"),
				new JButton("Cuarto"),
				new JButton("Quinto"),
				new JButton("Sexto"),
				new JButton("Septimo"),
				new JButton("Octavo")
		};
		
		JPanel pBotones = new JPanel(new GridLayout(4,2));
		for (int i = 0; i < botones.length; i++)
			pBotones.add(botones[i]);

		JScrollPane spFinal = new JScrollPane(pBotones);
		
		// Modificación de los botones (colores, componentes, etc)
		botones[0].setBackground(new Color(134, 27, 131));
		botones[0].setForeground(Color.white);
			
		botones[1].setBackground(Color.decode("#DBC380"));
			
		botones[2].setBackground(Color.BLUE);
		botones[2].setForeground(Color.white);
		botones[2].setToolTipText("Boton tercero");

	// Agregarlos al contenedor
		cp.add(spFinal);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor (opcional)
		spFinal.setPreferredSize(new Dimension(130, 110));
		
	// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		// Bloquear cambios tamaño ventana
		
	// Programar el evento de cierre de ventana
	  //f.addWindowListener(new ControlVentana());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
