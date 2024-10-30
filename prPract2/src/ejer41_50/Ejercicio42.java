package ejer41_50;

import java.util.Scanner;

public class Ejercicio42 {

	public static void main(String[] args) {
		// Hacer un algoritmo para calcular si un número es primo o no. En matemáticas,
		// un número primo es un número natural mayor que 1 que tiene únicamente dos
		// divisores positivos distintos: él mismo y el 1.

		int num, rNum;
		boolean primo = true;
		Scanner sc = new Scanner(System.in);

		System.out.print("Especifica un número para ver si es primo o no: ");
		num = sc.nextInt();

		while (num != 0) { // Bucle, si pone 0 el usuario termina el programa
			rNum = (int) Math.sqrt(Math.abs(num)); // Guardar la raiz cuadrada de susodicho número

			for (int i = 2; i <= rNum && primo; i++) { // Comprobar si el número es divisible por todos los números desde 2 hasta la raiz cuadrada del número (números mayores dan igual)
				if ((num % i) == 0) {	// Comprobar si es divisible
					primo = false; // Booleano para salir del bucle y dejar de comprobar casos
					System.out.println("No es un número primo, el primer número divisible con resto cero es: " + i);
				}
			}
			if (primo == true) // Mostrar solo si es primo
				System.out.println(num + " sí es un número primo.");

			primo = true; // Reiniciar el valor del booleano primo
			System.out.print("\nEspecifica un número para ver si es primo o no (Pon 0 para terminar): ");
			num = sc.nextInt();
		}
		sc.close();
		
	}
}
