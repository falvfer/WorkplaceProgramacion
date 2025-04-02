package prPract20_MVC;
/**
 * Clase principal del ejecicio 9, seguiendo el MVC
 * 
 *  @author profesor
 */

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		
		// Crear un objeto Vista (Diseña el GUI)
		Vista miVista = new Vista();
		
		// Crear un objeto Controlador (programa los eventos)
		Controlador ctr = new Controlador(miVista);

		// Llamar al método que añade "control" a los componentes
		miVista.control(ctr);
		
		// Crear el objeto Ventana (JFrame)
		JFrame ventana = new JFrame("Eventos tipo check, combo y lista");
	
		// Colocar sobre el panel contenedor la vista (es un JPanel)
		ventana.setContentPane(miVista);
		
		// Añadir el control de cierre de ventana, pack, ....
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.pack();
		ventana.setVisible(true);
		
	}

}