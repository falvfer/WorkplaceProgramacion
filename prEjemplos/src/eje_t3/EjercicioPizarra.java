package eje_t3;

import java.util.Scanner;

public class EjercicioPizarra {
	/**
	 * Pedir al usuario el tamaño de una tabla y mostrarle
	 * susodicha tabla de la forma que se ve en el ejemplo
	 * 1 2 3 4 5 6
	 * 2 3 4 5 6 1
	 * 3 4 5 6 1 2
	 * 4 5 6 1 2 3
	 * 5 6 1 2 3 4
	 * 6 1 2 3 4 5
	 * tamaño = 6
	 * 
	 * @author Francisco Jesus Alvarez Fernandez
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tabla;

		System.out.print("Especifique el tamaño de la tabla: ");
		tabla = sc.nextInt();
		
		sc.close();
		
		for (int fila = 1; fila <= tabla; fila++) {
			for (int celda = fila, cont = 1; cont <= tabla; cont++, celda++) {
				System.out.print(celda+" ");
				if (celda == tabla)
					celda=0;
			}
			System.out.println();
		}
		
	}

}
