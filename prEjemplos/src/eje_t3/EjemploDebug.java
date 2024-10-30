package eje_t3;

import java.util.Scanner;

public class EjemploDebug {

	public static void main(String[] args) {
		
		// Declaración de las variables
		int numero;
		byte numTabla;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nIntroduzca un número: ");
		numero = sc.nextInt();

		// Par o impar
		if ((numero%2)==0)
			System.out.println("El número es par");
		else
			System.out.println("El número es impar");
		
		// Positivo, negativo o 0
		if (numero>0)
			System.out.println("El número es positivo");
		else if (numero<0)
			System.out.println("El número es negativo");
		else
			System.out.println("El número es 0");

		// Leer el número de la tabla
		System.out.print("Introduzca el número de la tabla: ");
		numTabla = sc.nextByte();
			
		System.out.println("Tabla de multiplicar de "+numTabla);
		
		// Generar la tabla de multiplicar (for)
		for (byte cont=1; cont<=10; cont++) {
			System.out.println(numTabla+" x "+cont+" = "+ (numTabla*cont));
		}

		System.out.println();
		
		// Generar la tabla de multiplicar (while)
		byte cont=1;
		while (cont<=10){	
			System.out.println(numTabla+" x "+cont+" = "+ (numTabla*cont));
			cont++;
		}
		
		System.out.println();		
		
		// Generar la tabla de multiplicar (do..while)
		byte cont2=1;
		do {	
			System.out.println(numTabla+" x "+cont2+" = "+ (numTabla*cont2));
			cont2++;
		}
		while (cont2<=10);
		
		System.out.println("Fin del programa");
		
		sc.close();
	}

	

}
