package ejer11_20;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		// Implementar un programa que pida por teclado un número decimal e indique si
		// es un número casi-cero, que son aquellos positivos o negativos, que se acercan
		// a 0 por menos de 1 unidad, aunque curiosamente el 0 no se considera un número
		// casi cero. Ejemplos de números casi-cero son el 0,3, el -0,99 o el 0,123;
		// algunos números que no se consideran casi-ceros son: el 12,3, el 0 o el -1.
		
		// Crear variable
		double decimal = 0;

		// Crear el objeto scanner
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);

		// Preguntar por pantalla el número y leerlo
		System.out.print("Especifique el número decimal: ");
		decimal = sc.nextDouble();

		// Cerrar el objeto Scanner
		sc.close();
		
		if ((int)decimal==0 && decimal!=0)
			System.out.println("Es un número casi-cero");
		else
			System.out.println("No es un número casi-cero");

	}

}
