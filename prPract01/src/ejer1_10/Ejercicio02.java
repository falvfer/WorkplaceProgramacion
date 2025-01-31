package ejer1_10;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		// Escribir un programa que pida el año actual y el de nacimiento del usuario.
		// Debe calcular su edad, suponiendo que en el año en curso el usuario ya ha cumplido años.
		Scanner sc = new Scanner(System.in);
		short annoActual=0;
		short annoUsuario=0;
		byte edad=0;
		
		System.out.print("Escriba el año actual: ");
		annoActual=sc.nextShort();
		System.out.print("Escriba en que año nació: ");
		annoUsuario=sc.nextShort();
		edad=(byte)(annoActual-annoUsuario);
		System.out.println("Su edad es: " + edad + " años (Dando por echo que ha cumplido años en este año)");

		sc.close();
	}
}