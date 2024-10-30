package ejer1_10;

/**
 * Hacer un programa para averiguar la frecuencia relativa con la que saldría
 * cada uno de los números de un dado si lanzáramos éste 1000 veces.
 * 
 * @author Francisco Jesús Álvarez Fernández
 */

public class Ejercicio05 {

	public static void main(String[] args) {
		
		int cont1=0, cont2=0, cont3=0, cont4=0, cont5=0, cont6=0, dado;		
		
		for (int i = 1; i<=1000; i++) {
			dado=(int)(Math.random()*6+1);
			
			switch (dado) {
				case 1 -> cont1++;
				case 2 -> cont2++;
				case 3 -> cont3++;
				case 4 -> cont4++;
				case 5 -> cont5++;
				case 6 -> cont6++;
				default -> System.out.println("ERROR");
			}
		}
		System.out.println("Probabilidad de la cara 1 en base a 1000 tiradas: "+((double)cont1/10)+"%");
		System.out.println("Probabilidad de la cara 2 en base a 1000 tiradas: "+((double)cont2/10)+"%");
		System.out.println("Probabilidad de la cara 3 en base a 1000 tiradas: "+((double)cont3/10)+"%");
		System.out.println("Probabilidad de la cara 4 en base a 1000 tiradas: "+((double)cont4/10)+"%");
		System.out.println("Probabilidad de la cara 5 en base a 1000 tiradas: "+((double)cont5/10)+"%");
		System.out.println("Probabilidad de la cara 6 en base a 1000 tiradas: "+((double)cont6/10)+"%");
		
	}
}
