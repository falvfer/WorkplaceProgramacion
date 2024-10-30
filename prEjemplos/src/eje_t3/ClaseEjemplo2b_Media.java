package eje_t3;

import java.util.Scanner;

public class ClaseEjemplo2b_Media {
	public static void main(String[] args) {
		// Calcular media aritmética de los números especificados

		// Crear las variables necesarias
		int num=1, suma = 0, cont = 0;

		try (Scanner sc = new Scanner(System.in)) { // Crear el objeto Scanner

			System.out.print("Di un número: "); // Pedir un número
			num = sc.nextInt(); // Leer el número

			for (; num > 0; cont++) {

				suma = suma + num; // Sumar el número a la media

				System.out.print("Di un número: "); // Pedir un número
				num = sc.nextInt(); // Leer el número
			}

			sc.close(); // Cerrar el objeto Scanner
		}
		
		// Imprimir los números ordenados por pantalla
		System.out.println("La media aritmética es: " + (double) suma / cont); // Calcular la media
		
	}
}
