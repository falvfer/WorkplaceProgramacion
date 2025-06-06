package test;

import java.sql.SQLException;

import javax.swing.JFrame;

import bd.BDConnection;
import controlador.Controlador;
import vista.Vista;

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
		
		/* SOLO LA PRIMERA VEZ
		 * // Crear las subsecciones
		 * Crear.actualizarSubsecciones(c);
		 * 
		 * // Crear unos cuantos Expedientes y Personas para probar
		 * Crear.expedientes(g);
		 */
		
		// Crear la Ventana
		Vista v = new Vista();
		v.setVisible(true);
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setLocationRelativeTo(null);
		v.setResizable(false);
		
		// Crear el controlador y añadirselo a la vista
		Controlador ctr = new Controlador(v);
		v.control(ctr);
		
		// Debug
		System.out.println(BDConnection.mostrarBBDD());
	}
	
	public static void printSQLException(SQLException ex) {
		
		ex.printStackTrace(System.err);
		System.err.println("SQLState: "+ex.getSQLState());
		System.err.println("Error code: "+ex.getErrorCode());
		System.err.println("Message: "+ex.getMessage());
		Throwable t = ex.getCause();
		while (t!=null) {
			System.out.println("Cause: "+t);
			t = t.getCause();
		}
	}
}
