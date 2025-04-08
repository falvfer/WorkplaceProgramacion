package calculadora;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// Crear un objeto de la clase Vista
		Vista miVista = new Vista();

		// Crear un objeto de la Clase Controlador
		Controlador ctr = new Controlador(miVista);

		// Llamar al m�todo que da control a los componentes
		miVista.control(ctr);

		// Crearemos un JFrame
		JFrame ventana = new JFrame("Calculadora");
		ventana.setContentPane(miVista);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setSize(250,230);
		ventana.setVisible(true);

	}

}
