package ejer0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraArchivoTexto {

	public static void main(String[] args) {
		
		String cadena;
		
		try (BufferedWriter flujoEscritura = new BufferedWriter(
												new FileWriter(
													new File("src/ejer0/Prueba.txt"),
													true))) {
			
			flujoEscritura.write("\nLínea añadida ");
			flujoEscritura.write('2');
			
		} catch (IOException e) {
			System.out.println("Error IOException");
		}
		
	}
}
