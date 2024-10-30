package ejer1_10;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ejercicio08 {

	public static void main(String[] args) {
		// Realizar un algoritmo que lea dos valores desde teclado y diga si cualquiera
		// de ellos divide de forma entera al otro.

		// Crear variables
		int num1 = 0, num2 = 0;

		try (Scanner sc = new Scanner(System.in)) { //Evitar errores

			// Pedir número por pantalla
			System.out.print("Especifique el primer número: ");
			num1 = sc.nextInt();
			System.out.print("Especifique el segundo número: ");
			num2 = sc.nextInt();

			// Comprobaciones:
			if ((num1 % num2) == 0) // Comprobar cual es divisible entre cual
				System.out.println(num1 + " es divisible entre " + num2);
			else if ((num2 % num1) == 0)
				System.out.println(num2 + " es divisible entre " + num1);
			else
				System.out.println("Ningún número es divisible entre el otro de forma entera.");
			
		} catch (ArithmeticException e) {
			System.out.println("Error: No se puede dividir entre cero.");
		} catch (InputMismatchException e) {
			System.out.println("Error de lectura de datos");
		}
	}
}