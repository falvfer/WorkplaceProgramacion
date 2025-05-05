package ejer06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Ejer6v2 {

	public static void main(String[] args) {
		try {
			
			Files.readAllLines(Path.of("./src/ejer6/Ejer6v2.java"))
				 .forEach(System.out::println);
			
		} catch (NoSuchFileException e) {
			System.out.println("[!] No existe el archivo especificado");
		} catch (IOException e) {
			System.out.println("[!] Error de entrada salida");
		}
		
	}
}
