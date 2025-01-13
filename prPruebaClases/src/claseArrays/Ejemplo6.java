package claseArrays;

import MisLibrerias.LibMatriz;

public class Ejemplo6 {

	public static void main(String[] args) {
		
		int[][] m1 = new int[7][10];
		
		LibMatriz.generarAleatorio(m1, 1, 1000);
		
		System.out.println(LibMatriz.toString(m1));
		
		

/*		Recorrer el array clase3 mostrando los datos en mayúscula
		for (int i: clase3) {
			System.out.println(i.toString().toUpperCase);
		}
*/
		
	}
}
