package ejer10_Libreria;

import java.util.Random;
import java.util.Scanner;

public class LiberiaObjeto {

// Variables de instancia
	private int[] array;

// Getters y Setters
	public int[] getArray() {return array;}
	public void setArray(int[] array) {this.array = array;}

// Constructores
	public LiberiaObjeto(int[] array) {
		this.array = array;
	}
	
	public LiberiaObjeto(int longitud) {
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
	
	public int minimo() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i<this.array.length; i++)
			if (this.array[i] < min)
				min = this.array[i];
		return min;
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
	
	public int buscarDic(int num) {
		
	}
	
// toString
	@Override
	public String toString() {
		String cadena = "";
		for (int i = 0; i<this.array.length; i++)
			cadena += this.array[i] + " ";
		return cadena;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
