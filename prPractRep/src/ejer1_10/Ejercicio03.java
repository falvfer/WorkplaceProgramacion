package ejer1_10;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa que determine cuantas cifras posee un número entero positivo dado
 * como entrada a nuestro programa por teclado. Repetir el proceso cuantas veces
 * se quiera.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio03 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		boolean terminar = false;
		char resp;
		long num;
		byte cont = 0;
		
		do {
			try {
				System.out.print("Especifique el número: ");
				num = Math.abs(sc.nextLong());

				if (num != 0) {
					while (num != 0) {
						num /= 10;
						cont++;
					}
					System.out.println("En total tiene " + cont + " cifras.");
					cont = 0;
				} else {
					System.out.println("El número 0 tiene 1 cifra.");
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
