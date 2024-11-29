package ejer04;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random rnd = new Random();
		
		try {
			
			/* ------------------------------------------------------------------------
			 * Test clase "Urna"
			 * ------------------------------------------------------------------------
			 */
			Urna u1 = new Urna(rnd.nextInt(1,101),rnd.nextInt(1,101));
			System.out.println(u1+"\n");
			do {
				
				if (u1.sacaBola() == u1.sacaBola())
					u1.meteBola('n');
				else
					u1.meteBola('b');
				
			} while (u1.quedaMasDeUnaBola());
			
			System.out.println("La última vola restante es: " + (u1.sacaBola()=='b'?"Blanca":"Negra"));
			System.out.println();
		
			/* ------------------------------------------------------------------------
			 * Test clase "UrnaTrampa"
			 * ------------------------------------------------------------------------
			 */
			UrnaTrampa u2 = new UrnaTrampa(50,50);
			
			for (int i = 10000; i>=1; i--) {
				u2.meteBola(u2.sacaBola());
			}
			
			System.out.println("\n" + u2);
		
			System.out.println(1/(0.2/100));

		} catch (Exception e) {
		}
	}

}
