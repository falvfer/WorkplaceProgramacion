package ejer07;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ejercicio {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			InterfazPila<Double> miPila = new Pila<Double>();

			System.out.println("Introduzca la operación aritmética en notación postfija,"
					+ "\nseparando cada valor y operacion con espacios: ");
			String[] opAritmetica = sc.nextLine().split(" ");
			
			for (int i = 0; i < opAritmetica.length; i++) {
				
				try {
					miPila.push(Double.parseDouble(opAritmetica[i]));
				} catch (Exception e) {
					switch (opAritmetica[i]) {
						case "+" -> miPila.push(miPila.pop() + miPila.pop());
						case "-" -> miPila.push(- miPila.pop() + miPila.pop());
						case "*" -> miPila.push(miPila.pop() * miPila.pop());
						case "/" -> {
							double k = miPila.pop();
							miPila.push(miPila.pop() / k);
						}
					}
				}
				
			}
			
			double resultado = miPila.pop();
			if (miPila.isVacia())
				System.out.println("El resultado es " + resultado);
			else
				throw new NoSuchElementException();
			
		} catch (NoSuchElementException e) {
			System.out.println("Error: La operación es incorrecta");
		}
		
		
		
		
	}
}
