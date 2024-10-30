package ejer41_50;

public class Ejercicio50 {

	public static void main(String[] args) {
		// Simular el lanzamiento de una moneda al aire y que pare cuando salgan 3 caras
		// consecutivas. Visualizar el número de tiradas realizadas.

		double rand;
		byte cont = 0, consecutivas = 0;

		do { // Bucle para "tirar la moneda" tantas veces como se especificó.
			rand = Math.random(); // Generar un valor double 0>=valor<1
			cont++;
			if (rand < 0.5) // Comprobar si rand<0.5 (cruz) o rand>=0.5 (cara)
				consecutivas++;
			else
				consecutivas = 0;
		} while (consecutivas < 3);

		System.out.println("Número total de tiradas hasta que han salido 3 caras es de: " + cont);

	}
}
