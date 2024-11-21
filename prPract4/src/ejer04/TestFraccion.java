package ejer04;

public class TestFraccion {

	public static void main(String[] args) {
		/*
		 * Fraccion --> num, den
		 * Constructores --> (num, den) (num) ()
		 * Métodos --> invierte, simplifica, simplificacion, multiplica, divide
		 * Otros métodos --> toString, equals
		 * Getters y Setters
		 */
		
		Fraccion f1 = new Fraccion(6,2);
		Fraccion f2 = new Fraccion(2,4);
		Fraccion f3 = new Fraccion(2);
		Fraccion f4 = new Fraccion(5);
		Fraccion f5 = new Fraccion();
		
		System.out.println(f1.toString());		
		System.out.println(f2.toString());		
		System.out.println(f3.toString());		
		System.out.println(f4.toString());		
		System.out.println(f5.toString());
		System.out.println();

		System.out.println(f5.getNum() + "/" + f5.getDen());
		f5.setNum(4);
		f5.setDen(8);
		System.out.println(f5.getNum() + "/" + f5.getDen());
		System.out.println();
		
		if (f2.equals(f5))
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		
		if (f2.equals(f1))
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		System.out.println();
		
		System.out.println(f1.toString());
		f1.invierte();
		System.out.println(f1.toString());
		System.out.println();
		
		System.out.println(f1.toString());
		f1.simplifica();
		System.out.println(f1.toString());
		System.out.println();

		System.out.println("(" + f1.toString() + ") x (" + f2.toString() + ") = ("
						   + f1.multiplica(f2).toString() + ") = ("
						   + f1.multiplica(f2).simplificado().toString() + ")");
		System.out.println("(" + f1.toString() + ") / (" + f2.toString() + ") = ("
				   + f1.divide(f2).toString() + ") = ("
				   + f1.divide(f2).simplificado().toString() + ")");
		System.out.println();
		
		
	}
}
