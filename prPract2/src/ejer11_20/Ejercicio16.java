package ejer11_20;

public class Ejercicio16 {

	public static void main(String[] args) {
		// ¿Cuántas veces se ejecutará la Acción 1?
		int cont = 0;
		while (cont < 10) {
			cont++;
			if (cont == 10)
				System.out.println("Acción 1");
		}
		//Se ejecutará 1 sola vez
	}
}