package ejer03;

public class TestCoche {
	
	public static void main(String[] args) {
		
		Coche c1 = new Coche("Toledo", "Seat", 18000, (byte)12);
		Coche c2 = new Coche("C3", "Citroen", 22300);
		Coche c3 = new Coche("A", "Mercedes", 32021.23f, (byte)12);
		Coche c4 = new Coche();
		
		System.out.println(c1.toString());
		System.out.println("\n"+c2.toString());
		System.out.println("\n"+c3.toString());
		System.out.println("\n"+c4.toString()+"\n");
		
		c4.setModelo("A");
		c4.setFabricante("Mercedes");
		c4.setPrecioBruto(29630.1f);
		c4.setIva((byte)18);

		System.out.println(c4.toString());
		System.out.println();
		c4.consulta();
		System.out.println();
		
		if (c3.equals(c4))
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		
		if (c1.equals(c4))
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
	}
	
}
