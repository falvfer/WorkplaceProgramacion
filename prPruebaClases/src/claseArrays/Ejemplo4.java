package claseArrays;

import java.util.Arrays;

public class Ejemplo4 {

	public static void main(String[] args) {
		
		int[] vector1 = {1,3,4};
		int[] vector2 = {1,3,4};
		int[] vector3 = {1,3,5};
		int[] vector4 = {1,3,4,5};
		
		System.out.println(Arrays.equals(vector1, vector2));
		System.out.println(Arrays.equals(vector1, vector3));
		System.out.println(Arrays.equals(vector1, vector4));
		System.out.println();
		
		int[][] matriz1 = {{1,2,3}, {4,5,6}};
		int[][] matriz2 = {matriz1[0], {1,2,3}};
		int[][] matriz3 = {{4,5,6}, matriz1[1]};
		int[][] matriz4 = {matriz2[0], matriz3[1]};
		int[][] matriz5 = {matriz2[1], matriz3[1]};
		
		System.out.println(Arrays.equals(matriz1, matriz2));
		System.out.println(Arrays.equals(matriz1, matriz3));
		System.out.println(Arrays.equals(matriz1, matriz4));
		System.out.println(Arrays.equals(matriz1, matriz5));
		System.out.println();
		
		System.out.println(Arrays.deepEquals(matriz1, matriz2));
		System.out.println(Arrays.deepEquals(matriz1, matriz3));
		System.out.println(Arrays.deepEquals(matriz1, matriz4));
		System.out.println(Arrays.deepEquals(matriz1, matriz5));

	}

}
