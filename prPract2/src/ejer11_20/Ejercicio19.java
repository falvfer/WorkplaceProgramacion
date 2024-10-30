package ejer11_20;

public class Ejercicio19 {

	public static void main(String[] args) {
		// ¿Qué rango de valores pueden tomar X e Y para garantizar que el siguiente
		// algoritmo termina?

		int a=-23, b=-5;
		do {
			while (a>b) {
				a=a-b;
				System.out.println(a+"\t"+b);
			}
			while (b>a) {
				b=b-a;
				System.out.println(a+"\t"+b);
			}
		} while (a!=b);
		System.out.println("FIN DEL PROGRAMA");
		
		// Tiene que tomar valores POSITIVOS, con que uno de los dos números sea
		// negativo el programa se queda en bucle hasta que de lugar a un error por
		// desbordamiento.
	}

}
