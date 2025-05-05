package ejer12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Leer {

@SuppressWarnings("unchecked") // Esto es para evitar que de el warning del casting a una lista
	public static void main(String[] args) {
		List<Persona> personas = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(
						new File("src/ejer12/listaPersonas")))) {
			personas = (List<Persona>)ois.readObject();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		for (Persona p: personas) {
			System.out.println(p);
		}
		
	}
	
}
