package ejer31_40;

import java.util.Scanner;

public class Ejercicio31 {
	
	public static void main(String[] args) {
		// Realizar un programa para calcular el valor máximo y el mínimo de una lista de n
		// números que se introducen por teclado, es decir, me indicarán cuántos valores
		// se van a introducir, y se pedirán por teclado los que nos hayan indicado.		
		
		// Crear las variables necesarias
		int num, max, min, nums = 0;

		// Objeto Scanner, pedir cantidad de números
		Scanner sc = new Scanner(System.in);
		while (nums < 2) {
			System.out.print("Especifique la cantidad de números a especificar (dos números o más): ");
			nums = sc.nextInt();
		}
		nums--; // Restar uno ya que se especifica el primer número fuera del bucle
		
		System.out.print("Especifique el primer número: ");
		num = sc.nextInt();
		max = num; // Especificar el primer número como el mayor y el menor
		min = num; 
		
		for (int i = 1; i <= nums;i++) {
			System.out.print("Especifique otro número: ");
			num = sc.nextInt();
			if (num>max) // Comprobar si es mayor o menor, entonces guardarlo
				max = num;
			else if (num<min)
				min = num;
		}
		sc.close();
		
		System.out.println("El mayor de los números especificados es: "+max);
		System.out.println("El mínimo de los números especificados es: "+min);
		
	}
}
