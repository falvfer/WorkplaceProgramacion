package ejer04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejer4 {

	public static void main(String[] args) {
		
		List<String> listaCadenas = new ArrayList<>();
		for (int i = 1; i<=10; i++)
			listaCadenas.add("Cadena número "+i);
		
		try (FileWriter fw = new FileWriter("src/ejer4/cadenas.txt", true)) {
			
			for (String str: listaCadenas)
				fw.write(str+'\n');
			
		} catch (IOException e) {
			System.out.println("Error al abrir el archivo.");
		}
		
	}
	
}
