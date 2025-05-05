package ejer00;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaArchivoTexto {

	public static void main(String[] args) {
		
		String cadena;
		
		try (BufferedReader flujoLectura = new BufferedReader(
												new FileReader(
													new File("src/ejer0/Prueba.txt")))) {
			
			cadena = flujoLectura.readLine();
			while (cadena != null) {
				System.out.println(cadena);
				cadena = flujoLectura.readLine();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		} catch (IOException e) {
			System.out.println("Error IOException");
		}
		
	}
}
