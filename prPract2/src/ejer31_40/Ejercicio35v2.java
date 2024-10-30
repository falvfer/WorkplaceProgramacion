package ejer31_40;

import java.util.Scanner;

public class Ejercicio35v2 {

	public static void main(String[] args) {
		// Hacer un algoritmo que calcule el valor de un número combinatorio a partir de
		// dos valores, a y b, que se introducen por teclado.

		int a = 0, b = 0, ab;

		Scanner sc = new Scanner(System.in);
		
		// Pedir los números al usuario y controlar los errores
		do {
			System.out.print("Especifique el primer valor (positivo): ");
			a = sc.nextInt();
		} while (a<1);
		do {
			System.out.print("Especifique el segundo valor (positivo): ");
			b = sc.nextInt();
		} while (b<1);

		sc.close();
		
		if (b>a) { // Cambiar el orden en caso de que "a" sea menor a "b"
			ab = b;
			b = a;
			a = ab;
		}
		
		System.out.println("El resultado es: " + ((double) factorial(a) / (factorial(b) * factorial(a - b))));
		
	} // FIN MAIN
	
	/**
	 * <h1>Método que calcula el factorial de un número.</h1>
	 * <p>El factorial de un número se calcula multiplicando
	 * el número por todos los inferiores a el hasta el número 1.</p>
	 * <p>No existe el factorial de números negativos</p>
	 * 
	 * <dl>
	 *     <dt>Ejemplos:</dt>
	 *       <dd>4! = 4x3x2x1</dd>
	 * 	     <dd>0! = 1 (Caso especial)</dd>
	 * </dl>
	 * 
	 * @param num --> El número entero con el cual se calculará el factorial
	 */
	
	public static long factorial(int num) {
		
		long fact = 1;
		
		for (int i = 2; i <= num; i++)
			fact = fact * i;
		
		return fact;
	} // FIN FACTORIAL
	
} // FIN DE CLASE
