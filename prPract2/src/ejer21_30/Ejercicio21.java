package ejer21_30;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio21 {
	
	public static void main(String[] args) {
		// Programa que imprima la tabla de multiplicar de un número entero
		// (entre 1 y 10)
		
		// Crear la variable tabla
		byte tabla;
		
		// Objeto Scanner y leer la tabla
		try (Scanner sc = new Scanner(System.in)){
			System.out.print("Especifique la tabla de multiplicar a mostrar (1-10): ");
			tabla=sc.nextByte();
			
			if (tabla>0&&tabla<=10) // Comprobar que sea entre 1 y 10
				for (byte cont=1;cont<=10;cont++) // Hacer el bucle para mostrar la tabla
					System.out.println(tabla+" x "+cont+" = "+tabla*cont);
			else // Mensaje de error
				System.out.println("Error: Especifica una tabla del 1 al 10");
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Formato del número incorrecto.");
		}
		
	}
}
