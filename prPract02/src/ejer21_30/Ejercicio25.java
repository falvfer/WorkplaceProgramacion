package ejer21_30;

import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
		// Programa que obtenga el cociente y el resto de dos números enteros positivos
		// mediante restas y sumas, no podéis utilizar las operaciones de división (/) y
		// de resto (%).

		// Crear las variables necesarias
		int dividendo, divisor, cociente = 0, resto;

		// Objeto Scanner, pedir números
		Scanner sc = new Scanner(System.in);
		System.out.print("Especifique el primer número: ");
		dividendo = sc.nextInt();
		System.out.print("Especifique el segundo número: ");
		divisor = sc.nextInt();
		sc.close();

		if (dividendo <= 0 || divisor <= 0) // Comprobar que ambos números sean positivos
			System.out.println("Ambos números tienen que ser positivos");
		else {
			resto = dividendo;
			while (resto >= divisor) { // Bucle para hacer la división
				resto = resto - divisor;
				cociente++;
			}
			System.out.println("Cociente: " + cociente + "\nResto: " + resto);
		}

	}
}
