package ejer08;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Ejercicio {
	
	/* Con la ayuda de las colecciones, genera una lista de 50 números aleatorios
	 * que no estén repetidos. Finalmente muestra la lista en pantalla.
	 */
	public static void main(String[] args) {
		
		Random rdn = new Random();
		Set<Integer> setNumeros = new HashSet<>();
		
		while (setNumeros.size() < 50) {
			setNumeros.add(rdn.nextInt(0,1000));
		}
		
		int i = 1;
		for (Integer num: setNumeros) {
			System.out.print(num + "\t");
			if (i == 5) {
				i = 0;
				System.out.println();
			}
			i++;
		}
		
		
		
		
		
		
		
		
		
		

	}

}
