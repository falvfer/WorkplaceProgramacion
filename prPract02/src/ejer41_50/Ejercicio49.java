package ejer41_50;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ejercicio49 {
	
	public static void main(String[] args) {
		// Hacer un algoritmo que simule el funcionamiento de un reloj digital y que nos
		// permita ponerlo en hora, es decir, al comenzar a ejecutar el programa nos
		// preguntará si deseamos ponerlo en hora, si respondemos sí, nos pedirá la
		// hora, minutos y segundos de partida, si respondemos no, comenzaremos en la
		// 00:00:00. Este algoritmo nunca finalizará.	
		DecimalFormat patron = new DecimalFormat("00");
		Scanner sc = new Scanner(System.in);
		
		int hor = 0, min = 0, seg = 0;
		char resp;
		
		System.out.println("Desea poner el reloj a hora? (S/N)");
		resp = sc.next().charAt(0);
		
		if (resp=='S'||resp=='s') {
			System.out.println("Especifique las horas a añadir: ");
			hor=Math.abs(sc.nextInt());
			System.out.println("Especifique los minutos a añadir: ");
			min=Math.abs(sc.nextInt());
			System.out.println("Especifique los segundos a añadir: ");
			seg=Math.abs(sc.nextInt());
			
			if (seg>=60) {
				min += seg/60;
				seg = seg%60;
			}
			if (min>=60) {
				hor += min/60;
				min = min%60;
			}
			if (hor>=24) {
				hor = hor%24;
			}
			
		}
		sc.close();
		
		while (true) {
			System.out.println(patron.format(hor)+":"+patron.format(min)+":"+patron.format(seg));
			seg++;
			if (seg == 60) {
				seg = 0;
				min++;
				if (min == 60) {
					min = 0;
					hor++;
					if (hor == 24) {
						hor = 0;
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}	
		}
		
		
	}
}
