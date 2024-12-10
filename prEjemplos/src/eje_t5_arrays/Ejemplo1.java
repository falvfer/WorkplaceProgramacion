package eje_t5_arrays;

import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		// Definir un array de 4 elementos de tipo entero
		int[] array = new int[4];
		
		// Pedir valores por teclado para los componentes del array
		try (Scanner sc = new Scanner(System.in)) {
			for (int i = 0; i<array.length; i++) {
				System.out.print("Introduzca elemento de posición " + (i+1) + ": ");
				array[i] = sc.nextInt();
			}
		}
		
		// Recorrer todo el array mientras se muestra por pantalla lo que contiene
		System.out.print("Contenido del array: ");
		for (int i = 0; i<array.length; i++)
			System.out.print(array[i] + " ");
		
		
	}
	
}
