package ejer01_09;

import java.util.Random;

public class Ejercicio5 {

	/**
	 * Realizar un programa que genere y almacene en un array
	 * 20 números de forma aleatoria. A continuación deberá
	 * mostrar el array con los números generados, así como mostrar
	 * (junto con su posición en el array), contar y sumar los
	 * elementos pares que ocupan las posiciones impares.
	 * @param args
	 */
	
	public static void main(String[] args) {
		// Objeto Random
		Random rdn = new Random();

		// Definir un array de 4 elementos de tipo entero
		int sumaArray = 0;
		int[] array = new int[20];
		
		// Simular el pedir valores por teclado para los componentes del array
		System.out.print("Contenido del array: ");
		for (int i = 0; i<array.length; i++) {
			array[i] = rdn.nextInt(0,101);
			System.out.print(array[i] + " ");
		}
		System.out.println("\n");
		// Contar y sumar las posiciones impares
		for (int i = 0; i<array.length; i+=2) {
			if (array[i]%2==0) {
				System.out.println("Posicion " + (i+1) + ": " + array[i]);
				sumaArray += array[i];
			}
		}
		System.out.println("\nLa suma es: " + sumaArray);

	}

}
