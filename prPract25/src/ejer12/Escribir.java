package ejer12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Escribir {

	public static void main(String[] args) {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Francisco", "Alvarez", "654321987"));
		personas.add(new Persona("Federico", "Lopez", "604323587"));
		personas.add(new Persona("Jorge", "Martinez", "654567217"));
		
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(
						new File("src/ejer12/listaPersonas")))) {
			
			oos.writeObject(personas);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
