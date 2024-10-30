package ejer31_40;

import java.util.Scanner;

public class Ejercicio33 {

	public static void main(String[] args) {
		// Hacer un algoritmo para calcular de forma automática las n primeras max_exps
		// de un número A. Se introducen por teclado los números n (exponente) y A
		// (base).

		// Crear las variables necesarias
		int num, max_exp = -1;

		// Objeto Scanner, pedir cantidad de números
		Scanner sc = new Scanner(System.in);

		while (max_exp < 0) {
			System.out.print("Especifique el exponencial maximo a mostrar (0 o positivo): ");
			max_exp = sc.nextInt();
		}

		System.out.print("Especifique el número base: ");
		num = sc.nextInt();

		sc.close();

		for (int cont = 0, potencia = 1; cont <= max_exp; cont++) {
			System.out.println(num + "^" + cont + " = " + potencia);
			potencia*=num;
		}

	}
}
