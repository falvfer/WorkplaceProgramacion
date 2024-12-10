package eje_t5_arrays;

import java.util.Random;
import java.util.Scanner;

public class Ejemplo2 {

	public static void main(String[] args) {
		
		// Objeto Random para uso posterior
		Random rdn = new Random();
		
		// Definir un array de 4 elementos de tipo entero
		int[] array = new int[12];

		
		// Generar valores aleatorios y mostrarlos por pantalla
		System.out.print("Contenido del array: ");
		for (int i = 0; i<array.length; i++) {
			array[i] = rdn.nextInt(0,50);
			System.out.print(array[i] + " ");
		}
		
		// Crear un array de 8 elementos de tipo entero asignando el valor directamente
		int[] array2 = {1, 23, 245, 23, 121, 0, -63, -100};
		
		System.out.print("\nContenido del array2: ");
		for (int i = 0; i<array2.length; i++)
			System.out.print(array2[i] + " ");
		
		// Crear un tercer array cuyos elementos son de tipo caracter
		char[] array3 = {'a','b','c','$','€','@'};
		for (int i = 0; i<array3.length; i++)
			System.out.print(array3[i] + " ");
		
		
		
		
		
		
		
		
	}
	
}
