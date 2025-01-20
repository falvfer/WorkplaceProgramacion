package claseObjects;

import java.util.Objects;

public class Test0 {

	public static void main(String[] args) {
		
		String s1 = null;
		String s2 = "Hola";

		// Comparación no seguroa
		// s1.equals(s2); // Saltará la excepción NullPointerException
		
		// Comparación segura
		System.out.println(Objects.equals(s1, s2));  // false

		// Retorna "null" si el objeto es null
		System.out.println(Objects.toString(s1, "Valor por defecto")); // "Valor por defecto"
		System.out.println(Objects.toString(s2, "Valor por defecto")); // Hola
		
		// Lanza NullPointerException si s1 es null
		Objects.requireNonNull(s1, "El objeto no puede ser null");
	
	}

}
