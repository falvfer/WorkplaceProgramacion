package ejer01_09;

import java.util.Random;

public class Ejercicio9 {

	/*
	 * Hacer un programa que genere un array de 15 números enteros
	 * de forma aleatoria, y a continuación invierta internamente
	 * los números del array, no se puede utilizar un array auxiliar.
	 */
	
	public static void main(String[] args) {
		
		// Objeto Random
		Random rdn = new Random();

		// Definir un array de tipo entero
		int[] array = new int[15];
		
		// Crear valores para array1
		System.out.print("Valores del array: ");
		for (int i = 0; i<array.length; i++) {
			array[i] = rdn.nextInt(0,101);
			System.out.print(array[i] + " ");
		}
		
		// Variable int auxiliar (No array)
		int aux;
		
		// Invertir internamente
		for (int i = 0, k = array.length-1; i!=k; i++, k--) {
			aux = array[i];
			array[i] = array[k];
			array[k] = aux;
		}
		
		// Mostrar los valores
		System.out.print("\nValores del array invertido: ");
		for (int i = 0; i<array.length; i++)
			System.out.print(array[i] + " ");
		
	}
	
}
