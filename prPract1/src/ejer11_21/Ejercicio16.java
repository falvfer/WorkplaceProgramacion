package ejer11_21;

public class Ejercicio16 {

	public static void main(String[] args) {
		// Un programa tiene como entrada dos números y los almacena en las variables “u” y “v”.
		// ¿Qué hay que hacer para que al final del algoritmo los valores de las variables
		// estén intercambiados? Diseña el algoritmo correspondiente.
		
		// Crear la variables "u" y "v"
		short u=25;
		short v=268;
		
		// Crear la variable "intermedio" para guardar una de las variables temporalmente
		short intermedio=0;
		
		// Mostrar los valores Iniciales
		System.out.println("Valores Iniciales: ");
		System.out.println("- El valor de la variable u es: "+u);
		System.out.println("- El valor de la variable v es: "+v);
		
		// Intercambiar los valores de "u" y "v" con la ayuda de "intermedio"
		intermedio=u;
		u=v;
		v=intermedio;
		
		// Mostrar los valores Finales
		System.out.println("");
		System.out.println("Valores Finales: ");
		System.out.println("- El valor de la variable u es: "+u);
		System.out.println("- El valor de la variable v es: "+v);
		
	}
}
