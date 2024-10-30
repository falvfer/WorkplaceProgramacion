package ejer1_10;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Escribir un programa que permita realizar descuentos en un comercio, en
 * función del total de compras realizadas por cada cliente. Para realizar
 * dichos descuentos, se deben leer los importes de cada compra parcial de un
 * cliente hasta que un importe sea igual a cero; posteriormente se escribirá el
 * importe total a pagar teniendo en cuenta que se pueden efectuar las
 * siguientes descuentos:
 * Si el importe total de la compra está entre 300 y 800 euros, el descuento es del 15%.
 * Si el importe total de la compra es mayor de 800 euros. El descuento es del 20%.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio09 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		int cont = 1;
		double imp = 0, impTotal = 0;
		
		
		try {
			System.out.print("Precio producto "+cont+": ");
			imp = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.out.println("Error: Formato de número no válido.");
			cont--;
			sc.nextLine();
		}
		
		while (imp != 0 || cont == 0) {
			cont++;
			try {
				if (imp >= 0)
					impTotal+=imp;
				else
					System.out.println("Error: Importe negativo.");
				
				System.out.print("(0) Precio producto "+cont+": ");
				imp = sc.nextDouble();
				
			} catch (InputMismatchException e) {
				System.out.println("Error: Formato de número no válido.");
				cont--;
				sc.nextLine();
			}
		}
		if (impTotal != 0) {
			if (impTotal < 300)
				System.out.println("Importe total: "+impTotal);
			else if (impTotal < 800)
				System.out.println("Importe total: "+impTotal*0.85);
			else
				System.out.println("Importe total: "+impTotal*0.8);
		}
		sc.close();
		
		
		
		
		
		
		
		
	}
}
