package ejer4;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejer4v2 {

	public static void main(String[] args) {
		
		String ultimaCadena = null;
		int inicio;
		
		if (Files.exists(Path.of("src/ejer4/cadenas.txt"))) {
			try (BufferedReader br = Files.newBufferedReader(Path.of("src/ejer4/cadenas.txt"))) {
				String lineaActual;
				
				while ((lineaActual = br.readLine()) != null) {
					ultimaCadena = lineaActual;
				}
				inicio = Integer.parseInt(ultimaCadena.split(":")[1]);
			} catch (IOException e) {
				System.out.println("Error al abrir el archivo");
				inicio = 1;
			}
		} else
			inicio = 1;
		
		List<String> listaCadenas = new ArrayList<>();
		for (int i = 1; i<=10; i++)
			listaCadenas.add("Cadena:"+(++inicio));
		
		try (FileWriter fw = new FileWriter("src/ejer4/cadenas.txt", true)) {
			
			for (String str: listaCadenas)
				fw.write(str+'\n');
			
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
		}
		
	}
	
}
