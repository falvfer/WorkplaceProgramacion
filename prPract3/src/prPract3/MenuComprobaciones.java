package prPract3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuComprobaciones {

	/**
	 * Proceso para pedir un número entero por consola
	 * @param sc (Exportar Scanner)
	 * @return int --> El número especificado por el usuario
	 */
	private static int pedirInt(Scanner sc) {
		System.out.print("Especifique un número entero: ");
		return sc.nextInt();
	}
	
	/**
	 * Proceso para pedir "otro" número entero por consola
	 * @param sc (Exportar Scanner)
	 * @return int --> El número especificado por el usuario
	 */
	private static int pedirOtroInt(Scanner sc) {
		System.out.print("Especifique otro número entero: ");
		return sc.nextInt();
	}
	
	/**
	 * Proceso para comprobar si un número es primo
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso1(Scanner sc) {
		
		int num = pedirInt(sc);
		
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
		
		int num = pedirInt(sc);
		long fact = MiLibreria.factorial(num);
		
		if (fact == -1)
			throw new ArithmeticException("No se puede hacer el factorial de "+num);
		else if (fact == -2)
			throw new ArithmeticException("Es un número muy grande para el factorial, prueba con otro más pequeño.");
		else
			System.out.println("El factorial de "+num+" es igual a: "+fact);
	}

	/**
	 * Proceso para calcular el combinatorio de dos números
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso3(Scanner sc) {
		
		int a = pedirInt(sc), b = pedirOtroInt(sc);
		int comb = MiLibreria.combinatorio(a, b);
		
		if (comb == -1)
			throw new ArithmeticException("No se puede hacer el combinatorio de "+a+" y "+b+" porque uno de los números es negativo.");
		else if (comb == -2)
			throw new ArithmeticException("Algun número es demasiado grande para el combinatorio, especifica números más pequeños.");
		else
			System.out.println("El combinatorio de "+a+" y "+b+" es igual a: "+comb);
	}

	/**
	 * Proceso para comprobar si un número es perfecto
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso4(Scanner sc) {
		
		int num = pedirInt(sc);
		
		if (MiLibreria.isPerfecto(num))
			System.out.println(num+" es un número perfecto.");
		else
			System.out.println(num+" no es un número perfecto.");
	}
	
	/**
	 * Proceso para comprobar si dos números son amigos
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso5(Scanner sc) {

		int num1 = pedirInt(sc), num2 = pedirOtroInt(sc);
		
		if (MiLibreria.isAmigo(num1,num2))
			System.out.println(num1+" y "+num2+" son números amigos.");
		else
			System.out.println(num1+" y "+num2+" no son números amigos.");
	}
	
	/**
	 * Proceso para comprobar si dos números son coprimos
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso6(Scanner sc) {
		int num1 = pedirInt(sc), num2 = pedirOtroInt(sc);
		
		if (MiLibreria.isCoprimos(num1,num2))
			System.out.println(num1+" y "+num2+" son primos entre sí.");
		else
			System.out.println(num1+" y "+num2+" no son primos entre sí.");
	}

	/**
	 * Proceso para calcular el Euler de un número
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso7(Scanner sc) {
		int num = pedirInt(sc);
		
		System.out.println("El Euler de "+num+" es "+MiLibreria.funcionEuler(num));
	}
	
	private static void proceso8(Scanner sc) {
		
	}
	
	private static void menu() {
		System.out.println("0. Salir del programa");
		System.out.println("1. Comprobar si un número es primo o no");
		System.out.println("2. Calcular el factorial de un número");
		System.out.println("3. Calcular el combinatorio de dos números");
		System.out.println("4. Comprobar si un número es perfecto");
		System.out.println("5. Comprobar si dos números son amigos");
		System.out.println("6. Comprobar si dos números son primos entre sí");
		System.out.println("7. Calcular el euler de un número");
		System.out.println("8. Calcular el MCD de dos números");
	}
	
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
				case 5 -> proceso5(sc);
				case 6 -> proceso6(sc);
				case 7 -> proceso7(sc);
				case 8 -> proceso8(sc);
				default -> System.out.println("Error: Opción no válida.");
				}
				
				System.out.println();
				
				Thread.sleep(800);
					
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
			} catch (InterruptedException e) {}
		} while (!terminar);
		sc.close();
	}
	
}
