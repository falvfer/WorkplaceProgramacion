package ejer10_Libreria;

import java.util.Random;
import java.util.Scanner;

public class ArrayEntero {

// Variables de instancia
	private int[] array;

// Getters y Setters
	public int[] getArray() {return array;}
	public void setArray(int[] array) {this.array = array;}

// Constructores
	public ArrayEntero(int[] array) {
		this.array = array;
	}
	
	public ArrayEntero(int longitud) {
		this(new int[longitud]);
	}
	
	public ArrayEntero() {
		this(new int[1]);
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
	
	public void cargarAleatorio() throws Exception {
		this.cargarAleatorio(0, 100);
	}
	
	public int maximo(int posInicio, int posFin) {
		int max = Integer.MIN_VALUE;
		for (int i = posInicio - 1; i < posFin; i++)
			if (this.array[i] > max)
				max = this.array[i];
		return max; // Devuelve Integer.MIN_VALUE como error
	}
	
	public int maximo(int posInicio) {
		return this.maximo(posInicio, this.array.length);
	}
	
	public int maximo() {
		return this.maximo(1, this.array.length);
	}
	
	public int minimo(int posInicio, int posFin) {
		int min = Integer.MAX_VALUE;
		for (int i = posInicio - 1; i < posFin; i++)
			if (this.array[i] < min)
				min = this.array[i];
		return min; // Devuelve Integer.MAX_VALUE como error
	}
	
	public int minimo(int posInicio) {
		return this.minimo(posInicio, this.array.length);
	}
	
	public int minimo() {
		return this.minimo(1, this.array.length);
	}
	
	public long suma() throws Exception {
		long sumaArray = 0;
		for (int i = 0; i<this.array.length; i++)
				sumaArray += this.array[i];
		return sumaArray;
	}

	public int buscarLin(int num, int ini, int fin) {
		int cont = ini-2;
		
		do {
			cont++;
		} while (cont < fin && this.array[cont] != num);
		
		if (cont == fin)
			return -1;
		
		return cont + 1;
	}
	
	public int buscarLin(int num, int ini) {
		return this.buscarLin(num, ini, this.array.length);
	}
	
	public int buscarLin(int num) {
		return this.buscarLin(num, 1, this.array.length);
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
		
		if (this.array[pos] == num)
			return pos + 1;
		
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
			
			posMin = this.buscarLin(this.minimo(i+1), i+1)-1;
			
			if (this.array[i] != this.array[posMin]) {
				aux = this.array[i];
				this.array[i] = this.array[posMin];
				this.array[posMin] = aux;
			}
		}
	}
	
	public void ordenarInsercion() {
		int esteNumero;
		int k;
		
		for (int i = 1; i < this.array.length; i++) {
			esteNumero = this.array[i];
			
			k = 0;
			while (esteNumero > this.array[k]) k++;
			
			for (int l = i; l > k; l--)
				this.array[l] = this.array[l-1];
			
			this.array[k] = esteNumero;
		}
	}
	
	public void ordenarShell() {
		final int[] secuencia = {121, 40, 13, 4, 1};
		int longitud, pos;
		ArrayEntero grupo = new ArrayEntero();
		
		for (int i = 0; i < secuencia.length; i++) {
			if (secuencia[i] < this.array.length) {
				
				for (int k = 0; k+secuencia[i] < this.array.length && k < secuencia[i]; k++) {
					
					longitud = 0;
					pos = k;
					
					while (pos < this.array.length) {
						longitud++;
						pos += secuencia[i];
					}
					
					grupo.array = new int[longitud];

					pos = k;
					for (int l = 0; l < longitud; l++) {
						grupo.array[l] = this.array[pos];
						pos += secuencia[i];
					}
					
					grupo.ordenarInsercion();

					pos = k;
					for (int l = 0; l < longitud; l++) {
						this.array[pos] = grupo.array[l];
						pos += secuencia[i];
					}
				}
			}
		}
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
		Random rdn = new Random();
		int posMax = this.array.length;
		int pos1, pos2, aux;
		
		for (int i = 0; i < grado; i++) {
			pos1 = rdn.nextInt(0, posMax);
			pos2 = rdn.nextInt(0, posMax);
			
			if (pos1 != pos2) {
				aux = this.array[pos1];
				this.array[pos1] = this.array[pos2];
				this.array[pos2] = aux;
			}
		}
	}
	
	public void insertar(int num, int pos) {
		pos--;
		
		if (pos >= 0 && pos < this.array.length) {
			
			for (int i = this.array.length - 1; i > pos ; i--)
				this.array[i] = this.array[i-1];
			
			this.array[pos] = num;
		}
	}
	
	public void insertar(int num) {
		this.insertar(num, 1);
	}
	
	public void borrar(int pos) {
		pos--;
		
		if (pos >= 0 && pos < this.array.length) {
			
			for (int i = pos; i < this.array.length - 1; i++)
				this.array[i] = this.array[i+1];
			
			this.array[this.array.length-1] = 0;
		}
	}
	
	public void borrarNum(int num) {
		this.borrar(this.buscarLin(num));
	}
	
	public void borrarTodos(int num) {
		int pos = this.buscarLin(num);
		
		while (pos != -1) {
			this.borrar(pos);	
			pos = this.buscarLin(num);
		}
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
