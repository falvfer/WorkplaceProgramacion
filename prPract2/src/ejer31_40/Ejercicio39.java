package ejer31_40;

public class Ejercicio39 {

	public static void main(String[] args) {
		// Realizar un algoritmo para imprimir las tablas de multiplicar del uno al diez,
		// es decir, tenéis que mostrar la tabla del 1, la del 2, la del 3, …, hasta la del 10.
		
		for (int num1 = 1; num1 <= 10 ; num1++) {
			System.out.println("Tabla del "+num1+":");
			for (int num2 = 1; num2 <= 10; num2++)
				System.out.println(num1+" x "+num2+" = "+num1*num2);
			System.out.println();
		}
		
	}
}