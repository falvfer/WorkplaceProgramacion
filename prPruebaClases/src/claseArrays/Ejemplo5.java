package claseArrays;

import java.util.Arrays;

public class Ejemplo5 {

	public static void main(String[] args) {
		
		int[] v = {2,7,4,1,3,5,6};
		System.out.println("Array desordenado: " + Arrays.toString(v));
		
		Arrays.sort(v);
		System.out.println("Array ordenado: " + Arrays.toString(v));
		
		System.out.println("Posición del elemento 1: " + Arrays.binarySearch(v, 1));
		System.out.println("Posición del elemento 5: " + Arrays.binarySearch(v, 5));
		System.out.println("Posición del elemento 20: " + Arrays.binarySearch(v, 20));
		
		int[] v2 = Arrays.copyOf(v, 3);
		int[] v3 = Arrays.copyOf(v, 10);
		int[] v4 = Arrays.copyOfRange(v, 2, 5);
		
		System.out.println("Vector 2: " + Arrays.toString(v2));
		System.out.println("Vector 3: " + Arrays.toString(v3));
		System.out.println("Vector 4: " + Arrays.toString(v4));
		
		
		
	}
	
}
