package ejer11_20;

import java.util.Scanner;

public class EjercicioMaestra12v9 {

	public static void main(String[] args) {
		
		int num1, num2;
		char operador;
		
		// Crear un objeto Scanner
		Scanner obLectura = new Scanner(System.in);


		// Lectura de la operación
		System.out.print("Operación: "); 	
		operador=obLectura.nextLine().charAt(0);
		
		// Lectura de los operandos
		System.out.print("Operando 1: "); 	
		num1 = obLectura.nextInt();
		
		System.out.print("Operando 2: "); 	
		num2 = obLectura.nextInt();
		
		// Cerrar el objeto Scanner
		obLectura.close();
		
		switch (operador) {
		
		  case '+': System.out.println("Resultado: " + (num1+num2)); break; 
		  case '-': System.out.println("Resultado: " + (num1-num2)); break;
		  case '*': System.out.println("Resultado: " + (num1*num2)); break;
		  case '/': 

			  try {
				  float resultado = (float)num1/num2;				  
				  if (Float.isInfinite(resultado)==true) {
					  throw new ArithmeticException("Error, al dividir por cero");
				  }
				  System.out.println("Resultado: "+resultado);
			  }
			  catch (ArithmeticException e) {
					System.out.println("Error, no se puede dividir por cero");
					System.out.println(e.getMessage());
				}
			  break;
		  default: System.out.println("Operación incorrecta");
		}  // end switch

	}
}




