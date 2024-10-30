package ejer11_21;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		// Diseñar un algoritmo que a partir de la base y la altura de un
		// triángulo muestre como resultado su superficie. (superficie = b · h / 2).

		// Crear el objeto Scanner y las variables
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		float base=0;
		float altura=0;
		
		// Preguntar por la base y la altura para hacer los calculos
		System.out.print("Especifique la base del triangulo: ");
		base=sc.nextFloat();
		System.out.print("Especifique la altura del triangulo: ");
		altura=sc.nextFloat();
		
		// Mostrar la superficie del triangulo
		System.out.println("La superficie del triangulo es igual a: "+(base*altura/2));
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}