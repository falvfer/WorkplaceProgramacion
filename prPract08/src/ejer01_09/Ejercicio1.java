package ejer01_09;

import java.util.Random;

public class Ejercicio1 {

	/**
	 * Hacer un programa que lea del teclado 10 números enteros y
	 * los almacene en un vector. Utilizando este vector, visualizar
	 * y sumar los elementos que ocupan las posiciones pares.
	 * @param args
	 */
	public static void main(String[] args) {
		// Objeto random
		Random rdn = new Random();

		// Definir un array de 4 elementos de tipo entero
		int sumaArray = 0;
		int[] array = new int[10];
		
		// Simular el pedir valores por teclado para los componentes del array
		for (int i = 0; i<array.length; i++)
			array[i] = rdn.nextInt(0,101);
		
		// Recorrer las posiciones pares el array mientras se muestra por pantalla lo que contiene
		System.out.print("Numeros en posiciones pares: ");
		for (int i = 1; i<array.length; i+=2) {
			System.out.print(array[i] + " ");
			sumaArray += array[i];
		}
		System.out.println("\nSuma de los números en posiciones pares: " + sumaArray);
	
		
	}

}
