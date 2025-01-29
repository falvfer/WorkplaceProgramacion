package ejer12;

import java.util.Arrays;

public class Carton {

	private static final byte tamannoCarton = 15;
	private int contadorAciertos;
	private int[] arrayCarton;
	private int numBolas;

	public Carton(int numBolasBombo) {
		int i,aux;
		
		this.numBolas = numBolasBombo;
		this.contadorAciertos = 0;
		this.arrayCarton = new int[tamannoCarton];
		
		for (i=0; i<tamannoCarton; i++) {
			do {
				aux = (int)(Math.random()*numBolas);
			} while (existeNumero(aux));
			arrayCarton[i] = aux;
		}
		
		Arrays.sort(arrayCarton);
	}

	public boolean existeNumero(int num) {
		int pos = Arrays.binarySearch(arrayCarton, num);
		
		return pos >= 0;
	}

	public void compruebaNumero(int num) {
		if (existeNumero(num))
			contadorAciertos++;
	}
	
	public boolean quedanNumeros() {
		return contadorAciertos<tamannoCarton;
	}

}
