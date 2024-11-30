package ejer02;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/* Clase AdivinarNumero
 *  - Variables:
 *    - int numero
 *    - int rangoMin
 *    - int rangoMax
 *    - int intentos
 *  - Métodos públicos
 *    - boolean adivinarNumero(int)
 *    - boolean quedanIntentos
 *    - String rango ("12..23") 
 */

public class AdivinarNumero {
	
// Variables de instancia
	private int numero, rangoMin, rangoMax;
	private byte intentos;
	
// Variables de clase
	private Random rdn = new Random();
	
// Getters y Setters
	public byte getIntentos() {return intentos;}
	public int getNumero() {return numero;}
	public int getRangoMin() {return rangoMin;}
	public int getRangoMax() {return rangoMax;}
	
	public void setIntentos(byte intentos) {this.intentos = intentos;}
	public void setNumero(int numero) {this.numero = numero;}
	public void setRangoMin(int rangoMin) {this.rangoMin = rangoMin;}
	public void setRangoMax(int rangoMax) {this.rangoMax = rangoMax;}

// Constructores
	public AdivinarNumero(byte intentos, int rangoMin, int rangoMax) {
		this.intentos = intentos;
		this.rangoMin = rangoMin;
		this.rangoMax = rangoMax;
		this.numero = rdn.nextInt(rangoMin,rangoMax);
	}
	
	public AdivinarNumero(byte intentos, int rangoMax) {
		this(intentos, rangoMax, 1);
	}
	
	public AdivinarNumero(byte intentos) {
		this(intentos, 100, 1);
	}
	
	public AdivinarNumero() {
		this((byte)5, 100, 1);
	}
	
// Métodos públicos
	public boolean adivinarNumero(int adivinacion) {
		boolean isNumero = (this.numero == adivinacion);
		
		if (!isNumero)
			if (adivinacion < this.numero) {
				if (adivinacion >= this.rangoMin)
					this.rangoMin = adivinacion+1;
			} else if (adivinacion <= this.rangoMax)
				this.rangoMax = adivinacion-1;
		
		this.intentos--;
		return isNumero;
	}
	
	public boolean quedanIntentos() {
		return (this.intentos > 0);
	}
	
	public String rango() {
		return "(" + this.rangoMin + ".." + this.rangoMax + ")";
	}
	
	
	/*
	 * Método MAIN:
	 * 	- Variables:
	 * 	  - boolean salir = false, terminar = false;
	 *  - Crear objeto AdivinarNumero, máximo de 5 intentos
	 *  - Bucle while (variable terminar para terminar programa)
	 *    - Pedir al usuario que lo adivine
	 *    - Bucle while (variable salir para salir)
	 *      - Si ha acertado: 
	 *        - Felicitar 
	 *        - "salir" a true
	 *      - No ha acertado:
	 *        - Comprobar que haya intentos > 0
	 *      	- Si sí hay:
	 *      	  - Decirle que intente adivinar otra vez con el rango nuevo
	 *      	- Si no hay:
	 *      	  - Decir que ha perdido
	 *      	  - "salir" a true
	 *    - Preguntar si quiere repetir
	 *      - Sí repetir: Generar nuevo número
	 *      - No repetir: terminar a true
	 */
	
	public static void main(String[] args) {
		
		boolean salir, terminar = false;
		byte opcion;
		byte intentos;
		Scanner sc = new Scanner(System.in);
		AdivinarNumero num;
		
		do {
			
			try {
				salir = false;
				menu();
				opcion = sc.nextByte();
				
				switch (opcion) {
					case 1 -> intentos = 127;
					case 2 -> intentos = 8;
					case 3 -> intentos = 5;
					case 4 -> intentos = 4;
					default -> throw new InputMismatchException();
				}
				System.out.println();
				
				num = new AdivinarNumero(intentos, 1, 100);
				System.out.print("Adivina el número: Rango " + num.rango() + " ");
				
				do {
					
					if (num.adivinarNumero(sc.nextInt())) {
						System.out.println("\n¡Felicidades! Has adivinado el número correcto");
						salir = true;
					} else if (num.quedanIntentos())
						System.out.print("¡Incorrecto! Rango " + num.rango() + " ");
					else {
						System.out.println("\n¡Incorrecto! No quedan más intentos, has perdido");
						salir = true;
					}
					
				} while (!salir);
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("Error: Número u opción no válida.");
			}
			
			sc.nextLine();
			System.out.print("\n¿Quieres volver a jugar? [s/n] ");
			if (Character.toLowerCase(sc.nextLine().charAt(0)) == 's') {
				num = new AdivinarNumero((byte)5, 1, 100);
				System.out.println();
			} else
				terminar = true;
			
		} while (!terminar);
		sc.close();
		
	}
	
	public static void menu() {
		System.out.println("1. Infinitos intentos");
		System.out.println("2. Fácil (8 intentos)");
		System.out.println("3. Normal (5 intentos)");
		System.out.println("4. Dificil (4 intentos)");
		System.out.print("Elija la dificultad: ");
	}
	
	
	
	
	
	
}
