package ejer11_21;

import java.util.Locale;
import java.util.Scanner;

public class Ejercicio18 {

	// NOTA "\n" sirve para insertar una salto de línea y "\t" sirve para insertar una tabulación.

	public static void main(String[] args) {
		// Diseñar un programa que, a partir de los tres puntos extremos (P1, P2 y P3) de un triángulo,
		// calcule el área del mismo, de acuerdo con la siguiente fórmula:
			// area = sqrt(T*(T-S1)*(T-S2)*(T-S3))
				// donde T = (S1+S2+S3)/2 y S1,S2,S3 son las longitudes de los lados del triángulo.
				// La distancia entre dos puntos p(x1,y1) y q(x2,y2) es: sqrt((x1−x2)^2+(y1−y2)^2)

		// Crear el objeto scanner
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		
		// Crear las variables para las coordenadas x,y de los tres puntos del triángulo
		float x1=0;
		float x2=0;
		float x3=0;
		float y1=0;
		float y2=0;
		float y3=0;
		
		// Crear las variables para la longitud de los lados del triángulo
		float s1=0;
		float s2=0;
		float s3=0;
		
		// Crear las variables para T y para el area
		float t=0;
		float area=0;
		
		// Preguntar al usuario por las coordenadas de los tres puntos del triangulo
		System.out.println("Especifique las coordenadas del primer punto del triángulo: ");
		System.out.print("x = ");
		x1=sc.nextFloat();
		System.out.print("y = ");
		y1=sc.nextFloat();
		System.out.println("\nEspecifique las coordenadas del segundo punto del triángulo: ");
		System.out.print("x = ");
		x2=sc.nextFloat();
		System.out.print("y = ");
		y2=sc.nextFloat();
		System.out.println("\nEspecifique las coordenadas del tercer punto del triángulo: ");
		System.out.print("x = ");
		x3=sc.nextFloat();
		System.out.print("y = ");
		y3=sc.nextFloat();
		
		// Calcular las longitudes de los lados del triángulo
		s1=(float)Math.sqrt(Math.pow((x1-x2), 2)+Math.pow((y1-y2), 2));
		s2=(float)Math.sqrt(Math.pow((x2-x3), 2)+Math.pow((y2-y3), 2));
		s3=(float)Math.sqrt(Math.pow((x3-x1), 2)+Math.pow((y3-y1), 2));
		
		// Calcular la "T"
		t=(s1+s2+s3)/2;
		
		// Calcular el area del triangulo y redondearlo a 3 decimales
		area=(float)Math.sqrt(t*(t-s1)*(t-s2)*(t-s3));
		area=Math.round(area*1000)/1000;
		
		// Imprimir por pantalla el resultado del area
		System.out.println("El área del triángulo especificado es: "+area);
		
		// Cerrar el objeto Scanner
		sc.close();
	}
}
