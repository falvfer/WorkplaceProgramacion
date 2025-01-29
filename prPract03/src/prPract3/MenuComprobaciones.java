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
	 * Proceso para pedir al usuario si quiere calcular de forma recursiva o con bucle.
	 * @param sc (Exportar Scanner)
	 * @return byte --> 1 = Bucle / 2 = Recursividad
	 */
	private static byte elegirBucleRecursivo(Scanner sc) {
		System.out.println("¿Cómo quiere hacerlo?");
		System.out.println("1. Con un bucle");
		System.out.println("2. De forma recursiva");
		System.out.print("\tElija una opción: ");
		return sc.nextByte();
	}

	/**
	 * Proceso para calcular el factorial de un número
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso1(Scanner sc) {
		
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
	private static void proceso2(Scanner sc) {
		
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
	 * Proceso para calcular los números primos entre dos números
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso3(Scanner sc) {
		int num1 = pedirInt(sc), num2 = pedirOtroInt(sc);
		System.out.println();
		System.out.print("Los números primos entre "+num1+" y "+num2+" son: ");
		
		for (int i = num1; i<=num2; i++)
			if (MiLibreria.isPrimo(i)) System.out.print(i+" ");
	}
	
	private static void proceso4(Scanner sc) {
		int num1 = pedirInt(sc), num2 = pedirOtroInt(sc);
		System.out.println();
		System.out.print("Los números perfectos entre "+num1+" y "+num2+" son: ");
		
		for (int i = num1; i<=num2; i++)
			if (MiLibreria.isPerfecto(i)) System.out.print(i+" ");
	}
	
	private static void proceso5(Scanner sc) {
		int num1 = pedirInt(sc), num2 = pedirOtroInt(sc);
		System.out.println();
		System.out.println("Los números amigos entre "+num1+" y "+num2+" son:");
		
		for (int i = num1; i<=num2; i++)
			for (int k = i; k<=num2; k++)
				if (MiLibreria.isAmigo(i,k)) System.out.println(i+" y "+k);
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

	/**
	 * Proceso para comprobar si un número es primo
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso9(Scanner sc) {
		
		int num = pedirInt(sc);
		
		if (num==0)
			throw new ArithmeticException("0 no es 'primo' ni 'no primo'.");
		else if (MiLibreria.isPrimo(num))
			System.out.println("El número "+num+" es primo.");
		else
			System.out.println("El número "+num+" no es primo.");
	}

	/**
	 * Proceso para comprobar si un número es perfecto
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso10(Scanner sc) {
		
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
	private static void proceso11(Scanner sc) {

		int num1 = pedirInt(sc), num2 = pedirOtroInt(sc);
		
		if (MiLibreria.isAmigo(num1,num2))
			System.out.println(num1+" y "+num2+" son números amigos.");
		else
			System.out.println(num1+" y "+num2+" no son números amigos.");
	}
	
	/**
	 * Proceso para calcular el MCD de dos números
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso12(Scanner sc) {
		int num1, num2;
		byte opt = elegirBucleRecursivo(sc);
		System.out.println();
		
		if (opt == 1 || opt == 2) {
			num1 = pedirInt(sc);
			num2 = pedirOtroInt(sc);
			
			if (opt == 1)
				System.out.println("El MCD de "+num1+" y "+num2+" es igual a "+MiLibreria.mcdWhile(num1, num2));
			else
				System.out.println("El MCD de "+num1+" y "+num2+" es igual a "+MiLibreria.mcdRecursivo(num1, num2));
			
		} else
			throw new InputMismatchException("Error: Opción no válida.");
	}

	/**
	 * Proceso para calcular el Fibonacci de una posición de la serie
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso13 (Scanner sc) {
		int num;
		byte opt = elegirBucleRecursivo(sc);
		System.out.println();
		
		if (opt == 1 || opt == 2) {
			num = pedirInt(sc);
			if (num<0)
				throw new ArithmeticException("Error: No se puede hacer fibonacci de números negativos.");
			else {
				if (opt == 1)
					System.out.println("La posición "+num+" de la serie de fibonacci es "+MiLibreria.fibFor(num));
				else
					System.out.println("La posición "+num+" de la serie de fibonacci es "+MiLibreria.fibRecursivo(num));
			}
		} else
			throw new InputMismatchException("Error: Opción no válida.");
	}
	
	/**
	 * Proceso para calcular la potencia de un número
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso14 (Scanner sc) {
		int base, exp;
		
		System.out.print("Especifique la base: ");
		base = sc.nextInt();
		System.out.print("Especifique el exponente: ");
		exp = sc.nextInt();
		
		System.out.println();
		System.out.println("El resultado de "+base+"^"+exp+" es igual a "+MiLibreria.potenciaRecursiva(base, exp));
	}
	
	/**
	 * Proceso para calcular la suma de la serie de Fibonacci hasta una posición dada
	 * @param sc (Exportar Scanner)
	 */
	private static void proceso15 (Scanner sc) {
		int pos = pedirInt(sc);
		if (pos<0)
			throw new ArithmeticException("No hay posiciones negativas en la serie de Fibonacci");
		else
			System.out.println("La suma de la serie de fibonacci hasta la posición "+pos+" es igual a "+MiLibreria.sumaFibRecursivo(pos));
	}
	
	/**
	 * Menú usado para mostrar todas las opciónes del programa
	 */
	private static void menu() {
		System.out.println("0. Otras opciones");
		System.out.println("1. Calcular el factorial de un número.");
		System.out.println("2. Calcular el combinatorio de dos números.");
		System.out.println("3. Visualizar los números primos que hay entre dos números.");
		System.out.println("4. Visualizar por pantalla los de números perfectos que hay entre dos números.");
		System.out.println("5. Visualizar por pantalla las parejas de números amigos que hay entre dos números.");
		System.out.println("6. Comprobar si dos números son primos entre sí.");
		System.out.println("7. Calcular la función de euler de un número.");
		System.out.println("8. Salir del programa.");
	}
	
	private static void menuOtros() {
		System.out.println("8. Salir del programa.");
		System.out.println("9. Comprobar si un número es primo o no.");
		System.out.println("10. Comprobar si un número es perfecto.");
		System.out.println("11. Comprobar si dos números son amigos.");
		System.out.println("12. Calcular el MCD de dos números.");
		System.out.println("13. Calcular el fibonacci dada la posición de la serie.");
		System.out.println("14. Calcular la potencia de un número.");
		System.out.println("15. Calcular la suma de la serie de Fibonacci.");
	}
	
	public static void main(String[] args) {
		
		byte opcion = -1;
		boolean terminar = false;
		Scanner sc = new Scanner(System.in);
		
		do {
			try {
				menu();
				System.out.print("\tEspecifica la opcion (1..9): ");
				opcion = sc.nextByte();
				
				if (opcion == 0) {
					System.out.println();
					menuOtros();
					System.out.print("\tEspecifica la opcion (9..16): ");
					opcion = sc.nextByte();
				}
				
				System.out.println();
				
				switch(opcion) {
				case 1 -> proceso1(sc);
				case 2 -> proceso2(sc);
				case 3 -> proceso3(sc);
				case 4 -> proceso4(sc);
				case 5 -> proceso5(sc);
				case 6 -> proceso6(sc);
				case 7 -> proceso7(sc);
				case 8 -> terminar = true;
				case 9 -> proceso9(sc);
				case 10 -> proceso10(sc);
				case 11 -> proceso11(sc);
				case 12 -> proceso12(sc);
				case 13 -> proceso13(sc);
				case 14 -> proceso14(sc);
				case 15 -> proceso15(sc);
				default -> throw new InputMismatchException("Error: Opción no válida.");
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
				System.out.println();
			}
			try {Thread.sleep(800);} catch (InterruptedException e) {}
		} while (!terminar);
		sc.close();
	}
	
}
