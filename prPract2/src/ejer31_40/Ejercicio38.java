package ejer31_40;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio38 {

	public static void main(String[] args) {
		// Realizar un algoritmo con un menú de 4 opciones. La selección de cada opción
		// se realizará usando una variable de tipo carácter. Cada una de las opciones
		// realizará las siguientes tareas:
		// 		F: Calculará el factorial.
		// 		R: Calculará la raíz cuadrada de un número si es positivo y si es negativo,
		// 			dará un mensaje de error.
		// 		C: Calculará el cuadrado de un número.
		// 		T: Finalizará el algoritmo.

		char opcion = ' ';
		int num, resultado = 1;
		Scanner sc = new Scanner(System.in);

		do {
			try {
				System.out.println("Elige lo que quieras hacer: ");
				System.out.println("\tF. Calcular el factorial.");
				System.out.println("\tR. Calcular la raíz cuadrada.");
				System.out.println("\tC. Calcular el cuadrado.");
				System.out.println("\tT. Finalizar el algoritmo.");
				opcion = sc.next().charAt(0);

				// Opcion Factorial _________________________________________________________________
				if (Character.toUpperCase(opcion) == 'F') {
					System.out.print("\nEspecifique el número (positivo): ");
					num = sc.nextInt();
					if (num < 1)
						throw new Exception("Error: Número no válido para calcular un factorial.");
					else {
						for (int i = 2; i <= num; i++)
							resultado = resultado * i;
						System.out.println("\nEl resultado es: " + resultado);
					}

					// Opcion Raiz cuadrada _________________________________________________________
				} else if (Character.toUpperCase(opcion) == 'R') {
					System.out.print("\nEspecifique el número: ");
					num = sc.nextInt();
					if (num < 0)
						throw new Exception("Error: Raiz no válida.");
					else
						System.out.println("La raiz cuadrada de " + num + " es igual a: " + Math.sqrt(num));

					// Opcion Cuadrado ______________________________________________________________
				} else if (Character.toUpperCase(opcion) == 'C') {
					System.out.print("\nEspecifique el número: ");
					num = sc.nextInt();
					System.out.println(num + " al cuadrado es igual a: " + Math.pow(num, 2));
					
					// Opción no válida ________________________________________
				} else if (Character.toUpperCase(opcion) != 'T') { 
					System.out.println("Error, opción no válida");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Error: Formato incorrecto.");
				sc.nextLine();
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
			System.out.println();
			
			// FIN BUCLE _________________________________
		} while (Character.toUpperCase(opcion) != 'T');

		sc.close();
	}
}
