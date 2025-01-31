package ejer51_55;

import java.util.Scanner;

public class Ejercicio52 {

	public static void main(String[] args) {
		// Simular el lanzamiento de dos monedas un número determinado de tiradas.
		// Calcular cuántas caras y cuántas cruces han salido, e imprimir el número
		// mayor de tiradas consecutivas con dos caras.
		
		byte mon1, mon2;
		int totalTiradas, caraCont=0, cruzCont=0, carConsec=0, totalCar=0;
		
		System.out.print("Especifique el número de veces a tirar la moneda: ");
		Scanner sc = new Scanner(System.in);
		totalTiradas=sc.nextInt();
		sc.close();
		
		for (int i=1;i<=totalTiradas;i++) { // Bucle para "tirar" las monedas tantas veces como se especificó.
			mon1 = (byte) (Math.random()*2); // Generar dos valores que sean aleatorios entre 0 y 1
			mon2 = (byte) (Math.random()*2); 
			
			System.out.println(mon1+"  "+mon2);
			
			if (mon1 + mon2 == 0) { // Si ambas son caras
				caraCont += 2;
				carConsec++; // Sumar en uno el contador de caras consecutivas
				if (carConsec > totalCar) // Comprobar que las caras cosecutivas actuales son mayores que el máximo
					totalCar++;

			} else {
				carConsec = 0; // Cambiar el marcador de caras consecutivas a 0

				if (mon1 + mon2 == 2) { // Si ambas son cruz
					cruzCont += 2;

				} else { // Si una es cruz y la otra cara
					caraCont++;
					cruzCont++;
				}
			}
		}
		System.out.println("Número total de Caras: "+caraCont);
		System.out.println("Número total de Cruzes: "+cruzCont);
		System.out.println("Número máximo de doble Caras consecutivas: "+totalCar);
		
	}
}

