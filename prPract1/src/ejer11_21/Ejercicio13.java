package ejer11_21;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		// Escribir un programa que convierta un número dado en segundos
		// en el equivalente de minutos y segundos.
		
		// Crear variables y objeto Scanner
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		int usuSeg=0;
		double intermedio=0;
		int minutos=0;
		byte segundos=0;
		
		// Pedir los segundos por pantalla
		System.out.print("Especifique los segundos a transformar a minutos: ");
		usuSeg=sc.nextInt();
		
		// Hacer los cálculos para pasar a minutos y segundos
		intermedio=usuSeg/60.0;
		minutos=(int)intermedio;
		segundos=(byte)(usuSeg-minutos*60);
		
		// Mostrar por pantalla el resultado
		System.out.println("El número total es de: "+((minutos>=1)?minutos+((minutos==1)?" minuto":" minutos")+((segundos>0)?" y "+segundos+((segundos==1)?" segundo.":" segundos."):"."):segundos+((segundos==1)?" segundo.":" segundos.")));

		// Cerrar el objeto Scanner
		sc.close();
	}

}
