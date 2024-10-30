package ejer1_10;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calcular la última cifra del cuadrado de un número y el número de cifras.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio04 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean terminar = false;
		char resp;
		long num, cuadrado;
		byte cont = 0, ultNum;

		do {
			try {
				System.out.print("Especifique el número: ");
				num = sc.nextLong();

				cuadrado = (long) Math.pow(num, 2);

				System.out.println(num + "^2 = " + cuadrado);

				if (cuadrado != 0) {
					ultNum = (byte) (cuadrado % 10);
					while (cuadrado != 0) {
						cuadrado /= 10;
						cont++;
					}
					System.out.println("En total tiene " + cont + " cifras y el último número es " + ultNum);
					cont = 0;
				} else {
					System.out.println("El número 0 tiene 1 cifra y el último número es él mismo.");
				}

				System.out.print("\n¿Quiéres probar con otro número? (S/N): ");
				sc.nextLine();
				resp = Character.toUpperCase(sc.nextLine().charAt(0));

				if (resp != 'S')
					terminar = !terminar;
			} catch (InputMismatchException e) {
				System.out.println("Error: Formato de número no valido.");
				sc.nextLine();
			}
		} while (!terminar);

		sc.close();

	}
}
