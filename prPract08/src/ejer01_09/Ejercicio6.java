package ejer01_09;

import java.util.Random;

public class Ejercicio6 {

	/**
	 * Desarrolla un programa que lea las notas de un determinado examen,
	 * y las almacene en un array, mostrando a continuación, la nota media,
	 * la nota más alta y la nota más baja. El programa lo primero que
	 * solicitará será el número de alumnos que han realizado el examen,
	 * y en función de ese valor se definirá el array.
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		// Objeto Random
		Random rdn = new Random();

		// Definir un array de 4 elementos de tipo entero
		float sumaNotas = 0, notaMax = Float.MIN_VALUE, notaMin = Float.MAX_VALUE;
		float[] notas = new float[rdn.nextInt(1,33)]; // Tamaño del array aleatorio para facilitar
													  // la simulación (cantidad aleatoria de alumnos)
		
		// Simular el pedir valores por teclado para los componentes del array
		System.out.println("Cantidad de notas: " + notas.length);
		System.out.print("Notas: ");
		for (int i = 0; i<notas.length; i++) {
			notas[i] = Math.round(rdn.nextFloat(0,10) * 100) / 100f;
			sumaNotas += notas[i];
			if (notas[i] > notaMax) notaMax = notas[i];
			if (notas[i] < notaMin) notaMin = notas[i];
			System.out.print(notas[i] + " ");
		}
		
		// Notas más alta y baja
		System.out.println("\nNota media: " + sumaNotas / notas.length);
		System.out.println("Nota más alta: " + notaMax);
		System.out.println("Nota más baja: " + notaMin);

	}

}
