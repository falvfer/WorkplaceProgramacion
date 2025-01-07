package claseArrays;

import java.util.Arrays;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		int[] vector = new int[10];
		System.out.println(Arrays.toString(vector));
		
		// Rellenar el array completamente con el valor 9
		Arrays.fill(vector, 9);
		System.out.println(Arrays.toString(vector));
		
		// Rellenar el array desde la posicion 2 a la 5 con el valor 1
		Arrays.fill(vector, 2, 6, 1); // Excluye la ultima posición, va de 0 hasta length-1
		System.out.println(Arrays.toString(vector));
		
		
		
		System.out.println();
		// Array de caracteres
		char[] vectorChar = new char[10];
		
		Arrays.fill(vectorChar, 'A');
		System.out.println(Arrays.toString(vectorChar));
		
		
		
		System.out.println();
		// Rellenar una matriz con un contador por filas
		int[][] matriz = new int[6][5];
		
		for (int i = 0; i < matriz.length; i++) {
			Arrays.fill(matriz[i], i+1);
			System.out.println(Arrays.toString(matriz[i]));
		}
		
		
		
		System.out.println();
		// Rellenar una matriz por filas con las potencias de 2 hasta 2^8
		matriz = new int[9][5];
		for (int i = 0; i < matriz.length; i++) {
			Arrays.fill(matriz[i], (int)Math.pow(2, i));
			System.out.println(Arrays.toString(matriz[i]));
		}

	}

}
