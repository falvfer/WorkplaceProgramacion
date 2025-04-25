package ejer3;

import java.io.FileWriter;
import java.io.IOException;

/**
 * En este ejercicio vamos a realizar un programa que nos permite escribir en un
 * fichero de caracteres una cadena que contengan el comienzo del El Quijote.
 * Los caracteres los debéis escribir uno a uno en el fichero con la ayuda
 * de un flujo FileWriter. El archivo que debéis crear se llama
 * introquijote.txt.
 */

public class Ejer3 {

	public static void main(String[] args) {
		
		String inicioQuijote = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme...";
		
		try (FileWriter fw = new FileWriter("src/ejer3/introquijote.txt", true)) {
			
			for (char ch: inicioQuijote.toCharArray())
				fw.write(ch);
			fw.append('\n');
			
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
		}
		
	}
	
}
