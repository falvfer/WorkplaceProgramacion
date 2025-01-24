package ejer01_10;

import java.util.Arrays;

import MisLibrerias.LibreriaVector;

public class Ejer04 {

	public static void main(String[] args) {

		System.out.println("--- 1 ---------------------------------------------------------------");
		// Crea un objeto de tipo String que contenga varias palabras
			String cadena = "Esta es una frase muy larga y muy original. ¿A que sí?";
			System.out.println("Cadena: " + cadena);
	
		System.out.println("\n--- 2 ---------------------------------------------------------------");
		// Averigua la longitud de la cadena.
			System.out.println("La longitud de la cadena es: " + cadena.length());
	
		System.out.println("\n--- 3 ---------------------------------------------------------------");
		// Muestra el carácter que se encuentra en la posición 2 de tu cadena.
			System.out.println("Caracter en la posición 2: " + cadena.charAt(1));
	
		System.out.println("\n--- 4 ---------------------------------------------------------------");
		// Mostrar todas las vocales de una cadena.
			System.out.print("Todas las vocales de la cadena son: ");
			for (char ch: cadena.toCharArray())
				if (Character
						.toString(ch)
						.matches("[aeiouAEIOUáéíóúÁÉÍÓÚ]"))
					System.out.print(ch + " ");
			System.out.println();
	
		System.out.println("\n--- 5 ---------------------------------------------------------------");
		// Extraer la penúltima letra de una cadena.
			System.out.println("Caracter en la penúltima posición: "
					+ cadena.charAt(cadena.length()-2));
	
		System.out.println("\n--- 6 ---------------------------------------------------------------");
		// Extrae y almacena en otro objeto del mismo tipo toda la cadena excepto los 2
		// primeros caracteres (subcadena).
			String cadena2 = cadena.substring(2);
			System.out.println("Cadena 2: " + cadena2);
	
		System.out.println("\n--- 7 ---------------------------------------------------------------");
		// Extrae y almacena en otro objeto del mismo tipo toda la cadena excepto los 2
		// primeros caracteres y los dos últimos caracteres.
			String cadena3 = cadena.substring(2, cadena.length()-2);
			System.out.println("Cadena 3: " + cadena3);
	
		System.out.println("\n--- 8 ---------------------------------------------------------------");
		// Modifica en la cadena anterior todas las veces que aparezca la vocal ‘a’
		// (minúscula) por ‘A’ (mayúscula).
			cadena = cadena.replace('a', 'A');
			System.out.println("Cadena: " + cadena);
	
		System.out.println("\n--- 9 ---------------------------------------------------------------");
		// Crea un array de caracteres cuyos elementos serán los de la cadena anterior.
			char[] arrayCadena = cadena.toCharArray();
			System.out.println("Array cadena: " + Arrays.toString(arrayCadena));
			System.out.println(arrayCadena);
			
			/* Método viejo, se puede hacer así, pero mejor de la otra forma.
			 *     arrayCadena = new char[cadena.length()];
			 *     cadena.getChars(0, cadena.length(), arrayCadena, 0);
			 *     System.out.println("Array cadena: " + Arrays.toString(arrayCadena));
			 *     System.out.println(arrayCadena);
			 */
	
		System.out.println("\n--- 10 --------------------------------------------------------------");
		// Convierte la subcadena que creaste anteriormente a mayúscula,
		// y que se quede modificada internamente, es decir, no solo a la hora de imprimirla.
			// Para el Array
			for (int i = 0; i < arrayCadena.length; i++)
				arrayCadena[i] = Character.toUpperCase(arrayCadena[i]);
			
			System.out.println("Array cadena: " + Arrays.toString(arrayCadena));

			// Para la Cadena 3
			cadena3 = cadena3.toUpperCase();
			System.out.println(cadena3);
	
		System.out.println("\n--- 11 --------------------------------------------------------------");
		// Comprueba si la cadena empieza por la palabra “Hola”.
			if (cadena.toUpperCase().startsWith("HOLA"))
				System.out.println("Empieza por 'Hola'.");
			else
				System.out.println("No empieza por 'Hola', empieza por '" + cadena.substring(0, cadena.indexOf(' ')) + "'.");
	
		System.out.println("\n--- 12 --------------------------------------------------------------");
		// Busca una subcadena que exista dentro de tu cadena, y otra que no exista (indexOf),
		// recordad que en la cadena original la letra ‘a’ se había cambiado a mayúscula.
			if (cadena.toUpperCase().indexOf("ALMENDRA") >= 0)
				System.out.println("Existe la cadena 'almendra'");
			else
				System.out.println("No existe la cadena 'almendra'");
			
			if (cadena.toUpperCase().contains("FRASE"))
				System.out.println("Existe la cadena 'frase'");
			else
				System.out.println("No existe la cadena 'frase'");
			
			System.out.println(cadena.toUpperCase().contains("ORIGINAL")?
					"Existe la cadena 'original'":
					"No existe la cadena 'original'");
	
		System.out.println("\n--- 13 --------------------------------------------------------------");
		// Busca todas las ocurrencias de una cadena.
			System.out.println("La cadena 'muy' ha aparecido "
					+ contarOcurrenciasIgnoreCase(cadena, "muy")
					+ " veces.");
			System.out.println("La cadena 'ras' ha aparecido "
					+ contarOcurrenciasIgnoreCase(cadena, "ras")
					+ " veces.");
			System.out.println("La cadena 'almendra' ha aparecido "
					+ contarOcurrenciasIgnoreCase(cadena, "almendra")
					+ " veces.");
			System.out.println("La cadena 'a' ha aparecido "
					+ contarOcurrenciasIgnoreCase(cadena, "e")
					+ " veces.");
	
		System.out.println("\n--- 14 --------------------------------------------------------------");
		// Extrae de tu cadena la segunda palabra y almacénala en una nueva cadena.
			int indexOfPrimerEspacio = cadena.indexOf(' ');
			int indexOfSegundoEspacio = cadena.indexOf(' ', indexOfPrimerEspacio + 1);
			String segundaPalabra = cadena.substring(indexOfPrimerEspacio+1,indexOfSegundoEspacio);
			System.out.println("La segunda palabra es: " + segundaPalabra);
			
			// Con split
			String[] cadenas = cadena.split("[ -.,;:¿?¡!]");
			System.out.println("La segunda palabra es: " + cadenas[1]);
			System.out.println(Arrays.deepToString(cadenas));
			System.out.println(Arrays.deepToString(LibreriaVector.removeBlanks(cadenas)));
			
		System.out.println("\n--- 15 --------------------------------------------------------------");
		// A partir de un array de caracteres crea un objeto de tipo cadena.
			String cadena4 = "";
			for (char ch: arrayCadena)
				cadena4 += ch;
			// Otra forma con un método
			cadena4 = String.valueOf(arrayCadena);
			System.out.println("Array a cadena: " + cadena4);
			
		System.out.println("\n--- 16 --------------------------------------------------------------");
		// Muestra el valor Unicode de cada uno de los caracteres de
		// la cadena anterior (codePointAt).
			System.out.print("Valor de todos los valores: ");
			for (int i = 0; i < cadena.length(); i++)
				System.out.print(cadena.codePointAt(i) + " ");
			System.out.println();
			
		System.out.println("\n--- 17 --------------------------------------------------------------");
		// Crea un objeto de tipo StringBuffer, y prueba diferentes formas de concatenación
		// con el método Append.
			StringBuffer cadena5 = new StringBuffer("Esta es una cadena corta");
			System.out.println("Cadena 5: " + cadena5);
			System.out.println("Cadena 5: " + cadena5.append(", pero ahora más larga."));
			System.out.println("Cadena 5: " + cadena5.append(" Un boolean: ").append(true));
			System.out.println("Cadena 5: " + cadena5.append(". Un long: ").append(234232l));
			
		System.out.println("\n--- 18 --------------------------------------------------------------");
		// Insertar al objeto anterior una subcadena, a partir de la posición 7.
			System.out.println("Cadena 5: " + cadena5.insert(7, " (CADENA NUEVA)"));
			
		System.out.println("\n--- 19 --------------------------------------------------------------");
		// A partir de un array de tipo byte que contiene números de un dígito, y con
		// la ayuda del método reverse de la clase StringBuffer, invierte el citado array.
			byte[] arrayBytes = {2,7,5,8,4,1,9,4,6};
			System.out.println("Array normal: " + Arrays.toString(arrayBytes));
			arrayBytes = new StringBuffer(new String(arrayBytes)).reverse().toString().getBytes();
			System.out.println("Array invertido: " + Arrays.toString(arrayBytes));
	}
	
	public static int contarOcurrencias(String cadena, String cadenaBuscar) {
		int contOcurrencias = 0, posicion;

		posicion = cadena.indexOf(cadenaBuscar);
		
		while (posicion != -1) {
			contOcurrencias++;
			posicion += cadenaBuscar.length();
			posicion = cadena.indexOf(cadenaBuscar, posicion);
		}
		
		return contOcurrencias;
	}
	
	public static int contarOcurrenciasIgnoreCase(String cadena, String cadenaBuscar) {
		return contarOcurrencias(cadena.toUpperCase(), cadenaBuscar.toUpperCase());
	}

}
