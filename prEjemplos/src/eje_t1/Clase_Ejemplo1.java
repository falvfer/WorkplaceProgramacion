package eje_t1;

import java.util.Scanner;
/**
 * Ejemplo de prueba de la E/S estándar
 * 
 * @author Francisco
 */
public class Clase_Ejemplo1 {

	/**
	 * Método principal
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Definir, declarar o pedir memoria para varias variables
		int num1=0, num2, suma;
		
		//Iniciar num2
		num2=0;
		
		//Crear un objeto Scanner para poder solicitar datos por teclado
		Scanner sc = new Scanner(System.in);
		
		//Solicitar dos números al usuario para posteriormente sumarlos
		System.out.print("Escriba el primer número a sumar: ");
		num1 = sc.nextInt();
		System.out.print("Escriba el segundo número a sumar: ");
		num2 = sc.nextInt();
		
		//Sumo los dos números anteriores y guardo el resultado en la variable suma
		suma=num1+num2;
		
		//Imprimo el resultado por pantalla
		System.out.println("La suma de " + num1 + " y " + num2 + " da de resultado " + suma);
		
		//Cerrar el objeto Scanner
		sc.close();
		
		System.out.println("FIN DEL PROGRAMA");
	}
}