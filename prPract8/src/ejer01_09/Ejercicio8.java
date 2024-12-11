package ejer01_09;

import java.util.Random;

public class Ejercicio8 {

	/*
	 * Hacer un programa que:
	 *  - Cree y cargue un array unidimensional de 12 elementos de tipo entero.
	 *  - Recorra ese array metiendo en un segundo array todos aquellos elementos
	 *    que sean pares y mayores que 25.
	 *  - Muestre en pantalla el contenido de los dos arrays unidimensionales.
	 */
	
	public static void main(String[] args) {
		
		// Objeto Random
		Random rdn = new Random();

		// Definir un array de tipo entero
		int[] array1 = new int[12];
		byte cont = 0;
		
		// Crear valores para array1
		System.out.print("Valores del array1: ");
		for (int i = 0; i<array1.length; i++) {
			array1[i] = rdn.nextInt(0,101);
			System.out.print(array1[i] + " ");
			if (array1[i]%2 == 0 && array1[i] > 25)
				cont++;
			}
		
		// Crear segundo array
		int[] array2 = new int[cont];
		cont = 0;
		
		// Mostrar longitud del segundo array
		System.out.println("\nLongitud del array2: " + array2.length);
		
		// Añadir los valores al segundo array
		System.out.print("Valores del array2: ");
		for (int i = 0; i<array1.length; i++) {
			if (array1[i]%2 == 0 && array1[i] > 25) {
				array2[cont] = array1[i];
				System.out.print(array2[cont] + " ");
				cont++;
			}
		}
		

	}

}
