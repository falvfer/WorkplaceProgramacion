package ejer11_21;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		// Realizar un programa que realiza y muestra las operaciones aritméticas básicas
		// de dos números pasados a nuestro programa. Las operaciones aritméticas básicas
		// son, suma, resta, multiplicación y división.

		// Crear el objeto Scanner y las variables a usar
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		double num1=0;
		double num2=0;
		
		// Pedir por pantalla los números para las operaciones
		System.out.print("Especifique el primer número: ");
		num1=sc.nextDouble();
		System.out.print("Especifique el segundo número: ");
		num2=sc.nextDouble();
		
		// Enseñar las operaciones por pantalla:
		System.out.println("");
		System.out.println("La suma de "+num1+" y "+num2+" es igual a: "+(num1+num2));
		System.out.println("La resta de "+num1+" menos "+num2+" es igual a: "+(num1-num2));
		System.out.println(num1+" multiplicado por "+num2+" es igual a: "+(num1*num2));
		System.out.println(num1+" dividido por "+num2+" es igual a: "+(num1/num2));
		
		// Cerrar el objeto Scanner
		sc.close();
	}

}
