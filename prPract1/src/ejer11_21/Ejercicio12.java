package ejer11_21;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		// Escribir un programa que calcule el salario semanal de un trabajador, dada la tarifa horaria por horas y
		// el número de horas trabajadas. Además, hay que tener en cuenta que se le practica una retención del
		// 4% para la S.S. y del 7% para el IRPF. Es decir, solicitaremos por teclado, cuánto cobra por hora (tarifa
		// horaria), así como las horas trabajadas, y mostraremos por pantalla el sueldo semanal del trabajador
		// según los datos proporcionados.
		
		// Crear las variables, constantes y el objeto Scanner
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		byte horas=0;
		float sueldoXh=0;
		float sueldo=0;
		final float ss=0.04f;
		final float irpf=0.07f;
		
		// Pedir las horas trabajadas en esa semana
		System.out.print("Especifique el numero de horas trabajadas en la semana: ");
		horas=sc.nextByte();
		
		// Pedir el suelo por hora
		System.out.print("Especifique el dinero a pagar por hora (€/h): ");
		sueldoXh=sc.nextFloat();
		
		// Calcular el sueldo final
		sueldo=horas*sueldoXh;
		sueldo=sueldo-sueldo*ss-sueldo*irpf;
		
		// Redondear a los dos decimales con Math.round para poder tener una cantidad de dinero lógica
		sueldo=(float)Math.round(sueldo*100)/100;
		
		// Mostrar por pantalla el resultado final
		System.out.print("El sueldo semanal de este trabajador es de: "+sueldo+"€");
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}
