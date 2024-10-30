package ejer1_10;
/**
 * Programa que calcule el cuadrado de los 100 primeros números pares.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		
		double cuadrado = 0;
		
		for (int i = 2; i<=200; i+=2) {
			cuadrado = Math.pow(i, 2);
			System.out.println(i+"^2 --> "+cuadrado);
		}
		
	}
}