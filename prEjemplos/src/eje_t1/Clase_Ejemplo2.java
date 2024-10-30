package eje_t1;

import java.util.Locale;
import java.util.Scanner;

public class Clase_Ejemplo2 {

	public static void main(String[] args) {
		
		// Definición de variables
		float num1;
		double num2;
		
		// Asignar valores a las variables
		//Para num1 tienes que hacer un casting a float, se puede hacer también con (float)4.5
		num1 = 4.5f;
		num2 = 75.89;
		
		//Crear scanner y usar el locale "US" para que los decimales usen el punto y no la coma
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		//Pedir valores por teclado para las variables anteriores
		System.out.print("Introduzca un valor float: ");
		num1 = sc.nextFloat();
		System.out.print("Introduzca un valor double: ");
		num2 = sc.nextDouble();
		
		System.out.println("Valor actual de num1 y num2: " + num1 + ", " + num2);
		
		sc.close();
	}
}
