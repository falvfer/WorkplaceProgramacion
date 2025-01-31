package ejer1_10;

import java.util.Scanner;

public class Ejercicio07 {

	public static void main(String[] args) {
		// Hacer un algoritmo para ver si un número introducido por teclado es par o impar.

		// Crear objeto Scanner y variable
		Scanner sc = new Scanner(System.in);
		int num = 0;

		// Pedir número por pantalla
		System.out.print("Especifique el número: ");
		num = sc.nextShort();

		// Cerrar el objeto Scanner
		sc.close();

		// Comprobar que el resto de ser dividido por 2 de igual a 0 (par) o no (impar)
		if ((num % 2) == 0)
			System.out.println("El número es par");
		else
			System.out.println("El número es impar");
	}
}
