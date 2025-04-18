package ejer1;

import java.awt.event.*;
import javax.swing.*;

/**
 * Clase para probar los eventos de ventana
 */
public class Ejer1 extends JFrame {
	private static final long serialVersionUID = 2407093880534212790L;

	/**
	 * Constructor
	 * 
	 * @param s  --> Título de la ventana
	 * @param w  --> Alto de la ventana
	 * @param h  --> Ancho de la ventana
	 * @param lo --> Posición de la ventana
	 */
	public Ejer1(String s, int w, int h, int lo) {
		// Establecer el título de la ventana
		super(s);
		// Establecer un tamaño para la ventana (ancho y alto)
		setSize(w, h);
		// Poner visible la ventana
		setVisible(true);
		// Posicionar la ventana en las coordenadas indicadas
		setLocation(lo, 100);
		// También podríamos usar el método setBounds, para unificar setSize y setLocation
		// setBounds(lo, 100, w, h);
		// Añado el control al cierre de la ventana
		addWindowListener(new ControlVentana());
	}

	/**
	 * Método principal
	 */
	public static void main(String[] args) {
		// Crear tres objetos tipo ventana
		new Ejer1("Prueba eventos de ventana 1", 200, 100, 1);
		new Ejer1("Prueba eventos de ventana 2", 100, 50, 200);
		new Ejer1("Prueba eventos de ventana 3", 200, 200, 500);
	}

	/**
	 * Clase para programar los eventos de ventana
	 */
	public class ControlVentana implements WindowListener {
		public void windowOpened(WindowEvent e) {
			System.out.println("Ventana " + e.getWindow().getName() + " abierta");
		}

		public void windowClosing(WindowEvent e) {
			System.out.println("Cerrando ventana " + e.getWindow().getName());
			e.getWindow().dispose();
		}

		public void windowClosed(WindowEvent e) {
			System.out.println("Ventana " + e.getWindow().getName() + " cerrada");
		}

		public void windowActivated(WindowEvent e) {
			System.out.println("Ventana " + e.getWindow().getName() + " activa (en uso)");
		}

		public void windowDeactivated(WindowEvent e) {
			System.out.println("Ventana " + e.getWindow().getName() + " desactivada (fuera de uso)");
		}

		public void windowIconified(WindowEvent e) {
			System.out.println("Ventana " + e.getWindow().getName() + " minimizada");
		}

		public void windowDeiconified(WindowEvent e) {
			System.out.println("Ventana " + e.getWindow().getName() + " restaurada");
		}
	}
}