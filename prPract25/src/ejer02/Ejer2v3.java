package ejer2;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Realizar un programa que nos permita leer byte a byte el contenido
 * del fichero creado en el ejercicio anterior, ayudaros de la clase
 * BufferedInputStream. Los datos leídos los mostraremos en consola.
 */
public class Ejer2v3 {

	public static void main(String[] args) {
		try (BufferedReader flujoLectura = Files.newBufferedReader(Path.of("src/ejer1/buffered.dat"))){
			
			System.out.println(flujoLectura.readLine());
			
		} catch (IOException e) {
			System.out.println("Error: Problema al leer en el archivo.");
		}
		
	}
	
}
