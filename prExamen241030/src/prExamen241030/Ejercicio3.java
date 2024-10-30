package prExamen241030;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Apuntes del ejercicio:
 *  Pedir cantidad de pruebas
 *  
 *    Generar nº aleatorio 1-6
 *    Mostrarlo por pantalla
 *    Contar cantidad de 5
 *   Repetir lo anterior hasta que sean cuatro 5
 *   Mostrar total de tiradas
 *   Sumar el total de tiradas para hacer media aritmética luego
 *  Repetir lo anterior por la cantidad de pruebas determinadas
 * 	
 *  Mostrar por pantalla la media aritmética de totalTiradas entre nPruebas
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio3 {

	public static void main(String[] args) {
		
		int numPruebas, totalTiradas = 0, contTiradas, cont5;
		byte dado;
		
		// Try con recursos para evitar errores
		try (Scanner sc = new Scanner(System.in)) {
			// Preguntar el número total de veces que se va a hacer
			System.out.print("¿Cuántas pruebas quieres realizar para el estudio? ");
			numPruebas = sc.nextInt();
			
			// Lanzar un error en caso de que sea un número negativo
			if (numPruebas < 0) 
				throw new InputMismatchException("El número tiene que ser positivo."); // Mensaje de información para el catch
			
			System.out.println();
			
			//Bucle inicial para hacer tantas pruebas como se especcificó antes
			for (int i = 1; i <= numPruebas; i++) {
				
				// Bucle anidado para lanzar el dado hasta que salgan cuatro 5 seguidos
				for (contTiradas = 0, cont5 = 0; cont5 < 4; contTiradas++) {
					
					// Generar el número aleatorio entre 1 y 6
					dado = (byte) (Math.random()*6+1);
					
					// Mostrar lo que va saliendo
					System.out.print(dado+" ");
					
					// Si el dado da 5 entonces sumar 1 al contador de 5 para poder salir del bucle cuando sea 4
					if (dado == 5)
						cont5++;
				}
				// Mostrar por pantalla el número de intento y las tiradas realizadas en total
				System.out.println();
				System.out.println("Intento "+i+": "+contTiradas+" tiradas");
				System.out.println();
				
				// Sumar las tiradas del intento al total para después hacer la media aritmética
				totalTiradas += contTiradas;
				
			}
			// Mostrar el número de tiradas haciendo la media
			System.out.println("El número medio de tiradas para poder sacar las 4 fichas es: "+(float)totalTiradas/numPruebas);
		
		} catch (InputMismatchException e) {
			// He elegido esta excepción para poder controlar también el caso de que no se introduzca un número
			System.out.println("Error: Formato de número no válido. "+(e.getMessage()==null?"":e.getMessage()));
		}
		
	}
}
