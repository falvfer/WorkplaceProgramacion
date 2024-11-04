package eje_t4;

public class EjemploClaseApuntes {
	/**
	 * Método de clase que averigua el menor de dos valores recibidos como
	 * parámetros
	 * 
	 * @param x
	 * @param y
	 * @return --> devuelve el menor de los valores
	 */
	public static int minimo(int x, int y) {
		if (x < y)
			return x;
		else
			return y;
	}
	
	
	public static int minimoMasUno(int x, int y) {
		
		int minimo;
		
		if (x < y)
			minimo = ++x;
		else
			minimo = ++y;
		
		return minimo;
	}
	

	/**
	 * Método principal
	 */
	public static void main(String[] args) {
		int menor = minimo(10, 7);
		System.out.println("El valor menor es: " + menor);
		System.out.println("El menor de 8 y 10 es: " + minimo(8, 10));
		
		int num1 = 20, num2 = 12;
		
		System.out.println("El mínimo más uno es: "+ minimoMasUno(num1,num2));
		System.out.println("Num1 = "+num1+"\nNum2 = "+num2);
	}
}
