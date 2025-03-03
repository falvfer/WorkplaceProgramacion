package pract1_Arrays;

import java.util.Scanner;

import librerias.LibreriaMatriz;

public class Ejer3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Especifica el tamaño del cuadrado: ");
		int longitud = sc.nextByte();
		int[][] cuadrado = new int[longitud][longitud];
		int tam = (int)Math.pow(longitud, 2);
		
		int x = longitud/2, y = 0;
		for (int cont = 1; cont <= tam; cont++) {
			cuadrado[y][x] = cont;
			if (cont%longitud == 0) {
				y = (y+1)%longitud;
			} else {
				x = (x+1)%longitud;
				y = (y-1)%longitud;
			}
			if (y == -1)
				y = longitud-1;
		}
		
		System.out.println(LibreriaMatriz.toString(cuadrado));
		
		sc.close();
		
		
		
		
	}
}
