package test;

import javax.swing.JFrame;

import controlador.Controlador;
import modelo.TipoPropiedad;
import vista.Vista;

public class Test {
	
	public static void main(String[] args) {
		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

		// Crear un objeto de la Clase Controlador
		Controlador ctr = new Controlador(miVista);

		// Llamar al m�todo que da control a los componentes
		miVista.control(ctr);

		// Crearemos un JFrame
		JFrame ventana = new JFrame("Agencia moviliaria");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setSize(700,550);
		ventana.setVisible(true);
		miVista.getCbPropiedades().setSelectedItem(TipoPropiedad.FINCA);
	}
	
}
