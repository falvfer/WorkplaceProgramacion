package ejer1_10;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		// Diseñar una aplicación que calcule la longitud y el área de una circunferencia.
		// Para ello el usuario debe introducir el radio (que puede contender decimales).
		// longitud = 2 * π * radio
		// area = π * radio ^ 2

		
		// Crear Scanner, y las variables iniciandolas.
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		float radio=0;
		float longitud=0;
		float area=0;
		
		// Definir la constante PI
		final double pi=3.1415926536;
		
		// Pedir el radio al usuario.
		System.out.print("Especifique el radio de la circunferencia: ");
		radio=sc.nextFloat();
		
		// Hacer el cálculo, también lo redondeo a tres dígitos usando Math.round
		longitud=(float)Math.round(1000*(2*Math.PI*radio))/1000;
		area=(float)Math.round(1000*(pi*Math.pow(radio, 2)))/1000;
		
		// Mostrar por pantalla la longitud y el area.
		System.out.println("La longitud de una circunferencia con radio " + radio + " es igual a: " + longitud);
		System.out.println("El area de una circunferencia con radio " + radio + " es igual a: " + area);
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}