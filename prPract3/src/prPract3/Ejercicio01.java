package prPract3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase para testear el método que calcula el factorial de un número
 * 
 * @author Francisco Jesús Álvarez Fernández
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		
		int num;
		long fact;
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.print("Introduzca un valor: ");
			num = sc.nextInt();
			fact = MiLibreria.factorial(num);
			
			if (fact == -1)
				throw new ArithmeticException("Error: El factorial de un número negativo no existe");
			else
				System.out.println("El factorial de "+num+" es igual a: "+fact);
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Formato de número no válido.");
			
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

	}

}
