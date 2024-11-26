package examen241126;

public class Examen {

	public static void main(String[] args) {
		System.out.println("Pruebas de Tribonnaci:"
							+ "\n\t0 --> " + tribonacci(0)
							+ "\n\t1 --> " + tribonacci(1)
							+ "\n\t2 --> " + tribonacci(2)
							+ "\n\t3 --> " + tribonacci(3)
							+ "\n\t4 --> " + tribonacci(4)
							+ "\n\t5 --> " + tribonacci(5)
							+ "\n\t6 --> " + tribonacci(6)
							+ "\n\t7 --> " + tribonacci(7));

		System.out.println("Pruebas de Producto:"
							+ "\n\t0x2 --> " + producto(0, 2) + " (" + 0 * 2 + ")"
							+ "\n\t1x0 --> " + producto(1, 0) + " (" + 1 * 0 + ")"
							+ "\n\t2x4 --> " + producto(2, 4) + " (" + 2 * 4 + ")"
							+ "\n\t3x8 --> " + producto(3, 8) + " (" + 3 * 8 + ")"
							+ "\n\t43x100 --> " + producto(43, 100) + " (" + 43 * 100 + ")"
							+ "\n\t5x2 --> " + producto(5, 2) + " (" + 5 * 2 + ")"
							+ "\n\t7x3 --> " + producto(7, 3) + " (" + 7 * 3 + ")"
							+ "\n\t-7x3 --> " + producto(-7, 3) + " (" + -7 * 3 + ")"
							+ "\n\t-7x-3 --> " + producto(-7, -3) + " (" + -7 * -3 + ")"
							+ "\n\t7x-3 --> " + producto(7, -3) + " (" + 7 * -3 + ")");

	}

	/**
	 * Método para calcular la suseción de Tribonacci
	 * @param pos (La posición a calcular)
	 * @return int --> El número que equivale a susodicha posición
	 */
	public static int tribonacci(int pos) {
		if (pos == 0)
			return 0;
		if (pos == 1 || pos == 2)
			return 1;
		return tribonacci(pos - 1) + tribonacci(pos - 2) + tribonacci(pos - 3);
	}

	/**
	 * Algoritmo para calcular el producto de dos números (multiplicación de dos números)
	 * @param num1 (Primer número de la multiplicación)
	 * @param num2 (Segundo número de la multiplicación)
	 * @return int --> El resultado del producto de num1 y num2
	 */
	public static int producto(int num1, int num2) {
		// Devolver 0 si cualquiera de ambos números es igual a 0
		if (num1 == 0 || num2 == 0) return 0;
		
		// Optimizar el código haciendo que el número más pequeño sea siempre el segundo
		if (Math.abs(num2) > Math.abs(num1)) {
			int reserva = num1;
			num1 = num2;
			num2 = reserva;
		}
		
		// Invertir los números si num2 es negativo,
		// esto es para evitar llamadas infinitas si el segundo es negativo
		if (num2 < 0) { 
			num1 = -num1;
			num2 = -num2;
		}

		if (num2 == 1) return num1;
		return producto(num1, num2 - 1) + num1;
	}

}
