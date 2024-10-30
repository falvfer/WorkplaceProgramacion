package ejer1_10;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Diseñar un programa que calcule los días que faltan hasta fin de año a partir
 * de una fecha dada. Nota: tener en cuenta los años bisiestos.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		byte dia = 0, mes = 0, diaMes = 0;
		short anno = 0;
		double diaAnno=0;
		boolean diaCorrecto=false, salirBucle = false;
		
		while (!salirBucle) {
			try {
				System.out.println("Especifica la fecha");
				System.out.print("Año: ");
				anno = sc.nextShort();
				do {
					System.out.print("Mes: ");
					mes = sc.nextByte();
					switch (mes) {
						case 12:
						case 10:
						case 8:
						case 7:
						case 5:
						case 3:
						case 1: diaMes = 31; break;
						case 11:
						case 9:
						case 6:
						case 4: diaMes = 30; break;
						case 2: diaMes = (byte) ((anno % 4 == 0) ? 29 : 28); break;
						default: System.out.println("Mes incorrecto, tiene que ser del 1 al 12, prueba otra vez.");
					}
				} while (mes < 1 || mes > 12);

				do {
					System.out.print("Día: ");
					dia = sc.nextByte();
					if (dia <= diaMes && dia > 0)
						diaCorrecto = !diaCorrecto;
					else
						System.out.println("Día incorrecto, este mes tiene " + diaMes + " días, prueba otra vez.");
				} while (!diaCorrecto);
				salirBucle = !salirBucle;
			} catch (InputMismatchException e) {
				System.out.println("Error: Formato de número no válido\n");
				sc.nextLine();
			}
		}
		
		sc.close();
		
		switch (mes) {
			case 12: diaAnno += 30;
			case 11: diaAnno += 31;
			case 10: diaAnno += 30;
			case 9: diaAnno += 31;
			case 8: diaAnno += 31;
			case 7: diaAnno += 30;
			case 6: diaAnno += 31;
			case 5: diaAnno += 30;
			case 4: diaAnno += 31;
			case 3: diaAnno += (anno%4==0)?29:28;
			case 2: diaAnno += 31;
			case 1: diaAnno += dia; break;
		}
		
		System.out.println("Quedan "+(((anno%4==0)?366:365)-diaAnno)+" días para que acabe el año.");
		
	}
}
