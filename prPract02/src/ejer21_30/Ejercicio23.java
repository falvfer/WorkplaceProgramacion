package ejer21_30;

import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		// Hacer un algoritmo que nos sume los números naturales, comprendidos entre dos
		// números introducidos por teclado, debéis tener en cuenta si el primero de los
		// números no es más pequeño que el segundo.

		// Crear las variables necesarias
		int num1, num2, suma = 0;

		// Objeto Scanner, pedir números
		Scanner sc = new Scanner(System.in);
		System.out.print("Especifique el primer número: ");
		num1 = sc.nextInt();
		System.out.print("Especifique el segundo número: ");
		num2 = sc.nextInt();
		sc.close();

		if (num1 > num2) { // Comprobar que num1 sea menor a num2, si no darles la vuelta
			suma = num1;
			num1 = num2;
			num2 = suma;
			suma = 0;
		}
		
		for (int cont = num1; cont <= num2; cont++) // Bucle para sumar los números
			suma += cont;
		
		System.out.println("La suma desde " + num1 + " hasta " + num2 + " es igual a: " + suma);		

	}
}
