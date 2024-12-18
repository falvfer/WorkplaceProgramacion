package ejer11_18;

public class Ejercicio13 {

	/*
	 * Define un array de números enteros de 3 filas por 6 columnas y asigna los valores
	 * según la siguiente tabla. Muestra el contenido de todos los elementos del array
	 * dispuestos en forma de tabla como se muestra en la figura.
	 */
	
	public static void main(String[] args) {
		
		int[][] matriz = new int[3][6];
		
		matriz[0][1] = 30;
		matriz[0][2] = 2;
		matriz[0][5] = 5;
		matriz[1][0] = 75;
		matriz[2][2] = -2;
		matriz[2][3] = 9;
		matriz[2][5] = 11;
		
		System.out.println(LibreriaMatriz.toString(matriz));
		
	}
	
}
