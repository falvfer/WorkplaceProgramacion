package ejer51_55;

public class Ejercicio51 {

	public static void main(String[] args) {
		// Generar aleatoriamente una quiniela de una columna, si la probabilidad de que salga 1 es del 50%, la x es del 30% y la del 2 es del 20%.

		double rand;
		char result;

		for (int i = 1; i<=15; i++) {
			rand = Math.random();
			
			if (rand<0.5)
				result='1';
			else if (rand<0.8)
				result='X';
			else
				result='2';
			
			System.out.println("Encuentro "+i+": "+result);
		}
		
	}
}
