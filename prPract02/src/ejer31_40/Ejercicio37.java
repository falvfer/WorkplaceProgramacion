package ejer31_40;

import java.util.Scanner;

public class Ejercicio37 {
	
	public static void main(String[] args) {
		// Realizar un algoritmo que calcule la media aritmética de una lista de números
		// que se introducen por teclado. El proceso finalizará con la introducción del
		// número 0 y se usará en la media el valor absoluto de los números negativos,
		// si ya lo hicisteis en el ejercicio 22, no es necesario que lo volváis a hacer.		
		
		// Crear las variables necesarias
		int num, suma = 0, cont = 0;

		// Objeto Scanner, pedir número
		System.out.print("Di un número: ");
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();

		while (num != 0) { // Comprobar que sea distinto a 0
			suma = suma + Math.abs(num); // Sumar el número a la media
			cont++;
			// Pedir otro número
			System.out.print("Di otro número (0 para terminar): ");
			num = sc.nextInt();
		}
		
		sc.close(); // Cerrar el objeto Scanner

		// Imprimir el resultado por pantalla
		if(cont!=0)
			System.out.println("La media aritmética es: " + (double) suma / cont); // Calcular la media
		else
			System.out.println("Error: No introduzcas 0 como primer número.");
		
	}
}
