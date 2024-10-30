package ejer41_50;

import java.util.Scanner;

public class Ejercicio46 {
	
	public static void main(String[] args) {
		// Con la ayuda de la clase Random, o bien el método random de la clase Math,
		// simular el lanzamiento de una moneda al aire y visualizar por pantalla si ha
		// salido cara o cruz. Repetir el proceso tantas veces como se quiera.		
		
		double rand;
		int cont, aCont=0, bCont=0;
		
		System.out.print("Especifique el número de veces a tirar la moneda: ");
		Scanner sc = new Scanner(System.in);
		cont=sc.nextInt();
		sc.close();
		
		for (int i=1;i<=cont;i++) { // Bucle para "tirar la moneda" tantas veces como se especificó.
			rand = Math.random(); // Generar un valor double 0>=valor<1
			if (rand < 0.5) // Comprobar si rand<0.5 (cruz) o rand>=0.5 (cara) 
				aCont++;
			else
				bCont++;
		}
		
		System.out.println("Número total de Cruzes: "+aCont);
		System.out.println("Número total de Caras: "+bCont);
		
	}
}
