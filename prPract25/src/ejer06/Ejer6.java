package ejer6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejer6 {

	public static void main(String[] args) {
		String linea = null;
		
		try (BufferedReader br = Files.newBufferedReader(Path.of("./src/ejer6/Ejer6.java"))) {
			
			while ((linea = br.readLine()) != null)
				System.out.println(linea);
			
		} catch (NoSuchFileException e) {
			System.out.println("[!] No existe el archivo especificado");
		} catch (IOException e) {
			System.out.println("[!] Error de entrada salida");
		}
		
	}
}
