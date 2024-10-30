package examen23_24;

import java.util.InputMismatchException;
import java.util.Scanner;

/* 
 * Apuntes de ejercicio:
 * 
 *  Lunes - Viernes = 2€ infantil, 5€ adulto
 *  Fin de semana   = 3€ infantil, 7€ adulto
 *  
 *  Entradas inf >= 3, descuento 10%
 *  
 *  Pedir día de la semana para las entradas
 *  Pedir Nº entradas adult
 *  Pedir Nº entradas inf
 *  
 *  Mostar día espectaculo en palabra "Lunes - Domingo"
 *  Mostrar total a pagar
 *  
 *  Preguntar si quiere volver a realizar otra venta.
 */
public class Ejercicio4 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		byte entradaInf, entradaAdu, diaSemana;
		float total;
		char continuar;
		
		do {
			try {
				System.out.print("Especifique el dia de la semana (en número) para el que se desea las entradas: ");
				diaSemana = sc.nextByte();
				if (diaSemana<1 || diaSemana >7) {
					sc.nextLine();
					throw new Exception("Error: Día de semana no válido.");
				}
				
				System.out.print("Especifique el número de entradas de adultos: ");
				entradaAdu = sc.nextByte();
				
				System.out.print("Especifique el número de entradas de infantiles: ");
				entradaInf = sc.nextByte();
				sc.nextLine();
				
				System.out.print("Día del espectáculo: ");
				
				if (diaSemana<6) {
					switch (diaSemana) {
					case 1 -> System.out.println("Lunes");
					case 2 -> System.out.println("Martes");
					case 3 -> System.out.println("Miércoles");
					case 4 -> System.out.println("Jueves");
					case 5 -> System.out.println("Viernes");
					}
					total = entradaInf * 2 + entradaAdu * 5;
					
				} else {
					switch (diaSemana) {
					case 6 -> System.out.println("Sábado");
					case 7 -> System.out.println("Domingo");
					}
					total = entradaInf * 3 + entradaAdu * 7;
				}
				
				if (entradaInf>=3)
					total*=0.9;
				
				System.out.println("Total a pagar: "+total+"€");
				
			} catch (InputMismatchException e) {
				System.out.println("Error: Formato no válido.");
				sc.nextLine();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 

			System.out.print("\n¿Desea continuar vendiendo entradas? (S/N): ");
			continuar = sc.nextLine().charAt(0);
			
		} while (Character.toUpperCase(continuar)=='S');
		
		sc.close();

	}

}
