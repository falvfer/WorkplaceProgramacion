package eje_t1;

import java.util.Scanner;

public class Ejemplo2_Ordenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crear las variables requeridas inicializandolas
		boolean ordenados = false;
		int numero1 = 0;
		int numero2 = 0;
		int numero3 = 0;
		int reserva = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Di un número: ");
		numero1=sc.nextInt();
		System.out.print("Di otro número: ");
		numero2=sc.nextInt();
		System.out.print("Di el último número: ");
		numero3=sc.nextInt();
		
		
		if (numero1!=numero2&&numero2!=numero3&&numero3!=numero1) {
			do {
				if (numero1>numero2) {
					if (numero2>numero3) {
						ordenados = true;
					} else {
						reserva = numero2;
						numero2 = numero3;
						numero3 = reserva;
					}
				} else {
					reserva = numero1;
					numero1 = numero2;
					numero2 = reserva;
				}
			} while (ordenados==false);
		} else {
			System.out.println("Error: Los números tienen que ser diferentes.");
		}
		
		System.out.println("Los números en orden son: " + numero1 + " > " + numero2 + " > " + numero3);
		
		sc.close();
		
	}
	
}
