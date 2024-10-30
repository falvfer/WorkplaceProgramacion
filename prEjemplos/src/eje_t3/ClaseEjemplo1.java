package eje_t3;

import java.util.Scanner;

public class ClaseEjemplo1 {

	public static void main(String[] args) {

		// Ejemplo 1, comparación básica
		int num = 100;

		if (num == 100) {
			System.out.println("Enhorabuena");
			System.out.println("Has ganado");
		} else {
			System.out.println("Lo siento, has perdido");
		}

		// Ejemplo 2, mayor o menor de edad
		Scanner sc = new Scanner(System.in);
		int edad = 0;

		System.out.print("Especifique la edad: ");
		edad = sc.nextInt();

		// Versión 1 de Ejemplo 2, sin llaves
		if (edad > 18)
			System.out.println("Eres mayor de edad");
		else if (edad < 18)
			System.out.println("Eres menor de edad");
		else
			System.out.println("Acabas de cumplir 18 años");

		// Versión 1 de Ejemplo 2, con llaves
		if (edad > 18) {
			System.out.println("Eres mayor de edad");
		} else {
			if (edad < 18) {
				System.out.println("Eres menor de edad");
			} else {
				System.out.println("Acabas de cumplir 18 años");
			}
		}

		sc.close();

		// Fin del programa
		System.out.println("Fin del programa");

	}

}
