package ejer41_50;

public class Ejercicio48 {
	
	public static void main(String[] args) {
		// Simular 100 tiradas de 2 dados y contar las veces que entre los dos suman 10.		
		
		int rand;
		int cont = 0;

		for (int i = 1; i <= 100; i++) { // Bucle para "tirar" los dos dados 100 veces.
			rand = (int) (Math.random() * 6 + 1) + (int) (Math.random() * 6 + 1); // Simular la tirada de ambos dados
			if (rand == 10) // Comprobar si rand==10					entonces sumarles "2" para que los valores sean correctos
				cont++;
		}

		System.out.println("Número total de '10': " + cont);
		
	}
}
