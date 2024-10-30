package ejer1_10;

import java.util.InputMismatchException;
/**
 * Diseñar un programa para determinar si un número entero es múltiplo de 3, 4 o 5.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;
		boolean divisible = false;
		
		try {
			System.out.print("Especifica un número: ");
			num = sc.nextInt();
			
			for (int i = 3; i <= 5; i++) {
				if (num%i==0) {
					System.out.println("El número es divisible entre "+i);
					divisible = true;
				}
			}
			
			if (!divisible)
				System.out.println("El número no es divisible entre 3, 4 ni 5");
		} catch (InputMismatchException e) {
			System.out.println("Error: Formato del número incorrecto.");
		}
		
		sc.close();
	}
}
