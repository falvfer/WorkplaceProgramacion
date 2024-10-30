package ejer41_50;

import java.util.Scanner;

public class Ejercicio43 {
	
	public static void main(String[] args) {
		// Hacer un algoritmo para que introducido el número de mes lo visualice en
		// letra. Por ejemplo, si nos dan el número 6, escribiremos “Junio”.		
		
		byte mes;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Especifique el mes: ");
		mes = sc.nextByte();
		
		while (mes != 0) {
			switch (mes) {
				case 1 -> System.out.println("Enero");
				case 2 -> System.out.println("Febrero");
				case 3 -> System.out.println("Marzo");
				case 4 -> System.out.println("Abril");
				case 5 -> System.out.println("Mayo");
				case 6 -> System.out.println("Junio");
				case 7 -> System.out.println("Julio");
				case 8 -> System.out.println("Agosto");
				case 9 -> System.out.println("Septiembre");
				case 10 -> System.out.println("Octubre");
				case 11 -> System.out.println("Noviembre");
				case 12 -> System.out.println("Diciembre");
				default -> System.out.println("Mes no válido");
			}
			System.out.print("\nEspecifique el mes (0 para terminar): ");
			mes = sc.nextByte();
		}
		sc.close();
	}
}
