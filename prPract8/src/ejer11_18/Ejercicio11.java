package ejer11_18;

public class Ejercicio11 {

	public static void main(String[] args) {
		menu();
		

	}
	
	private static void menu() {
		System.out.println("1. Sumar dos polinómios");
		System.out.println("2. Restar dos polinómios");
		System.out.println("3. Multiplicar dos polinómios");
		System.out.println("Eliga una opción: ");
	}
	
	private static int[] sumaPolinomios(int[] pol1, int[] pol2) {
		int[] polFinal = new int[longitudMayor(pol1, pol2)];
		return null;
	}
	
	private static int[] restaPolinomios(int[] pol1, int[] pol2) {
		int[] polFinal = new int[longitudMayor(pol1, pol2)];
		return null;
	}
	
	private static int[] multiplicacionPolinomios(int[] pol1, int[] pol2) {
		int[] polFinal = new int[longitudMayor(pol1, pol2)];
		return null;
	}
	
	private static int longitudMayor(int[] array1, int[] array2) {
		return (array1.length>array2.length?array1.length:array2.length);
	}
	
	private static int longitudMenor(int[] array1, int[] array2) {
		return (array1.length>array2.length?array2.length:array1.length);
	}

}
