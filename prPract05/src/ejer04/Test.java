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
			
			for (int i = 1000; i>=1; i--) {
				u2.meteBola(u2.sacaBola());
			}
			
			System.out.println("\n" + u2);
			
			System.out.println();
		
			/* ------------------------------------------------------------------------
			 * Test clase "UrnaTrampa"
			 * ------------------------------------------------------------------------
			 */
			
			UrnaDeTresColores u3 = new UrnaDeTresColores(rnd.nextInt(1,101),rnd.nextInt(1,101),rnd.nextInt(1,101));
			
			char bola1, bola2;
			
			do {
				bola1 = u3.sacaBola();
				bola2 = u3.sacaBola();
				
				if (bola1 == bola2)
					if (bola1 == 'b')
						u3.meteBola('r');
					else
						u3.meteBola(bola1);
				else
					u3.meteBola('b');
			} while (u3.quedaMasDeUnaBola());
			bola1 = u3.sacaBola();
			
			System.out.print("La última vola restante es: ");
			if (bola1 == 'b') System.out.println("Blanca");
			else if (bola1 == 'n') System.out.println("Negra");
			else System.out.println("Roja");
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
