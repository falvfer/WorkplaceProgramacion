package eje_t1;

import java.util.Scanner;

public class Ejemplo1_Suma {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crear variables inicializandolas
		int numero = 0;
		int numero2 = 0;
		int totalSuma = 0;
		// Crear el objeto Scanner usado más adelante para pedir números
		Scanner sc = new Scanner(System.in);
		//Pedir el primer número
		System.out.print("Escribe un número para sumar: ");
		numero = sc.nextInt();
		//Pedir el segundo número		
		System.out.print("Escribe el otro número: ");
		numero2 = sc.nextInt();
		//Sumar ambos numeros y guardar el resultado
		totalSuma = numero + numero2;
		//Decir el resultado por pantalla
		System.out.println(numero + " + " + numero2 + " = " + totalSuma);
		//Cerrar el objeto de Scanner
		sc.close();
	}
	
}
