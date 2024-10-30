package eje_edd;

import java.util.Scanner;

public class EjemploMult {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numero = 0;
		int mult = 0;
		int maximo = Integer.MIN_VALUE;
		int minimo = Integer.MAX_VALUE;
		int contador = 0;
		double mediaMultiplicacion;
		// El profe quiere variable max y min

		// probar con el 24, -7 , 19, 11
		Scanner sc = new Scanner(System.in);

		System.out.println("Introduce un número distinto de cero para multiplicacion");
		System.out.println("Si el número es cero acaba el programa.");

		numero = sc.nextInt();
		maximo = numero;
		minimo = numero;

		while (numero != 0) {

			if (numero > maximo)
				maximo = numero;
			if (numero < minimo)
				minimo = numero;
			
			mult = mult * numero; // sum+=num
			contador++;
			System.out.println("Introduce otro número");
			numero = sc.nextInt();


		}

		mediaMultiplicacion = (double) mult / contador;
		System.out.println("El resultado de la multiplicacion es:" + mult);
		System.out.println("El máximo es:" + maximo);
		System.out.println("El mínimo es:" + minimo);
		System.out.println("La media multiplicacion es:" + mediaMultiplicacion);

		sc.close();

	}
}
