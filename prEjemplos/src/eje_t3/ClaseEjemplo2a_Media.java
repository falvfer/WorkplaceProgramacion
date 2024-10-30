package eje_t3;

import java.util.Scanner;

public class ClaseEjemplo2a_Media {

	public static void main(String[] args) {
		// Calcular media aritmética de los números especificados

		// Crear las variables necesarias
		int num, suma = 0, cont = 0;

		Scanner sc = new Scanner(System.in); // Crear el objeto Scanner
		
		System.out.print("Di un número: "); // Pedir un número
		num = sc.nextInt(); // Leer el número

		while (num > 0) { // Comprobar que no sea menor a 0
			suma = suma + num; // Sumar el número a la media
			cont++; // Añadir 1 al contador
			System.out.print("Di un número (0 o negativo para terminar): "); // Volver a pedir el número
			num = sc.nextInt(); // Leer el número
		} // Fin while
		sc.close(); // Cerrar el objeto Scanner

		// Imprimir los números ordenados por pantalla
		System.out.println("La media aritmética es: " + (double) suma / cont); // Calcular la media
	}
}