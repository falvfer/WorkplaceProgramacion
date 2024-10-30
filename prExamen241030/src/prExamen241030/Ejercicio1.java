package prExamen241030;

import java.util.Scanner;

/**
 * Apuntes del ejercicio:
 *  Ir pidiendo edad de corredores, terminar con negativa
 *  No pueden ser menores de edad (ni mayores de 100)
 *  Categorias a clasificar las edades:
 *    18>= edad <23 Juvenil
 *    23>= edad <30 Promesa
 *    31>= edad <40 Senior
 *    40>= edad <50 Veterano A
 *    50>= edad <60 Veterano B
 *    60>= edad <100 Veterano C
 *  Al final mostrar la cantidad de cada uno
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		byte num;
		int juvenil = 0, promesa = 0, senior = 0, vetA = 0, vetB = 0, vetC = 0;
		
		// Preguntar por la edad antes de entrar al bucle para evitar errores varios.
		System.out.print("Indique la edad del corredor: ");
		num = sc.nextByte();
		
		// Bucle para repetir tantas veces como lo necesite el usuario
		while (num>=0) { 
			if (num<18) // Si es menor de edad
				System.out.println("Error: Tiene que ser mayor de edad.");
			else if (num>=100) // Si es mayor de 100 años
				System.out.println("Error: Edad no válida (18-99).");
			else { // 18 <= edad <= 99
				// Dependiendo de la edad se sumará a su categoría correspondiente.
				// Lo he hecho en este orden pensando que la gran mayoría de corredores van a ser jovenes.
				// Siendo así, aunque entre 60 y 99 haya más cantidad de edades,
				// van a haber menos corredores en ese rango.
				if (num < 23) 
					juvenil++;
				else if (num < 31)
					promesa++;
				else if (num < 40)
					senior++;
				else if (num < 50)
					vetA++;
				else if (num < 60)
					vetB++;
				else
					vetC++;
			}

			// Volver a preguntar por la edad
			System.out.print("Indique la edad del corredor: ");
			num = sc.nextByte();
		}
		sc.close(); // Cerrar Scanner
		
		// Mostrar todos las categorias con su cantidad de corredores
		System.out.println();
		System.out.println("Juvenil: "+(juvenil!=0?(juvenil+" corredores"):("Ningúno inscrito")));
		System.out.println("Promesa: "+(promesa!=0?(promesa+" corredores"):("Ningúno inscrito")));
		System.out.println("Senior: "+(senior!=0?(senior+" corredores"):("Ningúno inscrito")));
		System.out.println("Veterano A: "+(vetA!=0?(vetA+" corredores"):("Ningúno inscrito")));
		System.out.println("Veterano B: "+(vetB!=0?(vetB+" corredores"):("Ningúno inscrito")));
		System.out.println("Veterano C: "+(vetC!=0?(vetC+" corredores"):("Ningúno inscrito")));
		
	}
}
