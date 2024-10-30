package ejer11_20;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// Diseñar un algoritmo para leer las longitudes de los lados de un triángulo y
		// determine que tipo de triángulo es, de acuerdo a los siguientes casos:
		// suponiendo que A es el mayor de los lados y que B y C corresponden a los
		// otros 2 lados:
		//		Si A >= B + C    No es un triángulo 
		//		Si A² = B² + C²   Triángulo rectángulo 
		//		Si A² > B² + C²   Triángulo obtusángulo 
		//		Si A² < B² + C²   Triángulo acutángulo 

		// Crear variables
		float lB = 0, l2 = 0, l3 = 0, l23;

		// Crear el objeto scanner
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);

		// Preguntar por pantalla los números
		System.out.print("Especifique el lado MAYOR del triángulo: ");
		lB = sc.nextFloat();
		System.out.print("Especifique el segundo lado del triángulo: ");
		l2 = sc.nextFloat();
		System.out.print("Especifique el tercer lado del triángulo: ");
		l3 = sc.nextFloat();

		// Comprobaciones de errores y de tipo de triangulo
		if (lB > l2 && lB > l3) // Que lB sea el lado mayor
			if (lB >= (l2 + l3)) // Que sea un triangulo
				System.out.print("No es un triángulo.");
			else {
				// Hacer la cuenta previamente para no tener que hacerla 2 veces
				lB = (float) Math.pow(lB, 2);
				l23 = (float) Math.pow(l2, 2) + (float) Math.pow(l3, 2);
				if (lB < l23) // Que sea acutangulo
					System.out.println("Triángulo acutángulo");
				else if (lB > l23) // Que sea obtusángulo
					System.out.println("Triángulo obtusángulo");
				else
					System.out.println("Triángulo rectángulo");
			}
		else
			System.out.println("Error: No se ha especificado el lado más grande primero.");

		// Cerrar el objeto Scanner
		sc.close();

	}

}
