package ejer1_10;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		// Realizar un algoritmo que permita saber si un número es mayor, menor o igual a cero.

		// Crear objeto Scanner y variables
		Scanner sc = new Scanner(System.in);
		byte num = 0;

		// Preguntar por el número
		System.out.print("Especifique el número: ");
		num = sc.nextByte();

		// Cerrar el objeto Scanner
		sc.close();

		// Comprobación lógica
		if (num > 0)
			System.out.println("El número es mayor que 0"); // num > 0
		else if (num < 0)
			System.out.println("El número es menor que 0"); // num < 0
		else
			System.out.println("El número es igual a 0"); // num == 0

		// Forma alternativa
		System.out.println("El número es " + (num > 0 ? "mayor que 0" : num < 0 ? "menor que 0" : "igual a 0"));
	}

}
