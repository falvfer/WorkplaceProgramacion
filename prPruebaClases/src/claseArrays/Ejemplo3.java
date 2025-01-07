package claseArrays;

import java.util.Arrays;

public class Ejemplo3 {

	public static void main(String[] args) {
		
		char[][] matriz = new char[10][20];
		final char marco = '*', relleno = '-';
		
		// Rellenar primera y última fila con "marco"
		Arrays.fill(matriz[0], marco);
		Arrays.fill(matriz[matriz.length-1], marco);
		
		// Rellenar las demás filas
		for (int i = 1; i < matriz.length-1; i++) {
			// Rellenar usando "relleno" la zona central
			Arrays.fill(matriz[i], 1, matriz[i].length-1, relleno);
			// Cambiar el primer caracter y el último por "marco"
			matriz[i][0] = marco;
			matriz[i][matriz[i].length-1] = marco;
		}
		
		for (int i = 0; i < matriz.length; i++) {
			for (int k = 0; k < matriz[i].length; k++) {
				System.out.print(matriz[i][k] + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
	}
	
}
