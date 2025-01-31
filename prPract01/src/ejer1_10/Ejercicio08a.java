package ejer1_10;

public class Ejercicio08a {
	
	public static void main(String[] args) {
		// Realizar un programa que reciba un número como argumento de entrada,
		// y a continuación muestre un mensaje mostrando un saludo e indicando
		// cuál ha sido el número introducido.
		
		// Crear la variable num y especificarle que tiene que
		// tener el número especificado como primer argumento.
		byte num=0;
		num=(byte)Integer.parseInt(args[0]);
		
		// El saludo mostrando el número
		System.out.println("Hola! El número indicado como argumento es: "+num);
		
		
	}
}
