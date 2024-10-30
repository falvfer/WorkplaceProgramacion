package ejer1_10;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		// Realizar un programa que calcule la media aritmética de tres valores que
		// se han leído de teclado, y muestre el resultado por pantalla.
		
		// Crear Scanner y variables, iniciandolas.
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		float num1=0;
		float num2=0;
		float num3=0;
		
		// Pedir los tres números.
		System.out.print("Escriba tres números para hacer la media aritmética: ");
		num1=sc.nextFloat();
		System.out.print("El segundo: ");
		num2=sc.nextFloat();
		System.out.print("El tercero: ");
		num3=sc.nextFloat();
		
		// Hacer el cálculo y mostrar por pantalla la media aritmética.
		System.out.print("La media de " + num1 + ", " + num2 + " y "+ num3 + "es igual a: " + ((num1+num2+num3)/3));
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}
