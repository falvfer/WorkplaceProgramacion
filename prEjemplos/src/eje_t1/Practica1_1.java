package eje_t1;

import java.util.Scanner;

public class Practica1_1 {

	public static void main(String[] args) {
		// Hacer un programa que pida al usuario su edad, y muestre la edad que tendrá el próximo año.
		int edad=0;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Escriba su edad: ");
		edad=sc.nextInt();
		edad++;
		System.out.println("Su edad el año que viene será: " + edad);

		sc.close();
	}

}
