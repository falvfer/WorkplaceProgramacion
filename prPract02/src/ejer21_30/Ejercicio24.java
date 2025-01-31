package ejer21_30;

import java.util.Scanner;

public class Ejercicio24 {

	public static void main(String[] args) {
		// Programa que calcule el producto de dos números enteros positivos mediante
		// sumas sucesivas, no podéis utilizar la operación de multiplicación.

		// Crear las variables necesarias
		int num1, num2, suma = 0;

		// Objeto Scanner, pedir números
		Scanner sc = new Scanner(System.in);
		System.out.print("Especifique el primer número: ");
		num1 = sc.nextInt();
		System.out.print("Especifique el segundo número: ");
		num2 = sc.nextInt();
		sc.close();

		if (num1 <= 0 || num2 <= 0) // Comprobar que ambos números sean positivos
			System.out.println("Ambos números tienen que ser positivos");
		else {
			for (int cont = 1; cont <= num2; cont++) // Bucle para sumar los números y hacer la multiplicación
				suma = suma + num1;
			System.out.println(num1 + " x " + num2 + " = " + suma);
		}

	}
}
