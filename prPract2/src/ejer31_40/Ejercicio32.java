package ejer31_40;

import java.util.Scanner;

public class Ejercicio32 {
	
	public static void main(String[] args) {
		// Hacer un algoritmo para calcular el valor máximo y el valor mínimo de una
		// lista de números que se introducen por teclado, se terminará la operación
		// cuando se introduzca el número 0, en este caso no sabremos cuántos valores
		// se van a introducir.		
		
		// Crear las variables necesarias
		int num = 0, max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;

		// Objeto Scanner
		Scanner sc = new Scanner(System.in);
		
		do { // Bucle para pedir números y comprobar si son mayores o menores
			if (num>max) // Comprobar si es mayor o menor, entonces guardarlo
				max = num;
			if (num<min)
				min = num;
			System.out.print("Número (0 para salir): ");
			num = sc.nextInt();
		} while (num!=0);
		sc.close();
		
		System.out.println("El mayor de los números especificados es: "+max);
		System.out.println("El mínimo de los números especificados es: "+min);
		
	}
}
