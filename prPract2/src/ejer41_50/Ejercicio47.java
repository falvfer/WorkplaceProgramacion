package ejer41_50;

public class Ejercicio47 {
	
	public static void main(String[] args) {
		// Simular 100 tiradas de un dado y contar las veces que aparece el nº 6
		
		double rand;
		int cont = 0;

		for (int i = 1; i <= 100; i++) { // Bucle para "tirar el dado" 100 veces.
			rand = Math.random() * 5; // Generar un valor double 0>=valor<1 y multiplicarlo por 6
			if (rand >= 5) // Comprobar si rand>=5, significando que ha salido un 6
				cont++;
		}

		System.out.println("Número total de '6': " + cont);
		
	}
}
