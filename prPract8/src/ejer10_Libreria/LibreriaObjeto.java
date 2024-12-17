package ejer10_Libreria;

import java.util.Random;
import java.util.Scanner;

public class LibreriaObjeto {

// Variables de instancia
	private int[] array;

// Getters y Setters
	public int[] getArray() {return array;}
	public void setArray(int[] array) {this.array = array;}

// Constructores
	public LibreriaObjeto(int[] array) {
		this.array = array;
	}
	
	public LibreriaObjeto(int longitud) {
		this(new int[longitud]);
	}

// Métodos públicos
	public void cargarPorTeclado(Scanner sc) throws Exception {
		for (int i = 0; i<this.array.length; i++) {
			System.out.print("Posición " + i + ": ");
			this.array[i] = sc.nextInt();
			System.out.println();
		}
	}
	
	public void cargarAleatorio(int min, int max) throws Exception {
		max++; // Según la ayuda de Random, el máximo es excluido, por eso le sumo 1
		if (min >= max) throw new Exception("Error: El número mínimo para generar aleatoriamente es mayor o igual al máximo");

		Random rdn = new Random();

		for (int i = 0; i<this.array.length; i++)
			this.array[i] = rdn.nextInt(min,max+1);
	}
	
	public int maximo() {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i<this.array.length; i++)
			if (this.array[i] > max)
				max = this.array[i];
		return max;
	}
	
	public int maximo(int posInicio) {
		int max = Integer.MIN_VALUE;
		for (int i = posInicio - 1; i<this.array.length; i++)
			if (this.array[i] > max)
				max = this.array[i];
		return max; // Devuelve Integer.MIN_VALUE como error
	}
	
	public int maximo(int posInicio, int posFin) {
		int max = Integer.MIN_VALUE;
		for (int i = posInicio - 1; i < posFin; i++)
			if (this.array[i] > max)
				max = this.array[i];
		return max; // Devuelve Integer.MIN_VALUE como error
	}
	
	public int minimo() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i<this.array.length; i++)
			if (this.array[i] < min)
				min = this.array[i];
		return min;
	}
	
	public int minimo(int posInicio) {
		int min = Integer.MAX_VALUE;
		for (int i = posInicio - 1; i<this.array.length; i++)
			if (this.array[i] < min)
				min = this.array[i];
		return min; // Devuelve Integer.MAX_VALUE como error
	}
	
	public int minimo(int posInicio, int posFin) {
		int min = Integer.MAX_VALUE;
		for (int i = posInicio - 1; i < posFin; i++)
			if (this.array[i] < min)
				min = this.array[i];
		return min; // Devuelve Integer.MAX_VALUE como error
	}
	
	public long suma() throws Exception {
		long sumaArray = 0;
		for (int i = 0; i<this.array.length; i++)
				sumaArray += this.array[i];
		return sumaArray;
	}
	
	public int buscarLin(int num) {
		int cont = -1;
		
		do {
			cont++;
		} while (this.array[cont] != num && cont<this.array.length);
		
		if (this.array[cont] == num)
			return cont;
		
		return -1;
	}
	
	public int buscarLin(int num, int ini) {
		int cont = ini-1;
		
		do {
			cont++;
		} while (this.array[cont] != num && cont<this.array.length);
		
		if (this.array[cont] == num)
			return cont;
		
		return -1;
	}
	
	public int buscarLin(int num, int ini, int fin) {
		int cont = -1;
		
		do {
			cont++;
		} while (this.array[cont] != num && cont < fin);
		
		if (this.array[cont] == num)
			return cont;
		
		return -1;
	}
	
	public int buscarDic(int num) {
		int ini = 0; int fin = this.array.length-1;
		int pos = (ini+fin)/2;
		
		while (this.array[pos] != num && ini <= fin) {
			
			if (this.array[pos] < num)
				ini = pos+1;
			else
				fin = pos-1;
			
			pos = (ini+fin)/2;
		}
		
		if (this.array[pos] == num) return pos;
		
		return -1;
	}
	
	public void ordenarBurbuja() {
		int aux, i = this.array.length - 1;
		int acciones;
		
		do {
			acciones = 0;
			for (int k = 0; k < i; k++) {
				if (this.array[k]>this.array[k+1]) {
					aux = this.array[k];
					this.array[k] = this.array[k+1];
					this.array[k+1] = aux;
					acciones++;
				}
			}
			i--;
		} while (i > 0 && acciones > 0);
	}
	
	public void ordenarSeleccion() {
		int aux, posMin, longitudArray = this.array.length;
		
		for (int i = 0; i < longitudArray - 1; i++) {
			
			posMin = this.buscarLin(this.minimo(i+1), i+1);
			
			if (this.array[i] != this.array[posMin]) {
				aux = this.array[i];
				this.array[i] = this.array[posMin];
				this.array[posMin] = aux;
			}
		}
	}
	
	public void ordenarInsercion() {
		
	}
	
	public void ordenarShell() {
		
	}
	
	public void desordenar() {
		Random rdn = new Random();
		int posMax = this.array.length;
		int pos1, pos2, aux;
		
		for (int i = 0; i < 100; i++) {
			pos1 = rdn.nextInt(0, posMax);
			pos2 = rdn.nextInt(0, posMax);
			
			if (pos1 != pos2) {
				aux = this.array[pos1];
				this.array[pos1] = this.array[pos2];
				this.array[pos2] = aux;
			}
		}
	}
	
	public void desordenar(int grado) {
		
	}
	
	// + rotar derecha e izquierda el array
	// + buscar ocurrencias de un número en un array y
	//   devolver todas las posiciones como un array
	
// toString
	@Override
	public String toString() {
		String cadena = "";
		for (int i = 0; i<this.array.length; i++)
			cadena += this.array[i] + " ";
		return cadena;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
