package ejer21_30;

import java.util.Scanner;

public class Ejercicio28 {

	public static void main(String[] args) {
		// Hacer un algoritmo que imprima, sume y cuente los números pares que hay entre
		// dos números determinados, debéis tener en cuenta si el primero de los números
		// no es más pequeño que el segundo.
		
		// Crear las variables necesarias
		int num1, num2, suma = 0, cont = 0;

		// Objeto Scanner, pedir número
		Scanner sc = new Scanner(System.in);
		System.out.print("Especifique el primer número: ");
		num1 = sc.nextInt();
		System.out.print("Especifique el segundo número: ");
		num2 = sc.nextInt();
		sc.close();
		
		if (num1==num2) { // Comprobar si son iguales (casos especiales)
			if (num1%2==0) // Comprobar si son pares
				System.out.println("\nEl unico número par entre ambos (y la suma) es "+num1);
			else
				System.out.println("\n"+num1+" no es un número par, así que no hay números pares.");
		} else {
			if (num1 > num2) { // Comprobar que el número 1 sea menor que en número 2, si no invertirlos
				suma = num1;
				num1 = num2;
				num2 = suma;
				suma = 0;
			}
			System.out.print("\nLos números pares entre " + num1 + " y " + num2 + " (ambos incluidos) son: ");
			for (int i = (num1%2 == 0) ? num1 : num1 + 1; i <= num2; i += 2, cont++) { // Bucle para hacer todo
				System.out.print(i + " ");
				suma = suma + i;
			}
			System.out.println("\nLa suma de los números pares entre " + num1 + " y " + num2 + " es igual a: " + suma);
			System.out.println("Hay " + cont + " números pares entre " + num1 + " y " + num2);
		}
		
	}
}
