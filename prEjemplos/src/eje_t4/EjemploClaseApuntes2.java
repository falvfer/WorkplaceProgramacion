package eje_t4;

public class EjemploClaseApuntes2 {
	/**
	 * Método de clase que averigua el menor de dos valores recibidos como
	 * parámetros
	 * 
	 * @param x
	 * @param y
	 */
	public static void minimo(int x, int y) {
		if (x < y)
			System.out.println("El menor es " + x);
		else
			System.out.println("El menor es " + y);
	}

	/**
	 * Método principal
	 */
	public static void main(String[] args) {
		minimo(10, 7);
		minimo(8, 10);
	}
}