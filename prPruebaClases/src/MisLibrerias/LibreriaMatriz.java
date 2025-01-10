package MisLibrerias;

import java.util.Random;

public class LibreriaMatriz {

	public static String toString(int[][] matriz) {
		int longitudTab = LibreriaVarios.calcularLongitud(mayor(matriz)) + 2; 
		String cadena = "";
		
		for(int[] i: matriz) {
			for (int k: i) {
				cadena += k + LibreriaVarios.tabular(k, longitudTab);
			}
			cadena += "\n";
		}
		
		return cadena;
	}
	
	public static int mayor(int[][] matriz) {
		int mayor = Integer.MIN_VALUE;
		
		for (int[]i: matriz)
			for (int k: i)
				if (k > mayor) mayor = k;
		
		return mayor;
	}
	
/*	public static String toString(String[][] matriz) {
		String cadena = "";
		for(int i = 0; i < matriz.length; i++) {
			for (int k = 0; k < matriz[i].length; k++) {
				cadena += matriz[i][k] + "\t";
			}
			cadena += "\n";
		}
		return cadena;
	}
*/
	public static void generarAleatorio(int[][] matriz, int ini, int fin) {
		Random rdn = new Random();
		
		for(int i = 0; i < matriz.length; i++)
			for (int k = 0; k < matriz[i].length; k++)
				matriz[i][k] = rdn.nextInt(ini, fin);
	}
	
	public static void generarAleatorio(int[][] matriz) {
		generarAleatorio(matriz, 0, 100);
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
		int posMax = -1;
		
		for (int i = 0; i < vector.length; i++)
			if (vector[i] > max) {
				posMax = i;
				max = vector[i];
			}
		
		return posMax;
	}
	
	public static int[][] transponer(int[][] matriz) {
		int[][] matrizFinal = new int[matriz[filaMasGrande(matriz)].length][matriz.length];
		
		for (int i = 0; i < matriz.length; i++)
			for (int k = 0; k < matriz[i].length; k++)
				matrizFinal[k][i] = matriz[i][k];
		
		return matrizFinal;
	}
	
	public static void enumerar(int[][] matriz, int inicio) {
		for (int i = 0; i < matriz.length; i++)
			for (int k = 0; k < matriz[i].length; k++)
				matriz[i][k] = inicio++;
	}
	
	public static void enumerar(int[][] matriz) {
		enumerar(matriz, 1);
	}
	
	public static void desordenar(int[][] matriz, int grado) {
		Random rdn = new Random();
		int posIMax = matriz.length;
		int pos1I, pos1K, pos2I, pos2K, aux;
		
		for (int i = 0; i < grado; i++) {
			pos1I = rdn.nextInt(0, posIMax);
			pos1K = rdn.nextInt(0, matriz[pos1I].length);
			pos2I = rdn.nextInt(0, posIMax);
			pos2K = rdn.nextInt(0, matriz[pos2I].length);
			
			if (pos1I != pos2I && pos1K != pos2K) {
				aux = matriz[pos1I][pos1K];
				matriz[pos1I][pos1K] = matriz[pos2I][pos2K];
				matriz[pos2I][pos2K] = aux;
			}
		}
	}
	
	public static int[] buscarNum(int[][] matriz, int num) {
		boolean terminar = false;
		int[] pos = new int[2];
		
		do {
			pos[1] = 0;
			do {
				if (matriz[pos[0]][pos[1]] == num) terminar = true;
				pos[1]++;
			} while (pos[1] < matriz[pos[0]].length && !terminar);
			pos[0]++;
		} while (pos[0] < matriz.length && !terminar);
		pos[0]--;
		pos[1]--;
		
		return pos;
	}
	
	/**
	 * Método para desordenar el array, cambia de posiciones dos números aleatoriamente 100 veces.
	 */
	public static void desordenar(int[][] matriz) {
		desordenar(matriz, 100);
	}
	
	
}
