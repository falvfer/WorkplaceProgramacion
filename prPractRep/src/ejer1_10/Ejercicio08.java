package ejer1_10;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Escribir un programa que lea las edades de los empleados de una empresa
 * mientras la edad leída sea distinta de cero y calcule cuántos jóvenes
 * (menores de 22 años), maduros (entre 22 y 50 años) y mayores (aquellos con
 * más de 50 años) hay, mostrando el resultado en pantalla. En aquellos casos en
 * los que se lea una edad no correcta (negativa o fuera del intervalo de 18 a
 * 65 años) se escribirá un mensaje de error en pantalla y se leerá otra edad.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio08 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int edad = 0, jovenes = 0, maduros = 0, mayores = 0, cont = 0;
		
		System.out.print("Especifique la edad del empleado: ");
		try {
			edad = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error: Formato de número no válido.");
			sc.nextLine();
		}
		
		while (edad!=0) {
			try {
				if (edad < 18)
					System.out.println("Error: Edad no válida.");
				else if (edad < 22)
					jovenes++;
				else if (edad <= 50)
					maduros++;
				else if (edad <= 65)
					mayores++;
				else
					System.out.println("Error: Edad no válida.");
				
				System.out.print("Otro empleado (0 para salir): ");
				edad = sc.nextInt();
				
			} catch (InputMismatchException e) {
				System.out.println("Error: Formato de número no válido.");
				sc.nextLine();
			}
		}
		cont = jovenes + maduros + mayores;
		if (cont != 0) {
			System.out.println("Número de trabajadores: "+cont);
			System.out.println("Jóvenes: "+jovenes);
			System.out.println("Maduros: "+maduros);
			System.out.println("Mayores: "+mayores);
		} else {
			System.out.println("No se ha especificado ningún empleado.");
		}
		sc.close();
	}
}
