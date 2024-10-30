package ejer21_30;

import java.util.Scanner;

public class Ejercicio30 {

	public static void main(String[] args) {
		// Hacer un algoritmo para mostrar por pantalla los números múltiplos de 3 que
		// hay entre dos números determinados, de forma alternativa.

		// Crear las variables necesarias
		int num1, num2, reserva, cont;

		// Objeto Scanner, pedir número
		Scanner sc = new Scanner(System.in);
		System.out.print("Especifique el primer número: ");
		num1 = sc.nextInt();
		System.out.print("Especifique el segundo número: ");
		num2 = sc.nextInt();
		sc.close();

		if (num1 == num2) { // Comprobar si son iguales (casos especiales)
			if (num1 % 3 == 0) // Comprobar si son multiplos de 3
				System.out.println("\nEl unico número multiplo de tres entre ambos números especificados es " + num1);
			else
				System.out.println("\n" + num1 + " no es un múltiplo de tres, así que no hay multiplos de tres.");
		} else {
			if (num1 > num2) { // Comprobar que el número 1 sea menor que el número 2, si no invertirlos
				reserva = num1;
				num1 = num2;
				num2 = reserva;
			}

			cont = num1;
			while ((cont%3)!=0) // Asegurar que empieze por un número múltiplo de 3
				cont++;
				
			System.out.print("\nLos multiplos de tres entre " + num1 + " y " + num2 + " (ambos incluidos) son: ");
			for (; cont <= num2; cont += 6) { // Bucle para hacer todo
				System.out.print(cont + " ");
			}
		}
		
	}
}
