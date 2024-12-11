package ejer01_09;

import java.util.Random;

public class Ejercicio7 {

	/**
	 * Crear e imprimir una lista unidimensional de 50 elementos con números
	 * aleatorios entre 1 y 100 de tal forma que no se repita ninguno.
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		// Objeto Random
		Random rdn = new Random();

		// Definir un array de tipo entero
		int[] numeros = new int[50];
		int numero;
		
		
		System.out.println("Cantidad de números: " + numeros.length);
		
		// Generar los números aleatoriamente
		System.out.println("Números: ");
		for (int i = 0; i<numeros.length; i++) {
			do {
				numero = rdn.nextInt(1, 101);
			} while (existe(numeros, i, numero));
			
			numeros[i] = numero;	
			System.out.print(numeros[i] + " ");
			if ((i+1)%5 == 0) System.out.println(); // Salto de linea cada 5 números
		}
		
	}
	
	private static boolean existe(int[] array, int tope, int numero) {
		boolean existe = false;
		int cont = 0;
		
		while (!existe && cont < tope) { // Comprobar si es igual a otro, si lo es, generar otro.
			if (numero == array[cont])
				existe = true;
			cont++;
		}
		
		return existe;
	}
	
}
