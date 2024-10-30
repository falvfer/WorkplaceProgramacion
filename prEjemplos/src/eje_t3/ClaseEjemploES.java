package eje_t3;

import java.util.Scanner;

public class ClaseEjemploES {

	public static void main(String[] args) {
		int numero;
		char caracter;
		String cadena;
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Introduzca un número: ");
			numero = sc.nextInt();
			System.out.println(numero);
			
			sc.nextLine(); // Limpiar buffer de teclado
			System.out.print("Introduzca un caracter: ");
			caracter = sc.nextLine().charAt(0);
			System.out.println(caracter);
			
			System.out.print("Introduzca una cadena: ");
			cadena = sc.nextLine();
			System.out.println(cadena);
		}

	}

}
