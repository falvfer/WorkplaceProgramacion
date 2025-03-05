package prPract14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.*;

public class GUI04Swing {

	public static void main(String[] args) {

	// Crear un contenedor
		JFrame f = new JFrame("Mi primer GUI");
		Container cp = f.getContentPane();
		
	// Seleccionar un gestor de esquemas para la inserción de los componentes
		cp.setLayout(new BorderLayout());
		
	// Crear los componentes adecuados
		JButton bNorte = new JButton("Norte");
		JRadioButton rHombre = new JRadioButton("Hombre");
		JRadioButton rMujer = new JRadioButton("Mujer");
		JButton bCentro = new JButton("Centro");
		JButton bEste = new JButton("Este");
		JButton bSur = new JButton("Sur");
		
		ButtonGroup gSexo = new ButtonGroup();
		gSexo.add(rHombre);
		gSexo.add(rMujer);
		
		// Colores
		bNorte.setBackground(Color.red);
		bNorte.setForeground(Color.white);
		bSur.setBackground(Color.blue);
		bSur.setForeground(Color.white);
		
		// Crear el panel oeste con el radio
		JPanel pOeste = new JPanel(new GridLayout(2,1));
		pOeste.add(rHombre);
		pOeste.add(rMujer);
		
	// Agregarlos al contenedor
		cp.add(bNorte, BorderLayout.NORTH);
		cp.add(pOeste, BorderLayout.WEST);
		cp.add(bCentro, BorderLayout.CENTER);
		cp.add(bEste, BorderLayout.EAST);
		cp.add(bSur, BorderLayout.SOUTH);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor(opcional)
		f.setSize(250,170);
		
	// Mostrar el contenedor
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		
		// Bloquear cambios tamaño ventana
		f.setResizable(false);
		
	// Programar el evento de cierre de ventana
	  //f.addWindowListener(new ControlVentana());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
