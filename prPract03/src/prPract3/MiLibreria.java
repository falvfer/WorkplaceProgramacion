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
	 * @return float --> Calculo del combinatorio de ambos números, -1 si "a" o "b" es negativo, -2 si "a" o "b" es muy grande, -3 si a<b
	 */
	public static int combinatorio(int a, int b) {
		
		int comb = 0;
		long factA = factorial(a);
		long factB = factorial(b);
		
		if (factA == -1 || factB == -1) return -1;
		if (factA == -2 || factB == -2) return -2;
		if (a<b) return -3;
		
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
	
	/**
	 * Calcula el MCD de dos números (con un bucle)
	 * @param num1 (Primer número)
	 * @param num2 (Segundo número)
	 * @return int --> El MCD de susodichos números
	 */
	public static int mcdWhile(int num1, int num2) {
		while (num1!=num2) {
			if (num1>num2)
				num1-=num2;
			else
				num2-=num1;
		}
		return num1;
	}

	/**
	 * Calcula el MCD de dos números (de forma recursiva)
	 * @param num1 (Primer número)
	 * @param num2 (Segundo número)
	 * @return int --> El MCD de susodichos números
	 */
	public static int mcdRecursivo(int num1, int num2) {
		if (num1>num2) return mcdRecursivo(num1-num2,num2);
		if (num2>num1) return mcdRecursivo(num1,num2-num1);
		return num1;
	}
	
	/**
	 * Comprueba si dos números son Coprimos
	 * @param num1 (Primer número)
	 * @param num2 (Segundo número)
	 * @return boolean --> TRUE si son Coprimos, FALSE si no lo son
	 */
	public static boolean isCoprimos(int num1, int num2) {
		return (mcdWhile(num1,num2) == 1);
	}
	
	/**
	 * Calcula la función de Euler de un número
	 * @param num (Número para calcularle el Euler)
	 * @return int --> El resultado de la función (Cantidad de números menor a este que son Coprimos)
	 */
	public static int funcionEuler(int num) {
		int cont = 0;
		num = Math.abs(num);
		
		for (int i=1; i<num; i++)
			if (isCoprimos(num,i)) cont++;
		return cont;
	}

	/**
	 * Calcula una posición de la serie de fibonnaci (con bucle for)
	 * @param num (Posición de la serie)
	 * @return int --> El número en susodicha posición
	 */
	public static int fibFor(int num) {
		int aux1 = 1, aux2 = 1;
		
		for (int cont = 2; cont <= num; cont+=2) {
			aux1+=aux2;
			aux2+=aux1;
		}
		return (num%2==0?aux1:aux2);
	}

	/**
	 * Calcula una posición de la serie de fibonnaci (con recursividad)
	 * @param num (Posición de la serie)
	 * @return int --> El número en susodicha posición
	 */
	public static int fibRecursivo(int num) {
		if (num == 0 || num == 1) return 1;
		return fibRecursivo(num-1) + fibRecursivo(num-2);
	}
	
	/**
	 * Calcula la potencia tanto negativa como positiva de un número
	 * @param base (La base de la potencia)
	 * @param exp (El exponente de la potencia)
	 * @return double --> El resultado de la potencia
	 */
	public static double potenciaRecursiva(int base, int exp) {
		if (exp < 0) return 1/potenciaRecursiva(base,Math.abs(exp));
		if (exp == 0) return 1;
		if (exp == 1) return base;
		return potenciaRecursiva(base,exp-1)*base; 
	}
	
	public static long sumaFibRecursivo(int pos) {
		if (pos==0) return 1;
		return fibRecursivo(pos) + sumaFibRecursivo(pos-1);
	}
}
