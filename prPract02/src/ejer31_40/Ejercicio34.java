package ejer31_40;

import java.util.Scanner;

public class Ejercicio34 {
	
	public static void main(String[] args) {
		// Hacer un algoritmo que calcule la suma de la serie de Fibonacci para un
		// término n que se introduce por teclado.
		
		// Crear las variables necesarias
		int posSerie, aux1 = 1, aux2 = 1;

		// Objeto Scanner, pedir cantidad de números
		Scanner sc = new Scanner(System.in);

		// Preguntar por el número
		do {
			System.out.print("Especifique la posicion de la serie de Fibonacci a mostrar (0 o positivo): ");
			posSerie = sc.nextInt();
		} while (posSerie < 0);
		sc.close();
		
		// Calcular la serie de Fibonacci
		for (int cont = 2; cont <= posSerie; cont+=2) {
			aux1+=aux2;
			aux2+=aux1;
		}
		
		// Decir el resultado
		System.out.println("La posición "+posSerie+" de la serie es: "+(posSerie%2==0?aux1:aux2));
		
		// Forma "normal"
		//int aux0;
		//for (int cont = 2; cont <= posSerie; cont++) {
		//	aux0=aux2;
		//	aux2+=aux1;
		//	aux1=aux0;
		//}
		// 
		// Decir el resultado
		//System.out.println("La posición "+posSerie+" de la serie es: "+aux2);
		
	}
}
