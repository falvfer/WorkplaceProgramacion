package ejer01_10;

public class Ejer02 {
	/* Prueba el funcionamiento de algunos de los métodos de la clase Math, y además:
	 *   Genera un número aleatorio entre 1 y 25 utilizando la clase Math.
	 *   Calcula la raíz cúbica del número 13 y de 125.
	 *   Para qué sirve el método IEEERemainder.
	 *   Para qué sirve el método signum, prueba con distintos valores.
	 *   Calcula la hipotenusa de un triángulo según el Teorema de Pitágoras.
	 */
	public static void main(String[] args) {
		
		// Genera un número aleatorio entre 1 y 25 utilizando la clase Math.
		System.out.println("Número aleatorio entre 1 y 25: " + ((int)(Math.random()*25)+1) + "\n");
		
		// Calcula la raíz cúbica del número 13 y de 125.
		System.out.println("Raiz cúbica de 13: " + Math.cbrt(13));
		System.out.println("Raiz cúbica de 125: " + Math.cbrt(125) + "\n");
		
		// Para qué sirve el método IEEERemainder.
		// Es lo mismo que % pero más seguro. Devuelve el resto de una división
		System.out.println(Math.IEEEremainder(12, 5) + "\n");
		System.out.println(Math.IEEEremainder(12.5, 5) + "\n");
		
		// Para qué sirve el método signum, prueba con distintos valores.
		System.out.println("Signo de -23: " + Math.signum(-23));
		System.out.println("Signo de 23: " + Math.signum(23));
		System.out.println("Signo de 0: " + Math.signum(0) + "\n");
		
		// Calcula la hipotenusa de un triángulo según el Teorema de Pitágoras
		System.out.println("Hipotenusa de 3 y 4: " + Math.sqrt(Math.pow(3, 2)+Math.pow(4, 2)));
		System.out.println("Hipotenusa de 3 y 4: " + Math.hypot(3, 4));
		
	}
}
