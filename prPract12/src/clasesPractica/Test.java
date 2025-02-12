package clasesPractica;

public class Test {

	public static void main(String[] args) {
		
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
		System.out.println(lib2 + "\n");

		//---------------------------------------------------------------------------------------
		// TEST DE LA CLASE USUARIO
		//---------------------------------------------------------------------------------------
		System.out.println("USUARIO--------------------------------------------------------------");
		Usuario u1 = new Usuario("José Mª García");
		Usuario u2 = new Usuario("María López");
		
		u1.sacaLibro(lib1);
		u1.sacaLibro(lib2);
		
		System.out.println(u1);
		System.out.println(u2);

		//---------------------------------------------------------------------------------------
		// TEST DE LA CLASE 
		//---------------------------------------------------------------------------------------
		System.out.println("---------------------------------------------------------------------");
		
		
		
		
		
		
		
		

	}

}
