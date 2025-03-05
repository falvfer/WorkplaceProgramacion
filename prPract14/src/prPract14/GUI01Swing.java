package prPract14;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class GUI01Swing {

	public static void main(String[] args) {

	// Crear un contenedor
		JFrame f = new JFrame("Mi primer GUI");
		Container gcp = f.getContentPane();
		
	// Seleccionar un gestor de esquemas para la inserción de los componentes
		gcp.setLayout(new FlowLayout());
		
	// Crear los componentes adecuados
		JButton bSi = new JButton("Si");
		JButton bNo = new JButton("No");
		JLabel lNombre = new JLabel("Nombre");
		
	// Agregarlos al contenedor
		gcp.add(lNombre);
		gcp.add(bSi);
		gcp.add(bNo);
		
	// Pedir el ajuste de los componentes al contenedor
		f.pack();
		
	// Dimensionar el contenedor(opcional)
		f.setSize(300,150);
		
	// Mostrar el contenedor
		f.setVisible(true);
		
	// Programar el evento de cierre de ventana
	  //f.addWindowListener(new ControlVentana());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
