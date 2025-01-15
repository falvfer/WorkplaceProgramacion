package ejer18;

import java.util.Random;

import MisLibrerias.LibreriaVarios;

public class Baraja {

// Variables
	private Carta[][] baraja;
	private int posicionActual;
	
// Getters y Setters
	public Carta[][] getBaraja() {return baraja;}
	public int getPosicionActual() {return posicionActual;}

	public void setBaraja(Carta[][] baraja) {this.baraja = baraja;}
	public void setPosicionActual(int posicionActual) {this.posicionActual = posicionActual;}
	
// Constructores
	/**
	 * Constructor principal de la clase Baraja
	 * @param clase -> Baraja espannola (1) o Baraja inglesa (2)
	 */
	public Baraja(int clase) {
		switch (clase) {
		// Caso de baraja espannola
		case 1 -> {
			this.baraja = new CartaEspannola[4][10];
			for (int i = 0; i < this.baraja.length; i++)
				for (int k = 0; k < this.baraja[i].length; k++)
					this.baraja[i][k] = new CartaEspannola((byte)(i+1), (byte)(k+1));
			
		} // Caso de baraja inglesa
		case 2 -> {
			this.baraja = new CartaInglesa[4][13];
			for (int i = 0; i < this.baraja.length; i++)
				for (int k = 0; k < this.baraja[i].length; k++)
					this.baraja[i][k] = new CartaInglesa((byte)(i+1), (byte)(k+1));
		}
		} // Enumerar las posiciones
		this.ordenar();
		this.posicionActual = 1;
	}
	
	/**
	 * Constructor por defecto, crea una baraja espannola.
	 */
	public Baraja() {
		this(2);
	}
	
// Métodos
	public void ordenar() {
		byte cont = 1;
		for (int i = 0; i < this.baraja.length; i++)
			for (int k = 0; k < this.baraja[i].length; k++)
				this.baraja[i][k].setPosicion(cont++);
	}
	
	public void barajar() {
		Random rdn = new Random();
		int posIMax = this.baraja.length;
		int pos1I, pos1K, pos2I, pos2K;
		byte aux;
		
		for (int i = 0; i < 100; i++) {
			pos1I = rdn.nextInt(0, posIMax);
			pos1K = rdn.nextInt(0, this.baraja[pos1I].length);
			pos2I = rdn.nextInt(0, posIMax);
			pos2K = rdn.nextInt(0, this.baraja[pos2I].length);
			
			if (pos1I != pos2I && pos1K != pos2K) {
				aux = this.baraja[pos1I][pos1K].getPosicion();
				this.baraja[pos1I][pos1K].setPosicion(this.baraja[pos2I][pos2K].getPosicion());
				this.baraja[pos2I][pos2K].setPosicion(aux);
			}
		}
	}
	
	public int[] getPosicion(byte num) {
		boolean salir = false;
		int[] posicion = new int[2];
		
		for (int i = 0; i < this.baraja.length && !salir; i++)
			for (int k = 0; k < this.baraja[i].length && !salir; k++)
				if (this.baraja[i][k].getPosicion() == num) {
					posicion[0] = i;
					posicion[1] = k;
					salir = true;
				}
		
		return posicion;
	}
	
	public int valorCarta(int posicion) {
		int[] pos = getPosicion((byte)(this.posicionActual + posicion));
		return this.baraja[pos[0]][pos[1]].getValor();
	}
	
	public int valorCarta() {
		return valorCarta(0);
	}
	
	public int paloCartaActual() {
		int[] pos = getPosicion((byte)this.posicionActual);
		return this.baraja[pos[0]][pos[1]].getPalo();
	}
	
	public String valorCartaActualToString() {
		int[] pos = getPosicion((byte)this.posicionActual);
		return this.baraja[pos[0]][pos[1]].valorToString();
	}
	
	public String paloCartaActualToString() {
		int[] pos = getPosicion((byte)this.posicionActual);
		return this.baraja[pos[0]][pos[1]].paloToString();
	}
	
	public String cartaActualToString() {
		int[] pos = getPosicion((byte)this.posicionActual);
		return this.baraja[pos[0]][pos[1]].toString();
	}
	
	public void siguienteCarta() {
		this.posicionActual++;
	}
	
	public String debugPosiciones() {
		String resultado = "";
		for (int i = 0; i < this.baraja.length; i++) {
			for (int k = 0; k < this.baraja[i].length; k++) {
				resultado += this.baraja[i][k].getPosicion() + LibreriaVarios.tabular(this.baraja[i][k].getPosicion(), 3);
			}
			resultado += "\n";
		}
		
		return resultado;
	}
	
	
	
	
	
	
}
