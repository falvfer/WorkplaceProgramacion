package eje_t3;

import java.util.Scanner;

public class ClaseEjemplo2c_Media {
	public static void main(String[] args) {
		// Calcular media aritmética de los números especificados

		// Crear las variables necesarias
		int num, suma = 0, cont = 0;

		Scanner sc = new Scanner(System.in); // Crear el objeto Scanner
		
		do {
			System.out.print("Di un número: "); // Pedir un número
			num = sc.nextInt(); // Leer el número
			
			suma = suma + num;
			cont++;
			
		} while (num>0);
		
		sc.close(); // Cerrar el objeto Scanner
		
		// "Arreglo" pocho
		suma = suma - num;
		cont--;

		// Imprimir los números ordenados por pantalla
		System.out.println("La media aritmética es: " + (double) suma / cont); // Calcular la media
	}
}
