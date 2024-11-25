package ejer03;

public class Test {

	public static void main(String[] args) {
		
		/* ---------------------------------------------------------------
		 * Prueba clase Direccion
		 * ---------------------------------------------------------------
		 */
		Direccion d1 = new Direccion("C/ Infante",37,"29200");
		Direccion d2 = new Direccion("C/ La Union",2,"29532");
		
		d2.setNomCalle("C/ La Unión");
		
		System.out.println(d1);
		System.out.println(d2);

		System.out.println();
		
		/* ---------------------------------------------------------------
		 * Prueba clase Edificio
		 * ---------------------------------------------------------------
		 */
		Edificio e1 = new Edificio(d1, (short)20, (byte)3, 350f);
		Edificio e2 = new Edificio("C/ Fresca", 2, "29313", (short)15, (byte)2, 200f);
		
		System.out.println("IBI edificio 1: " + e1.calculaIbi());
		System.out.println("IBI edificio 2: " + e2.calculaIbi());
		
		System.out.println();
		
		System.out.println(e1);
		System.out.println(e2);

		System.out.println();
		
		/* ---------------------------------------------------------------
		 * Prueba clase Casa
		 * ---------------------------------------------------------------
		 */
		Casa c1 = new Casa(e2, (byte)3, (byte)3);

		System.out.println("IBI casa 1: " + c1.calculaIbi());

		System.out.println();
		
		System.out.println(c1);

		System.out.println();
		
		/* ---------------------------------------------------------------
		 * Prueba clase Colegio
		 * ---------------------------------------------------------------
		 */
		Colegio co1 = new Colegio(e1, (byte)12, (byte)2);

		System.out.println();
		
		System.out.println(co1);
		
		/* ---------------------------------------------------------------
		 * Prueba clase Guardería
		 * ---------------------------------------------------------------
		 */
		Colegio gu1 = new Guarderia(co1, 100f);

		System.out.println();
		
		System.out.println(gu1);
		
		
	}

}
