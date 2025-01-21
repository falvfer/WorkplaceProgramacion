package ejer04;

public class Ejer04_1 {

	public static void main(String[] args) {
		
		// Crea un objeto de tipo String que contenga varias palabras
		String cadena = "Esta es una frase muy larga y muy original. ¿A que sí?";
		
		// Averigua la longitud de la cadena.
		System.out.println("La longitud de la cadena es: " + cadena.length());
		
		// Muestra el carácter que se encuentra en la posición 2 de tu cadena.
		System.out.println("Caracter en la posición 2: " + cadena.charAt(1));
		
		// Mostrar todas las vocales de una cadena.
		for (Character ch: cadena.toCharArray()) {
			if (ch == 'a')
				System.out.print(ch);
		}
		
		
		System.out.println("Todas las vocales de la cadena son: ");
		
		// Extraer la penúltima letra de una cadena.
		// Extrae y almacena en otro objeto del mismo tipo toda la cadena excepto los 2 primeros caracteres (subcadena).
		// Extrae y almacena en otro objeto del mismo tipo toda la cadena excepto los 2 primeros caracteres y los dos últimos caracteres.
		// Modifica en la cadena anterior todas las veces que aparezca la vocal ‘a’ (minúscula) por ‘A’ (mayúscula).
		// Crea un array de caracteres cuyos elementos serán los de la cadena anterior.
		// Convierte la subcadena que creaste anteriormente a mayúscula, y que se quede modificada internamente, es decir, no solo a la hora de imprimirla.
		// Comprueba si la cadena empieza por la palabra “Hola”.
		// Busca una subcadena que exista dentro de tu cadena, y otra que no exista (indexOf), recordad que en la cadena original la letra ‘a’ se había cambiado a mayúscula.
		// Busca todas las ocurrencias de una cadena.
		
		
		
		
		

	}

}
