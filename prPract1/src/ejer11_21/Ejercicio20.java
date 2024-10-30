package ejer11_21;

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		// Un biólogo está realizando un estudio de distintas especies de invertebrados
		// y necesita una aplicación que le ayude a contabilizar el número de patas que
		// tienen en total todos los animales capturados durante una jornada de trabajo.
		// Para ello, nos ha solicitado una aplicación a la que hay que proporcionar:
			// El número de hormigas capturadas (6 patas).
			// El número de arañas capturadas (8 patas).
			// El número de cochinillas capturadas (14 patas).
		// La aplicación debe mostrar el número total de patas.
		
		// Crear el objeto Scanner y las variables necesarias
		Scanner sc = new Scanner(System.in);
		int hormiga=0;
		int aranna=0;
		int cochinilla=0;
		
		// Pedir al usuario el número de insectos capturados
		System.out.print("Especifique el número de hormigas: ");
		hormiga=sc.nextInt();
		System.out.print("Especifique el número de arañas: ");
		aranna=sc.nextInt();
		System.out.print("Especifique el número de cochinillas: ");
		cochinilla=sc.nextInt();
		
		// Hacer el cálculo y mostrar por pantalla el resultado
		System.out.println("El número total de patas es de: "+(hormiga*6+aranna*8+cochinilla*14));
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}
