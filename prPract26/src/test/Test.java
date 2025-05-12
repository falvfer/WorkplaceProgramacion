package test;

import javax.swing.JFrame;

import controlador.Controlador;
import modelo.EnumDescuentos;
import vista.Vista;

public class Test {

	public static void main(String[] args) {
		
		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

		// Crear un objeto de la Clase Controlador
		Controlador ctr = new Controlador(miVista);

		// Llamar al método que da control a los componentes
		miVista.control(ctr);

		// Crearemos un JFrame
		JFrame ventana = new JFrame("Venta de billetes de tren");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);
		
		miVista.getCbTipoDescuento().setSelectedItem(EnumDescuentos.SIN_DESCUENTO);
	}
}
