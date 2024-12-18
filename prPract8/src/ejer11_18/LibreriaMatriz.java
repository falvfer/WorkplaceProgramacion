package ejer11_18;

import java.util.Random;

public class LibreriaMatriz {

	public static String toString(int[][] matriz) {
		String cadena = "";
		for(int i = 0; i < matriz.length; i++) {
			for (int k = 0; k < matriz[i].length; k++) {
				cadena += matriz[i][k] + "\t";
			}
			cadena += "\n";
		}
		return cadena;
	}
	
	public static int[][] generarAleatorio(int[][] matriz, int ini, int fin) {
		Random rdn = new Random();
		
		for(int i = 0; i < matriz.length; i++)
			for (int k = 0; k < matriz[i].length; k++)
				matriz[i][k] = rdn.nextInt(ini, fin);
		
		return matriz;
	}
	
	public static int[][] generarAleatorio(int[][] matriz) {
		return generarAleatorio(matriz, 0, 100);
	}
	
	public static int[] sumarFilas(int[][] matriz) {
		int[] totalSumas = new int[matriz.length];
		
		for(int i = 0; i < matriz.length; i++)
			for (int k = 0; k < matriz[i].length; k++)
				totalSumas[i] += matriz[i][k];
				
		return totalSumas;
	}
	
	public static int[] sumarColumnas(int[][] matriz) {
		int[] totalSumas = new int[matriz[filaMasGrande(matriz)].length];
		
		for(int i = 0; i < totalSumas.length; i++)
			for (int k = 0; k < matriz.length; k++) {
				try {
					totalSumas[i] += matriz[k][i];
				} catch (Exception e) {}
			}
				
		return totalSumas;
	}
	
	private static int filaMasGrande(int[][] matriz) {
		int[] filas = new int[matriz.length];
		
		for(int i = 0; i < matriz.length; i++)
			filas[i] = matriz[i].length;
		
		return posNumMaximo(filas);
	}
	
	private static int posNumMaximo(int[] vector) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < vector.length; i++)
			if (vector[i] > max)
				max = i;
		return max;
	}
	
	
	
	
	
}
