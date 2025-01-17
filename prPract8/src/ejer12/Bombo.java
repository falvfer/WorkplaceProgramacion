package ejer12;

import java.util.Arrays;
import java.util.Random;

public class Bombo {

	// Variables
	private boolean[] bolas;
	private int numBolas;
	private static Random rdn = new Random();
	
	// Getter y Setters
	public boolean[] getBolas() {return bolas;}
	public int getNumBolas() {return numBolas;}

	public void setBolas(boolean[] bolas) {this.bolas = bolas;}
	public void setNumBolas(int numBolas) {this.numBolas = numBolas;}
	
	// Constructores
	public Bombo(int cantidad) {
		this.bolas = new boolean[cantidad];
		this.numBolas = cantidad;
		Arrays.fill(bolas, true);
	}
	
	// Métodos
	public int extraeBola() {
		int bola;
		do {
			bola = rdn.nextInt(0, numBolas);
		} while (!bolas[bola]);
		return bola+1;
	}
	
	public boolean quedanBolas() {
		boolean salir = false;
		for (int i = 0; i < numBolas && !salir; i++)
			if (bolas[i]) salir = true;
		return salir;
	}

	
	
	
	
	
	
	
}
