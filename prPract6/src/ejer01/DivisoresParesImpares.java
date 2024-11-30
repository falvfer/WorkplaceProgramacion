package ejer01;

/* Realizar un programa que muestre por pantalla todos los números entre 1 y 100, que tengan el mismo
 * número de divisores pares e impares.
 * 
 * Datos del ejercicio:
 *   MAIN:
 *    - Mostrar todos los números entre 1 y 100 que cumplan con:
 * 	    - Tener misma cantidad de divisores pares e impares.
 * 
 *   Hacer con POO:
 *    - Variables:
 * 	    - Número que calcular los divisores.
 * 	    - Contador de pares.
 * 	    - Contador de impares.
 * 	  - Métodos públicos:
 * 		- Calcular los divisores del número y clasificarlos como pares e impares.
 * 		  - Bucle for comprobando si es divisible hasta llegar al número.
 * 		    - Si es divisible sumar 1 a contador PAR/IMPAR en base a como es el número.
 * 	  - Métodos privados:
 * 		- Método para comprobar si un número es divisor de otro.
 */

public class DivisoresParesImpares {
	
// Variables de instancia
	private int num, contPar, contImpar;
	
// Getters y Setters
	public int getNum() {return num;}
	public int getContPar() {return contPar;}
	public int getContImpar() {return contImpar;}
	
	public void setNum(int num) {this.num = num;}
		
// Constructores
	public DivisoresParesImpares(int num) {
		this.num = num;
		this.contPar = 0;
		this.contImpar = 0;
	}
	
// Métodos públicos
	public void calcularDivisores() {
		for (int i = 1; i<=this.num; i++)
			if (isDivisor(this.num,i))
				if (isDivisor(i,2)) this.contPar++;
				else this.contImpar++;
	}
	
// Métodos privados
	private static boolean isDivisor(int num, int div) {
		return (num % div == 0);
	}
	
// Método main: Mostrar los números entre 1 y 100 que tienen la misma cantidad de divisores pares e impares
	public static void main(String[] args) {
		
		final int inicio = 1,
				  fin = 100;
		
		System.out.println("Los números con misma cantidad de pares e impares entre " + inicio + " y " + fin + " son:");
		
		for (int i = inicio; i<=fin; i++) {
			DivisoresParesImpares num = new DivisoresParesImpares(i);
			num.calcularDivisores();
			if (num.getContPar() == num.getContImpar())
				System.out.print(i + " ");
		}
	}
}
