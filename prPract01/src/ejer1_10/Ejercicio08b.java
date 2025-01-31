package ejer1_10;

class Ejercicio08b {
	
	public static void main(String[] args) {
		// Dado el siguiente programa, traza su ejecución y determina
		// los resultados si los datos de entrada son: 7 y 11.
		
		// Constantes y Variables
		final int n = 10;
		int a, b, c=0;
		
		a = Integer.parseInt(args[0]); // Cargar el argumento con indice 0 a la variable "a" convirtiendolo a Int
			// Después de esta línea: a=7; b=(Datos basura); c=0;
		
		b = Integer.parseInt(args[1]); // Cargar el argumento con indice 0 a la variable "b" convirtiendolo a Int
			// a=7; b=11; c=0;
		
		c = a -  b +  n;
	 // c = 7 - 11 + 10; c=6
		// a=7; b=11; c=6;
		
		c = c + c;
	 // c = 6 + 6; c=12
		// a=7; b=11; c=12;
		
		b = a +  b -  c;
	 // b = 7 + 11 - 12; b=6
		// a=7; b=6; c=12;
		
		a = a + b -  c;
	 // a = 7 + 6 - 12; a=1
		// a=1; b=6; c=12;
		
		a =  n * a;
	 // a = 10 * 1; a=10
		// a=10; b=6; c=12;
		
		System.out.println(a); // El resultado final de "a" es 10
	}
}