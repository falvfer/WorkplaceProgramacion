package ejer11_20;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		// Diseñar un algoritmo que lee un número y un valor entre 1 y 3, y en función de este último calcula: 
		//		1.- El cuadrado del número 
		//		2.- El cubo del número 
		//		3.- La raíz cuadrada del número 

		// Crear variables
		double numero = 0;
		byte operacion = 0;
		char resp;

		// Crear el objeto scanner
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);

		do {
			try {
				// Preguntar por pantalla los números
				System.out.print("Especifique el número: ");
				numero = sc.nextDouble();
				System.out.println("Especifique la operación escribiendo uno de estos números: ");
				System.out.println("\t1.- El cuadrado del número");
				System.out.println("\t2.- El cubo del número");
				System.out.println("\t3.- La raíz cuadrada del número");
				operacion = sc.nextByte();

				// Comprobación de cuál operación es y error en caso de que no sea válida
				switch (operacion) {
					case 1 -> System.out.println("El cuadrado de " + numero + " es igual a: " + Math.pow(numero, 2));
					case 2 -> System.out.println("El cubo de " + numero + " es igual a: " + Math.pow(numero, 3));
					case 3 -> {
						if (Double.isNaN(Math.sqrt(numero)))
							throw new ArithmeticException("No se pueden hacer raizes de números negativos ni de 0.");
						System.out.println("La raiz cuadrada de " + numero + " es igual a: " + Math.sqrt(numero));
					}
					default -> System.out.println("Error: Operación no válida.");
				}
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Error: Lectura de datos incorrecta.");
			}
			sc.nextLine();
			System.out.print("\nQuieres hacer otra operación? (S/N): ");
			resp = sc.nextLine().charAt(0);

		} while (Character.toUpperCase(resp) == 'S');

		// Cerrar el objeto Scanner
		sc.close();
	}
}
