package ejer41_50;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio44 {
	
	public static void main(String[] args) {
		// Introducir la nota de una asignatura por teclado, que esté comprendida entre
		// 0 y 10 y escribir la nota en letra, atendiendo a:
		//		0 > Nota < 3	Muy deficiente
		//	   3 >= Nota < 5	Insuficiente
		//	   5 >= Nota < 6	Suficiente
		//	   6 >= Nota < 7 	Bien
		//	   7 >= Nota < 9 	Notable
		//	   9 >= Nota =< 10	Sobresaliente
		
		float nota;
		String[] calificaciones = {"Muy deficiente", "Muy deficiente", "Muy deficiente", "Insuficiente", "Insuficiente", "Suficiente", "Bien", "Notable", "Notable", "Sobresaliente", "Sobresaliente"};
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		System.out.print("Especifique la nota (0-10): ");
		nota = sc.nextFloat();
		
		while (nota >= 0) {
			if (nota <= 10)
				System.out.println(calificaciones[(int)nota]);
			else
				System.out.println("Nota no válida.");
			System.out.print("\nEspecifique la nota (0-10) (número negativo para terminar): ");
			nota = sc.nextFloat();
		}
		sc.close();
	}
}
