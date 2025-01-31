package ejer31_40;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio40 {

	public static void main(String[] args) {
		// Introducir un número desde teclado y desglosarlo de forma ideal en billetes y
		// monedas de curso legal, es decir, con el mínimo número de billetes y monedas.

		long dinero;
		int e500 = 0, e200 = 0, e100 = 0, e50 = 0, e20 = 0, e10 = 0, e5 = 0,
				e2 = 0, e1 = 0, c50 = 0, c20 = 0, c10 = 0, c5 = 0, c2 = 0, c1 = 0;
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Especifique el dinero (en euros): ");
		dinero = (long)(sc.nextDouble()*100);
		sc.close();
		
		while (dinero>=50000) {
			e500++;
			dinero-=50000;
		} while (dinero>=20000) {
			e200++;
			dinero-=20000;
		} while (dinero>=10000) {
			e100++;
			dinero-=10000;
		} while (dinero>=5000) {
			e50++;
			dinero-=5000;
		} while (dinero>=2000) {
			e20++;
			dinero-=2000;
		} while (dinero>=1000) {
			e10++;
			dinero-=1000;
		} while (dinero>=500) {
			e5++;
			dinero-=500;
		} while (dinero>=200) {
			e2++;
			dinero-=200;
		} while (dinero>=100) {
			e1++;
			dinero-=100;
		} while (dinero>=50) {
			c50++;
			dinero-=50;
		} while (dinero>=20) {
			c20++;
			dinero-=20;
		} while (dinero>=10) {
			c10++;
			dinero-=10;
		} while (dinero>=5) {
			c5++;
			dinero-=5;
		} while (dinero>=2) {
			c2++;
			dinero-=2;
		} while (dinero>=1) {
			c1++;
			dinero-=1;
		}

		System.out.println("\nEl número total de billetes es de: ");
		if (e500 > 0)
			System.out.println("\t" + e500 + " billetes de 500€");
		if (e200 > 0)
			System.out.println("\t" + e200 + " billetes de 200€");
		if (e100 > 0)
			System.out.println("\t" + e100 + " billetes de 100€");
		if (e50 > 0)
			System.out.println("\t" + e50 + " billetes de 50€");
		if (e20 > 0)
			System.out.println("\t" + e20 + " billetes de 20€");
		if (e10 > 0)
			System.out.println("\t" + e10 + " billetes de 10€");
		if (e5 > 0)
			System.out.println("\t" + e5 + " billetes de 5€");

		System.out.println("\nEl número total de monedas es de: ");
		if (e2 > 0)
			System.out.println("\t" + e2 + " monedas de 2€");
		if (e1 > 0)
			System.out.println("\t" + e1 + " monedas de 1€");
		if (c50 > 0)
			System.out.println("\t" + c50 + " monedas de 50 centimos");
		if (c20 > 0)
			System.out.println("\t" + c20 + " monedas de 20 centimos");
		if (c10 > 0)
			System.out.println("\t" + c10 + " monedas de 10 centimos");
		if (c5 > 0)
			System.out.println("\t" + c5 + " monedas de 5 centimos");
		if (c2 > 0)
			System.out.println("\t" + c2 + " monedas de 2 centimos");
		if (c1 > 0)
			System.out.println("\t" + c1 + " monedas de 1 centimo");
	}
}