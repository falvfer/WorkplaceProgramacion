package ejer01_10;

import java.util.Random;

public class Ejer01 {

	/*
	 * Crea un objeto de la clase Random, a continuación, genera un número aleatorio, y por último
	 * busca algún método que te informe del nombre de la clase a la que pertenece un objeto,
	 * así como del nombre del paquete.
	 * 
	 * Averigua cómo se usa y para qué sirve el método nanoTime de la clase System.
	 * ¿Podría servirnos para averiguar cuánto tarda en ejecutarse un determinado método,
	 * y así comprobar si es más o menos eficiente?
	 * 
	 * Realiza alguna prueba con los métodos de las clases Object y Objects.
	 */
	
	public static void main(String[] args) {
		
		long inicioProcedimiento = System.nanoTime();
		
		// Objeto aleatorio
		Random rdn = new Random();
		
		// Generar número aleatorio
		System.out.println(rdn.nextInt(100) +"\n");
		
		// Averiguar si pertenece a una clase o no
		if (rdn instanceof Random)
			System.out.println("Pertenece a la clase Random");
		else
			System.out.println("No pertenece a la clase Random");
		
		// Nombre del paquete y clase
		System.out.println("\n" + rdn.getClass().getName());
		// Nombre del paquete
		System.out.println(rdn.getClass().getPackageName());
		// Nombre de la clase
		System.out.println(rdn.getClass().getSimpleName());
		
		System.out.println();
		
		// System.nanoTime
		// Este proceso lo que hace es devolver el tiempo en nano segundos con un punto de
		// referencia indeterminado, se puede usar como lo he hecho para calcular el tiempo
		// de ejecución por ejemplo, y, según pone en la ayuda, el tiempo de referencia puede
		// ser en el futuro, por lo que puede dar valores negativos.
		System.out.println("Ha tardado " + (System.nanoTime() - inicioProcedimiento)/1000000d + " milisegundos en ejecutarse.");

	}
	
}
