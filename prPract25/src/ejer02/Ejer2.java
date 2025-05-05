package ejer02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * Realizar un programa que nos permita leer byte a byte el contenido
 * del fichero creado en el ejercicio anterior, ayudaros de la clase
 * BufferedInputStream. Los datos leídos los mostraremos en consola.
 */
public class Ejer2 {

	public static void main(String[] args) {
		
		BufferedInputStream flujoLectura = null;
		int caracter;

		try {
			flujoLectura = new BufferedInputStream(
					new FileInputStream(
						new File("src/ejer1/buffered.dat")));
			while ((caracter = flujoLectura.read()) != -1)
			System.out.print((char)caracter + " ");
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: El archivo no se ha podido encontrar.");
		} catch (IOException e) {
			System.out.println("Error: Problema al escribir en el archivo");
		}
		finally {
			try {
				flujoLectura.close();
			} catch (IOException e) {
				System.out.println("Error al cerrar el archivo.");
			} catch (NullPointerException e) {
				System.out.println("Error al cerrar el archivo.");
			}
		}
		
	}
	
}
