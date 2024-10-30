package ejer1_10;

import java.util.Scanner;

public class Ejercicio09 {

	public static void main(String[] args) {
		// Una empresa maneja códigos numéricos con las siguientes características: 
		// 		Cada código consta de 4 dígitos. 
		// 		El primero representa una provincia. 
		// 		El segundo el tipo de operación. 
		// 		Los dos últimos el número de operación. 
		// Diseñar un programa que lea del teclado un número de 4 dígitos y
		// posteriormente imprima en pantalla la siguiente información:
		// 		PROVINCIA: & 
		// 		TIPO DE OPERACIÓN: & 
		// 		NUMERO DE OPERACIÓN: && 
		// Por ejemplo, para el código 2548 debería de dar como salida: 
		// 		PROVINCIA: 2 
		// 		TIPO DE OPERACIÓN: 5 
		// 		NUMERO DE OPERACIÓN: 48 
		// En caso de que el número no tenga exactamente 4 dígitos, en lugar del mensaje
		// anterior, habrá que imprimir en pantalla el siguiente mensaje de error:
		// 		ERROR: CÓDIGO INVÁLIDO.

		// Crear la variable de código
		short codigo = 0;
		byte provincia = 0;
		byte operacion = 0;
		byte numOperacion = 0;

		// Preguntar por pantalla el código, crear el objeto scanner, leer el código, cerrar el objeto Scanner
		System.out.print("Especifique el código: ");
		Scanner sc = new Scanner(System.in);
		codigo = (short) Math.abs(sc.nextShort()); // Hacerle el absoluto para evitar números negativos
		sc.close();

		// Comprobar que sea un código válido
		if ((codigo > 9999) || (codigo < 1000))
			System.out.println("Error: Código inválido.");
		
		else {
			// Calculos de la provincia, operación y número de operación
			provincia = (byte) (codigo / 1000);
			operacion = (byte) (codigo % 1000 / 100);
			numOperacion = (byte) (codigo % 100);

			// Escribir por pantalla todos los datos
			System.out.println("Provincia: " + provincia);
			System.out.println("Tipo de operacion: " + operacion);
			System.out.println("Número de operación: " + numOperacion);
		}
	}

}
