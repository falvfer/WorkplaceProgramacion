package ejer05;

import java.util.*;

public class Ejercicio {

	public static void main(String args[]) {
		
		// Colección de tipo Mapa
		Map<String,String> dic1 = new HashMap<>();
		// Map<String,String> miDiccionario = new LinkedHashMap<>();
		
		// Añadir varias palabras a nuestro diccionario
		dic1.put("amar", "love");
		dic1.put("coche", "car");
		dic1.put("leyenda", "legend");
		dic1.put("hacer", "do");
		dic1.put("perro", "dog");
		
		System.out.println(dic1);
		
		// Prueba del método "get".
		System.out.println("Traducción de amar: " + dic1.get("amar"));
		System.out.println("Traducción de amir: " + dic1.get("amir"));
		
		// Crear un TreeMap a partir de un HashMap
		SortedMap<String,String> dic2 = new TreeMap<>(dic1);
		System.out.println(dic2);

		// Crear un TreeMap volcando otro (putAll)
		SortedMap<String,String> dic3 = new TreeMap<>();
		dic3.putAll(dic1);
		dic3.put("rojo", "red");
		dic3.put("azul", "blue");
		dic3.put("verde", "green");
		
		System.out.println("Diccionario 3: " + dic3);

		// Crear un TreeMap pero que esté ordenado de forma inversa
		SortedMap<String,String> dic4 = new TreeMap<>((o1, o2) -> o2.compareTo(o1));
		dic4.putAll(dic3);
		
		System.out.println("Diccionario 4: " + dic4);
		
		// Obtén las claves de algunas palabras de tu diccionario
		// y guardalas en un set
		Set<String> claves = dic4.keySet();
		System.out.println("Claves: " + claves);
		
		// En un conjunto ordenado
		SortedSet<String> claves2 = new TreeSet<>(dic4.keySet());
		System.out.println("Claves 2: " + claves2);
		
		// Ordenado a la inversa
		SortedSet<String> claves3 = new TreeSet<>(
				(o1, o2) -> o2.compareToIgnoreCase(o1));
		
		claves3.addAll(dic2.keySet());
		System.out.println("Claves 2: " + claves3);
		
		SortedSet<String> valores = new TreeSet<>(dic4.values());
		System.out.println("Valores: " + valores);
		
		List<String> valores2 = new ArrayList<>(dic4.values());
		System.out.println("Valores 2: " + valores2);
		Collections.sort(valores2);
		System.out.println("Valores 2 ordenados: " + valores2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
