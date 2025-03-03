package pract1_Arrays;

import java.util.Arrays;
import java.util.Scanner;
import librerias.LibreriaMatriz;

public class Ejer1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Especifica el horizontal y el vertical del marco (ej. \"5x2\"): ");
		String[] dimensiones = sc.nextLine().split("x");
		int[][] marco = new int[Integer.parseInt(dimensiones[1])][Integer.parseInt(dimensiones[0])];
		
		Arrays.fill(marco[0], 1);
		Arrays.fill(marco[marco.length-1], 1);
		
		for (int i = 1; i < marco.length-1; i++) {
			Arrays.fill(marco[i], 2);
			marco[i][0] = 1;
			marco[i][marco[i].length-1] = 1;
		}
		
		System.out.println(LibreriaMatriz.toString(marco));
		
		sc.close();
	}
}
