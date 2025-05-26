package test;

import java.util.Random;

import javax.swing.JFrame;

import controlador.ControladorBusqueda;
import modelo.GeneradorExpediente;
import modelo.Gestor;
import vista.VentanaBusqueda;

public class Test {
	
	/**
	 * Explicación del ejercicio:
	 * 
	 * He decidido simular la vista de una base de datos que tienen en access.
	 * Para ello he tenido que crear las clases Expediente y Caja para simular
	 * los propios expedientes y donde están archivados. Este sistema lo usan
	 * en el ayuntamiento para ordenar todos los expedientes, habiendo hoy en día
	 * más de 4000 cajas.
	 * 
	 * Para las secciones he decidido usar Enumeraciones ya que son categorías fijas.
	 * 
	 * Toda la interfaz gráfica y los eventos los he hecho en la clase Ventana.
	 * 
	 * Para la simulación y el testeo he decidido crear un generador de expedientes.
	 * Con este generador el main genera 20 Cajas y 130 Expedientes, estos expedientes
	 * tienen datos completamente aleatorios.
	 * @param args
	 */
	
	public static void main(String[] args) {
		Random rdn = new Random();
		// Crear las cajas y los expedientes para probar
		Gestor g = new Gestor();
		GeneradorExpediente expGen = new GeneradorExpediente();
		for (int i = 1; i<=20; i++) {
			g.crearCaja(i);
		}
		for (int i = 0; i<130; i++) {
			g.addExpediente(
					expGen.next((short)(i%10+1),
								(short)(2013+i/10)),
					rdn.nextInt(1,21));
		}
		
		// Crear la Ventana
		VentanaBusqueda v = new VentanaBusqueda();
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLocationRelativeTo(null);
		v.setResizable(false);
		
		// Crear el controlador
		ControladorBusqueda ctr = new ControladorBusqueda(v, g);
		v.control(ctr);
		
		// Esto es para poder hacer debug y mirar los expedientes y las cajas que se generan.
		System.out.println(g.toString());
	}
}
