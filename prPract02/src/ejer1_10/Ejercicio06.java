package ejer1_10;

import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
		// Diseñar un algoritmo que nos permita saber el mayor de dos números
		// introducidos. Controlar el caso de que sean iguales.

		// Crear objeto Scanner y variables
		Scanner sc = new Scanner(System.in);
		int num1 = 0, num2 = 0;

		// Pedir números por pantalla
		System.out.print("Especifique el primer número: ");
		num1 = sc.nextShort();
		System.out.print("Especifique el segundo número: ");
		num2 = sc.nextShort();

		// Cerrar el objeto Scanner
		sc.close();

		if (num1 == num2) // Comprobación de que sean iguales
			System.out.println("Los números son iguales");
		else if (num1 > num2) // Comprobación para saber cual es mayor que cual
			System.out.println(num1 + " es mayor que " + num2);
		else
			System.out.println(num2 + " es mayor que " + num1);
	}
}
