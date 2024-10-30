package ejer11_20;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Una pizzería vende pizzas de 3 tamaños. Normal (25 cm. de diámetro). Mediana
 * (30 cm. de diámetro) y Grande (40 cm. de diámetro). A su vez, una pizza puede
 * ser sencilla (con sólo queso y tomate) o con ingredientes extras, tales como
 * pepinillos, champiñones, cebolla, jamón, etc.
 * 
 * Los propietarios de la pizzería desean realizar un algoritmo para calcular el
 * precio de venta de una pizza, dado el tamaño y número de ingredientes extras.
 * 
 * El precio de venta será 1.5 veces el coste total, el cual viene determinado
 * por un coste fijo de preparación de 3 € por pizza, más un coste variable
 * proporcional al tamaño de la pizza y estimado en 0.15 céntimos * cms, y más un
 * coste variable para cada ingrediente extra, estimado en 0.50 céntimos por
 * ingrediente. Se considera que todos los ingredientes extras poseen el mismo
 * precio.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */
public class Ejercicio11 {

	public static void main(String[] args) {
		
		final byte diamNormal = 25, diamMediana = 30, diamGrande = 40;
		byte tipoPizza, ingExtra;
		
		try (Scanner sc = new Scanner(System.in)){
			System.out.println("1. Normal\n2. Mediana\n3. Grande");
			System.out.print("Elija el tipo de pizza: ");
			tipoPizza = sc.nextByte();
			
			if (tipoPizza == 1)
				tipoPizza = diamNormal;
			else if (tipoPizza == 2)
				tipoPizza = diamMediana;
			else if (tipoPizza == 3)
				tipoPizza = diamGrande;
			else
				throw new InputMismatchException();
			
			System.out.print("¿Cuántos ingredientes extra se han añadido?: ");
			ingExtra = sc.nextByte();
			
			System.out.println("\nEl precio total es de: "+1.5*(3+0.1*tipoPizza+0.5*ingExtra));
		
		} catch (InputMismatchException e) {
			System.out.println("Error: Formato u opción no válida.");
		}
		
	}

}
