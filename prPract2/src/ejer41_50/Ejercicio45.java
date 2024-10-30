package ejer41_50;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio45 {
	
	public static void main(String[] args) {
		// Hacer un algoritmo para que nos calcule la estadística de una serie de notas
		// introducidas por teclado. La serie finalizará con la introducción del 0,
		// sabiendo que:		
		//	   1 < Nota < 5 	Deficiente
		//	  5 <= Nota < 6 	Suficiente
		//	  6 <= Nota < 7 	Bien
		//	  7 <= Nota < 9 	Notable
		//	  9 <= Nota =< 10 	Sobresaliente
		
		float nota;
		int cont = 0, def = 0, suf = 0, bien = 0, not = 0, sob = 0;
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);

		System.out.print("Especifique la nota (1-10): ");
		nota = sc.nextFloat();

		while (nota != 0) {
			if (nota < 1 || nota > 10)
				System.out.println("Nota no válida.");
			else if (nota < 5)
				def++;
			else if (nota < 6)
				suf++;
			else if (nota < 7)
				bien++;
			else if (nota < 9)
				not++;
			else
				sob++;
			
			System.out.print("Especifique la nota (1-10) (0 para terminar): ");
			nota = sc.nextFloat();
		}
		sc.close();
		cont = def + suf + bien + not + sob;
		
		System.out.println();
		if (def>0)
			System.out.println((float)def/cont*100+"% de deficientes.");
		if (suf>0)
			System.out.println((float)suf/cont*100+"% de suficientes.");
		if (bien>0)
			System.out.println((float)bien/cont*100+"% de bien.");
		if (not>0)
			System.out.println((float)not/cont*100+"% de notables.");
		if (sob>0)
			System.out.println((float)sob/cont*100+"% de sobresalientes.");

	}
}
