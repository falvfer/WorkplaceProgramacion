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
	 * @return long -> El cáculo del factorial, -1 si el número es negativo, -2 si es muy grande como para calcularlo
	 */
	public static long factorial(int num) {
		
		long fact = 1;

		if (num<0) return -1;
		if (num>20) return -2;
		
		for (int i = 2; i <= num; i++)
			fact *= i;
		
		return fact;
		
	}
	
	/**
	 * Metodo que calcula el combinatorio de dos números.
	 * @param a (Es el primer valor, tiene que ser mayor a cero, si es menor que "b" entonces se intercambian)
	 * @param b (Es el segundo valor, tiene que ser mayor a cero, si es mayor que "a" entonces se intercambian)
	 * @return float --> Calculo del combinatorio de ambos números, -1 si "a" o "b" es negativo, -2 si "a" o "b" es muy grande
	 */
	public static int combinatorio(int a, int b) {
		
		int comb = 0;
		long factA = factorial(a);
		long factB = factorial(b);
		
		if (factA == -1 || factB == -1) return -1;
		if (factA == -2 || factB == -2) return -2;
		
		if (a<b) {
			long reserva = factA;
			factA = factB;
			factB = reserva;
			reserva = a;
			a = b;
			b = (int) reserva;
		}
		
		comb = (int) (factA / (factB * factorial(a-b)));
		
		return comb;
		
	}
	
	/**
	 * Este método calcula si un número es primo o no.
	 * @param num (El número a comprobar si es primo o no.
	 * @return boolean --> Devuelve verdadero (primo) o falso (no primo)
	 */
	public static boolean isPrimo(int num) {
		
		num = Math.abs(num);
		int i = 2, rNum = (int) Math.sqrt(Math.abs(num));
		boolean primo = true;
		
		while (i <= rNum && primo) {
			if ((num % i) == 0)
				primo = false;
			i++;
		}

		/*for (int i = 2; i <= rNum && primo; i++) {
			if ((num % i) == 0)
				primo = false;
		}*/ // Esto no es del todo correcto ya que en otros lenguajes el for es más rigido. 
		
		return primo;
	}
	
	/**
	 * Calcular la suma de los divisores de un número sin contar él mismo.
	 * @param num (El número del que se va a calcular la suma de sus divisores)
	 * @return int --> La suma de los divisores.
	 */
	private static int sumaDiv(int num) {
		
		int sum = 0, limit = num/2;
		
		for (int i = 1; i<=limit; i++) {
			if (num%i == 0)
				sum += i;
		}
		return sum;
	}
	
	/**
	 * Comprueba si un número es perfecto o no (La suma de los divisores de un número sin contarse a si mismo es igual al número).
	 * @param num (El número a comprobar)
	 * @return boolean --> TRUE si es perfecto, FALSE si no es perfecto
	 */
	public static boolean isPerfecto(int num) {
		return (num == sumaDiv(num));
	}
	
	/**
	 * Comprueba si dos números son amigos o no (La suma de los divisores del primer número es igual al segundo y viceversa).
	 * @param a (Primer número)
	 * @param b (Segundo número)
	 * @return boolean --> TRUE si ambos son amigos, FALSE si no son amigos
	 */
	public static boolean isAmigo(int a, int b) {
		return (sumaDiv(a) == b && sumaDiv(b) == a);
	}
	
	public static int mcdWhile(int num1, int num2) {
		while (num1!=num2) {
			if (num1>num2)
				num1-=num2;
			else
				num2-=num1;
		}
		return num1;
	}

	public static int mcdRecursivo(int num1, int num2) {
		if (num1>num2) return mcdRecursivo(num1-=num2,num2);
		if (num2>num1) return mcdRecursivo(num1,num2-=num1);
		return num1;
	}
	
	public static boolean isCoprimos(int num1, int num2) {
		return (mcdWhile(num1,num2) == 1);
	}
	
	public static int funcionEuler(int num) {
		int cont = 0;
		num = Math.abs(num);
		
		for (int i=1; i<num; i++)
			if (isCoprimos(num,i)) cont++;
		return cont;
	}
	
	
}
