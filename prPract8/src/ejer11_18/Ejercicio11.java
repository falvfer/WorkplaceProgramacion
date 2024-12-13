package ejer11_18;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		
		Random rdn = new Random();
		byte opcion = 0;
		int[] pol1 = generarPolinomio((byte)rdn.nextInt(1,7)),
			  pol2 = generarPolinomio((byte)rdn.nextInt(1,7));
		
		System.out.println("Polinomio 1: " + polToString(pol1));
		System.out.println("Polinomio 2: " + polToString(pol2) + "\n");
		
		menu();

		try (Scanner sc = new Scanner(System.in)) {
			
			opcion = sc.nextByte();
			if (opcion > 3 || opcion < 1) throw new Exception();
			
			int[] pol3 = calculaPolinomio(pol1, pol2, opcion);

			System.out.println("\nResultado: " + polToString(pol3));
			
		} catch (Exception e) {
			System.out.println("\nError: Opción no válida");
		}
	}
	
	private static String polToString(int[] pol) {
		String salida = "";
		int abs;
		
		if (pol[pol.length-1]<0)
			salida += "-";
		
		for (int i = pol.length-1; i>=0; i--) {
			abs = Math.abs(pol[i]);
			if (abs!=0) {
				if (abs!=1 || i == 0)
					salida += abs;
				
				if (i>1)
					salida += "x^" + i;
				else if (i>0)
					salida += "x";
				
				if (i>0 && (i>1 || abs!=0))
					salida += (pol[i-1] >= 0?" +":" -");
			}
		}
		return salida;
	}
	
	private static void menu() {
		System.out.println("1. Sumar dos polinómios");
		System.out.println("2. Restar dos polinómios");
		System.out.println("3. Multiplicar dos polinómios");
		System.out.print("Eliga una opción: ");
	}
	
	private static int[] generarPolinomio(byte grado) {
		Random rdn = new Random();
		int[] pol = new int[grado];
		for (int i = 0; i<pol.length; i++)
			pol[i] = rdn.nextInt(-20,21);
		return pol;
	}
	
	private static int[] calculaPolinomio(int[] pol1, int[] pol2, byte opcion) {
		int[] polMayor = pol2.length>pol1.length?pol2:pol1,
			  polMenor = pol2.length<pol1.length?pol2:(pol2.length==pol1.length?pol2:pol1),
			  polFinal = new int[polMayor.length + (opcion==3?polMenor.length-1:0)];
													// Si es multiplicar la longitud tiene otras reglas
		switch (opcion) {
			case 1 -> { // Sumar
				for (int i = 0; i<polMenor.length; i++)
					polFinal[i] = polMayor[i] + polMenor[i];
			} case 2 -> { // Restar
				for (int i = 0; i<polMenor.length; i++)
					polFinal[i] = polMayor[i] - polMenor[i];
			} case 3 -> { // Multiplicar
				for (int i = 0; i<polMenor.length; i++)
					for (int k = 0; k<polMayor.length; k++)
						polFinal[i+k] += polMenor[i] * polMayor[k];
			}
		}
		if (opcion != 3) // En caso de suma o resta añadir lo que no se puede sumar o restar
			for (int i = polMenor.length; i<polMayor.length; i++)
				polFinal[i] = polMayor[i];
		
		return polFinal;
	}
}
