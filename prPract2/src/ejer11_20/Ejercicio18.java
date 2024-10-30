package ejer11_20;

public class Ejercicio18 {

	public static void main(String[] args) {
		// Un programa posee tres bucles anidados, cuyas variables de control toman M, N
		// y K valores respectivamente. Determinar cuántas veces se ejecutan las
		// instrucciones del cuerpo del bucle más interno.
		int contM=0;
		int contN=0;
		int contK=0;
		
		for (int m=1;m<=2;m++) {
			contM++;
			for (int n=1;n<=4;n++) {
				contN++;
				for (int k=1;k<=3;k++)
					contK++;
			}
		}
		
		System.out.println("El bucle externo: "+contM+" veces.");
		System.out.println("El bucle medio: "+contN+" veces.");
		System.out.println("El bucle interno: "+contK+" veces.");
		
		// Se va a ejecutar el de dentro multiplicando cuantas veces se ejecuta cada
		// uno, por ejemplo: en este se ejecuta el primero 2 veces, el segundo 4 y el
		// tercero (interno) 3 veces, por lo que 2*4*3=24 veces se va a ejecutar el
		// interno, el medio se ejecuta 2*4=8 veces y el externo 2 veces solo.		
		
		
	}
}
