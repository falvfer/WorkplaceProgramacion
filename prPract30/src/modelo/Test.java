package modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		/*
		//---------------------------------------------------------------------------------------
		// TEST DE LA CLASE LIBRO
		//---------------------------------------------------------------------------------------
		System.out.println("LIBRO----------------------------------------------------------------");
		Libro lib1 = new Libro("0005", "El Señor de los Anillos", "J.R.R. Tolkien");
		String[] pLib1 = {"Gandalf", "Aragorn", "Frodo Bolsón", "Legolas", "Gollum"};
		System.out.println("Se han insertado " + lib1.añadirPersonajes(pLib1) + " personajes.");
		
		Libro lib2 = new Libro("0001", "Don Quijote de la Mancha", "Miguel de Cervantes");
		lib2.añadirPersonaje("Alonso Quijano");
		lib2.añadirPersonaje("Sancho Panza");
		
		System.out.println(lib1);
		System.out.println(lib2);
		
		Libro lib3 = new Libro("0002","Los pilares de la Tierra","Ken Follet",
		Arrays.asList("Aliena","Jack Jackson","Regan Hamleigh"));
		System.out.println(lib3);
		
		Libro lib4 = new Libro("0003","El tiempo entre costuras","María Dueñas",
		Arrays.asList("Sira Quiroga","Ramiro Arribas", "Marcus Logan"));
		System.out.println(lib4);
		
		Libro lib5 = new Libro("0004","El principito","Antoine de Saint-Exupary",
		Arrays.asList("The Little Prince","El vanidoso","Le renard"));
		System.out.println(lib5);
		
		Libro lib6 = new Libro("0006","Cien Años de Soledad","Gabriel García Márquez",
		Arrays.asList("José Arcadio Buendía","Coronel Aureliano Buendía"));
		System.out.println(lib6);
		
		Libro lib7 = new Libro("0007","El principito","Antoine de Saint-Exupary",
		Arrays.asList("The Little Prince","El vanidoso","Le renard"));
		System.out.println(lib7 + "\n");

		//---------------------------------------------------------------------------------------
		// TEST DE LA CLASE USUARIO
		//---------------------------------------------------------------------------------------
		System.out.println("USUARIO--------------------------------------------------------------");
		Usuario u1 = new Usuario("José Mª García");
		Usuario u2 = new Usuario("María López");
		
		System.out.println(u1);
		System.out.println(u2 + "\n");

		//---------------------------------------------------------------------------------------
		// TEST DE LA CLASE BIBLIOTECA
		//---------------------------------------------------------------------------------------
		System.out.println("BIBLIOTECA-----------------------------------------------------------");
		
		Biblioteca bib = new Biblioteca();
		
		bib.altaUsuario(u1);
		bib.altaUsuario(u2);
		bib.altaLibro(lib1);
		bib.altaLibro(lib2);
		bib.altaLibro(lib3);
		bib.altaLibro(lib4);
		bib.altaLibro(lib5);
		bib.altaLibro(lib6);
		bib.altaLibro(lib7);
		
		try {
			bib.prestarLibro(lib7.getTitulo(), u1.getNombre());
		} catch (BibliotecaException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Usuario: " + u1 + "\n");
		
		try {
			System.out.println(bib.librosToString());
		} catch (BibliotecaException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("\n" + bib.usuariosToString());
		*/
		
		//---------------------------------------------------------------------------------------
		// TEST ACTUALIZADO
		//---------------------------------------------------------------------------------------
		
		Biblioteca bib;
		
		try {
			bib = new Biblioteca(Path.of("recursos/files/clientes.txt"),
					Path.of("recursos/files/libros.txt"));
			System.out.println(bib.librosToString()+'\n');
			System.out.println(bib.usuariosToString());
		} catch (BibliotecaException e) {
			System.out.println(e.getMessage());
		}
	}
}
