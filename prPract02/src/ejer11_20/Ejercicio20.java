package ejer11_20;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		// Dearrolla un programa que resuelva la siguiente serie matemática:
		// s(n) = 1 + 1/2 + 1/3 + ... + 1/n

		// Variables
		int n;
		double total = 1;

		// Scanner y preguntar por N
		System.out.print("Especifique el número entero para N: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		sc.close();

		// Bucle FOR para calcular la serie
		for (int cont = 2; cont <= n; cont++)
			total += 1.0 / cont;

		// Mostrar resultado
		System.out.println("El resultado final de la serie es: " + total);

	}
}