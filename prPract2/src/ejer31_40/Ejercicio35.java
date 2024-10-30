package ejer31_40;

import java.util.Scanner;

public class Ejercicio35 {

	public static void main(String[] args) {
		// Hacer un algoritmo que calcule el valor de un número combinatorio a partir de
		// dos valores, a y b, que se introducen por teclado.

		int a = 0, b = 0, aF = 1, bF = 1, abF = 1, ab;

		Scanner sc = new Scanner(System.in);
		
		// Pedir los números al usuario y controlar los errores
		do {
			do {
				System.out.print("Especifique el primer valor (positivo, tiene que ser mayor que el segundo): ");
				a = sc.nextInt();
			} while (a<1);
			do {
				System.out.print("Especifique el segundo valor (positivo, tiene que ser menor que el primero): ");
				b = sc.nextInt();
			} while (b<1);
			System.out.println();
		} while (a<b);
		
		sc.close();
		
		// Calculo de los exponenciales
		ab = a - b;
		for (int i = 2; i <= a; i++)
			aF = aF * i;
		for (int i = 2; i <= b; i++)
			bF = bF * i;
		for (int i = 2; i <= ab; i++)
			abF = abF * i;
		
		System.out.println("El resultado es: "+((double)aF/(bF*abF)));
		
	}
}
