package ejer09;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ejercicio {

	/* Crea un diccionario de términos informáticos y su definición,
	 * con la ayuda de las colecciones. El diccionario deberá estar
	 * ordenado por clave de forma alfabética. Para probarlo, pide al
	 * usuario un término y muéstrale su definición.
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<String, String> diccionario = new TreeMap<>();
		diccionario.put("ordenador", "Computadora electrónica.");
		diccionario.put("software", "Conjunto de programas, instrucciones y reglas informáticas para ejecutar ciertas tareas en una computadora.");
		diccionario.put("hardware", "Conjunto de aparatos de una computadora.");
		diccionario.put("programación", "La programación es el proceso de crear un conjunto de instrucciones que le dicen a una computadora como realizar algún tipo de tarea.");
		
		System.out.print("Especifica un termino: ");
		StringBuilder termino = new StringBuilder(sc.nextLine());
		
		if (diccionario.containsKey(termino.toString().toLowerCase()))
			System.out.println(termino + ": " + diccionario.get(termino.toString().toLowerCase()));
		else
			System.out.println("No existe ese termino en este diccionario.");
		
	}
}
