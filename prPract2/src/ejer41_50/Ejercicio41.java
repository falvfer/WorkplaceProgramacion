package ejer41_50;

import java.util.Scanner;

public class Ejercicio41 {

	public static void main(String[] args) {
		// Introducir dos números inferiores a 50 y superiores a 0 por teclado. Al más
		// pequeño de ellos lo aumentamos de 5 en 5 y al más grande lo disminuimos de 2
		// en 2. Imprimir ambas series alternativamente hasta que el menor supere al
		// mayor.

		// Variables y objeto Scanner
		int num1, num2, reserva;
		Scanner sc = new Scanner(System.in);

		// Leer los dos números con control de errores
		do {
			do {
				System.out.print("Especifica el primer número (0-50): ");
				num1 = sc.nextInt();
			} while (num1 < 0 || num1 > 50);

			do {
				System.out.print("Especifica el segundo número (0-50): ");
				num2 = sc.nextInt();
			} while (num2 < 0 || num2 > 50);
		} while (num1 == num2);
		sc.close();

		// Comprobar que num1 sea menor que num2, si no darle la vuelta
		if (num1 > num2) {
			reserva = num1;
			num1 = num2;
			num2 = reserva;
		}

		// Bucle para mostrar la serie de sumas y restas
		System.out.println("\nSerie de suma de 5 y resta de 2 a los números:");
		System.out.println("    " + num1 + "  " + num2);
		do {
			num1 += 5;
			num2 -= 2;
			System.out.println("    " + num1 + "  " + num2);
		} while (num1 <= num2);

	}
}
