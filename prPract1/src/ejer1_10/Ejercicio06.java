package ejer1_10;

import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
		// Diseña un programa que solicite al usuario su edad,
		// y a continuación indique si es mayor o menor de
		// edad, os podéis ayudar del operador condicional,
		// no se puede utilizar la sentencia condicional if.
		
		// Crear Scanner, y las variables iniciandolas.
		Scanner sc = new Scanner(System.in);
		byte edad=0;
		String mensaje="";
		
		// Pedir la edad del usuario.
		System.out.print("Especifique su edad: ");
		edad=sc.nextByte();
		
		// Operación lógica para elegir cual mensaje mostrar por pantalla.
		mensaje=(edad>=18)?"El usuario con " + edad + " años es mayor de edad.":"El usuario con " + edad + " años es menor de edad.";
		
		// Mostrar por pantalla los datos del triangulo rectángulo.
		System.out.println(mensaje);
		
		// Cerrar el objeto Scanner
		sc.close();
	}

}
