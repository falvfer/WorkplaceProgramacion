package librerias;

import java.util.Random;
import java.util.Scanner;

public class LibreriaVector {

	public static String toString(int[] vector) {
		String cadena = "";
		
		for(int i = 0; i < vector.length; i++)
				cadena += vector[i] + " ";
		
		return cadena;
	}
	
	public static void cargarPorTeclado(Scanner sc, int[] vector) throws Exception {
		for (int i = 0; i<vector.length; i++) {
			System.out.print("Posición " + i + ": ");
			vector[i] = sc.nextInt();
			System.out.println();
		}
	}
	
	/**
	 * Cargar números aleatorios entre "min" y "max" (incluidos) para todas las posiciones del array
	 * @param min
	 * @param max
	 * @throws Exception
	 */
	public static void cargarAleatorio(int[] vector, int min, int max) throws Exception {
		max++; // Según la ayuda de Random, el máximo es excluido, por eso le sumo 1
		if (min >= max) throw new Exception("Error: El número mínimo para generar aleatoriamente es mayor o igual al máximo");

		Random rdn = new Random();

		for (int i = 0; i<vector.length; i++)
			vector[i] = rdn.nextInt(min,max+1);
	}
	
	/**
	 * Cargar numeros aleatorios entre 0 y 100 para todas las posiciones del array
	 * @throws Exception
	 */
	public static void cargarAleatorio(int[] vector) throws Exception {
		cargarAleatorio(vector, 0, 100);
	}
	
	/**
	 * Buscar el número máximo en el array, entre las posiciones "posInicio" y "posFin"
	 * @param posInicio
	 * @param posFin
	 * @return
	 */
	public static int maximo(int[] vector, int posInicio, int posFin) {
		int max = Integer.MIN_VALUE;
		for (int i = posInicio - 1; i < posFin; i++)
			if (vector[i] > max)
				max = vector[i];
		return max; // Devuelve Integer.MIN_VALUE como error
	}
	
	/**
	 * Buscar el número máximo en el array, a partir de la posición "posInicio"
	 * @param posInicio
	 * @return
	 */
	public static int maximo(int[] vector, int posInicio) {
		return maximo(vector, posInicio, vector.length);
	}

	/**
	 * Buscar el número máximo en el array entero
	 * @return
	 */
	public static int maximo(int[] vector) {
		return maximo(vector, 1, vector.length);
	}
	
	/**
	 * Buscar el número mínimo en el array, entre las posiciones "posInicio" y "posFin"
	 * @param posInicio
	 * @param posFin
	 * @return
	 */
	public static int minimo(int[] vector, int posInicio, int posFin) {
		int min = Integer.MAX_VALUE;
		for (int i = posInicio - 1; i < posFin; i++)
			if (vector[i] < min)
				min = vector[i];
		return min; // Devuelve Integer.MAX_VALUE como error
	}
	
	/**
	 * Buscar el número mínimo en el array, a partir de la posición "posInicio"
	 * @param posInicio
	 * @return
	 */
	public static int minimo(int[] vector, int posInicio) {
		return minimo(vector, posInicio, vector.length);
	}

	/**
	 * Buscar el número mínimo en el array entero
	 * @return
	 */
	public static int minimo(int[] vector) {
		return minimo(vector, 1, vector.length);
	}
	
	/**
	 * Sumar todos los valores del array
	 * @return
	 * @throws Exception
	 */
	public static long suma(int[] vector) throws Exception {
		long sumaArray = 0;
		for (int i = 0; i<vector.length; i++)
				sumaArray += vector[i];
		return sumaArray;
	}

	/**
	 * Busqueda lineal de un número "num" entre las posiciones "ini" y "fin"
	 * @param num
	 * @param ini
	 * @param fin
	 * @return
	 */
	public static int buscarLin(int[] vector, int num, int ini, int fin) {
		int cont = ini-2;
		
		do {
			cont++;
		} while (cont < fin && vector[cont] != num);
		
		if (cont == fin)
			return -1;
		
		return cont + 1;
	}

	/**
	 * Busqueda lineal de un número "num" desde la posición "ini"
	 * @param num
	 * @param ini
	 * @return
	 */
	public static int buscarLin(int[] vector, int num, int ini) {
		return buscarLin(vector, num, ini, vector.length);
	}
	
	/**
	 * Busqueda lineal de un número "num" en el array entero
	 * @param num
	 * @return
	 */
	public static int buscarLin(int[] vector, int num) {
		return buscarLin(vector, num, 1, vector.length);
	}
	
	/**
	 * Busqueda dicotómica de un número "num". El array tiene que estar
	 * previamente ordenado, si no el resultado es indeterminado.
	 * @param num
	 * @return
	 */
	public static int buscarDic(int[] vector, int num) {
		int ini = 0; int fin = vector.length-1;
		int pos = (ini+fin)/2;
		
		while (vector[pos] != num && ini <= fin) {
			
			if (vector[pos] < num)
				ini = pos+1;
			else
				fin = pos-1;
			
			pos = (ini+fin)/2;
		}
		
		if (vector[pos] == num)
			return pos + 1;
		
		return -1;
	}
	
