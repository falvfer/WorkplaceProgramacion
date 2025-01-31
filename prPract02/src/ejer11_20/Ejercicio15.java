package ejer11_20;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		// Programa que lea 3 números de teclado y los muestre en pantalla de forma ordenada.

		// Crear las variables necesarias
		int num1, num2, num3, reserva;
		boolean ordenado = false;
		
		// Crear el objeto Scanner, leer los tres números, cerrar el objeto Scanner
		try (Scanner sc = new Scanner(System.in);){
			System.out.print("Di un número: ");
			num1=sc.nextInt();
			System.out.print("Di otro número: ");
			num2=sc.nextInt();
			System.out.print("Di el último número: ");
			num3=sc.nextInt();
			
			// Comprobar que sean distintos los números
			if (num1 == num2 || num2 == num3 || num3 == num1) 
				System.out.println("Error: Los números tienen que ser diferentes.");
			else { 
				do { // Bucle para ordenar los números
					if (num1 < num2)
						if (num2 < num3)
							ordenado = true;
						else {
							reserva = num2;
							num2 = num3;
							num3 = reserva;
						}
					else {
						reserva = num1;
						num1 = num2;
						num2 = reserva;
					}
				} while (!ordenado); // Fin bucle

				// Imprimir los números ordenados por pantalla
				System.out.println("Los números en orden son: " + num1 + ", " + num2 + " y " + num3);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
