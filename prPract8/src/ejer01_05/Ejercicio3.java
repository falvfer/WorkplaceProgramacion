package ejer01_05;

public class Ejercicio3 {

	/**
	 * Define un array de 10 caracteres y asigna valores a los elementos
	 * según la tabla que se muestra a continuación. Muestra el contenido
	 * de todos los elementos del array. ¿Qué sucede con los valores de
	 * los elementos que no han sido inicializados?
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		char[] array = new char[10];
		
		array[0] = 'a';
		array[1] = 'x';
		array[4] = '@';
		array[6] = ' ';
		array[7] = '+';
		array[8] = 'Q';
		
		System.out.print("Contenido del array: ");
		for (int i = 0; i<array.length; i++)
			System.out.println("'" + array[i] + "'");
		
		// Los valores los inicializa Java por defecto al caracter espacio (' ')
		
	}

}
