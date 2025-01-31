package ejer31_40;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio40v2 {

	public static void main(String[] args) {
		// Introducir un número desde teclado y desglosarlo de forma ideal en billetes y
		// monedas de curso legal, es decir, con el mínimo número de billetes y monedas.

		long dinero;
		int[] cantidades = {50000,20000,10000,5000,2000,1000,500,200,100,50,20,10,5,2,1},
			  cont = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Especifique el dinero (en euros): ");
		dinero = (long)(sc.nextDouble()*100);
		sc.close();

		for (int i = 0; i <= 14; i++) {
			cont[i] = (int) (dinero / cantidades[i]);
			dinero = dinero % cantidades[i];
		}

		System.out.println("\nEl número total de billetes es de: ");
		for (int i = 0; i<= 14; i++) {
			if (cont[i] > 0)
				if (i<9)
					System.out.println(cont[i] + " " + (i<7?"billetes":"monedas") + " de " + cantidades[i]/100 + "€");
				else
					System.out.println(cont[i] + " monedas de " + cantidades[i] + " céntimos");
		}
	}
}