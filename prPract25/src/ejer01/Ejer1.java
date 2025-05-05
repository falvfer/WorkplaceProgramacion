package ejer1;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Desarrollar un programa que os permita escribir bytes en un fichero
 * con la ayuda de un objeto BufferedOutputstream, realizaremos una única
 * escritura a través de un array de tipo byte, que previamente habremos
 * rellenado con el valor “1”, este array también funcionará como una
 * “especie de buffer”, ya que nos va a permitir escribir más de una dato
 * con una sola sentencia de escritura. El tamaño del buffer vuestro
 * (el array) no debe ser ni muy pequeño ni muy grande, por ejemplo de 32Kb.
 * El archivo creado se llamará buffered.dat.
 */
public class Ejer1 {

	public static void main(String[] args) {
		
		byte[] buffer = new byte[1024*32];
		Arrays.fill(buffer, (byte)1);

		try (BufferedOutputStream flujoEscritura = new BufferedOutputStream(
													new FileOutputStream(
														new File("src/ejer1/buffered.dat")))) {
			
			flujoEscritura.write(buffer);
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: El archivo no se ha podido encontrar.");
		} catch (IOException e) {
			System.out.println("Error: Problema al escribir en el archivo");
		}
		
	}
	
}
