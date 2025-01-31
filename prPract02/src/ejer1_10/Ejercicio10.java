package ejer1_10;

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		// Realizar un algoritmo para deducir el mayor de tres valores introducidos por teclado.

		// Crear variables
		int num1 = 0, num2 = 0, num3 = 0, mayor;

		// Crear el objeto scanner
		Scanner sc = new Scanner(System.in);

		// Preguntar por pantalla los número y leer los números
		System.out.print("Especifique el primer número: ");
		num1 = sc.nextInt();
		System.out.print("Especifique el segundo número: ");
		num2 = sc.nextInt();
		System.out.print("Especifique el tercer número: ");
		num3 = sc.nextInt();

		// Cerrar el objeto Scanner
		sc.close();

		// Hacer comprobaciones y mostrar el resultado ____________________________________________
		if (num1 > num2)
			if (num1 > num3)
				System.out.println("El número " + num1 + " es el mayor.");
			else
				System.out.println("El número " + num3 + " es el mayor.");
		else if (num2 > num3)
			System.out.println("El número " + num2 + " es el mayor.");
		else
			System.out.println("El número " + num3 + " es el mayor.");
		
		// Version simplificada ___________________________________________________________________
		mayor = num1;
		if (num2>mayor) mayor = num2;
		if (num3>mayor) mayor = num3;
		System.out.println("El número " + mayor + " es el mayor.");
	}
}
