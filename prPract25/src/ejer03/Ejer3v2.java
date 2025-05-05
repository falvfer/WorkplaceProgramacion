package ejer03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

/**
 * Modificar el programa para que os escriba la cadena en una sola sentencia de escritura.
 */

public class Ejer3v2 {

	public static void main(String[] args) {
		
		String inicioQuijote = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme...";
		
		try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/ejer3/introquijote.txt"),
				StandardOpenOption.APPEND, StandardOpenOption.CREATE)) {
			
			bw.write(inicioQuijote+'\n');
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
