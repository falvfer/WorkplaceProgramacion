package prPract3;

/**
 * Librería matemática con métodos de clase, como son factorial,
 * primo, combinatorio, perfecto, amigos, ...
 */

public class MiLibreria {

	/**
	 * Calcula el factorial de un número
	 * <pre>Ejemplo: 4! = 4x3x2x1 = 24
	 *         0! = 1
	 *         No existe el factorial de números negativos.</pre><br>
	 * @param num (num es el valor al que se va a calcular el factorial)
	 * @return long -> el cáculo del factorial o -1 si el número es negativo
	 */
	public static long factorial(int num) {
		
		long fact = 1;
		
		if (num < 0) return -1;
		
		for (int i = 2; i <= num; i++)
			fact *= i;
		
		return fact;
		
	}
	
	/**
	 * Metodo que calcula el combinatorio de dos números.
	 * @param a (Es el primer valor, tiene que ser mayor a cero, si es menor que "b" entonces se intercambian)
	 * @param b (Es el segundo valor, tiene que ser mayor a cero, si es mayor que "a" entonces se intercambian)
	 * @return float --> Devuelve el calculo del factorial de ambos números o -1 si "a" o "b" es menor que 0
	 */
	public static float combinatorio(int a, int b) {
		
		float comb = 0;
		
		if (a<0 || b<0) return -1;
		
		if (a<b) {
			int reserva = a;
			a = b;
			b = reserva;
		}
		
		comb = (float)factorial(a) / (factorial(b) * factorial(a-b));
		
		return comb;
		
	}
	
	/**
	 * Este método calcula si un número es primo o no.
	 * @param num (El número a comprobar si es primo o no.
	 * @return boolean --> Devuelve verdadero (primo) o falso (no primo)
	 */
	public static boolean isPrimo(int num) {
		
		int rNum;
		boolean primo = true;
	
		rNum = (int) Math.sqrt(Math.abs(num));

		for (int i = 2; i <= rNum && primo; i++) {
			if ((num % i) == 0) {
				primo = false;
			}
		}
		return primo;
	}
	
	private static int sumaDiv(int num) {
		
		int sum = 0, limit = num/2;
		
		for (int i = 1; i<=limit; i++) {
			if (num%i == 0)
				sum += i;
		}
		return sum;
	}
	
	public static boolean isPerfecto(int num) {
		return (num == sumaDiv(num));
	}
	
}
