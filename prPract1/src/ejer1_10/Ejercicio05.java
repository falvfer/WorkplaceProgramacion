package ejer1_10;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		// Realizar un programa para calcular el valor de la hipotenusa de un triángulo
		// rectángulo aplicando el	teorema de Pitágoras. Se pedirán por teclado los dos catetos,
		// y se mostrará por pantalla el resultado de calcular la hipotenusa.
		
		// Crear Scanner, y las variables iniciandolas.
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		float cat1=0;
		float cat2=0;
		float hipo=0;
		
		// Pedir los catetos al usuario.
		System.out.print("Especifique el primer cateto del triangulo rectangulo: ");
		cat1=sc.nextFloat();
		System.out.print("Especifique el segundo cateto: ");
		cat2=sc.nextFloat();
		
		// Hacer el cálculo, también lo redondeo a tres dígitos usando Math.round
		hipo=(float)Math.round(1000*(Math.sqrt(Math.pow(cat1,2)+Math.pow(cat2,2))))/1000;
		
		// Mostrar por pantalla los datos del triangulo rectángulo.
		System.out.println("La hipotenusa del triangulo rectángulo cuyos catetos son: " + cat1 + " y " + cat2 + " es igual a: " + hipo);
		
		// Cerrar el objeto Scanner
		sc.close();
	}

}
