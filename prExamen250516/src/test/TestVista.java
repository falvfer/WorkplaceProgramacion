package test;

import javax.swing.JFrame;

import controlador.Controlador;
import controlador.ControlVentana;
import vista.Vista;

public class TestVista {

	public static void main(String[] args) {
		
		// Crear un objeto de la clase Vista
				Vista miVista = new Vista();

				// Crearemos un JFrame
				JFrame ventana = new JFrame("Consulta médica");
				ventana.setContentPane(miVista);
				ventana.pack();
				ventana.setVisible(true);

				// Crear un objeto de la Clase Controlador
				Controlador ctr = new Controlador(miVista);

				// Llamar al método que da control a los componentes
				miVista.control(ctr);
				
				// Añadirle el controlador de ventana para poder preguntar cuando cierre.
				ventana.addWindowListener(new ControlVentana(miVista, ctr.getGestor()));
				
				// Poner estado inicial
				ctr.limpiarFormulario();
		
	}
}
