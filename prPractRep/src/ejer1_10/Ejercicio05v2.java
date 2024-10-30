package ejer1_10;

/**
 * Hacer un programa para averiguar la frecuencia relativa con la que saldría
 * cada uno de los números de un dado si lanzáramos éste 1000 veces.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio05v2 {

	public static void main(String[] args) {
		
		int[] cont = {0,0,0,0,0,0}; // Array para contar todas las caras del dado (6 valores)
		byte dado;
		
		for (int i = 1; i<=1000; i++) {
			dado=(byte)(Math.random()*6); // Simulación de dado
			cont[dado]++; // Sumar 1 a la cara que haya salido
		}
		for (int i = 1; i<=6; i++) // Mostrar los porcentajes de cada cara
			System.out.println("Probabilidad de la cara " + i + " en base a 1000 tiradas: "+((double)cont[i-1]/10)+"%");
		
	}
}
