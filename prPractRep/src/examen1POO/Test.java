package examen1POO;

public class Test {

	private static void divisorTest(String cadena) {
		System.out.println("\n------------------------------------------------------------------------------------------------------------");
		System.out.println("TEST " + cadena);
		System.out.println("------------------------------------------------------------------------------------------------------------\n");
	}
	
	
	private static void testLibreriaJamones() {
		System.out.println(
				  "1234.23 desglosado: " + LibreriaJamones.desglosar(1234.23f) + "\n"
				+ "234564.123 desglosado: " + LibreriaJamones.desglosar(234564.123f) + "\n"
				+ "234@ a kilos: " + LibreriaJamones.aKilos(234) + "\n"
				+ "234kg a @: " + LibreriaJamones.aArrobas(234564.123f) + "\n"
				+ "234.21€/@ a €/kg: " + LibreriaJamones.aPrecioKilo(234564.123f) + "\n"
				+ "234.21€/kg a €/@: " + LibreriaJamones.aPrecioArroba(234564.123f));
	}

	private static void testGranja() {
		Granja g1 = new Granja("Granja de Pepito", true, 12.23f);
		Granja g2 = new Granja("Carne de cerdo S.L.");
		
		System.out.println(g1);
		System.out.println(g2);
	}
	
	private static void testCerdo() {
		Granja g1 = new Granja("Granja de Pepito", true, 12.23f);
		Granja g2 = new Granja("Carne de cerdo S.L.");
		
		Cerdo c1 = new Cerdo("abc1", g1, 10.0, true, "Bellota", 'M');
		Cerdo c2 = new Cerdo("abcd", g2, 11.0, true, "Recebo", 'M');
		Cerdo c3 = new Cerdo("agea", g2, 13.0, false, 'H');
		
		System.out.println(c1 + "\n\n" + c2 + "\n\n" + c3);
	}
	
	private static void testJamon () {
		Granja g1 = new Granja("Granja de Pepito", true, 12.23f);
		Granja g2 = new Granja("Carne de cerdo S.L.");
		
		Cerdo c1 = new Cerdo("abc1", g1, 10.0, true, "Bellota", 'M');
		Cerdo c2 = new Cerdo("abcd", g2, 11.0, true, "Recebo", 'M');
		Cerdo c3 = new Cerdo("agea", g2, 13.0, false, 'H');
		
		Jamon j1 = new Jamon(c1, 11, (byte)10);
		Jamon j2 = new Jamon(c2, 12, (byte)12);
		Jamon j3 = new Jamon(c3, 9, (byte)16);
		Jamon j4 = new Jamon(c3, 8);
		
		System.out.println(j1 + "\n\n" + j2 + "\n\n" + j3 + "\n\n" + j4);
	}
	
	public static void main(String[] args) {
		divisorTest("LIBRERÍA JAMONES");
		testLibreriaJamones();
		divisorTest("GRANJA");
		testGranja();
		divisorTest("CERDO");
		testCerdo();
		divisorTest("JAMON");
		testJamon();
	}
}
