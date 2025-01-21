package ejer01_10;

public class Ejer03 {

	public static void main(String[] args) {

		float float1 = Float.parseFloat("67.235");
		Float float2 = Float.valueOf("67.235");
		Integer int1 = 300;
		Integer int2 = 300;
		
		if (int1.intValue() == int2.intValue())
			System.out.println("Son iguales");
		else
			System.out.println("Son distintos");
		
		
		
	}
}
