package prPract3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuComprobaciones {
	
	public static void main(String[] args) {
		
		byte opcion = -1;
		boolean terminar = false;
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				menu();
				System.out.print("\tEspecifica la opcion (0..): ");
				opcion = sc.nextByte();
				
				System.out.println();
				
				switch(opcion) {
				case 0 -> terminar = true;
				case 1 -> proceso1(sc);
				case 2 -> proceso2(sc);
				case 3 -> proceso3(sc);
				case 4 -> proceso4(sc);
				default -> System.out.println("Error: Opción no válida.");
				}
				
				System.out.println();
					
			} catch (InputMismatchException e) {
				if (e.getMessage() == null) {
					System.out.println();
					System.out.println("Error: Número no válido.");
					sc.nextLine();
				} else
					System.out.println(e.getMessage());
				System.out.println();
				
			} catch (ArithmeticException e) {
				if (e.getMessage() == null)
					System.err.println("Error: Operación no válida.");
				else
				System.out.println(e.getMessage());
			}
		} while (!terminar);
		sc.close();
	}
	
	private static void menu() {
		System.out.println("0. Salir del programa");
		System.out.println("1. Comprobar si un número es primo o no");
		System.out.println("2. Calcular el factorial de un número");
		System.out.println("3. Calcular el combinatorio de dos números");
		System.out.println("4. Comprobar si un número es perfecto");
	}
	
	/**
	 * Proceso para comprobar si un número es primo
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso1(Scanner sc) {
		int num;
		
		System.out.print("Introduzca el número: ");
		num = sc.nextInt();
		
		System.out.println();
		
		if (num==0)
			throw new ArithmeticException("0 no es 'primo' ni 'no primo'.");
		else if (MiLibreria.isPrimo(num))
			System.out.println("El número "+num+" es primo.");
		else
			System.out.println("El número "+num+" no es primo.");
	}

	/**
	 * Proceso para calcular el factorial de un número
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso2(Scanner sc) {

		int a, b;
			
		System.out.print("Introduzca el valor \"a\": ");
		a = sc.nextInt();
		System.out.print("Introduzca el valor \"b\": ");
		b = sc.nextInt();

		System.out.println();
		
		int comb = MiLibreria.combinatorio(a, b);
		
		if (comb == -1)
			throw new ArithmeticException("No se puede hacer el combinatorio de "+a+" y "+b+" porque uno de los números es negativo.");
		else if (comb == -2)
			throw new ArithmeticException("Algun número es demasiado grande para el combinatorio, especifica números más pequeños.");
		else
			System.out.println("El combinatorio de "+a+" y "+b+" es igual a: "+comb);
		System.out.println();
		
	}

	/**
	 * Proceso para calcular el combinatorio de dos números
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso3(Scanner sc) {
		
	}

	/**
	 * Proceso para comprobar si un número es perfecto
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso4(Scanner sc) {
		
	}
	
}
