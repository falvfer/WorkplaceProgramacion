package ejer01_09;

// import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

	/**
	 * Escribe un programa que lea 8 números por teclado y que luego los
	 * muestre en orden inverso, es decir, el primero que se introduce es
	 * el último en mostrarse y viceversa.
	 * @param args
	 */
	
	public static void main(String[] args) {
		// Objeto Random
		// Random rdn = new Random();

		// Definir un array de 4 elementos de tipo entero
		int[] array = new int[8];
		
		// Simular el pedir valores por teclado para los componentes del array
		try (Scanner sc = new Scanner(System.in)) {
			for (int i = 0; i<array.length; i++) {
				System.out.print("Especifica el número de la posición " + (i+1) + ": ");
				array[i] = sc.nextInt();
			}
		}
		
		System.out.print("Valores del array (invertido): ");
		for (int i = array.length-1; i>=0; i--)
			System.out.print(array[i] + " ");

	}

}
