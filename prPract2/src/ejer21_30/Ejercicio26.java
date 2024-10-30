package ejer21_30;

import java.util.Scanner;

public class Ejercicio26 {

	public static void main(String[] args) {
		// Hacer un algoritmo que nos sume, los números naturales que sean pares, y
		// menores que un número introducido por teclado.

		// Crear las variables necesarias
		int num, suma = 0;

		// Objeto Scanner, pedir número
		Scanner sc = new Scanner(System.in);
		System.out.print("Especifique el número: ");
		num = sc.nextInt();
		sc.close();
		
		if (num <= 0) // Comprobar que el número sea positivo
			System.out.println("Error: El número tiene que ser mayor a 0");
		else {
			for (int i = (num%2!=0)?num-1:num-2; i >= 2; i -= 2) { // Bucle para hacer la suma
				suma = suma + i;
				System.out.print(i+", ");
			}
			System.out.println("\nLa suma de los números pares entre 1 y " + num + " es igual a: " + suma);
		}
		
	}
}
