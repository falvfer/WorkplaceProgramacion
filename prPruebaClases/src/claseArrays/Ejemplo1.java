package claseArrays;

import java.util.Arrays;

public class Ejemplo1 {

	public static void main(String[] args) {
		
		int[] array = new int[10];
		
		for (int i = 1; i <= 10; i++)
			array[i-1] = i;
		
		// Mostrar el array
		System.out.print("Array: ");
		for (int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		
		// Mostrar el array con la clase "Arrays"
		System.out.println("\nArray: " + Arrays.toString(array));
		
		
		
		System.out.println();
		// Definir una matriz
		int[][] matriz = {{1,2,3,4},{5,6,7,8}};
		
		// Mostrar la matriz por pantalla
		for (int i = 0; i < matriz.length; i++) {
			for (int k = 0; k < matriz[i].length; k++) {
				System.out.print(matriz[i][k] + " ");
			}
			System.out.println();
		}
		
		
		
		System.out.println();
		// Mostrar la matriz utilizando el método toString de Arrays
		for (int i = 0; i < matriz.length; i++)
			System.out.println(Arrays.toString(matriz[i]));

		
		
		System.out.println();
		// Mostrar una matriz con el método deepToString
		System.out.println(Arrays.deepToString(matriz));
	}
	
}
