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

	}

}
