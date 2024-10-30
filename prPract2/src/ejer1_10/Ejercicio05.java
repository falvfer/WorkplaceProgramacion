package ejer1_10;

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		// En una partida de un determinado juego, según los puestos conseguidos se
		// obtiene un grado u otro, siguiendo la siguiente tabla:
			// Puntos Grado
			// <60 	 	E
			// 60-69 	D
			// 70-79 	C
			// 80-89 	B
			// >=90	 	A
		// Escribir, usando sentencias de selección, el algoritmo que calcule el grado
		// correspondiente para una determinada puntuación.

		// Crear objeto Scanner y variables
		Scanner sc = new Scanner(System.in);
		short puntuacion = 0;

		// Preguntar por la puntuacion
		System.out.print("Especifique la puntuación obtenida: ");
		puntuacion = sc.nextShort();

		// Cerar el objeto Scanner
		sc.close();
		
		if (puntuacion < 0 || puntuacion > 200) // Comprobación de que sea una puntuación válida
			System.out.println("Error: Puntuacion no válida.");
		else if (puntuacion < 60) // Comprobación de la tabla de los grados
			System.out.println("Tu grado es 'E'");
		else if (puntuacion >= 90)
			System.out.println("Tu grado es 'A'");
		else if (puntuacion < 70)
			System.out.println("Tu grado es 'D'");
		else if (puntuacion < 80)
			System.out.println("Tu grado es 'C'");
		else
			System.out.println("Tu grado es 'B'");
	}

}
