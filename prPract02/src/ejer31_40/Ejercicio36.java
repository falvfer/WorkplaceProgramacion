package ejer31_40;

import java.util.Scanner;

public class Ejercicio36 {
	
	public static void main(String[] args) {
		// Realizar un programa que cuente los números positivos y negativos que
		// aparezcan en una lista de números que se introducen por teclado. El proceso
		// finalizará introduciendo el número 0.
		
		int num, contPos = 0, contNeg = 0;
		
		Scanner sc = new Scanner(System.in);

		System.out.print("Especifique el número (distinto a 0): ");
		num = sc.nextInt();
		
		while (num != 0) {
			if (num > 0)
				contPos++;
			else
				contNeg++;
			
			System.out.print("Especifique el número (0 para terminar): ");
			num = sc.nextInt();
		}
		if (contPos+contNeg==0)
			System.out.println("No se ha especificado ningún número.");
		else
			System.out.println("\nPositivos: "+contPos+"\nNegativos: "+contNeg);
		
		sc.close();
		
	}
}
