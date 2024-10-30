package ejer11_20;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio12 {

	// NOTA: Para leer una vocal es así: "sc.nextLine().charAt(0)"
	
	public static void main(String[] args) {
		// Diseñar un algoritmo para simular una calculadora simple. Para ello deberá tener las siguientes características: 
		//		Sólo efectuará operaciones con dos operandos. 
		//		Operaciones permitidas: (+, -, *, /). 
		//		Se trabajará con operandos enteros. 
		// 		Pedirá en primer lugar el operador, y a continuación los dos operandos. Si el
		// 			operador no se corresponde con alguno de los indicados se emitirá un mensaje
		// 			de error:

		// Crear variables
		int num1 = 0, num2 = 0;
		char operacion = 'a';
		Scanner sc = new Scanner(System.in); // Scanner fuera del try ya que no se puede volver a abrir (Da error NoSuchElementException)

		while (true) { // Bucle
			try { // Try-catch para errores
				System.out.print("Especifique el operando [+,-,*,/] ('T' para terminar): ");
				operacion = sc.nextLine().charAt(0);
				if (Character.toUpperCase(operacion) == 'T')
					break; // Si es '0' entonces hay que salir del bucle
				System.out.print("Especifique el primer número: ");
				num1 = sc.nextInt();
				System.out.print("Especifique el segundo número: ");
				num2 = sc.nextInt();
				sc.nextLine(); // Limpiar buffer

				switch (operacion) { // Comprobar cual operando se ha elegido
					case '+' -> System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
					case '-' -> System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
					case '*' -> System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
					case '/' -> {
						if (num2 == 0) 
							throw new ArithmeticException("Error: No se puede dividir entre 0."); // Controlar el caso de que se divida entre 0
						else
							System.out.println(num1 + " / " + num2 + " = " + ((float)num1 / num2));
					}
					default -> System.out.println("Error: Operación no válida.");
				}

			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			} catch (InputMismatchException e) {
				System.out.println("Error: Lectura de datos incorrecta.");
				sc.nextLine();
			} // FIN TRY-CATCH
			System.out.println();
		} // FIN WHILE
		sc.close();
	}
}
