package prExamen241030;

import java.util.Scanner;

/**
 * Apuntes del ejercicio:
 *  Preguntar Nº invitados
 *  Preguntar cake pops (S/N)
 *  Preguntar donuts (S/N)
 *  Preguntar fuente de chocolate (S/N)
 *  
 *  Precio base: 80€
 *  Cada invitado se añade 1€
 *  Cake pops: 0.25€ por invitado 
 *  Donuts: 0.3€ por invitado
 *  Fuente de chocolate: 100€
 *  
 *  Mostrar el coste total, y
 *  	El coste de montaje
 *  	Nº de invitados
 *  	Si hay cake pops
 *  	Si hay donuts
 *  	Si hay fuente de chocolate
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final int costeBase = 80;
		int invitados;
		double costeTotal;
		char cPops, donuts, fuente;
		
		// Preguntar por el número de invitados
		System.out.print("Indique el número de invitados al evento: ");
		invitados = sc.nextInt();
		sc.nextLine(); // Limpiar buffer de teclado para evitar errores
		// Preguntar por los cake pops
		System.out.print("¿Desea añadir cake pops? (S/N) ");
		cPops = Character.toUpperCase(sc.nextLine().charAt(0));
		// Preguntar por los donuts
		System.out.print("¿Desea añadir donuts? (S/N) ");
		donuts = Character.toUpperCase(sc.nextLine().charAt(0));
		// Preguntar por la fuente de chocolate
		System.out.print("¿Desea añadir una fuente de chocolate? (S/N) ");
		fuente = Character.toUpperCase(sc.nextLine().charAt(0));
		
		sc.close(); // Cerrar Scanner ya que no hace falta 
		
		// Calcular el costeTotal en base a los datos dados 
		costeTotal = costeBase + invitados;
		if (cPops == 'S')
			costeTotal += invitados * 0.25;
		if (donuts == 'S')
			costeTotal += invitados * 0.3;
		if (fuente == 'S')
			costeTotal += 100;
		
		// Mostrar por pantalla todos los datos finales
		System.out.println("EL COSTE TOTAL DE LA MESA ASCIENDE A: "+costeTotal+"€");
		System.out.println("\tCoste montaje: "+costeBase+"€");
		System.out.println("\tNúmero de invitados: "+invitados);
		System.out.println("\tCake pops: "+(cPops=='S'?"SI":"NO"));
		System.out.println("\tDonuts: "+(donuts=='S'?"SI":"NO"));
		System.out.println("\tFuente: "+(fuente=='S'?"SI":"NO"));
		
		
	}
}
