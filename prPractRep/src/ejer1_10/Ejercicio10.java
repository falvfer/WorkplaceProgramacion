package ejer1_10;

import java.util.Scanner;

/**
 * Diseña tres programas que dibujen las siguientes figuras, para ello se pedirá
 * la altura del triángulo. En estos tres ejemplos la altura del triángulo es 4.
 * 
 *    *         *         1      ****
 *   ***       ***       121     ***
 *  *****     *****     12321    **
 * *******   *******   1234321   *
 *            *****              
 *             ***               
 *              *   
 *                           
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lineas;
		
		// Pedir la longitud (en número de líneas) del triángulo
		System.out.println("Especifique el tamaño del triángulo");
		lineas = sc.nextInt();
		
		sc.close();
		
		// PRIMER TRIANGULO __________________________________________________________
		for (int espacios = lineas-1, cont; espacios>=0; espacios--) {
			for (cont = 1; cont <= espacios; cont++)
				System.out.print(" ");
			for (cont = 1; cont <= (lineas-espacios)*2-1; cont++)
				System.out.print("*");
			System.out.println();
		}
		
		System.out.println("\n");
		
		// SEGUNDO TRIANGULO _________________________________________________________
		for (int espacios = lineas-1, cont; espacios>=0; espacios--) {
			for (cont = 1; cont <= espacios; cont++)
				System.out.print(" ");
			for (cont = 1; cont <= (lineas-espacios)*2-1; cont++)
				System.out.print("*");
			System.out.println();
		}
		
		for (int espacios = 1, cont; espacios <= lineas-1; espacios++) {
			for (cont = 1; cont <= espacios; cont++)
				System.out.print(" ");
			for (cont = 1; cont <= (lineas-espacios)*2-1; cont++)
				System.out.print("*");
			System.out.println();
		}
		
		System.out.println("\n");
		
		// TERCER TRIANGULO __________________________________________________________
		for (int espacios = lineas-1, cont; espacios>=0; espacios--) {
			for (cont = 1; cont <= espacios; cont++)
				System.out.print(" ");
			for (cont = 1; cont <= lineas-espacios; cont++)
				System.out.print(cont);
			for (cont -= 2;cont >= 1; cont--)
				System.out.print(cont);
			
			System.out.println();
		}
		
		System.out.println("\n");
		
		// CUARTO TRIANGULO __________________________________________________________
		for (int asteriscos = lineas, cont; asteriscos >= 1; asteriscos--) {
			for (cont = asteriscos; cont >= 1; cont--)
				System.out.print("*");
			
			System.out.println();
		}
	}
}
