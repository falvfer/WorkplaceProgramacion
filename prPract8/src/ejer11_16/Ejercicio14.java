package ejer11_16;

import MisLibrerias.LibreriaMatriz;
import MisLibrerias.LibreriaVector;

public class Ejercicio14 {

	/*
	 * Diseñar un algoritmo que lee una matriz de tamaño 6 x 8 de números enteros
	 * (fila a fila), la almacena en un array bidimensional llamado A.
	 * A continuación almacena los resultados de las sumas de los elementos
	 * de cada fila en un vector llamado B, y las sumas de los elementos de
	 * cada columna en un vector llamado C. Finalmente imprime los tres arrays.
	 */
	
	public static void main(String[] args) {
		
		int[][] A = new int[6][8];
		int[] B, C;
		
		LibreriaMatriz.generarAleatorio(A);
		
		B = LibreriaMatriz.sumarFilas(A);
		C = LibreriaMatriz.sumarColumnas(A);
		
		System.out.println("Matriz A:\n" + LibreriaMatriz.toString(A));
		System.out.println("Vector B:\n" + LibreriaVector.toString(B));
		System.out.println("\nVector C:\n" + LibreriaVector.toString(C));
		
		LibreriaVector.ordenarBurbuja(C);
		System.out.println(LibreriaVector.toString(C));
		
	}
	
}