	/**
	 * Ordenar el array usando el método de Burbuja
	 */
	public static void ordenarBurbuja(int[] vector) {
		int aux, i = vector.length - 1;
		int acciones;
		
		do {
			acciones = 0;
			for (int k = 0; k < i; k++) {
				if (vector[k]>vector[k+1]) {
					aux = vector[k];
					vector[k] = vector[k+1];
					vector[k+1] = aux;
					acciones++;
				}
			}
			i--;
		} while (i > 0 && acciones > 0);
	}
	
	/**
	 * Ordenar el array usando el método de Seleccion
	 */
	public static void ordenarSeleccion(int[] vector) {
		int aux, posMin, longitudArray = vector.length;
		
		for (int i = 0; i < longitudArray - 1; i++) {
			
			posMin = buscarLin(vector, minimo(vector, i+1), i+1)-1;
			
			if (vector[i] != vector[posMin]) {
				aux = vector[i];
				vector[i] = vector[posMin];
				vector[posMin] = aux;
			}
		}
	}
	
	/**
	 * Ordenar el array usando el método de Insercion
	 */
	public static void ordenarInsercion(int[] vector) {
		int esteNumero;
		int k;
		
		for (int i = 1; i < vector.length; i++) {
			esteNumero = vector[i];
			
			k = 0;
			while (esteNumero > vector[k]) k++;
			
			for (int l = i; l > k; l--)
				vector[l] = vector[l-1];
			
			vector[k] = esteNumero;
		}
	}
	
	/**
	 * Ordenar el array usando el método Shell
	 */
	public static void ordenarShell(int[] vector) {
		final int[] secuencia = {121, 40, 13, 4, 1};
		int longitud, pos;
		int[] grupo;
		
		for (int i = 0; i < secuencia.length; i++) {
			if (secuencia[i] < vector.length) {
				
				for (int k = 0; k+secuencia[i] < vector.length && k < secuencia[i]; k++) {
					
					longitud = 0;
					pos = k;
					
					while (pos < vector.length) {
						longitud++;
						pos += secuencia[i];
					}
					
					grupo = new int[longitud];

					pos = k;
					for (int l = 0; l < longitud; l++) {
						grupo[l] = vector[pos];
						pos += secuencia[i];
					}
					
					ordenarInsercion(grupo);

					pos = k;
					for (int l = 0; l < longitud; l++) {
						vector[pos] = grupo[l];
						pos += secuencia[i];
					}
				}
			}
		}
	}
	
	/**
	 * Método para desordenar el array, cambia de posiciones dos números
	 * aleatoriamente tantas veces como se indique en el "grado".
	 * @param grado
	 */
	public static void desordenar(int[] vector, int grado) {
		Random rdn = new Random();
		int posMax = vector.length;
		int pos1, pos2, aux;
		
		for (int i = 0; i < grado; i++) {
			pos1 = rdn.nextInt(0, posMax);
			pos2 = rdn.nextInt(0, posMax);
			
			if (pos1 != pos2) {
				aux = vector[pos1];
				vector[pos1] = vector[pos2];
				vector[pos2] = aux;
			}
		}
	}
	
	/**
	 * Método para desordenar el array, cambia de posiciones dos números aleatoriamente 100 veces.
	 */
	public static void desordenar(int[] vector) {
		desordenar(vector, 100);
	}
	
	/**
	 * Insertar un número "num" en el array en la posición "pos".
	 * @param num
	 * @param pos
	 */
	public static void insertar(int[] vector, int num, int pos) {
		pos--;
		
		if (pos >= 0 && pos < vector.length) {
			
			for (int i = vector.length - 1; i > pos ; i--)
				vector[i] = vector[i-1];
			
			vector[pos] = num;
		}
	}
	
	/**
	 * Insertar un número "num" en el array en la primera posición.
	 * @param num
	 */
	public static void insertar(int[] vector, int num) {
		insertar(vector, num, 1);
	}
	
	/**
	 * Borrar el número de una posición indicada ("pos") del array
	 * @param pos
	 */
	public static void borrar(int[] vector, int pos) {
		pos--;
		
		if (pos >= 0 && pos < vector.length) {
			
			for (int i = pos; i < vector.length - 1; i++)
				vector[i] = vector[i+1];
			
			vector[vector.length-1] = 0;
		}
	}
	
	/**
	 * Borrar la primera ocurrencia del número indicado ("num").
	 * @param num
	 */
	public static void borrarNum(int[] vector, int num) {
		borrar(vector, buscarLin(vector, num));
	}
	
	/**
	 * Borrar todas las ocurrencias del número indicado ("num").
	 * @param num
	 */
	public static void borrarTodos(int[] vector, int num) {
		int pos = buscarLin(vector, num);
		
		while (pos != -1) {
			borrar(vector, pos);	
			pos = buscarLin(vector, num);
		}
	}
	
	public static int[] rotar(int[] vector, int salto) {
		if (salto < 0)
			salto = vector.length + salto;
		
		int longitud = vector.length;
		salto %= longitud;
		
		int acciones = 0;
		for (int inicio = 0; acciones < vector.length; inicio++) {
			int posActual = inicio;
			int guardar = vector[posActual];
			do {
				int posSiguiente = (posActual+salto)%longitud;
				int poner = guardar;
				guardar = vector[posSiguiente];
				
				vector[posSiguiente] = poner;
				
				posActual = posSiguiente;
				acciones++;
			} while (posActual != inicio);
		}
		
		return vector;
	}
}
