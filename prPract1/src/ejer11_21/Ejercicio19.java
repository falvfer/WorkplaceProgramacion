package ejer11_21;

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		// Convertir un tiempo expresado en segundos a un formato
		// que lo represente a horas, minutos y segundos.
		
		// Especificar las variables y el objeto Scanner
		Scanner sc = new Scanner(System.in);
		int segUsu=0;
		int horas=0;
		int minutos=0;
		int segundos=0;
		double intermedio=0;
		
		// Preguntar al usuario por los segundos
		System.out.print("Especifique los segundos: ");
		segUsu=sc.nextInt();
		
		// Calculos para transformar a horas, minutos y segundos
		intermedio=segUsu/3600.0;
		horas=(int)intermedio;
		intermedio=(intermedio-horas)*60;
		minutos=(int)intermedio;
		intermedio=(intermedio-minutos)*60;
		segundos=(int)Math.round(intermedio); // He usado Math.round para evitar errores con el truncado de segundos
		
		// Imprimir por pantalla el resultado
		System.out.println("El tiempo especificado es: "+horas+" horas, "+minutos+" minutos y "+segundos+" segundos.");
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}
