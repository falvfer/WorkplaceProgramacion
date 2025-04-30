package ejer6;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ejer6v3 {

	public static void main(String[] args) {
		try (BufferedWriter bw = Files.newBufferedWriter(Path.of("./src/ejer6/EjerCopia.txt"))){
			
			for (String linea: Files.readAllLines(Path.of("./src/ejer6/Ejer6v2.java"))) {
				bw.write(linea+'\n');
			}
			
			
		} catch (NoSuchFileException e) {
			System.out.println("[!] No existe el archivo especificado");
		} catch (IOException e) {
			System.out.println("[!] Error de entrada salida");
		}
		
	}
}
