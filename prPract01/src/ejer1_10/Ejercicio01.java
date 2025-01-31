package ejer1_10;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		// Hacer un programa que pida al usuario su edad, y muestre la edad que tendrá el próximo año.
		byte edad=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Escriba su edad: ");
		edad=sc.nextByte();
		System.out.println("Su edad el año que viene será: " + (edad+1));

		sc.close();
	}
}