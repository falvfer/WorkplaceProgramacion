package ejer1_10;

import java.util.Scanner;

/**
 * El recibo de la electricidad se elabora de la siguiente forma:
 *	- 6 euros de gastos fijos.
 *	- 1 euro./Kw para los primeros 100 Kw.
 *	- 80 céntimos/Kw para los siguientes 150 Kw.
 *	- 70 céntimos/Kw para el resto
 * Diseñar un programa que lea del teclado los dos últimos valores del
 * contador, y calcule e imprima en pantalla el importe total a pagar.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio07 {

	public static void main(String[] args) {
		float kw;
		float pagar = 6;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Especifique los Kw: ");
		kw = sc.nextFloat();
		sc.close();
		
		if (kw > 0) {
			if (kw > 100) {
				kw-=100;
				pagar+=100;
				if (kw > 150) {
					kw-=150;
					pagar+=150*0.8+kw*0.7;
				} else {
					pagar+=kw*0.8;
				}
			}
			else {
				pagar+=kw;
			}
		}
		System.out.println("En total tienes que pagar: "+pagar+"0€");
		
	}
}
