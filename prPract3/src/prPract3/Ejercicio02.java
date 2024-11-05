package prPract3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase para testear el método que calcula el factorial de un número
 * 
 * @author Francisco Jesús Álvarez Fernández
 */
public class Ejercicio02 {

	public static void main(String[] args) {
		
		int a, b;
		float comb;
		
		try (Scanner sc = new Scanner(System.in)) {
			
			System.out.print("Introduzca el valor \"a\": ");
			a = sc.nextInt();
			System.out.print("Introduzca el valor \"b\": ");
			b = sc.nextInt();
			
			comb = MiLibreria.combinatorio(a, b);
			
			if (comb == -1)
				throw new ArithmeticException("Error: Los números especificados tienen que ser positivos.");
			else if (comb < 0)
				throw new ArithmeticException("Error: Uno de los números es demasiado grande, prueba con números más pequeños");
			else
				System.out.println("El combinatorio de "+a+" y "+b+" es igual a: "+comb);
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Formato de número no válido.");
			
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}

	}

}
