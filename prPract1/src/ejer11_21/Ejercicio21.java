package ejer11_21;

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		// Una empresa que gestiona un parque acuático nos solicita una aplicación que
		// les ayude a calcular el importe que hay que cobrar en la taquilla por la
		// compra de una serie de entradas (cuyo número será introducido por el
		// usuario). Existen dos tipos de entradas: infantiles, que cuestan 15.50€, y de
		// adultos que cuestan 20€. En el caso de que el importe total sea igual o
		// superior a 100€, se aplicará automáticamente un bono descuento del 5%.

		Scanner sc = new Scanner(System.in);
		byte nInf = 0;
		byte nAdu = 0;
		final float prInf = 15.5f;
		final float prAdu = 20f;
		float total = 0;

		System.out.print("Especifique el número de entradas infantiles: ");
		nInf = sc.nextByte();
		System.out.print("Especifique el número de entradas de adultos: ");
		nAdu = sc.nextByte();

		total = nInf * prInf + nAdu * prAdu;
		total = (total >= 100) ? total * 0.95f : total;

		System.out.println("El precio total de las entradas es de: " + total + "€");

		sc.close();
	}

}
