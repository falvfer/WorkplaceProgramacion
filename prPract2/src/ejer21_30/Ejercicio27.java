package ejer21_30;

import java.util.Scanner;

public class Ejercicio27 {

	public static void main(String[] args) {
		// Hacer un algoritmo para calcular el factorial de un número natural positivo,
		// se debe tener en cuenta si el número no es positivo, ya que no existe el
		// factorial de los números negativos.

		// Crear las variables necesarias
		int num, suma = 1;

		// Objeto Scanner, pedir número
		Scanner sc = new Scanner(System.in);
		System.out.print("Especifique el número para hacer el factorial: ");
		num = sc.nextInt();
		sc.close();
		
		if (num < 0) // Comprobar que el número sea positivo
			System.out.println("Error: El número no puede ser negativo");
		else {
			for (int i = 2; i <= num; i++) // Bucle para hacer el factorial
				suma = suma * i;
			System.out.println("El factorial de " + num + " es igual a: " + suma);
		}
		
	}
}
