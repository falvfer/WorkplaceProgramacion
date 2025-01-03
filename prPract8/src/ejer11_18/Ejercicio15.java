package ejer11_18;

public class Ejercicio15 {

	/*
	 * Hacer una función para trasponer matrices de N x M elementos, otra para leer matrices
	 * desde teclado y otra para visualizar matrices. Hacer un programa que utilizando
	 * dichas funciones nos visualice la matriz traspuesta de una introducida desde teclado.
	 */
	
	public static void main(String[] args) {
		
		int[][] matriz = new int[3][6];
		matriz[0] = new int[8];
		matriz[2] = new int[10];
		
		LibreriaMatriz.generarAleatorio(matriz);
		System.out.println(LibreriaMatriz.toString(matriz));
		
		matriz = LibreriaMatriz.transponer(matriz);
		System.out.println(LibreriaMatriz.toString(matriz));
		
		
	}
	
}
