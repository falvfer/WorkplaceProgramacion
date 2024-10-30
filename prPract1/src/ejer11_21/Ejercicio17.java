package ejer11_21;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		// Escribir un programa que reciba 4 números naturales a, b, c y d y que calcule:
		// (a^b + c^d) * (a^c + b^d)

		// Crear el objeto Scanner y las variables necesarias
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		int a=0;
		int b=0;
		int c=0;
		int d=0;
		int resultado=0;

		// Pedir por pantalla los números para las variables a, b, c, d
		System.out.print("Especifique el número para la variable \"a\": ");
		a=sc.nextInt();
		System.out.print("Especifique el número para la variable \"b\": ");
		b=sc.nextInt();
		System.out.print("Especifique el número para la variable \"c\": ");
		c=sc.nextInt();
		System.out.print("Especifique el número para la variable \"d\": ");
		d=sc.nextInt();
		
		// Calcular el resultado
		resultado=(int)((Math.pow(a, b)+Math.pow(c, d))*(Math.pow(a, c)+Math.pow(b, d)));
		
		// Mostrar el resultado por pantalla
		System.out.println("El resultado es: "+resultado);
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}
