package ejer11_16;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		
		Random rdn = new Random();
		
		byte opcion = 0;
		int[] pol1 = generarPolinomio((byte)rdn.nextInt(1,7)),
			  pol2 = generarPolinomio((byte)rdn.nextInt(1,7)),
			  pol3;
		
		System.out.println("Polinomio 1: " + polToString(pol1));
		System.out.println("Polinomio 2: " + polToString(pol2) + "\n");
		
		menu();

		try (Scanner sc = new Scanner(System.in)) {
			
			opcion = sc.nextByte();
			if (opcion > 3 || opcion < 1) throw new Exception();

			if (opcion !=3)
				pol3 = new int[lengthPolMayor(pol1, pol2)];
			else
				pol3 = new int[pol1.length + pol2.length - 1];
			
			switch (opcion) {
			case 1 -> pol3 = sumaPolinomio(pol1, pol2);
			case 2 -> pol3 = restaPolinomio(pol1, pol2);
			case 3 -> pol3 = multiplicaPolinomio(pol1, pol2);
			}

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
	
	private static int lengthPolMayor(int[] pol1, int[] pol2) {
		return pol2.length>pol1.length?pol2.length:pol1.length;
	}
	
	private static int lengthPolMenor(int[] pol1, int[] pol2) {
		return pol2.length<pol1.length?pol2.length:pol1.length;
	}
	
	private static int[] sumaPolinomio(int[] pol1, int[] pol2) {
		int[] polFinal = new int[pol2.length>pol1.length?pol2.length:pol1.length];
		
		for (int i = 0; i<lengthPolMenor(pol1, pol2); i++)
			polFinal[i] = pol1[i] + pol2[i];
		
		if (pol1.length == lengthPolMayor(pol1, pol2)) {
			for (int i = lengthPolMenor(pol1, pol2); i<lengthPolMayor(pol1, pol2); i++)
				polFinal[i] = pol1[i];
		} else {
			for (int i = lengthPolMenor(pol1, pol2); i<lengthPolMayor(pol1, pol2); i++)
				polFinal[i] = pol2[i];
		}
		
		return polFinal;
	}
	
	private static int[] restaPolinomio(int[] pol1, int[] pol2) {
		int[] polFinal = new int[pol2.length>pol1.length?pol2.length:pol1.length];
		
		for (int i = 0; i<lengthPolMenor(pol1, pol2); i++)
			polFinal[i] = pol1[i] - pol2[i];
		
		if (pol1.length == lengthPolMayor(pol1, pol2)) {
			for (int i = lengthPolMenor(pol1, pol2); i<lengthPolMayor(pol1, pol2); i++)
				polFinal[i] = pol1[i];
		} else {
			for (int i = lengthPolMenor(pol1, pol2); i<lengthPolMayor(pol1, pol2); i++)
				polFinal[i] = pol2[i];
		}
		
		return polFinal;
	}
	
	private static int[] multiplicaPolinomio(int[] pol1, int[] pol2) {
		int[] polMayor = pol2.length>pol1.length?pol2:pol1,
				  polMenor = pol2.length<pol1.length?pol2:(pol2.length==pol1.length?pol2:pol1),
				  polFinal = new int[polMayor.length + polMenor.length - 1];
		
		for (int i = 0; i<polMenor.length; i++)
			for (int k = 0; k<polMayor.length; k++)
				polFinal[i+k] += polMenor[i] * polMayor[k];
		
		return polFinal;
	}
}