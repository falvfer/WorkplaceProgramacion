package ejer10_Libreria;

import java.util.Scanner;

public class TestLibrerias {
	
	private static void menu() {
		System.out.println("0. Generar otro array");
		System.out.println("1. Mostrar array");
		System.out.println("2. Elemento máximo del array");
		System.out.println("3. Elemento mínimo del array");
		System.out.println("4. Suma de los elementos");
		System.out.println("5. Buscar un número");
		System.out.println("6. Ordenar el array");
		System.out.println("7. Desordenar el array");
		System.out.println("8. Insertar número");
		System.out.println("9. Borrar número");
		System.out.println("10. Terminar");
	}
	
	private static void menuBuscar() {
		System.out.println("1. Buscar en array desordenado (lineal)");
		System.out.println("2. Buscar en array ordenado (dicotómica)");
	}
	
	private static void menuOrdenar() {
		System.out.println("1. Ordenar usando metodo de burbuja");
		System.out.println("2. Ordenar usando metodo de selección");
		System.out.println("3. Ordenar usando metodo de inserción");
		System.out.println("4. Ordenar usando metodo Shell");
	}
	
	private static void menuInsertar() {
		System.out.println("1. Insertar número en la primera posición");
		System.out.println("2. Insertar número en la posición indicada");
	}
	
	private static void menuBorrar() {
		System.out.println("1. Borrar el número de una posición especificada");
		System.out.println("2. Borrar un determinado número (primera ocurrencia)");
		System.out.println("3. Borrar todas las ocurrencias de un determinado número");
	}

	private static ArrayEntero generarArray(Scanner sc) throws Exception {
		System.out.print("Especifique la longitud del array: ");
		ArrayEntero vector = new ArrayEntero(sc.nextInt());
		System.out.println();
		
		sc.nextLine();
		System.out.print("Quiere rellenarlo aleatoriamente, o introducir los datos manualmente? [A/m]: ");
		
		if (Character.toUpperCase(sc.nextLine().charAt(0)) == 'M') {
			
			vector.cargarPorTeclado(sc);
			
		} else {

			System.out.println();
			System.out.print("Especificar el mínimo y el máximo? [N/s]: ");
			
			if (Character.toUpperCase(sc.nextLine().charAt(0)) == 'S') {

				System.out.println();
				System.out.print("Número mínimo (incluido): ");
				int min = sc.nextInt();
				
				System.out.print("Número máximo (incluido): ");
				int max = sc.nextInt();

				vector.cargarAleatorio(min, max);
				
			} else {
				vector.cargarAleatorio();
			}
		}
		
		return vector;
		
	}
	
	private static void proceso1(Scanner sc, ArrayEntero vector) throws Exception {
		// 5. Buscar un número
		int pos, num;
		
		System.out.print("Especifique el número a buscar: ");
		num = sc.nextInt();
		System.out.println();
		
		menuBuscar();
		System.out.print("Especifique el método de búsqueda: ");
		
		switch (sc.nextByte()) {
			case 1 -> {
				pos = vector.buscarLin(num);
				System.out.println(pos==-1?"No existe":"Está en la posición " + pos);
			}
			case 2 -> {
				pos = vector.buscarDic(num);
				System.out.println(pos==-1?"No existe":"Está en la posición " + pos);
			}
		}
	}
	
	private static void proceso2(Scanner sc, ArrayEntero vector) throws Exception {
		// 6. Ordenar el array
		menuOrdenar();
		System.out.print("Especifique el método de ordenación: ");
		
		switch (sc.nextByte()) {
			case 1 -> vector.ordenarBurbuja();
			case 2 -> vector.ordenarSeleccion();
			case 3 -> vector.ordenarInsercion();
			case 4 -> vector.ordenarShell();
		}
		
	}
	
	private static void proceso3(Scanner sc, ArrayEntero vector) throws Exception {
		// 7. Desordenar el array
		System.out.println("Nota: El grado de desorden por defecto es \"100\", esto indica la cantidad de movimientos aleatorios que se van a realizar.");
		System.out.print("¿Desea indicar el grado de desorden? [N/s]: ");
		sc.nextLine();
		
		if (Character.toUpperCase(sc.nextLine().charAt(0)) == 'S') {
			System.out.println();
			System.out.print("Indique el grado: ");
			vector.desordenar(sc.nextInt());
		} else {
			vector.desordenar();
		}
	}
	
	private static void proceso4(Scanner sc, ArrayEntero vector) throws Exception {
		// 8. Insertar número
		System.out.print("Especifique el número a insertar: ");
		int num = sc.nextInt();

		System.out.println();
		menuInsertar();
		System.out.print("Especifique la opción: ");
		
		switch (sc.nextByte()) {
			case 1 -> vector.insertar(num);
			case 2 -> {
				System.out.println();
				System.out.print("¿En qué posición desea insertar el número? ");
				vector.insertar(num, sc.nextInt());
			}
		}
	}
	
	private static void proceso5(Scanner sc, ArrayEntero vector) throws Exception {
		// 9. Borrar número
		menuBorrar();
		System.out.print("Especifique la opción: ");
		
		switch (sc.nextByte()) {
			case 1 -> {
				System.out.print("\nEspecifique la posición: ");
				vector.borrar(sc.nextInt());
			}
			case 2 -> {
				System.out.print("\nEspecifique el número: ");
				vector.borrarNum(sc.nextInt());
			}
			case 3 -> {
				System.out.print("\nEspecifique el número: ");
				vector.borrarTodos(sc.nextInt());
			}
		}
		
	}
	
	public static void main(String[] args) {
		boolean salir = false, generarOtro;
		Scanner sc = new Scanner(System.in);
		byte opcion;
		
		do {
			
			generarOtro = false;
			try {
				ArrayEntero vector = generarArray(sc);
				
				do {

					System.out.println();
					
					menu();
					System.out.print("¿Qué desea hacer? ");
					opcion = sc.nextByte();
					
					System.out.println();
					
					switch (opcion) {
						case 0 -> generarOtro = true;
						case 1 -> System.out.println(vector);
						case 2 -> System.out.println("El elemento máximo es: " + vector.maximo());
						case 3 -> System.out.println("El elemento mínimo es: " + vector.minimo());
						case 4 -> System.out.println("La suma de todos los elementos es: " + vector.suma());
						case 5 -> proceso1(sc, vector);
						case 6 -> proceso2(sc, vector);
						case 7 -> proceso3(sc, vector);
						case 8 -> proceso4(sc, vector);
						case 9 -> proceso5(sc, vector);
						case 10 -> {generarOtro = true; salir = true;}
					}
					
				} while (!generarOtro);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} while (!salir);
		
		sc.close();
	}
	
}
